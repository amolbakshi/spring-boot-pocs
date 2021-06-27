package com.bakshi.poc.dataflow.service;

import com.bakshi.poc.dataflow.model.Artifact;
import com.bakshi.poc.dataflow.repository.ArtifactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ArtifactService implements IArtifact{

    @Autowired
    ArtifactRepository artifactRepository;
    @Override
    public Mono<Artifact> save(Artifact artifact) {
        return artifactRepository.save(artifact);
    }
    
}
