package com.retooling.farm.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "farm")
public class Farm {
	
//	@Value("{farm.name}")
	private String name;
	
	/*private Integer eggLimit;
	private Integer chickenLimit;
	private Integer cattleMininum;
	private Double availableMoney;*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
