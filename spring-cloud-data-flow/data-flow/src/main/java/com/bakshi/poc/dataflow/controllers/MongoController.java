package com.bakshi.poc.dataflow.controllers;

import com.bakshi.poc.dataflow.model.Artifact;
import com.bakshi.poc.dataflow.model.Core;
import com.bakshi.poc.dataflow.model.Workflow;
import com.bakshi.poc.dataflow.service.IArtifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/mongo")
public class MongoController {
    
    @Autowired
    IArtifact iArtifact;

    @GetMapping(value = "/createArtifact")
    public Mono<Artifact> createArtifact(){
        
        Core core = new Core();
        core.id="D12345";
        core.type="test123";
        core.creator="Amol";

        Workflow workflow = new Workflow();
        workflow.assignedTo="Amol";
        workflow.taskId="tk1234";
        workflow.wfId="WF123345";
        workflow.status="started";

        Artifact artifact = new Artifact(core, null, workflow);
        return iArtifact.save(artifact);
    }

}
