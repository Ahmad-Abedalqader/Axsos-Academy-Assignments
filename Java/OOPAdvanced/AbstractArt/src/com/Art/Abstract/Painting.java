package com.Art.Abstract;

public class Painting extends Art {
	String paintType;
	


	public Painting(String paintType, String title, String author, String description) {
		super(title, author, description);
		this.paintType = paintType;
	}



	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("\n========== Painting Details ==========\n");
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Description: " + description);
		System.out.println("Paint Type: " + paintType);

	}

}
