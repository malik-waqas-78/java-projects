
package com.mycompany.exercise1;

import java.util.ArrayList;


public class Meeting extends CalendarItem{
    private String time;
    private ArrayList<String> participants;

    public Meeting(  int day,int month,String time) {
        super(day, month);
        this.time = time;
       
    }
    
    public static void main(String[] args) {
        ArrayList<CalendarItem> s=new ArrayList<>();
        s.add(new CalendarItem(2, 3));
        s.add(new Birthday("ali",3, 4));
        System.out.println(s);
    }
    
    public void addParticipants(String name){
        participants.add(name);
    }
    
    public void move(int uDay,int uMonth,String uTime){
        super.move(uDay, uMonth);
        time=uTime;
    }
    private void display(Flight f){
        System.out.println("Passengers with Extra Luggage");
        for(Passenger p:f.Passengers){
            for(Luggage l:p.luggage){
                if(l.getLength()+l.getHeight()+l.getwidth()>150&&l.weight>23){
                    System.out.println(l.toString());   
                }
            }
           
        }
    }

    public Meeting(String x ) {
        System.out.println("x");
    }
    
    
    
}
