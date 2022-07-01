
package com.mycompany.exercise2;

import java.util.ArrayList;


public class Drone {
    
    private String type;
    private int maxSpeed;
    private int maxDistance;
    
    private ArrayList<Camera> cameras=new ArrayList<Camera>();

    public Drone() {
    }

    public Drone(String type, int maxSpeed, int maxDistance) {
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
    }
    
    public void addCamera(Camera c){
        cameras.add(c);
    }
    
    public int calculate_camera_number(){
        return cameras.size();
    }
    
}
