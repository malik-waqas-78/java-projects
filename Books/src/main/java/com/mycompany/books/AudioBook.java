/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.books;


public class AudioBook extends Superbook{
	private int size;
	private int duration;
	public int getSize() {
		return size;
	}
	public AudioBook() {
		super();
		title = "audio book";
		duration = 3000;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
        @Override
	public void display() {
		System.out.print("Audiobook: duration "+ duration +" seconds, ");
		super.display();
		
	}
	
}
