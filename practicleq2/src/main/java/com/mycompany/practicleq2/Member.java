
package com.mycompany.practicleq2;

public class Member {
    private String memeber_name;
    private int age;    
    Member(String member_name,int age){
        this.memeber_name=member_name;
        this.age=age;
    }
    
    @Override
    public String toString(){
        return "The member name is " + this.memeber_name +" and age is "+this.age+"\n";
    }

    public String getMemeber_name() {
        return memeber_name;
    }

    public void setMemeber_name(String memeber_name) {
        this.memeber_name = memeber_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
