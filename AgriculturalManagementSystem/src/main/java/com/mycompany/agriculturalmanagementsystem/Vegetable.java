
package com.mycompany.agriculturalmanagementsystem;


public class Vegetable extends Crop implements Comparable<Vegetable>{

    String cultivatdRegion;
    final String type="vegetable";

    public Vegetable() {
        
    }

    public Vegetable(String name, float weight,String cultivatdRegion, CropKeeper cropKeeper) {
        super(name, weight, 10,cropKeeper);
        this.cultivatdRegion = cultivatdRegion;
        
    }
    
    
    
    
    
    @Override
    public String toString() {
        return name+","+type+","+weight+","+cultivatdRegion+","+price+","+cropKeeper.getKeeperId();
    }

    @Override
    public void consumeIt() {
        System.out.println("it is coocked.");
    }

    @Override
    public void storeIt() {
        cropKeeper.howToStore(this);
    }

    @Override
    public int compareTo(Vegetable o) {
            if(this.name.equalsIgnoreCase(o.name)){
                return 0;
            }else{
                return (int) (this.weight-o.weight);
            }
    }

    
    
}
