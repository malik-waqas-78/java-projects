
package com.mycompany.agriculturalmanagementsystem;


public class Fruit extends Crop implements Comparable<Fruit>{

    String taste;
    final String type="fruit";
   String cultivatedSeasson;

    public Fruit() {
    }

    public Fruit(String name,float weight,String cultivatedSeasson,String taste, float price, CropKeeper cropKeeper) {
        super(name, weight,price,cropKeeper);
        this.taste = taste;
        this.cultivatedSeasson=cultivatedSeasson;
      
        
    }
    
    @Override
    public String toString() {
        return name+","+type+","+weight+","+cultivatedSeasson+","+taste+","+price+","+cropKeeper.getKeeperId();
    }

    @Override
    public void consumeIt() {
        System.out.println("It is consumed Raw.");
    }

    @Override
    public void storeIt() {
        cropKeeper.howToStore(this);
    }

    @Override
    public int compareTo(Fruit o) {
        if(this.name.equalsIgnoreCase(o.name)){
            return 0;
        }else{
            return (int) (this.weight-o.weight);
        }
    }

    
}
