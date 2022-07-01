
package com.mycompany.exercise1;


public class Necklace extends Jewelry{
    
    private double length;

    public Necklace() {
    }

    public Necklace( String Metal, double weight, double PricePerGram,double length) {
        super(Metal, weight, PricePerGram);
        this.length = length;
    }
    
    public void  calculatePrice(){
        price = PricePerGram * weight;
    }
    
    public void calculateTax(){
        tax = price * 0.05;
    }

    @Override
    public String toString() {
        return super.toString()+"\nThe price per gram is : "+PricePerGram + "AED\n"
                + "The necklace price is :"+price+"AED\n"
                + "THe tax is :"+tax+"AED" ;
    }
    
    
    
    
}
