package amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable{
	
	//encapsulamiento
	private int id;
	private int timeViewed;
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		//metodo de Film
		setYear(year);
	}

	@Override
	public int getId() {
		return this.id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	public void showData() {
		System.out.println("Movie: " + getTitle() + " Genre: "+ getGenre() + " Year: " + getYear());
		
	}
	@Override
	public String toString() {
		return "Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear() + "\n Creator: " + getCreator();
		
	}

	@Override
	public Date startToSee(Date dateI) {
		
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if(dateF.getSeconds() > dateI.getSeconds()) {
			setTimeViewed(dateF.getSeconds() - dateI.getSeconds());
		} else  {
			setTimeViewed(0);
		}
		
	}
	public static ArrayList<Movie> makeMoviesList(){
		ArrayList<Movie> movies = new ArrayList();
		for(int i = 0; i < 5; i++) {
			movies.add(new Movie("Movie " + (i + 1), "Genre: " + i, "Creator" + i, 120 + i, (short)(2017 + i)));
		}
		return movies;
	}
}
