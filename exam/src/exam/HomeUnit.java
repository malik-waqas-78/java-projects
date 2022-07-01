package exam;

import exam.Accommodation;

public class HomeUnit extends Accommodation{
    private int HomeUnitNum;

    public HomeUnit() {
        super();
    }

    public HomeUnit(int HomeUnitNum, double area, String address, String owner, int numOfRooms) {
        super(area, address, owner, numOfRooms);
        this.HomeUnitNum = HomeUnitNum;
    }

    public int getHomeUnitNum() {
        return HomeUnitNum;
    }

    public void setHomeUnitNum(int HomeUnitNum) {
        this.HomeUnitNum = HomeUnitNum;
    }

    @Override
    public String toString() {
        return "HomeUnit{" + "HomeUnitNum=" + HomeUnitNum + '}';
    }
    
    
    
    
}
