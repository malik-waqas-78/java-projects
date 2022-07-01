

package com.mycompany.exercise2;

import java.util.ArrayList;


public class Driver extends Component{

    public static void main(String[] args) {
        
        Camera c1=new Camera(2, 3);
        Camera c2=new Camera(4,2);
       
        Drone d1=new    Drone("tactical", 10, 300);
        d1.addCamera(c1);
        d1.addCamera(c2);
        
        System.out.println("Total Cameras added : "+d1.calculate_camera_number());
    }
    
    
}
