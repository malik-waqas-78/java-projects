
package com.mycompany.exercise1;


public abstract class Jewelry {
    
    protected String Metal;
    protected double weight;
    protected double PricePerGram;
    protected double price;
    protected double tax;

    public Jewelry() {
    }

    public Jewelry(String Metal, double weight, double PricePerGram) {
        this.Metal = Metal;
        this.weight = weight;
        this.PricePerGram = PricePerGram;
    }

    @Override
    public String toString() {
        return "" + "The Metal used: " + Metal + "\nThe weight is :" + weight + "grams";
    }
    
    public  abstract void  calculatePrice();
    
    public abstract void calculateTax();
    
}
