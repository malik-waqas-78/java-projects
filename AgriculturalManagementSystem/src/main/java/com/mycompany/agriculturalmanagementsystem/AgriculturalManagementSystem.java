
package com.mycompany.agriculturalmanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AgriculturalManagementSystem {
    static Scanner input;
    
    static ArrayList<Supplier> suppliers=new ArrayList<Supplier>();
    static ArrayList<Store> stores=new ArrayList<Store>();
    static ArrayList<Crop> crops=new ArrayList<Crop>();

    public static void main(String[] args) {
        
        getSuppliersList();
        getStoresList();
        getCropsList();
        input=new Scanner(System.in);
        boolean isRunning=true;
        while(isRunning){
            showMenu();
            int choice=chooseANumber();
            switch (choice) {
                case 0:
                    isRunning=false;
                    break;
                case 1:
                    displayAllSuppliers();
                    break;
                case 2:
                    displayAllStores();
                    break;
                case 3:
                    buyAFruitCrop();
                    break;
                case 4:
                    sellAFruitCrop();
                    break;
                case 5:
                    removeAFruitFromStore();
                    break;
                case 6:
                    removeACropFromSupplier();
                    break;
                case 7:
                    addCrop();
                    break;
                case 8:
                    showRemainigBudget();
                    break;
                case 9:
                    showRemainingCapacity();
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
    }
    
    
    
    //Read files and populate lists
    public static void getSuppliersList(){
        
        
        
      
        try {
            FileInputStream fstream = new FileInputStream("Suppliers.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            String line="";
            while((line=reader.readLine())!=null){
                
                if(line.length()==0){
                    return;
                }
                String splitted[]=line.split(",");
                for(int i=0;i<splitted.length;i++){
                    splitted[i]=splitted[i].trim();
                }
                Supplier supplier=new Supplier(splitted[0],splitted[1],Float.valueOf(splitted[2]));
                suppliers.add(supplier);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(AgriculturalManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void getStoresList(){
        
        try {
            FileInputStream fstream = new FileInputStream("Stores.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            String line="";
            while((line=reader.readLine())!=null){
                if(line.length()==0){
                    return;
                }
                String splitted[]=line.split(",");
                for(int i=0;i<splitted.length;i++){
                    splitted[i]=splitted[i].trim();
                }
                Store store=new Store(splitted[0],splitted[1],Float.valueOf(splitted[2]),Float.valueOf(splitted[3]));
                stores.add(store);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(AgriculturalManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void getCropsList(){
        
        try {
            FileInputStream fstream = new FileInputStream("Crops.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            String line="";
            while((line=reader.readLine())!=null){
                if(line.length()==0){
                    return;
                }
                    
                String splitted[]=line.split(",");
                
                for(int i=0;i<splitted.length;i++){
                    splitted[i]=splitted[i].trim();
                }
                
                if(splitted[1].equalsIgnoreCase("fruit")){
                    Fruit fruit=new Fruit(splitted[0],Float.valueOf(splitted[2]),splitted[3],
                    splitted[4],Float.valueOf(splitted[5]),getCropKeeper(splitted[6]));
                    
                    addCropToList(fruit);
                    
                    crops.add(fruit);
                }else{
                    Vegetable vegetable=new Vegetable(splitted[0],Float.valueOf(splitted[2]),splitted[3],getCropKeeper(splitted[4]));
                    addCropToList(vegetable);
                    crops.add(vegetable);
                }
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(AgriculturalManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static CropKeeper getCropKeeper(String id) {
        if(id.charAt(0)=='5'){
            for(Store s:stores){
                if(s.getId().equals(id)){
                    return s;
                }
            }
        }else{
            for(Supplier s:suppliers){
                if(s.getId().equals(id)){
                    return s;
                }
            }
        }
        return null;
    }

    private static int chooseANumber() {
        System.out.println("Choose a number[0-9]");
        var choice=Integer.valueOf(input.nextLine());
        if(choice>=0&&choice<=9){
            return choice;
        }
        System.out.println("Number should be b/w [0-9]");
        return chooseANumber();
    }

    private static void showMenu() {
        System.out.println("(Press 1) Display all suppliers");
        System.out.println("(Press 2) Display all stores");
        System.out.println("(Press 3) Buy a fruit crop");
        System.out.println("(Press 4) Sell a fruit crop");
        System.out.println("(Press 5) Remove a fruit from a store");
        System.out.println("(Press 6) Remove a crop from a supplier");
        System.out.println("(Press 7) Add crop");
        System.out.println("(Press 8) Show remaining budget");
        System.out.println("(Press 9) Show remaining capacity");
        System.out.println("(Press 0) Quit");
    }

    private static void displayAllSuppliers() {
        for(Supplier supplier:suppliers){
            System.out.println("Suppliers Info : \n"+supplier.toString());
            System.out.println("Suppliers Crops:");
            for(int i=0;i<supplier.cropList.size();i++){
                System.out.println(i+1);
                Crop c=supplier.cropList.get(i);
                System.out.println(c.toString());
                c.consumeIt();
                c.storeIt();
            }
        }
    }

    private static void displayAllStores() {
        for(Store store:stores){
            System.out.println("Suppliers Info : \n"+store.toString());
            System.out.println("Suppliers Crops:");
            for(int i=0;i<store.fruits.size();i++){
                System.out.println(i+1);
                Fruit c=store.fruits.get(i);
                System.out.println(c.toString());
                c.consumeIt();
                c.storeIt();
            }
        }
    }

    private static void buyAFruitCrop() {
        System.out.println("Select A Supplier who would like to buy Fruit");
        for(int i=0;i<suppliers.size();i++){
            System.out.println(suppliers.get(i).name+" (Press "+(i+1)+")");
        }
        int choice=Integer.valueOf(input.nextLine());
        if(choice>0&&choice<=suppliers.size()){
            Supplier s=suppliers.get(choice-1);
            System.out.println("Select a store to buy from");
            for(int i=0;i<stores.size();i++){
                System.out.println(stores.get(i).getName()+" (Press"+(i+1)+")");
            }
            choice=Integer.valueOf(input.nextLine());
            if(choice>0&&choice<=stores.size()){
                Store store=stores.get(choice-1);
                System.out.println("Select crop to buy");
                for(int i=0;i<store.fruits.size();i++){
                    System.out.println(store.fruits.get(i).name+" (Press"+(i+1)+")");
                }
                choice=Integer.valueOf(input.nextLine());
                if(choice>0&&choice<=store.fruits.size()){
                    Crop c=store.fruits.get(choice-1);
                    try {
                        s.buyCrop(c, store);
                        System.out.println(s.name+" has Successfully bought "+c.name+" from "
                                +store.getName()+" store.");
                    } catch (SupplierHasNotEnoughMOney ex) {
                        System.out.println(ex.getMessage());
                    }
                }else{
                                    System.out.println("Wrong input.");

                }
            }else{
                System.out.println("Wrong input.");
            }
        }else{
            System.out.println("Woring input.");
        }
        
    
    }

    private static void sellAFruitCrop() {
        System.out.println("Select A Supplier who would like to sell Fruit");
        for(int i=0;i<suppliers.size();i++){
            System.out.println(suppliers.get(i).name+" (Press "+(i+1)+")");
        }
        int choice=Integer.valueOf(input.nextLine());
        if(choice>0&&choice<=suppliers.size()){
            Supplier s=suppliers.get(choice-1);
            System.out.println("Select a store to store it in");
            for(int i=0;i<stores.size();i++){
                System.out.println(stores.get(i).getName()+" (Press"+(i+1)+")");
            }
            choice=Integer.valueOf(input.nextLine());
            if(choice>0&&choice<=stores.size()){
                Store store=stores.get(choice-1);
                System.out.println("Select crop to sell");
                for(int i=0;i<s.cropList.size();i++){
                    System.out.println(s.cropList.get(i).name+" (Press"+(i+1)+")");
                }
                choice=Integer.valueOf(input.nextLine());
                if(choice>0&&choice<=s.cropList.size()){
                    Crop c=s.cropList.get(choice-1);
                   
                    try {
                        s.sellCrop(c, store);
                        System.out.println(s.name+" has Successfully sold "+c.name+" and crop is stored in "
                                +store.getName()+" store.");
                    } catch (FruitNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                        
                    
                }else{
                                    System.out.println("Wrong input.");

                }
            }else{
                System.out.println("Wrong input.");
            }
        }else{
            System.out.println("Woring input.");
        }
        
    }

    private static void removeAFruitFromStore() {
          System.out.println("Select a store to remove a crop from");
            for(int i=0;i<stores.size();i++){
                System.out.println(stores.get(i).getName()+" (Press"+(i+1)+")");
            }
            int choice=Integer.valueOf(input.nextLine());
            if(choice>0&&choice<=stores.size()){
                Store store=stores.get(choice-1);
                System.out.println("Select crop to remove");
                for(int i=0;i<store.fruits.size();i++){
                    System.out.println(store.fruits.get(i).name+" (Press"+(i+1)+")");
                }
                choice=Integer.valueOf(input.nextLine());
                if(choice>0&&choice<=store.fruits.size()){
                    Crop c=store.fruits.get(choice-1);
                    try {
                        store.exportCrop((Fruit) c);
                    }catch(FruitNotFoundException ex){
                        System.out.println(ex.getMessage());
                    }catch (Exception ex) {
                            
                        System.out.println(ex.getMessage());
                    }
                }else{
                    System.out.println("Wrong input.");

                }
    }
    }

    private static void removeACropFromSupplier() {
        System.out.println("Select A Supplier who would like to remove a Crop");
        for(int i=0;i<suppliers.size();i++){
            System.out.println(suppliers.get(i).name+" (Press "+(i+1)+")");
        }
        int choice=Integer.valueOf(input.nextLine());
        if(choice>0&&choice<=suppliers.size()){
            Supplier s=suppliers.get(choice-1);
           
                System.out.println("Select crop to remove");
                for(int i=0;i<s.cropList.size();i++){
                    System.out.println(s.cropList.get(i).name+" (Press"+(i+1)+")");
                }
                choice=Integer.valueOf(input.nextLine());
                if(choice>0&&choice<=s.cropList.size()){
                    Crop c=s.cropList.get(choice-1);
                    s.cropList.remove(c);
                }else{
                    System.out.println("Wrong input.");
                }
            }else{
                System.out.println("Wrong input.");
            }
        
    }

    private static void addCrop() {
        System.out.println("Choose a crop type to add");
        System.out.println("Fruit (Press 1)");
        System.out.println("Vegetable (Press 2)");
        int choice=Integer.valueOf(input.nextLine());
        switch (choice) {
            case 1:
                addAFruit();
                break;
            case 2:
                addAVegetable();
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }

    private static void showRemainigBudget() {
        
        System.out.println("Select A Supplier to know his remaining budget");
        for(int i=0;i<suppliers.size();i++){
            System.out.println(suppliers.get(i).name+" (Press "+(i+1)+")");
        }
        int choice=Integer.valueOf(input.nextLine());
        
        if(choice>0&&choice<=suppliers.size()){
            Supplier s=suppliers.get(choice-1);
            System.out.println("Remaining budget of "+s.getName()+" is "+s.budget+"AED.");
        }else{
            System.out.println("Wrong input.");
        }
        
    }

    private static void showRemainingCapacity() {
        System.out.println("Select a store to know its capacity");
            for(int i=0;i<stores.size();i++){
                System.out.println(stores.get(i).getName()+" (Press "+(i+1)+")");
            }
            int choice=Integer.valueOf(input.nextLine());
            if(choice>0&&choice<=stores.size()){
                Store store=stores.get(choice-1);
                System.out.println(store.getName()+" has remaining capacity of "+store.availableCapacity()
                +"(m^2)");
            }else{
                System.out.println("Wrong Input");
            }
    }

    private static void addAFruit() {
        System.out.println("Where to add the Fruit.");
        System.out.println("Suppliers' Crop list (Press 1)");
        System.out.println("Sores' Fruit list (Press 2)");
        int choice=Integer.valueOf(input.nextLine());
        switch (choice) {
            case 1:
                Supplier sup=getSuplier();
                if(sup!=null){
                    Fruit f=getTheFruittoAdd();
                    if(f!=null){
                        f.cropKeeper=sup;
                        sup.cropList.add(f);
                        System.out.println("SUCCSSFULLY ADDED.");
                    }
                }
                break;
            case 2:
                Store store=getStore();
                if(store!=null){
                    Fruit f=getTheFruittoAdd();
                    if(f!=null){
                        try {
                            store.importCrop(f);
                            System.out.println("SUCCSSFULLY ADDED.");
                        } catch (CapacityNotEnoughException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }
    
    private static void addAVegetable()
    {
        Supplier sup=getSuplier();
        if(sup!=null){
            Vegetable v=getTheVegetabletoAdd();
            if(v!=null){
                v.cropKeeper=sup;
                sup.cropList.add(v);
                System.out.println("SUCCSSFULLY ADDED.");
            }
        }
    }

    private static Supplier getSuplier() {
        System.out.println("Select a supplier to add Crop");
        for(int i=0;i<suppliers.size();i++){
            System.out.println(suppliers.get(i).name+" (Press "+(i+1)+")");
        }
        int choice=Integer.valueOf(input.nextLine());
        
        if(choice>0&&choice<=suppliers.size()){
            return suppliers.get(choice-1);
        }else{
            System.out.println("Wrong input");
            return null;
        }
    }

    private static Store getStore() {
        System.out.println("Select a Store to add Fruit");
        for(int i=0;i<stores.size();i++){
            System.out.println(stores.get(i).getName()+" (Press "+(i+1)+")");
        }
        int choice=Integer.valueOf(input.nextLine());
        
        if(choice>0&&choice<=stores.size()){
            return stores.get(choice-1);
        }else{
            System.out.println("Wrong input");
            return null;
        }
    }

    private static Fruit getTheFruittoAdd() {
        Fruit f=new Fruit();
        try{
            System.out.println("Enter Fruit Name");
            f.name=input.nextLine();
            System.out.println("Enter Fruit price");
            f.price=Float.valueOf(input.nextLine());
            System.out.println("Enter Weight of the fruit");
            f.weight=Float.valueOf(input.nextLine());
            System.out.println("Enter taste of the fruit");
            f.taste=input.nextLine();
            System.out.println("Enter cultivation season");
            f.cultivatedSeasson=input.nextLine();

        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        
        return f;
    }

    private static Vegetable getTheVegetabletoAdd() {
        Vegetable f=new Vegetable();
        try{
            System.out.println("Enter Vegetable Name");
            f.name=input.nextLine();
            System.out.println("Enter Vegetable price");
            f.price=Float.valueOf(input.nextLine());
            System.out.println("Enter Weight of the Vegetable");
            f.weight=Float.valueOf(input.nextLine());
            System.out.println("Enter cultivation city");
            f.cultivatdRegion=input.nextLine();
           
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        return f;
    }

    private static void addCropToList(Crop fruit) {
        CropKeeper ck=getCropKeeper(fruit.cropKeeper.getKeeperId());
        if(ck instanceof Supplier){
            Supplier supplier=(Supplier)ck;
            supplier.cropList.add(fruit);
        }else{
            Store store=(Store)ck;
            try {
                store.importCrop((Fruit) fruit);
            } catch (CapacityNotEnoughException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
   

}
