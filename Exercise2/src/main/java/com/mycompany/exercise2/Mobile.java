
package com.mycompany.exercise2;

import java.util.ArrayList;


public class Mobile {
    
    public double mobilePrice;
    public String mobileBrand;
    public int mobileYear;
    
    private ArrayList<Component> components=new ArrayList<>();

    public Mobile(String mobileBrand,int mobileYear,double mobilePrice ) {
        this.mobilePrice = mobilePrice;
        this.mobileBrand = mobileBrand;
        this.mobileYear = mobileYear;
    }

  
    
    public Mobile(String mobileBrand,int mobileYear,double mobilePrice  , ArrayList<Component> components) {
        this.mobilePrice = mobilePrice;
        this.mobileBrand = mobileBrand;
        this.mobileYear = mobileYear;
        this.components = components;
    }
    
    public void addComponent( Component c){
        components.add(c);
    }
    
    public int totalComponents(){
        return components.size();
    }
    
    
}
