package amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import amazonviewer.model.Chapter;
import amazonviewer.model.Movie;
import amazonviewer.model.Player;
import amazonviewer.model.Serie;


public class Main {
    public static void main(String[] args){
    	
        showMenu();

    }

    public static void showMenu(){
        // Initial state
        int exit = 0;

        // Mapa de respuestas
        Map<Integer, Runnable> optionsMap = new HashMap<>();

        optionsMap.put(1, new Runnable() {  // Movies
            @Override
            public void run() {
                showMovies();
            }
        });
        optionsMap.put(2, new Runnable() {
            @Override
            public void run() {
                showSeries();
            }
        });
        optionsMap.put(3, new Runnable() {
            @Override
            public void run() {
                showBooks();
            }
        });
        optionsMap.put(4, new Runnable() {
            @Override
            public void run() {
                showMagazines();
            }
        });
        optionsMap.put(5, new Runnable() {
            @Override
            public void run() {
                makeReport();
            }
        });
        optionsMap.put(6, new Runnable() {
            @Override
            public void run() {
                makeReport(new Date());
            }
        });
        optionsMap.put(0, new Runnable() {
        	@Override 
        	public void run() {
        		int exit = 0;
        	}
        });

        do {
            System.out.println("BIENVENIDOS A AMAZON VIEWER");
            System.out.println("");
            System.out.println("¿Qué te gustaría ver?");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report today");
            System.out.println("0. Exit");

            // Leer la respuesta

            System.out.println("\nIngresa la opción deseada:");
            Scanner inputScanner = new Scanner(System.in); //creación de un objeto Scanner
            int userInput = Integer.valueOf(inputScanner.nextLine()); //ejemplo de parseo
            optionsMap.get(userInput).run();
            exit = userInput;

        }while(exit != 0);
    }

    public static void showMovies(){
        int exit = 1;
        //metodo statico para ahorrar crear un ojeto
        ArrayList<Movie> movies = Movie.makeMoviesList();
        do {
            System.out.println();
            System.out.println(":: MOVIES ::");
            System.out.println();
            
            for(int i = 0; i < movies.size(); i++) {
            	//get() obtengo el objeto de la colleccion 
            	System.out.println((i + 1) + ". " + movies.get(i).getTitle() + 
            			" Visto: " + movies.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menú");
            System.out.println();
            
            //leer respuesta usuario
            
            // Scanner entrada = new Scanner(System.in);
            //int response = entrada.nextInt();
            //int response = Integer.valueOf(entrada.nextLine());
            
            //método que valida si es un número 
            int response = numberSelectedMenu();
            
            if(response == 0) {
            	showMenu();
            }
            
            Movie movieSelected = movies.get(response - 1);
            movieSelected.setViewed(true);
            Date dateI = movieSelected.startToSee(new Date());
            
            //simula el reproductor
            Player p = new Player();
			p.start();
			
			int outMovie;
			do {
				System.out.println("\n Si desea parar de verla, ingrese 0: ");
				outMovie = numberSelectedMenu();
				 
			} while(outMovie != 0) ;
			
			p.stopPlayer();

            // termine de verla
            movieSelected.stopToSee(dateI, new Date());
			
			System.out.println("Viste la película: " + "\n" + movieSelected +
					" \n por " + movieSelected.getTimeViewed() + " segundos.");
			
            
        }while(exit!=0);
    }

    public static void showSeries(){
        int exit = 0;
        ArrayList<Serie> series = Serie.makeSeriesList();
        
        do {
            System.out.println();
            System.out.println(":: SERIES ::");
            System.out.println();
            
            for(int i = 0; i < series.size(); i++) {
            	System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto " + series.get(i).isViewed());
            	
            }
            System.out.println("0. Regresar al Menú");
            System.out.println();
            
            Scanner entrada = new Scanner(System.in);
            int response = Integer.valueOf(entrada.nextLine());
            
            if(response == 0) {
            	showMenu();
            }
            showChapters(series.get(response -1).getChapters());
            
        }while(exit!=0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected){
        int exit = 0;
        do {
            System.out.println();
            System.out.println(":: CHAPTERS ::");
            System.out.println();
            
            for(int i = 0; i < chaptersOfSerieSelected.size(); i++) {
            	System.out.println(i + 1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto " + chaptersOfSerieSelected.get(i).isViewed());
            }
            
            System.out.println("0. Regresar al Menú");
            System.out.println();
            
            Scanner entrada = new Scanner(System.in);
            int response = Integer.valueOf(entrada.nextLine());
            if(response == 0) {
            	showSeries();
            }
            Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
            chapterSelected.setViewed(true);
            Date dateI = chapterSelected.startToSee(new Date());
            
            //simula el reproductor
            Player p = new Player();
			p.start();
			
			int outMovie;
			do {
				System.out.println("\n Si desea parar de verla, ingrese 0: ");
				outMovie = numberSelectedMenu();
				 
			} while(outMovie != 0) ;
			
			p.stopPlayer();
			
			//Termina de verla
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Viste: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + " segundos");
			
            
        }while(exit!=0);
    }

    public static void showBooks(){
        int exit = 0;
        do {
            System.out.println();
            System.out.println(":: BOOKS ::");
            System.out.println();
            
            
            
        }while(exit!=0);
    }

    public static void showMagazines(){
        int exit = 0;
        do {
            System.out.println();
            System.out.println(":: MAGAZINES ::");
            System.out.println();
        }while(exit!=0);
    }
    
    public static void makeReport() {
    	
    }

    public static void makeReport(Date date) {
    	
    }
    private static int numberSelectedMenu() {
		
		int response = 0;
		boolean completeSelect = false;
		// Leer respueta del usuario
		do {
			try {
				Scanner entrada = new Scanner(System.in);
				response = entrada.nextInt();
				return response;
				
			}catch(InputMismatchException ex) {
				System.out.println("Debes ingresar un número entero.");		
				
			}
		}while(!completeSelect);		
		
		return response;
		
	}
}