
package com.mycompany.exercise2;

public class Component {
public String compID;
public String compName;

    public Component(String compID, String compName) {
        this.compID = compID;
        this.compName = compName;
    }

    @Override
    public String toString() {
        return "[The Component is " + this.compID + ", its name is "+ this.compName + '}';
    }
    
    protected void print(){
        
    }
    
    int get(){
    }
    
}
