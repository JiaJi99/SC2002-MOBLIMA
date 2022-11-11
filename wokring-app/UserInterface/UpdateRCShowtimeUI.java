package UserInterface;


import ManagerClasses.SessionsCtrl;
import ManagerClasses.MoviesCtrl;
import BaseClasses.SeatPlan;
import BaseClasses.Sessions;
import BaseClasses.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class UpdateRCShowtimeUI {

	/**
	 * Display main body of Update showitime UI
	 */
	public void displayChoices_UpdateRCSession(){
		System.out.println("==============================");
		System.out.println("1. Create Movie Session");
		System.out.println("2. Update Movie Session");
		System.out.println("3. Delete Movie Session");
		System.out.println("4. Back");
		System.out.println("==============================");
	}
	
	
	/**
	 * Get user input to select action create, update or delete session
	 */
	public void displayUI_UpdateRCSession() {
		int choice;
		displayChoices_UpdateRCSession();
		choice = getInput(4);
		switch (choice) {
			case 1: createSession();
					break;
			case 2: updateSession();
					break;
			case 3: deleteSession();
			case 4: break;
		}
	}
	
	
	/**
	 * Get user to input choice and see if choice is valid by passing a value
	 *@param i  the max input allowed
	 *@return int  return user input, if input is within valid range, else loop
	 */
	public int getInput(int i) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice < 1 || choice > i)
				System.out.println("Please enter a valid choice");
		} while (choice < 1 || choice > i);
		sc.close();
		return choice;
	}
	
	/**
	 * Create new session 
	 */
	public void createSession() {
		SessionsCtrl sessionsCtrl = new SessionsCtrl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Cinema Code ");
		String cinemaCode = sc.nextLine();
		System.out.println("Enter Movie ID ");
		int movieID = sc.nextInt();
		MoviesCtrl movieCtrl = new MoviesCtrl();
		Movie movie = movieCtrl.readByID(movieID);
		System.out.println("Enter Session Start Date and Time  EEEE, dd/MM/yyyy HH:mm");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm");
		LocalDateTime sessionDateTime = LocalDateTime.parse(sc.nextLine(), formatter);	
		sessionsCtrl.create(cinemaCode, movie, sessionDateTime);
		sc.close();
	}
	
	/**
	 * Update session
	 */
	public void updateSession() {
		SessionsCtrl sessionsCtrl = new SessionsCtrl();
		Scanner sc = new Scanner(System.in);
		ArrayList<Sessions> sessionsList =  sessionsCtrl.read();
		if (sessionsList.size()==0)
			System.out.println("Sorry, no sessions have been created yet.");
		else {
			for (int i=0; i<sessionsList.size(); i++)
				System.out.println("\n\nID : "+sessionsList.get(i).getId()
								  +"\n Movie Title : "+sessionsList.get(i).getMovie().getTitle()
								  +"\n Date and Time : "+sessionsList.get(i).getSessionDateTimeToString());
			System.out.println("Enter session ID to update/edit");
			int sessionID = sc.nextInt();
			Sessions s;
			boolean found = false;
			for (int i=0; i<sessionsList.size();i++){
                if (sessionsList.get(i).getId()==sessionID){
                    s = sessionsList.get(i);
                    found = true;
                }
			}
            if (found == false ){
                  System.out.println("Sorry, session not found. Returning to main menu");
                  return ; 
			}
            System.out.printf("Choose option to update session by\n:" + 
            "1. Movie\n" +
            "2. Session Date and Time\n" +
            "3. Seats Availability\n"
            );
            int choice = getInput(3);
            switch(choice) {
            	case 1: System.out.println("Enter name of new movie");
            			String movieName = sc.nextLine();
            			MoviesCtrl movieCtrl = new MoviesCtrl();
            			ArrayList<Movie> newMovie = movieCtrl.readByAttribute(1, movieName);
            			sessionsCtrl.updateById(0,sessionID, newMovie);
            			break;
            	case 2: System.out.println("Enter new date and time EEEE, dd/MM/yyyy HH:mm");
        				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm");
        				LocalDateTime sessionDateTime = LocalDateTime.parse(sc.nextLine(), formatter);	
        				sessionsCtrl.updateById(1,sessionID, sessionDateTime);
        				break;
            	case 3: int row, col;
            			do {
            				System.out.println("Enter number of rows of seat");
            				row = sc.nextInt();
            				if (row <= 0) 
            					System.out.println("Please enter a positive number.");
            			} while (row <= 0);
            			do {
            				System.out.println("Enter number of columns of seat");
            				col = sc.nextInt();
            				if (col <= 0) 
            					System.out.println("Please enter a positive number.");
            			} while (col <= 0);
            			SeatPlan seats = new SeatPlan(row, col);
            			sessionsCtrl.updateById(2,sessionID, seats);
            			break;
            	}   
		}
	}
	
	
	/**
	 * Delete session
	 */
	public void deleteSession() {
		SessionsCtrl sessionsCtrl = new SessionsCtrl();
		Scanner sc = new Scanner(System.in);
		ArrayList<Sessions> sessionsList =  sessionsCtrl.read();
		if (sessionsList.size()==0)
			System.out.println("Sorry, no sessions have been created yet.");
		else {
			for (int i=0; i<sessionsList.size(); i++)
				System.out.println("\n\nID : "+sessionsList.get(i).getId()
								  +"\n Movie Title : "+sessionsList.get(i).getMovie().getTitle()
								  +"\n Movie ID : "+sessionsList.get(i).getMovie().getID()
								  +"\n Date and Time : "+sessionsList.get(i).getSessionDateTimeToString());
			System.out.printf("Select to delete session(s) by Session ID / Movie ID\n" 
							 +"1. Session ID\n" 
							 +"2. Movie ID\n");
			int choice = getInput(2);
			switch (choice) {
				case 1: int sessionID = sc.nextInt();
						sessionsCtrl.delete(sessionID);
						break;
				case 2: int movieID = sc.nextInt();
						sessionsCtrl.deleteByMovie(movieID);
						break;		
			}
		}
	}
	

		
}
