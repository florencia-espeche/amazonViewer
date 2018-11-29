package amazonviewer.model;

import java.util.Date;

public class Magazine extends Publication{

	//encapsulamiento
	private int id;
	
	public Magazine(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial, authors);
		
	}

	public int getId() {
		return id;
	}

	@Override 
	public String toString() {
		return "\n ::MAGAZINE::" + 
				"\n Titulo: " + getTitle() + 
				"\n Editorial: " + getEditorial() +
				"\n Edition Date: " + getEditionDate();
	}
	
}
