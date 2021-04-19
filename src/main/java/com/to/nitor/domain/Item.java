package com.to.nitor.domain;

public class Item {
	
	private String Name;
	private Long Quantity;
	private Long Id;
	
	public Item(String Name, Long Quantity) {
		this.Name = Name;
		this.Quantity = Quantity;
		this.Id = null;
	}
	
	public Item(String Name, Long Quantity, Long Id) {
		this.Name = Name;
		this.Quantity = Quantity;
		this.Id = Id;
	}
	
	public Item(String Name, int Quantity, int Id) {
		this.Name = Name;
		this.Quantity = Long.valueOf(Quantity);
		this.Id = Long.valueOf(Id);
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
