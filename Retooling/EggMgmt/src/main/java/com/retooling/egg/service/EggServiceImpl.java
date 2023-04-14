package com.retooling.egg.service;

import com.retooling.egg.service.EggService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retooling.egg.model.Egg;
import com.retooling.egg.repository.EggRepository;

@Service
public class EggServiceImpl implements EggService {

	@Autowired
	EggRepository eggRepository;
	
	public List<Egg> getAllEggs() {
		return eggRepository.findAll();			
	}

	public Optional<Egg> getEggById(Integer id) {
		return eggRepository.findById(id);			
	}
	
	public Egg saveEgg(Egg egg) {
		return eggRepository.save(egg);
	}

	public void updateEgg(Egg egg) {
		eggRepository.save(egg);
	}
	
	public void deleteEgg(Integer id) {
		eggRepository.deleteById(id);
	}
	
}
