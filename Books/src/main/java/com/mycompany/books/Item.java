
package com.mycompany.books;


public class Item{
	private String code;
	private double price;
	private String desc;
	
    public Item() {
		desc="Item";
		price =10; 
    }
	
    //getters and setters
	public String getCode() {
		return code; 
    }
	public double getPrice() {
		return price; 
    }
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setDesc(String desc, String desc2) {
		this.desc = desc;
	}
	public void display() {
		System.out.println(desc + ", " + price + "AED");
	}
	@Override
	public String toString() {
		return "Item [price=" + price + ", desc=" + desc + "]";
	}
	
	
	
}
