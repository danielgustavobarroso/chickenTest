package com.retooling.farm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

//import 

@Document(collection = "farms")
public class Farm {
	
//	@Value("{farm.name}")
	
	//@NotNull(message = "Name cannot be null")

	/*private Integer eggLimit;
	private Integer chickenLimit;
	private Integer cattleMininum;
	private Double availableMoney;*/
	
	@Id
	private Integer id;
	private String name;
	
	Farm(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", name=" + name + "]";
	}
	
}
