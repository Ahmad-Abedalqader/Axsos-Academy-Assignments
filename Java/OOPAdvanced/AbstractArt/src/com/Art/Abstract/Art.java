package com.Art.Abstract;

public abstract class Art {
	String title;
	String author;
	String description;
	
	public abstract void viewArt();

	public Art(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}

}
