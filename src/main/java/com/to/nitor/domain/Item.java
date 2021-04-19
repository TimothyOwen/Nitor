package com.to.nitor.domain;

public class Item {
	private String Name;
	private Long Quantity;
	private Long Id;
	public Item(String Name, Long Quantity, Long Id) {
		this.Name = Name;
		this.Id = Id;
		this.Quantity = Quantity;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public Long getQuantity() {
		return this.Quantity;
	}
	public void setQuantity(Long Quantity) {
		this.Quantity = Quantity;
	}
	public Long getId() {
		return this.Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
}
