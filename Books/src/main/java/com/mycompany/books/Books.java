/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.books;

import java.util.ArrayList;
import java.util.Iterator;


public class Books {

    public static void main(String[] args) {
        ArrayList<Item> list=new ArrayList();
		Laptop l = new Laptop();
		AudioBook ab=new AudioBook();
		ab.setTitle("Chaos");
		ab.setAuthor("James Gleick");
		Book b=new Book();
		b.setPages(248);
		b.setTitle("Lord of the Flies");
		b.setAuthor("William Golding");
		
		list.add(l);
		list.add(ab);
		list.add(b);
		
		b=new Book();
		b.setPages(582);
		b.setTitle("The Odyssey");
		b.setAuthor("Homer");
		list.add(b);
		
		b=new Book();
		b.setPages(426);
		b.setTitle("The Information");
		b.setAuthor("James Gleick");
		list.add(b);
		 
		
		// 1. Implement the method largestBook as described above
		Book largest = largestBook(list);
        if(largest!=null)
       {
        System.out.println("\nLagrest Book in this list:");
        largest.display();
        }
       else
           System.out.println("No Book found");
      
		
		// 2. Implement the method booksBy as described above
		ArrayList<Superbook> allbooks = booksby(list, "James Gleick");
        if(allbooks.size()!=0)
       {
        System.out.println("\nAll books by James Gleick:");
        for (Superbook myBook : allbooks){
            myBook.display();
            }
       }
       else
           System.out.println("No Book found by James Gleick");
   
        
        }
    
        public static Book largestBook(ArrayList list){
            Iterator i = list.iterator();
            int noofpages = 0;
            int f = 0;
            Book b = null;
            while(i.hasNext())
            {
                Item a = (Item) i.next();
                if (a instanceof Book)
                {
                    f = 1;
                     if(((Book) a).getPages() > noofpages )
                    {
                         b = (Book) a;
                         noofpages = ((Book) a).getPages();
                    }
               }
           }
       
      
       if(f==1)
       {
           return b;
       }
       else
       {
           return null;
       }      
   }
  
   public static ArrayList booksby(ArrayList list, String author) {
       Iterator i = list.iterator();
       ArrayList books = new ArrayList();
       while(i.hasNext())
       {
           Item a = (Item) i.next();
           if (a instanceof Superbook )
           {
               if(((Superbook) a).getAuthor().equals(author) )
                   books.add(a);
           }
       }
       return books;
   
		
    }

}

