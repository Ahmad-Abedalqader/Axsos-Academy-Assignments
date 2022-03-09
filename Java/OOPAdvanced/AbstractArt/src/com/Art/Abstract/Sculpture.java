package com.Art.Abstract;

public class Sculpture extends Art {

	String material;
	
	public Sculpture(String material, String title, String author, String description){
		super(title, author, description);
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("\n========== Sculpture Details ==========\n");
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Description: " + description);
		System.out.println("Material: " + material);

	}

}
