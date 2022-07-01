/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abc.calculator;

import java.util.Scanner;


public class Quize {
     static Scanner scan=new Scanner(System.in);
    
    
    public static void getIncom(double[] data){
         for(int i=0;i<data.length;i++){
             System.out.println("Enter incom : ");
             data[i]=scan.nextDouble();
         }
    }
    
    public static double findMin(double[] data){
        double min=data[0];
        
        for(int i=0;i<data.length;i++){
            if(data[i]<min){
                min=data[i];
            }
        }
        
        return min;
    }
    
    public static void isRich(double[] data,double min){
        double limit=min+(15*min)/100;
        System.out.println("Incom of Families who are rich");
        int count=0;
        for(int i=0;i<data.length;i++){
           if(data[i]>limit){
                System.out.println("Incom "+data[i]);
                count++;
           }
        }
        System.out.println("Totla number of rich families is "+count);
        
    }
    
 
    
    public static void main(String[] args) {
        
       
        
        System.out.println("Enter size of sample : ");
        int size=scan.nextInt();
        double[] arr=new double[size];
        
        getIncom(arr);
        double min=findMin(arr);
        isRich(arr, min);
        
    }


}

