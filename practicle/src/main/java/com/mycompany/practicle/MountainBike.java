
package com.mycompany.practicle;

public class MountainBike extends Bike{
    private int seatHeight;
    public MountainBike(int gear,int speed,int seaTheHeight){
        super(gear,speed);
        this.seatHeight=seaTheHeight;
    }
    public MountainBike(){
        super();
        this.seatHeight=0;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }
   

    @Override
    public String toString(){
        return super.toString()+", while seat heioght is "+getSeatHeight()+" inchs.";
    } 
}

