package com.bakshi.poc.dataflow.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowRepository extends ReactiveMongoRepository<WorkflowRepository,String>{
    
}
