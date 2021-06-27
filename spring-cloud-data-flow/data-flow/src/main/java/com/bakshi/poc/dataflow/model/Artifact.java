package com.bakshi.poc.dataflow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "artifacts")
@Getter
@Setter
@NoArgsConstructor
public class Artifact {
    @Id
    public String artifactId;
    public Core core;
    public Extended extended;
    public Workflow workflow;

    public Artifact(Core core,Extended extended,Workflow workflow){
        this.core=core;
        this.extended=extended;
        this.workflow=workflow;
        this.artifactId=core.id+"-"+workflow.taskId;
    }
}
