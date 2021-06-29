package com.bakshi.poc.dataflow.service;

import com.bakshi.poc.dataflow.model.Extended;

public interface IExtended {
    public void save(Extended extended);
    public void saveWithAgregation(Extended extended);
}
