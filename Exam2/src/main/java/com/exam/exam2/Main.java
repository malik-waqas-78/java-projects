
package com.exam.exam2;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops=new ArrayList<Laptop>();
        Laptop mac=new Laptop("MacBook Pro", "Silver", 6239, new Screen("1680 x 1050","Ratina"));
        Laptop dell=new Laptop("Dell G15", "Black", 4540, new Screen("1920 x 1080","4K UHD")); 
        Laptop mate=new Laptop("MateBook XPro", "Emerlad Green", 6499, new Screen("3000 x 2000","3k FullView"));
        
        laptops.add(mac);
        laptops.add(dell);
        laptops.add(mate);
        
        System.out.println(laptops.get(0).getScreen());
        
        double totalPrice=0;
        for(int i=0;i<laptops.size();i++){
            totalPrice+=laptops.get(i).getPrice();
        }
        double avgPrice=totalPrice/laptops.size();
        System.out.println("Average price : "+avgPrice);
            
    }
}
