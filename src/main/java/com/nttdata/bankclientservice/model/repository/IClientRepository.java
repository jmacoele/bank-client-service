package com.nttdata.bankclientservice.model.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bankclientservice.model.document.Client;

@Repository
public interface IClientRepository extends ReactiveMongoRepository<Client, String> {

}
