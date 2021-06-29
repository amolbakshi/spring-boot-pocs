package com.bakshi.poc.dataflow.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bakshi.poc.dataflow.model.Artifact;
import com.bakshi.poc.dataflow.model.Core;
import com.bakshi.poc.dataflow.model.Extended;
import com.bakshi.poc.dataflow.model.Metadata;
import com.bakshi.poc.dataflow.model.Workflow;
import com.bakshi.poc.dataflow.service.IArtifact;
import com.bakshi.poc.dataflow.service.IExtended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mongo")
public class MongoController {
    
    @Autowired
    IArtifact iArtifact;

    @Autowired
    IExtended iExtended;

    @GetMapping(value = "/createArtifact",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createArtifact(){
        
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
        iArtifact.save(artifact);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping(value = "saveExtended",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveExtended(){

        Extended extended = new Extended();
        List<Metadata> metadatas = new ArrayList<>();
        Metadata metadata = new Metadata();
        metadata.id="M1234";
        metadata.value="Amol";
        metadatas.add(metadata);
        extended.metadata=metadatas;
        extended.id="D123456";
        iExtended.save(extended);
        return new ResponseEntity<>("status",HttpStatus.OK);
    }

}
