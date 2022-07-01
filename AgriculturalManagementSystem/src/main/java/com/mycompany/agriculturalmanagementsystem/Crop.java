
package com.mycompany.agriculturalmanagementsystem;


abstract class Crop {
    String name;
    float weight;
    
    float price;
   
    CropKeeper cropKeeper;
    public Crop() {
    }

    public Crop(String name, float weight, float price,CropKeeper cropKeeper) {
        this.name = name;
        this.weight = weight;
       
        this.price = price;
        this.cropKeeper=cropKeeper;
       
    }

    
    
    
    
    public abstract String toString();
    public abstract void consumeIt();
    public abstract void storeIt();
}
