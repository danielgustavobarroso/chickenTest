package com.retooling.farm.service;

import com.retooling.farm.service.FarmService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retooling.farm.model.Farm;
import com.retooling.farm.repository.FarmRepository;

@Service
public class FarmServiceImpl implements FarmService {

	@Autowired
	FarmRepository farmRepository;
	
	public List<Farm> getAllFarms() {
		return farmRepository.findAll();			
	}

	public Optional<Farm> getFarmById(Integer id) {
		return farmRepository.findById(id);			
	}
	
	public Farm saveFarm(Farm farm) {
		return farmRepository.save(farm);
	}

	public void updateFarm(Farm farm) {
		farmRepository.save(farm);
	}
	
	public void deleteFarm(Integer id) {
		farmRepository.deleteById(id);
	}
	
}
