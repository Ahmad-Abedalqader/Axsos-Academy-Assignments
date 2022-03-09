package com.Art.Abstract;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painting painting1 = new Painting("Acrylic","Home", "Ahmad", "Home sweet home");
		Painting painting2 = new Painting("Coal", "Tree", "Sanad", "Tree at sunset");
		Painting painting3 = new Painting("Water color", "Beach", "Ahmad", "Shiny beach");
		
		Sculpture sculpture1 = new Sculpture("Bronze","Nostalgia", "Ahmad", "Home sweet home");
		Sculpture sculpture2 = new Sculpture("Stone", "Never give up", "Sanad", "You can and You will");
		
		painting1.viewArt();
		painting2.viewArt();
		painting3.viewArt();
		
		sculpture1.viewArt();
		sculpture2.viewArt();
		

	}

}
