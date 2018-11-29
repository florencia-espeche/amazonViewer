package amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Serie extends Film implements IVisualizable{
		
	//encapsulamiento
	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;
	
	public Serie(String title, String genre, String creator, int duration, int sessionQuantity, ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity;
		this.chapters = chapters;
	}

	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		return "\n ::SERIE::" +
				"\n Title: " + getTitle() +
				"\n Genre: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();			
	}
	public static ArrayList<Serie> makeSeriesList(){
		ArrayList<Serie> series = new ArrayList();
		for(int i = 0; i < 5; i++) {
			series.add(new Serie("Serie " + (i +1), " genero " + (i + 1), "creator " +(i+1), 1200, 5, Chapter.makeChaptersList()));
			
		}
		return series;
	}
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
	}
	
}
