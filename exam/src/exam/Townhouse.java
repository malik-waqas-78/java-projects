package exam;

import exam.Accommodation;

public class Townhouse extends Accommodation{
    
    private int numOfFoor;
    private boolean isCommercial;

    public Townhouse() {
        super();
    }

    public Townhouse(int numOfFoor, boolean isCommercial, double area, String address, String owner, int numOfRooms) {
        super(area, address, owner, numOfRooms);
        this.numOfFoor = numOfFoor;
        this.isCommercial = isCommercial;
    }

    public int getNumOfFoor() {
        return numOfFoor;
    }

    public void setNumOfFoor(int numOfFoor) {
        this.numOfFoor = numOfFoor;
    }

    public boolean isIsCommercial() {
        return isCommercial;
    }

    public void setIsCommercial(boolean isCommercial) {
        this.isCommercial = isCommercial;
    }

    @Override
    public String toString() {
        return "Townhouse{" + "numOfFoor=" + numOfFoor + ", isCommercial=" + isCommercial + '}';
    }
    
    
    
    
}
