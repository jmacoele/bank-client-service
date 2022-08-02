package com.nttdata.bankclientservice.service;

import com.nttdata.bankclientservice.model.document.Client;
import com.nttdata.bankclientservice.model.repository.IClientRepository;
import com.nttdata.bankclientservice.model.service.IClientService;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Client Service.
 *
 * @author jmacoele
 *
 */

@Service
public class ClientService implements IClientService  {

  @Autowired
  private IClientRepository clientRepository;

  @Override
  public Mono<Client> findById(String id) {
    return this
        .clientRepository
        .findById(id)
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Flux<Client> findAll() {
    return this
        .clientRepository
        .findAll()
        .switchIfEmpty(Flux.empty());
  }


  @Override
  public Flux<Client> findByName(String name) {
    return this
        .clientRepository
        .findAll()
        .filter(x -> x.getName().equalsIgnoreCase(name))
        .switchIfEmpty(Flux.empty());
  }

  @Override
  public Mono<Client> save(Client client) throws Exception {
    client.setId(client.getClientType().getValue() + "::" + UUID.randomUUID().toString());
    return this.clientRepository.save(client);
  }

  @Override
  public Mono<Client> save(String id, Client client) throws Exception {
    return this.clientRepository.save(client);
  }

  @Override
  public Mono<Client> delete(final String id) {
    final Mono<Client> client = findById(id);
    if (Objects.isNull(client)) {
      return Mono.empty();
    }
    return findById(id)
        .switchIfEmpty(Mono.empty())
        .filter(Objects::nonNull)
        .flatMap(clientToBeDeleted -> this.clientRepository
            .delete(clientToBeDeleted)
            .then(Mono.just(clientToBeDeleted)));
  }



  @Override
  public Mono<Boolean> existsById(String id) {
    return this
        .clientRepository
        .existsById(id);
  }
}
