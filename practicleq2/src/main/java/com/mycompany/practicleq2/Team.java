
package com.mycompany.practicleq2;

import java.util.Arrays;


public class Team {
   private String team_name;
   private String activity_type;
   private String address;
   private Member[] mem;
   
   Team(String team_name, String activity_type, String address){
       this.team_name=team_name;
       this.activity_type=activity_type;
       this.address=address;
       this.mem=new Member[0];
   }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Member[] getMem() {
        return mem;
    }

    public void setMem(Member[] mem) {
        this.mem = mem;
    }
   
   void addMember(Member m){
       mem=Arrays.copyOf(mem,mem.length+1);
       mem[mem.length-1]=m;
   }
   @Override
   public String toString(){
       String info="The team name is "+ this.team_name+" , activity type is "
               +this.activity_type+" , address is " + this.address+".\n";
       
       for(int i=0;i<mem.length;i++){
           info=info+mem[i];
       }
      return info;
   
       
   }
}
