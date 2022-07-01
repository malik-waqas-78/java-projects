
package com.mycompany.exercise1;


public class Specialist extends Doctor{
    private String speciality;

    public Specialist() {
    }

    public Specialist(String id, String name, int duration, double rate,String specialist) {
        super(id, name, duration, rate);
        this.speciality = specialist;
    }
    
    

    @Override
    public int calculateConsultingTime() {
        return (duration%15)+1;
    }

    @Override
    public double calculateTotalFee() {
        return calculateConsultingTime()*rate;
    }

    @Override
    public String toString() {
        return "Dr. "+name+" total fee is "+calculateTotalFee();
    }
    
    
    
    
}
