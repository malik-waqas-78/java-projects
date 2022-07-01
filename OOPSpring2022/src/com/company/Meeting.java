package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Meeting {
    private String name;
    private MDate date;
    private ArrayList<Person> attendees=new ArrayList<>();
    private final Person host;
    private boolean isOnline;
    private String url;
    private String location;
    public Meeting(MDate date,Person host,boolean isOnline,String urlOrLocation,ArrayList<Person> attendees) {
        this.host = host;
        this.date=date;
        this.isOnline=isOnline;
        if(isOnline){
            this.url=urlOrLocation;
        }else{
            this.location=urlOrLocation;
        }
        this.attendees=attendees;
    }
    public Meeting(String name,MDate date,Person host,boolean isOnline,String urlOrLocation) {
        this.name=name;
        this.host = host;
        this.date=date;
        this.isOnline=isOnline;
        if(isOnline){
            this.url=urlOrLocation;
        }else{
            this.location=urlOrLocation;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MDate getDate() {
        return date;
    }

    public void setDate(MDate date) {
        this.date = date;
    }

    public ArrayList<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<Person> attendees) {
        this.attendees = attendees;
    }

    public Person getHost() {
        return host;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(date, meeting.date) && Objects.equals(attendees, meeting.attendees) && Objects.equals(host, meeting.host) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, attendees, host, isOnline, url, location);
    }

    public void addAttendee(Person person){
        if(!attendees.contains(person)){
            if(person.addMeeting(this)){
                attendees.add(person);
            }
        }
    }
    public boolean removeAttendee(Person person){
        if(attendees.contains(person)){
            attendees.remove(person);
            person.removeMeeting(this);
            return true;
        }
        return false;
    }
    public void removeAllAttendees(){
        attendees.clear();
    }

    public String getFormattedMeeting(){
        return this.name+" "+this.getDate().toString();
    }

    @Override
    public String toString() {
        return "Meeting{" +
                ", host=" + host +
                "date=" + date +
                ", isOnline=" + isOnline +
                ", location='" + location + '\'' +
                ", attendees=" + attendees +'\''+
                '}';
    }
}
