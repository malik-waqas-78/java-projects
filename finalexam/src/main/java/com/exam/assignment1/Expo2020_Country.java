
package com.exam.assignment1;


public class Expo2020_Country {
    private String countryName,location;
    private int noOfVisitors;
    private String attraction;
    private double pavilionArea;

    public Expo2020_Country() {
        this.countryName = "";
        this.location = "";
        this.noOfVisitors = 0;
        this.attraction = "";
        this.pavilionArea = 0d;
    }

    public Expo2020_Country(String countryName, String location, int noOfVisitors, String attraction, double pavilionArea) {
        this.countryName = countryName;
        this.location = location;
        this.noOfVisitors = noOfVisitors;
        this.attraction = attraction;
        this.pavilionArea = pavilionArea;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfVisitors() {
        return noOfVisitors;
    }

    public void setNoOfVisitors(int noOfVisitors) {
        this.noOfVisitors = noOfVisitors;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public double getPavilionArea() {
        return pavilionArea;
    }

    public void setPavilionArea(double pavilionArea) {
        this.pavilionArea = pavilionArea;
    }
    public void addNewVisitor(){
        ++noOfVisitors;
    }
    
}
