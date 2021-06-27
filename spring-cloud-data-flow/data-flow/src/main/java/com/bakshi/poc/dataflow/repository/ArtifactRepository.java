package com.bakshi.poc.dataflow.repository;

import com.bakshi.poc.dataflow.model.Artifact;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends ReactiveMongoRepository<Artifact,String>{
    
}
