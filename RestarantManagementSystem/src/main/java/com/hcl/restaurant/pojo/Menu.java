package com.hcl.restaurant.pojo;

public class Menu {
	private int itemId;
	private String item;
	private Double price;
	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Menu(int itemId, String item, Double price) {
		super();
		this.itemId = itemId;
		this.item = item;
		this.price = price;
	}




	
	

	public int getItemId() {
		return itemId;
	}





	public void setItemId(int itemId) {
		this.itemId = itemId;
	}





	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}





	@Override
	public String toString() {
		return "Menu [ item=" + item + ", price=" + price + "]";
	}


	
	
	
}
