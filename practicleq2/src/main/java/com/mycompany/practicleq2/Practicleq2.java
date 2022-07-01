

package com.mycompany.practicleq2;

public class Practicleq2 {
    
  
    public static void main(String[] args) {
        Team team=new Team("Sports", "Cricket", "M Stadium");
        Member member1=new Member("w",19);
        Member member2=new Member("m",17);
        Member member3=new Member("f",21);
        
        team.addMember(member3);
        team.addMember(member2);
        team.addMember(member1);
        
        System.out.println(team);
            

        

    }
}
