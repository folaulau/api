package com.kaveinga.pizzaria.order;

import java.util.Date;
import java.util.Set;

import com.kaveinga.pizzaria.item.Item;

public class Order {
	private Long id;
	private Integer total;
	private Set<Item> items;
	private Date time;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
