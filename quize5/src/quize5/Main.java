
package quize5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

   
    public static void main(String[] args) {
        
        String name;
        int id;
        double GPA;
        int year;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Student name : ");
		    name=scan.nextLine();
                    System.out.println("Enter Student ID : ");
		    id=scan.nextInt();
		    System.out.println("Enter Student GPA : ");
		    GPA=scan.nextDouble();
                try{
		    
		    System.out.println("Enter Student Graduation Year : ");
		    year=scan.nextInt();
                    Graduate graduate=new Graduate();
		    graduate.setName(name);
                    graduate.setGPA(GPA);
                    graduate.setId(id);
                    graduate.setYear(year);
                    System.out.println(graduate.toString());
		    
		}catch(InputMismatchException e){
		    System.out.println("String and Doubles are not allowed. Only integer numbers are accepted");
		}finally{
                    System.out.println("Exiting");
		}
    }
    
}
