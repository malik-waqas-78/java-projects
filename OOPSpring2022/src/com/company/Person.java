package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private int id;
    private ArrayList<Meeting> myMeetings=new ArrayList<>();
    private ArrayList<Meeting> iOrganize=new ArrayList<>();

    public Person(String name){
        this.name=name;
    }
    public Person(int id,String name){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Meeting> getMyMeetings() {
        return myMeetings;
    }

    public void setMyMeetings(ArrayList<Meeting> myMeetings) {
        this.myMeetings = myMeetings;
    }

    public ArrayList<Meeting> getiOrganize() {
        return iOrganize;
    }

    public void setiOrganize(ArrayList<Meeting> iOrganize) {
        this.iOrganize = iOrganize;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, myMeetings, iOrganize);
    }

    public boolean addMeeting(Meeting meeting){
        for(Meeting meet: myMeetings){
            if(meet.getDate().equals(meeting)){
                return false;
            }
        }
        myMeetings.add(meeting);
        return true;
    }
    public void removeMeeting(Meeting meeting){
        myMeetings.remove(meeting);
    }
    public void organizeMeeting(Meeting meeting){
        iOrganize.add(meeting);
    }
    public void cancelMeeting(Meeting meeting){
        if(iOrganize.remove(meeting)){
            for(Person person:meeting.getAttendees()){
                person.removeMeeting(meeting);
            }
        }
    }
    public void displayMyMeetings(){
        if(myMeetings.size()>0){
            for(Meeting meeting:myMeetings){
                System.out.println(formatMeeting(meeting));
            }
        }else{
            System.out.println("You have no meeting to attend.");
        }
    }

    private String formatMeeting(Meeting meeting) {
       String s= String.format("Host : %s , Date : %s\n",meeting.getHost().getName(),meeting.getDate());
        return s;
    }

    public void displayMyOrganizations(){
        if(iOrganize.size()>0){
            for(Meeting meeting:iOrganize){
                System.out.println(" "+formatMeeting(meeting)+getAttendees(meeting));
            }
        }else{
            System.out.println("YOu are not hosting any meetings.");
        }
    }

    private String getAttendees(Meeting meeting) {
        String str="Attendees ";
        for(Person person:meeting.getAttendees()){
            str+=person.getName()+" ";
        }
        return str;
    }

    public void displayFormattedOrganizations(){
        for(Meeting meeting:iOrganize){
            System.out.println(meeting.getFormattedMeeting());
        }
    }


    @Override
    public String toString() {
        return "User " + name + " with ID " + id + " has " + myMeetings.size() + " meetings to attend and "
                + iOrganize.size() +" meetings organized."  ;
    }
}
