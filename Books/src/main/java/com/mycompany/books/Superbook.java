/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.books;

public class Superbook extends Item{
    protected String title;
	private String Author;
	
	public Superbook() {
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	
	@Override
	public void display() {
		System.out.print("Book: Title "+ title +" ");
		super.display();
	}
	
	public void display(String s) {
		System.out.print(s+ title +" ");
		super.display();
	}
	
}
