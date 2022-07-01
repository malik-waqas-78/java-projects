
package quize4;


import java.util.Arrays;


public class Course {
    private String courseCode;
    private int CRN;
    private String address;
    private Student[] students;
    
    
    public Course(){
    }
    
    public Course(String courseCode,int CRN, String address){
        this.courseCode=courseCode;
        this.CRN=CRN;
        this.address=address;
        students=new Student[0];
    }
    public void addStudent(Student s){
        students=Arrays.copyOf(students, students.length+1);
        students[students.length-1]=s;
        
    }

    @Override
    public String toString() {
        String str="\n";
        for(int i=0;i<students.length;i++){
            str+=students[i].toString()+"\n";
        }
        
        return "Class{" + "courseCode=" + courseCode + ", CRN=" + CRN + ", address=" + address + ",\nstudents=" +
                str+
                '}';
    }
    
    
}
