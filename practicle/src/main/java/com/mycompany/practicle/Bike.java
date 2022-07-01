
package com.mycompany.practicle;

public class Bike{
    protected int gear;
    protected int speed;
    public Bike(int gear,int speed){
        this.gear=gear;
        this.speed=speed;
    }
    public Bike(){
        this.gear=0;
        this.speed=0;
    }
    
    public int getGear(){
        return gear;
    }
    public void setGear(int gear){
        this.gear=gear;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    @Override
    public String toString(){
        return "Bike is going at a speed of "+getSpeed()+" KM/h and is in "+getGear()+
        " gear.";
    }
}
