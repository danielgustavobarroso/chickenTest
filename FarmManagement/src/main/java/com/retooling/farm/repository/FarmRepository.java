package com.retooling.farm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.retooling.farm.model.Farm;

public interface FarmRepository extends MongoRepository<Farm, Integer>{

}
