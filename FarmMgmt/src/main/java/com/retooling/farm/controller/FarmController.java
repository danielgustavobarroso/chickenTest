package com.retooling.farm.controller;

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

import com.retooling.farm.model.Farm;
import com.retooling.farm.service.FarmService;
import com.retooling.farm.service.FarmServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class FarmController {

	@Autowired
	FarmService farmService;
	
	/*@GetMapping("/farms")
	public List<Farm> getAllFarms() {
		return farmService.getAllFarms();
	}

	@PostMapping("/farm")
	public Farm createFarm(@RequestBody Farm farm) {
		return farmService.createFarm(farm);
	}*/
	
	//obtener todas las granjas
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

	//obtener una granja por id
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
	
	//guardar una granja
	@PostMapping("farms")
	public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
		try {
			return new ResponseEntity<>(farmService.saveFarm(farm), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//actualizar datos de una granja
	@PutMapping("farms/{id}")
	public ResponseEntity<Farm> updateFarm(@PathVariable("id") Integer id, @RequestBody Farm farmUpdated) {
		try {
			Optional<Farm> farm = farmService.getFarmById(id);
			if (farm.isEmpty()) {
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			} else {
				farmUpdated.setId(id);
				farmService.updateFarm(farmUpdated);
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//borrar una granja
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
