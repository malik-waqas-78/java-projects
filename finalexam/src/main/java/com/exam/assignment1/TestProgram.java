
package com.exam.assignment1;


public class TestProgram {
    public static void main(String[] args) {
        Expo2020_Country country1=new Expo2020_Country("Luxemborg","Oppertunity "
                + "District",2500000,"The only pavillion to have a slide",3650);
        Expo2020_Country country2=new Expo2020_Country("UAE","AL Forsan",5500000,"THE Uae"
                + "Pavillion features 28 movebale wings",15064);
        Expo2020_Country country3=new Expo2020_Country("Germany","Sustainable District",4300000,
        "the graduation hall has swinging seats",4600);
        
        if(country1.getPavilionArea()>=country2.getPavilionArea()){
            if(country1.getPavilionArea()>=country3.getPavilionArea()){
                System.out.println(country1.getCountryName()+" has the biggest pavillion area.");
            }else{
                System.out.println(country3.getCountryName()+" has the biggest pavillion area.");
            }
        }else if(country2.getPavilionArea()>=country3.getPavilionArea()){
            System.out.println(country2.getCountryName()+" has the biggest pavillion area.");
        }else{
            System.out.println(country3.getCountryName()+" has the biggest pavillion area.");
        }
        
        country1.addNewVisitor();
        
        System.out.println("no of visitos in "+country1.getCountryName()+" is "+country1.getNoOfVisitors());
    }
}
