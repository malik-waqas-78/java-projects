/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyera.exercise12_14;

/**
 *
 * @author malik-waqas
 */
 import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Exercise12_14 {

public static void main(String[] args) {
		File file=new File("Exercise12_14.txt");
		
		
		try{
		   Scanner scanner = new Scanner(file);
		   if(scanner.hasNextLine()){
		    String line=scanner.nextLine();
		    String[] numbers=line.split(" ");
		    int sum=0;
		    for(int i=0;i<numbers.length;i++){
		        sum+=Integer.valueOf(numbers[i]);
		    }
		    int average=sum/numbers.length;
		    System.out.println(sum +"  "+average);
		}
		}catch(FileNotFoundException ex){
		    System.out.println("File not found");
		}
		
	}
    
}
