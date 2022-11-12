package ManagerClasses;
import java.io.*;
import java.util.ArrayList;

import BaseClasses.*;

public class DataManager implements Serializable{
	public static final String FILENAME_ADMIN ="./AdminData.txt";
	public static final String FILENAME_MOVIEGOER = "./MovieGoerData.txt";
	public static final String [] FILES = {FILENAME_ADMIN, FILENAME_MOVIEGOER};
	private ArrayList<AdminAccount> adminAccounts;
	public ArrayList<MovieGoerAccount> movieGoerAccounts;
	
	public DataManager() {
		adminAccounts = new ArrayList<AdminAccount>();
		movieGoerAccounts = new ArrayList<MovieGoerAccount>();
	}
	
	
	@SuppressWarnings("unchecked")
	public void initialize() {
		FileInputStream fileIn;
		ObjectInputStream objectIn;
		try {
			
			for (int i=0; i<FILES.length; i++){
				fileIn = new FileInputStream(FILES[i]);
				objectIn = new ObjectInputStream(fileIn);
				if (fileIn.available() != 0) {
					if (i == 0) {					
						adminAccounts = (ArrayList<AdminAccount>) objectIn.readObject();
						objectIn.close();
						fileIn.close();
					}
					if (i == 1) {
						movieGoerAccounts = (ArrayList<MovieGoerAccount>) objectIn.readObject();
						objectIn.close();
						fileIn.close();
					}
				}
				else {
					if (i == 0) {
						
						adminAccounts = new ArrayList<AdminAccount>();
						objectIn.close();
						fileIn.close();
					}
					if (i == 1) {
						movieGoerAccounts = new ArrayList<MovieGoerAccount>();
						objectIn.close();
						fileIn.close();
					}			
				}
			}		
		}
		catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		FileOutputStream fileOut;
		ObjectOutputStream objectOut;
		try {
			for (int i=0; i<FILES.length; i++){
				fileOut = new FileOutputStream(FILES[i]);
				objectOut = new ObjectOutputStream(fileOut);
				if (i == 0) {
					objectOut.writeObject(adminAccounts);
					objectOut.close();
					fileOut.close();
				}
				if (i == 1) {
					objectOut.writeObject(movieGoerAccounts);
					objectOut.close();
					fileOut.close();
				}		
			}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<AdminAccount> getAdminAccounts(){
		return adminAccounts;
	}
	
	public ArrayList<MovieGoerAccount> getMovieGoerAccounts(){
		return movieGoerAccounts;
	}
	
	public void addAdminAccount(AdminAccount acc) {
		adminAccounts.add(acc);	
	}
	
	public void addMovieGoerAccount(MovieGoerAccount acc) {
		movieGoerAccounts.add(acc);
	}
	
	public void removeAdminAccount(AdminAccount acc) {
		adminAccounts.remove(acc);
	}
	
	public void removeMovieGoerAccount(MovieGoerAccount acc) {
		movieGoerAccounts.remove(acc);
	}
	
	public boolean isExistingAdminAccount(AdminAccount acc) {
		return adminAccounts.contains(acc);
	}
	
	public boolean isExistingMovieGoerAccount(MovieGoerAccount acc) {
		return movieGoerAccounts.contains(acc);
	}
}
