/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;


class Accommodation {
    private double area;
    private String address ;
    private String owner;
    private int numOfRooms;

    public Accommodation() {
    }

    public Accommodation(double area, String address, String owner, int numOfRooms) {
        this.area = area;
        this.address = address;
        this.owner = owner;
        this.numOfRooms = numOfRooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Override
    public String toString() {
        return "Accommodation{" + "area=" + area + ", address=" + address + ", owner=" + owner + ", numOfRooms=" + numOfRooms + '}';
    }
    
}
