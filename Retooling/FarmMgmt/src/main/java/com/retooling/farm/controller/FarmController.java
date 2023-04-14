package com.retooling.farm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retooling.farm.model.Farm;
import com.retooling.farm.service.FarmService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class FarmController {

	@Autowired
	FarmService farmService;
	
	//Obtener todas las granjas
	@GetMapping("farms")
	public ResponseEntity<List<Farm>> getAllFarms() {
		try {
			List<Farm> farms = farmService.getAllFarms();
			if (farms.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(farms, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Obtener una granja por id
	@GetMapping("farms/{id}")
	public ResponseEntity<Farm> getFarmById(@PathVariable("id") Integer id) {
		try {
			Optional<Farm> farm = farmService.getFarmById(id); 
			if (farm.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);				
			else
				return new ResponseEntity<>(farm.get(), HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Guardar una granja
	@PostMapping("farms")
	public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
		try {
			//Optional<Farm> f = farmService.saveFarm(farm);
			//if (f.isEmpty())
				
			return new ResponseEntity<>(farmService.saveFarm(farm), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	//Actualizar datos de una granja
	@PutMapping("farms")
	public ResponseEntity<Farm> updateFarm(@RequestBody Farm farmUpdated) {
		try {
			Optional<Farm> farm = farmService.getFarmById(farmUpdated.getId());
			if (farm.isEmpty()) {
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			} else {
				farmService.updateFarm(farmUpdated);
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Borrar una granja
	@DeleteMapping("farms/{id}")
	public ResponseEntity<Farm> deleteFarm(@PathVariable("id") Integer id){
		try {
			Optional<Farm> farm = farmService.getFarmById(id);
			if (farm.isEmpty()) {
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			} else {
				farmService.deleteFarm(id);
				return new ResponseEntity<> (null, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
