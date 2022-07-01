
package quize3;

import java.awt.Font;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Quize3 {

    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        try{
            System.out.println("Enter Maximum Capacity of car : ");
        int carCapacity=scan.nextInt();
        System.out.println("Ener total number of passangers : ");
        int totalPassangers=totalPassangers=scan.nextInt();
            int maxCarsNeeded=totalPassangers/carCapacity;
        System.out.println(maxCarsNeeded);
        }catch(ArithmeticException e){
            System.out.println("/ by zero. Car capacity can't be zero.");
            
        }catch(InputMismatchException e){
            System.out.println("Only Integers are allowed as input.");
           
        }
        
    }
    
}
