
package quize5;


public class Graduate extends Student {
    private int year;

    public Graduate() {
    }

    
    

    public Graduate(int year, String name, int id, double GPA) {
        super(name, id, GPA);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    

    @Override
    public String toString() {
        return super.toString()+" Graduation year=" + year ;
    }
    
    

    
    
    
}
