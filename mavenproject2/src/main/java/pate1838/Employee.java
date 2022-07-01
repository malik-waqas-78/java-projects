
package pate1838;

import java.lang.IllegalArgumentException;

/*
*
* Name: [your name here]
*
* File:  Employee.java
* Main class: Main.java
*
*/


public class Employee {
private String id="100";
private  String  eName="New Employee";
private int numOfYears=1;
private double monthlySalary=20000;
private boolean manager=true;


/**
 * a default empty constructor
 */
public Employee(){
    
}
/**
 * 
 * @param id : id of the employee
 * @param name :  name of the employee
 *             it cant be null object or null string
 * @param numOfYears : Number of years representing employees experience
 * 
 * this function is a default constructor which receives the above parameters 
 * and set those parameters to employees properties
 */
public Employee(String id,String name,int numOfYears){
    setId(id);
    seteName(name);
    setNumOfYears(numOfYears);
}

/**
 * 
 * @param id : employee id
 * @param name : employee name 
 * @param numOfYears : Number of years representing employees experience which 
 * must be of  1 or more years
 * @param monthlySalary : employee's monthly salary which can't be less than 
 * 2000 
 * @param manager : variable representing whether employee is a manager or not
 */
public Employee(String id,String name,int numOfYears,double monthlySalary
        ,boolean manager){
    setId(id);
    seteName(name);
    setNumOfYears(numOfYears);
    setMonthlySalary(monthlySalary);
    setManager(manager);
}
    
/**
 * 
 * @return id of the employee 
 */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id receives id of employee and set it to id variable after making 
     * sure its correct 
     * throws IllegalArgumentException if id is null or is empty
     */
    public void setId(String id) {
        if(id==null){
            throw new IllegalArgumentException("Employee Id must not be null.");
        }else if(id.isEmpty()){
            throw new IllegalArgumentException("Employee Id must not be empty.");
        }else{
            this.id = id;
        }
    }

    /**
     * 
     * @return employees name 
     */
    public String geteName() {
        return eName;
    }

    /**
     * 
     * @param eName employee name 
     * throws IllegalArgumentException if name is null or empty.
     */
    
    public void seteName(String eName) {
        if(eName==null){
            throw new IllegalArgumentException( "Name can't be Null.");
        }else if(eName.isEmpty()){
            throw new IllegalArgumentException("Name cna't be Empty.");
        }else{
        this.eName = eName;
        }
    }

    /**
     * 
     * @return num of years of employees experience
     */
    public int getNumOfYears(){
      
        return numOfYears;
    }

    /**
     * 
     * @param numOfYears employees experience years number
     * throws IllegalArgumentException if this field is less than 1 as it must 
     * be greater than 1 
     */
    public void setNumOfYears(int numOfYears) {
        if(numOfYears<1){
            throw new IllegalArgumentException("Num of Employees Experience years"
                    + " can't be less than 1.");
        }else{
            this.numOfYears = numOfYears;
        }
    }

    /**
     * 
     * @return employees monthly salary 
     */
    public double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * 
     * @param monthlySalary employees monthly salary
     * throws IllegalArgumentException if its value is less than 2000 as its value 
     * should be more than 2000
     */
    
    public void setMonthlySalary(double monthlySalary) {
        if(monthlySalary<2000){
            throw new IllegalArgumentException("Employees Monthly salary can't "
                    + "be less tahn 2000. ");
        }else{
            this.monthlySalary = monthlySalary;
        }
    }

    /**
     * 
     * @return manager 
     */
    public boolean isManager() {
        return manager;
    }
    
    /**
     * 
     * @param manager represents whether employee is manager or not
     */

    public void setManager(boolean manager) {
        this.manager = manager;
    }
    
    /**
     * 
     * @param numOfYears employees experience
     * @param monthlySalary 
     * @return num of years * monthly salary
     */
    public double calTotS(int numOfYears,double monthlySalary){
            return numOfYears*monthlySalary;
    }
    /**
     * 
     * @param manager
     * @param monthlySalary
     * @return if employee is manager than returns a bonus of 5 times of monthly
     * pay else return 0 
     */
    public double calBonus(boolean manager,double monthlySalary){
        if(manager){
            return monthlySalary*5;
        }else{
            return 0;
        }
    }

    /**
     * 
     * @return employee object as string 
     */
    @Override
    public String toString() {
        return  String.format("%7s", "id")+"\t"+String.format("%20s","Name")+"\t"
                +String.format("%20s", "Number Of Years")+"\t"+
                String.format("%20s", "Total Salary")+"\t"+
                String.format("%20s", "Bonus")+"\t"+
                String.format("%10s", "Manager")+"\n"+
                String.format("%7s", id)+"\t"+String.format("%20s", eName)+"\t"
                +String.format("%20s", numOfYears)+"\t"+String.format("%20s", 
                calTotS(numOfYears, monthlySalary))+"\t"+
                String.format("%20s", calBonus(manager, monthlySalary))+"\t"+
                (String.format("%10s", manager?"Yes":"No"));
    }
    
    
    

}
