
package com.mycompany.exercise2;


public class Camera {
    private int focalLength;
    private int batteryLife;

    public Camera(int focalLength, int batteryLife) {
        this.focalLength = focalLength;
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return  "FocalLength=" + focalLength + " BatteryLife=" + batteryLife ;
    }
    
    
}
