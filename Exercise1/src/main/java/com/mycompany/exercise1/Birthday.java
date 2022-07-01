
package com.mycompany.exercise1;


public class Birthday extends CalendarItem{
    private String name;
    public int birth_year;

    public Birthday(String name, int day, int month) {
        super(day, month);
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"'s birthday  is on "+super.toString();
    }
    
  
}
