package com.retooling.egg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retooling.egg.model.Egg;
import com.retooling.egg.service.EggService;

@RestController
@RequestMapping("/api/v1")
public class EggController {

	@Autowired
	EggService eggService;
	
	//Obtener todas los huevos
	@GetMapping("eggs")
	public ResponseEntity<List<Egg>> getAllEggs() {
		try {
			List<Egg> eggs = eggService.getAllEggs();
			if (eggs.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(eggs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Obtener un huevo por id
	@GetMapping("eggs/{id}")
	public ResponseEntity<Egg> getEggById(@PathVariable("id") Integer id) {
		try {
			Optional<Egg> egg = eggService.getEggById(id); 
			if (egg.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);				
			else
				return new ResponseEntity<>(egg.get(), HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Guardar un huevo
	@PostMapping("eggs")
	public ResponseEntity<Egg> createEgg(@RequestBody Egg egg) {
		try {
			//Optional<Farm> f = farmService.saveFarm(farm);
			//if (f.isEmpty())
				
			return new ResponseEntity<>(eggService.saveEgg(egg), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	//Actualizar datos de un huevo
	@PutMapping("eggs")
	public ResponseEntity<Egg> updateEgg(@RequestBody Egg eggUpdated) {
		try {
			Optional<Egg> egg = eggService.getEggById(eggUpdated.getId());
			if (egg.isEmpty()) {
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			} else {
				eggService.updateEgg(eggUpdated);
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Borrar un huevo
	@DeleteMapping("eggs/{id}")
	public ResponseEntity<Egg> deleteEgg(@PathVariable("id") Integer id){
		try {
			Optional<Egg> egg = eggService.getEggById(id);
			if (egg.isEmpty()) {
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			} else {
				eggService.deleteEgg(id);
				return new ResponseEntity<> (null, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}