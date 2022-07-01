
package com.mycompany.quizee2;

import java.util.ArrayList;


public class Course {
    
    private String courseCode;
    private String courseTitle;
    private int credits;
    
    private ArrayList<Assessment> assessments=new ArrayList<>();
    
    public Course() {
    }

    public Course(String courseCode, String courseTitle, int credits) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
    }
    
    public void addAssessment(Assessment assessment){
        assessments.add(assessment);
    }
    
    public Assessment getAssessment(int index){
        return assessments.get(index);

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public int totalAssessment(){
        return assessments.size();
    }

    
    
    
    
    
    
}
