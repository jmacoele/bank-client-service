package com.nttdata.bankclientservice.api;

import com.nttdata.bankclientservice.model.document.Client;
import com.nttdata.bankclientservice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client Controller.
 *
 * @author jmacoele
 *
 */

@RestController
@RequestMapping("/clients")
@Slf4j
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping
  @Operation(summary = "Get list of Clients")
  public Flux<Client> getAll() {
    log.info("getAll" + "OK");
    return clientService.findAll().log();
  }

  @GetMapping("{id}")
  @Operation(summary = "Get Client by Id")
  public Mono<Client> getById(@PathVariable("id") final String id) {
    log.info("getById: " + id);
    return clientService.findById(id).log();
  }

  @GetMapping("/name/{name}")
  @Operation(summary = "Get Client by name")
  public Flux<Client> getByName(
      @PathVariable("name") final String name) {
    log.info("getByName: " + name);
    return clientService.findByName(name).log();
  }

  @PutMapping("{id}")
  @Operation(summary = "Update Client by Id")
  public Mono<Client> updateById(@PathVariable("id") final String id,
      @RequestBody final Client client) throws Exception {
    log.info("update: " + id);
    return clientService.save(id, client).log();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create Client")
  public Mono<Client> create(@RequestBody final Client client)
      throws Exception {
    log.info("create: " + client.getName());
    return clientService.save(client).log();
  }

  @DeleteMapping("{id}")
  @Operation(summary = "Delete Client")
  public Mono<Client> delete(@PathVariable final String id) {
    log.info("delete: " + id);
    return clientService.delete(id).log();
  }

  @GetMapping("/exists/{id}")
  @Operation(summary = "verify existence of Client")
  public Mono<Boolean> existsById(
      @PathVariable("id") final String id) {
    log.info("exists by: " + id);
    return clientService.existsById(id).log();
  }

}
