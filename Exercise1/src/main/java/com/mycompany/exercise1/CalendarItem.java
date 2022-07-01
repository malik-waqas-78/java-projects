
package com.mycompany.exercise1;


public class CalendarItem {
    private int month;
    private int day;

    public CalendarItem(int day, int month) {
        this.month = month;
        this.day = day;
        System.out.println("4");
    }
    
    public void move(int uDay,int uMonth){
        day=uDay;
        month=uMonth;
    }

    @Override
    public String toString() {
        return day+"/"+month;
    }
    
    
}
