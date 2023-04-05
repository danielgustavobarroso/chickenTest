package com.retooling.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retooling.farm.repository.FarmRepository;

@RestController
@RequestMapping("/api")
public class FarmController {

	@Autowired
	FarmRepository farmRepository;

	@GetMapping("/farm")
	public String getAllFarms() {	
		System.out.println("hola1");
		return "getAllFarms";
	}
		
}
