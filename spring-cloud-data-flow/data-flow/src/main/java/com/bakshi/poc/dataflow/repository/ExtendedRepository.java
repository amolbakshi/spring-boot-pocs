package com.bakshi.poc.dataflow.repository;

import com.bakshi.poc.dataflow.model.Extended;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendedRepository extends ReactiveMongoRepository<Extended,String>{
    
}
