/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyera.mavenproject1;

/**
 *
 * @author malik-waqas
 */
public class Account {
    
    private String telNum="123";
    private double freeMinutes;
    private double packageFee;
    private double totalCharge;
    private double rate=0.5;
    
    private String customerID;
    
    public Account(){
        
    }
    
    public Account(double freeMinutes,double packageFee){
        
        this.freeMinutes=freeMinutes;
      
        this.packageFee=packageFee;
    }
    
    public void makeCall(double dutration){
        try{
            totalCharge=totalCharge+dutration*rate;
        }catch(ArithmeticException e){
            System.out.println(e);
        }
    }
    public void sendSMS(int nSMS){
        
    }
    public String toString(){
    
  return "Account [ telNumber = "+telNum+" freeMinutes = "+freeMinutes+" totalCharge = "+totalCharge+" packageFee = "+packageFee+"]"  ;
    }
    
    
    public void setCustomerID(String ID){
        customerID=ID;
    }
}
