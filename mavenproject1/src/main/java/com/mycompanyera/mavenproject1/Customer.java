/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyera.mavenproject1;

import java.util.ArrayList;


public class Customer {
      public String ID;
    public String Name;
    
    
    public ArrayList<Account> accounts=new ArrayList<Account>();
    
    public Customer(){
        
    }
    
    public Customer(String ID,String Name){
        this.ID=ID;
        this.Name=Name;
    }
    public void addAccount(Account acc){
        accounts.add(acc);
    }
    
    public String getID(){
        return ID;
    } 
    
    public String getName(){
        return Name;
    }
    
    public String toString(){
        return "Customer [ ID = "+ID+" NAME = "+Name+"]";
    }
    
}

