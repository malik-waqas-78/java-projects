
package com.mycompany.agriculturalmanagementsystem;

import java.util.ArrayList;


public class Store implements CropKeeper{

    private String id;
    private String name;
    private float maxCapacityArea;
    private float usedCapacityArea;
    private int KGperSquareMeter=10;
    
    ArrayList<Fruit> fruits=new ArrayList<Fruit>();

    public Store() {
    }

    public Store(String name,String id, float maxCapacityArea, float usedCapacityArea) {
        this.id = id;
        this.name = name;
        this.maxCapacityArea = maxCapacityArea;
        this.usedCapacityArea = usedCapacityArea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMaxCapacityArea() {
        return maxCapacityArea;
    }

    public void setMaxCapacityArea(float maxCapacityArea) {
        this.maxCapacityArea = maxCapacityArea;
    }

    public float getUsedCapacityArea() {
        return usedCapacityArea;
    }

    public void setUsedCapacityArea(float usedCapacityArea) {
        this.usedCapacityArea = usedCapacityArea;
    }

    public int getKGperSquareMeter() {
        return KGperSquareMeter;
    }

    public void setKGperSquareMeter(int KGperSquareMeter) {
        this.KGperSquareMeter = KGperSquareMeter;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }
    
    
    public float availableCapacity(){
        return maxCapacityArea-usedCapacityArea;
    }
    
    public boolean canBeStored(Fruit f){
        float remainingCapacity=availableCapacity();
        float howManyKGcanBeStored=remainingCapacity/KGperSquareMeter;
        return howManyKGcanBeStored>f.weight;
    }
    
    public void importCrop(Fruit fruit) throws CapacityNotEnoughException{
        if(canBeStored(fruit)){
            boolean isAlreadyStored=false;
            int storedAtIndex=-1;
            for(int i=0;i<fruits.size();i++){
                if(fruits.get(i).compareTo(fruit)==0){
                    isAlreadyStored=true;
                    storedAtIndex=i;
                    break;
                }
            }
            
            if(isAlreadyStored){
                Fruit f=fruits.get(storedAtIndex);
                f.weight+=fruit.weight;
                usedCapacityArea+=(f.weight/KGperSquareMeter);
                fruits.set(storedAtIndex,f);
            }else{
                fruit.cropKeeper=this;
                fruits.add(fruit);
            }
        }else{
            throw new CapacityNotEnoughException("Remaining Capacity is not enogh to store this Fruit.");
        }
    }
    
    public void exportCrop(Fruit f) throws FruitNotFoundException, Exception{
       boolean isAlreadyStored=false;
       int storedAtIndex=-1;
       for(int i=0;i<fruits.size();i++){
        if(fruits.get(i).compareTo(f)==0){
            isAlreadyStored=true;
            storedAtIndex=i;
            break;
        }
       }
       
       if(isAlreadyStored){
           if(f.weight==fruits.get(storedAtIndex).weight){
               fruits.remove(storedAtIndex);
               usedCapacityArea-=(f.weight/KGperSquareMeter);
           }else{
               throw new  Exception("No partial export or import is possible");
           }
       }else{
           throw new FruitNotFoundException("This Fruit is not stored in the store.");
       }
            
    }
    
    @Override
    public void howToStore(Crop c) {
        if(c instanceof Fruit){
            System.out.println("it is stored in large refrigerated cooler rooms.");
        }else{
            System.out.println("it is kept in in sheds, not listed");
        }
    }

    @Override
    public String getKeeperId() {
          return id;
    }

    @Override
    public String toString() {
        return name+","+id+","+maxCapacityArea+","+usedCapacityArea;
    }
    
    
    
}
