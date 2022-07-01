
package pate1838;

import java.util.Scanner;
/**
 * 
 * @author Name:  jay patel
 * Assignment:  [the name/title of the submission]
 * Program: [the name of the program you're enrolled in i.e. Computer Programmer
 * or Programmer Analyst]
 * 
 * Date: 27 May,2021
 * 
 * main class which is used to test the employee class
 * it will create a scanner and an array to hold three employee objects
 * used for loop to insert values for 3 employees
 * if any fields value of employee is entered incorrectly user is shown a
 * proper message and forced to enter the correct value again
 * after successful initialization of properties entered details of the 
 * employee is shown
 */
public class Main {
    
    /**

     * @param args 
     */
    public static void main(String[] args) {
        
        Employee employee1;
        Employee employee2;
        Employee employee3;
        System.out.println("Enter Eployee 1's Details");
        employee1=insertEmployeeDetails();
        System.out.println("Enter Eployee 2's Details");
        employee2=insertEmployeeDetails();
        System.out.println("Enter Eployee 3's Details");
        employee3=insertEmployeeDetails();
        
       
        System.out.println("");
        System.out.println("Employee 1's Details : ");
        System.out.println(employee1.toString());
        System.out.println("Employee 2's Details : ");
        System.out.println(employee2.toString());
        System.out.println("Employee 3's Details : ");
        System.out.println(employee3.toString());
    }
    
    /**
     * this method asks user to insert employee details
     * @return employee
     */
    
    public static Employee insertEmployeeDetails(){
        Employee employee=new Employee();
        Scanner scan=new Scanner(System.in);
        while(true){
                System.out.println("Enter Employee's ID: ");
                
                try{
                    employee.setId(scan.nextLine());
                }catch(IllegalArgumentException e){
                    System.out.println(e.toString());
                    continue;
                }
                break;
            }
            while(true){
                System.out.println("Enter Employee's Name: ");
                try{
                    employee.seteName(scan.nextLine());
                }catch(IllegalArgumentException e){
                    System.out.println(e.toString());
                    continue;
                }
                break;
            }
            while(true){
                System.out.println("Enter Employee's number of years of "
                        + "experiencs : ");
                try{
                    employee.setNumOfYears(scan.nextInt());
                    scan.nextLine();
                }catch(IllegalArgumentException e){
                    System.out.println(e.toString());
                    continue;
                }
                break;
            }
            while(true){
                System.out.println("Enter Employee's Monthly Salary : ");
                try{
                    employee.setMonthlySalary(scan.nextDouble());
                    scan.nextLine();
                }catch(IllegalArgumentException e){
                    System.out.println(e.toString());
                    continue;
                }
                break;
            }
            while (true){
                System.out.println("Is Employee a Manager[ Y/N ] : ");
                try{
                    String input=scan.nextLine();
                    if(input.equalsIgnoreCase("y")){
                        employee.setManager(true);
                    }else if(input.equalsIgnoreCase("n")){
                        employee.setManager(false);
                    }else{
                        System.out.println("Wrong Input you can only enter Y/N.");
                        continue;
                    }
                }catch(IllegalArgumentException e){
                    continue;
                }
                break;
                
            }
            
            return employee;
    }
}
