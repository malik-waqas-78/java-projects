/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyera.mavenproject1;

/**
 *
 * @author malik-waqas
 */
public class GoldAccount extends Account {
    public GoldAccount(){
        super();
        
    }
    public GoldAccount(double freeMinutes,double packageFee){
        super(freeMinutes,packageFee);
    }
    
    @Override
    public void sendSMS(int nSMS){
        super.sendSMS(nSMS);
    }
    
    @Override
     public String toString(){
        return super.toString() ;
    }
    @Override
    public void setCustomerID(String ID){
        super.setCustomerID(ID);
    }
    
    
    @Override
    public void makeCall(double durateion){
        super.makeCall(durateion);
    }
    
}
