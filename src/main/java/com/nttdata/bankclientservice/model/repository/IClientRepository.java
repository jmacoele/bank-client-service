package com.nttdata.bankclientservice.model.repository;

import com.nttdata.bankclientservice.model.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * IClientRepository Interface.
 *
 * @author jmacoele
 *
 */

@Repository
public interface IClientRepository
    extends ReactiveMongoRepository<Client, String> {

}
