

package com.mycompany.practicle;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Practicle {

    public static void main(String[] args) {
      Scanner scan =new Scanner(System.in);
      int gear=0;
      int speed=0;
      int height=0;
		try{
		    System.out.println("Enter Gear Value : ");
		    gear=scan.nextInt();
                    System.out.println("Enter Bike speed : ");
		    speed=scan.nextInt();
		    System.out.println("Enter Bike Seat Height : ");
		    height=scan.nextInt();
		    MountainBike mountainBike=new MountainBike();
		    mountainBike.setSeatHeight(height);
		    mountainBike.setGear(gear);
		    mountainBike.setSpeed(speed);
                    System.out.println(mountainBike.toString());
		    
		}catch(InputMismatchException e){
		    System.out.println("Only integer numbers are accepted");
		}finally{
                    System.out.println("Exiting");
		}
    }
}
