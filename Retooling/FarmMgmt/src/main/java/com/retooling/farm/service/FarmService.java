package com.retooling.farm.service;

import java.util.List;
import java.util.Optional;

import com.retooling.farm.model.Farm;

public interface FarmService {
	
	public List<Farm> getAllFarms();

	public Optional<Farm> getFarmById(Integer id);
	
	public Farm saveFarm(Farm farm);

	public void updateFarm(Farm farm);
	
	public void deleteFarm(Integer id);
	
}
