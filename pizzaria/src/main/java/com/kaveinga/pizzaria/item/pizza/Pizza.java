package com.kaveinga.pizzaria.item.pizza;

import java.util.Set;

import com.kaveinga.pizzaria.item.Item;

public class Pizza extends Item{

	private String size;
	private Set<String> toppings;
	private Integer cookingTime;// in minutes
	
	public Pizza() {
		this(null,null,null);
	}


	public Pizza(String size, Set<String> toppings, Integer cookingTime) {
		super();
		this.size = size;
		this.toppings = toppings;
		this.cookingTime = cookingTime;
	}
	
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Set<String> getToppings() {
		return toppings;
	}
	public void setToppings(Set<String> toppings) {
		this.toppings = toppings;
	}
	public Integer getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(Integer cookingTime) {
		this.cookingTime = cookingTime;
	}
	
	
	
}
