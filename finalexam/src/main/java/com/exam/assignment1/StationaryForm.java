
package com.exam.assignment1;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StationaryForm {
    public static void main(String[] args) {
        createUI();
    }
    public static void createUI(){
        
        JFrame frame=new JFrame();
        frame.setSize(800, 500);
        
        
        JTextField tf1=new JTextField();
        tf1.setBounds(250,100,100, 20);
        JTextField tf2=new JTextField();
        tf2.setBounds(250,200,100, 20);
        JTextField tf3=new JTextField();
        tf3.setBounds(550,400,200,20);
        tf3.setEnabled(false);
        JTextField tf4=new JTextField();
        tf4.setBounds(400,50,300, 300);
        tf4.setEnabled(false);
        JLabel jl1=new JLabel("Stationary Services");
        jl1.setBounds(10, 10,200,20);
        JLabel jl2=new JLabel("Orders");
        jl2.setBounds(400,10,200,20);
        JLabel jl3=new JLabel("Total Amount");
        jl3.setBounds(400,400,100,20);
        JLabel jl4=new JLabel("Black Paper QTY (0.2 AED / paper");
        jl4.setBounds(10,100,300, 20);
        JLabel jl5=new JLabel("Cefer paper QTY (1 AED/paper");
        jl5.setBounds(10,200,300, 20);
        JButton jb1=new JButton("Clear");
        jb1.setBounds(10,400,100,20);
        JButton jb2=new JButton("Add");
        jb2.setBounds(200,400,100,20);
        Checkbox cb=new Checkbox("Fexing (10 AED )");
        cb.setBounds(10,380,100,30);
        
        
     
       
        
        frame.add(tf1);
        frame.add(tf2);
        frame.add(tf3);
        frame.add(tf4);
        frame.add(jl1);
        frame.add(jl2);
        frame.add(jl3);
        frame.add(jl4);
        frame.add(jl5);
        frame.add(jb1);
        frame.add(jb2);
        frame.add(cb);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    
    
    
}

