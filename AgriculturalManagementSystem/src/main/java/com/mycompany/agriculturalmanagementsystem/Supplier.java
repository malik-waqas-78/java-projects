
package com.mycompany.agriculturalmanagementsystem;


import java.util.ArrayList;


public class Supplier implements CropKeeper{

    String name;
    String id;
    float budget;
    ArrayList<Crop> cropList=new ArrayList<Crop>();

    public Supplier() {
    }

    public Supplier(String name, String id, float budget) {
        this.name = name;
        this.id = id;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public ArrayList<Crop> getCropList() {
        return cropList;
    }

    public void setCropList(ArrayList<Crop> cropList) {
        this.cropList = cropList;
    }
    
    public void buyCrop(Crop c,Store store) throws SupplierHasNotEnoughMOney{
        if(c.price<budget){
            try {
                
                store.exportCrop((Fruit) c);
                budget-=c.price;
                c.cropKeeper=this;
                cropList.add(c);
            } catch (FruitNotFoundException ex) {
                System.out.println(ex.getMessage());
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }else{
            throw new SupplierHasNotEnoughMOney("Supplier has no mony to buy this crop.");
        }
    }
    
    public void sellCrop(Crop c,Store s) throws FruitNotFoundException{
        if(cropList.contains(c)){
            try {
                s.importCrop((Fruit) c);
                budget+=c.price;
                cropList.remove(c);
            } catch (CapacityNotEnoughException ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            throw new FruitNotFoundException("This Fruiyt is not owned by Supplier.");
        }
    }
    
    @Override
    public void howToStore(Crop c) {
            if(c instanceof Fruit){
                System.out.println("it is stored in big refegraators.");
            }else{
                System.out.println("it is kept in the field booths");
            }
        
    }

    @Override
    public String getKeeperId() {
        return id;
    }

    @Override
    public String toString() {
        return name+","+id+","+budget;
    }
    
    
    
    
}