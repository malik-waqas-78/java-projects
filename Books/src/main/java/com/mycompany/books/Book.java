/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.books;

public class Book extends Superbook{
	private int pages;


	public int getPages() {
		return pages;
	}

	public Book() {
		pages = 100;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public void display() {
		System.out.print("Physical book number of pages: "+ pages +" ");
		super.display();
	}
	
	
	
}
