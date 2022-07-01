
package quize4;


public class Student {
    private String studentName;
    private int studentID;
    private int yearOfStudy;
    
    public Student(){
        
    }
    
    public Student(String studentName,int studentID,int yearOfStudy){
        this.studentName=studentName;
        this.studentID=studentID;
        this.yearOfStudy=yearOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" + "studentName=" + studentName + ", studentID=" + studentID + ", yearOfStudy=" + yearOfStudy + '}';
    }

    
    
}
