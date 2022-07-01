/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyera.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author malik-waqas
 */
public class DriverClass {
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        
        String customerID=scan.nextLine();
        String owner=scan.nextLine();
        double freeMinutes=scan.nextDouble();
        double packageFee=scan.nextDouble();
        
        Customer customer=new Customer(customerID,owner);
        
        GoldAccount gAcc=new GoldAccount(freeMinutes,packageFee);
        SilverAccount sAcc=new SilverAccount(freeMinutes,packageFee);
        
        customer.addAccount(gAcc);
        customer.addAccount(sAcc);
        
        gAcc.makeCall(2);
        sAcc.makeCall(4);
        
        gAcc.sendSMS(23);
        sAcc.sendSMS(23);
        
        System.out.println(customer.toString());
        System.out.println(gAcc.toString());
        System.out.println(sAcc.toString());
        
        
    }
}
