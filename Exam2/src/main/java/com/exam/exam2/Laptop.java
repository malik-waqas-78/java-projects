
package com.exam.exam2;


public class Laptop {
    
    private String brand;
    private String color;
    private double price;
    
    private Screen screen;

    public Laptop() {
    }

    
    
    public Laptop(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    
    
    public Laptop(String brand, String color, double price, Screen screen) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.screen = screen;
    }

    public double getPrice() {
        return price;
    }

    public String getScreen() {
        return "Resolution : "+screen.getResolution()+"\n Type : "+screen.getType();
        
    }

    @Override
    public String toString() {
        return "Laptop Info \nBrand :"  + brand + "\nColor : " + color + "\nScreen : "+getScreen()+'}';
    }
    
    
    
    
    
}
