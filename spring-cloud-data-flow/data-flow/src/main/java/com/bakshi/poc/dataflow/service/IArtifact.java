package com.bakshi.poc.dataflow.service;

import com.bakshi.poc.dataflow.model.Artifact;

import reactor.core.publisher.Mono;

public interface IArtifact {
    public Mono<Artifact> save(Artifact artifact);
}
