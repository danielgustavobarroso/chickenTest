package com.retooling.egg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.retooling.egg.model.Egg;

public interface EggRepository extends MongoRepository<Egg, Integer>{

}
