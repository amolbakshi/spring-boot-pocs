package com.bakshi.poc.dataflow.service;

import com.bakshi.poc.dataflow.model.Extended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ExecutableAggregationOperation.AggregationWithCollection;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class ExtendedService implements IExtended{

    @Autowired
    ReactiveMongoTemplate mongoTemplate;


    @Override
    public void save(Extended extended) {
        mongoTemplate.save(extended, "extended").subscribe();
    }


    @Override
    public void saveWithAgregation(Extended extended) {
        
        MatchOperation matchOperation = Aggregation.match(Criteria.where("id").is("D123456"));

        
    }
    
}
