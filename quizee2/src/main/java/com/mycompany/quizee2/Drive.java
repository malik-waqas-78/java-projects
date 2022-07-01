
package com.mycompany.quizee2;


public class Drive {
    
    public static void main(String[] args) {
        Assessment project=new Assessment("Project", "Summative", 25);
        Assessment quize=new Assessment("Test", "Formative", 20);
        Assessment FWA=new Assessment("Project", "Summative", 30);
        
        Course OOP=new Course("CIS2403", "Object-Oriented Programming", 3);
        
        OOP.addAssessment(project);
        OOP.addAssessment(quize);
        OOP.addAssessment(FWA);

        for(int i=0;i<OOP.totalAssessment();i++){
            System.out.println(OOP.getAssessment(i).toString());
        }
        
        int totalmarks=0;
        
        for(int i=0;i<OOP.totalAssessment();i++){
            totalmarks+=OOP.getAssessment(i).marks;
        }
        System.out.println("Total marks");

    }
    
}
