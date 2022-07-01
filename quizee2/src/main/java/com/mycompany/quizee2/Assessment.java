
package com.mycompany.quizee2;
public class Assessment {
    public String assessmentTitle;
    public String assessmentType;
    public int marks;

    public Assessment(String assessmentTitle, String assessmentType, int marks) {
        this.assessmentTitle = assessmentTitle;
        this.assessmentType = assessmentType;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Assessment{" + "assessmentTitle=" + assessmentTitle + ", assessmentType=" + assessmentType + ", marks=" + marks + '}';
    }
    
    
}
