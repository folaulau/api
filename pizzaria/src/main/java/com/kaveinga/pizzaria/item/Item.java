package com.kaveinga.pizzaria.item;

public class Item {
	
	private Long id;
	private String barcode;
	private Double price;
	private String name;
	
	public Item() {
		this(null,null,null,null);
	}
	
	public Item(Long id, String barcode, Double price, String name) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.price = price;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
