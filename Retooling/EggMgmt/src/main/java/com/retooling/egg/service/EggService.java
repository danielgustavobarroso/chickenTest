package com.retooling.egg.service;

import java.util.List;
import java.util.Optional;

import com.retooling.egg.model.Egg;

public interface EggService {
	
	public List<Egg> getAllEggs();

	public Optional<Egg> getEggById(Integer id);
	
	public Egg saveEgg(Egg egg);

	public void updateEgg(Egg egg);
	
	public void deleteEgg(Integer id);
	
}
