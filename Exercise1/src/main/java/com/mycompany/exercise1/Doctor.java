
package com.mycompany.exercise1;


public abstract class Doctor {
    protected String id;
    protected String name;
    protected int duration;
    protected double rate;

    public Doctor() {
    }

    public Doctor(String id, String name, int duration, double rate) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.rate = rate;
    }
    
    public abstract int calculateConsultingTime();
    public abstract double calculateTotalFee();

    @Override
    public String toString() {
        return "Doctor ID is " + id + ", and name is DR. " + name ;
    }
    
}
