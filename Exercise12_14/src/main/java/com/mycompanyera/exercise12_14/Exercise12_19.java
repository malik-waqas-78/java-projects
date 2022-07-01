import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Exercise12_19
{
	public static void main(String[] args) {
	File file=new File("Exercise12_19.txt");
		
		
		try{
		   Scanner scanner = new Scanner(file);
		   if(scanner.hasNextLine()){
		    String line=scanner.nextLine();
		    line=line.trim();
		    line=line.replace(","," ");
		    line=line.replace("--"," ");
		    line=line.replace("."," ");
		    
		    String[] numbers=line.split(" ");
		   
		    System.out.println(numbers.length);
		}
		}catch(FileNotFoundException ex){
		    System.out.println("File not found");
		}
		
	}
}
