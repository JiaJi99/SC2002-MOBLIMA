package ManagerClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import BaseClasses.*;


public class TransactionsCtrl {
	
	/**
	 * File path to database of transaction that this controller will access
	 */
	public final static String FILENAME = "MOBLIMA/database/transactions.txt";
	
	/**
	 * Create a new transaction and add it into database
	 * Attributes are validated before adding to database
	 * @param cinemaCode 	This transaction cinemas code
	 * @param name			Name of movie goer
	 * @param email			Email of Movie goer
	 * @param mobileNumber	Mobile number of movie goer
	 * @param movie			Movie in this transaction
	 */
	public void create(String cinemaCode, String name, String email, String mobileNumber, Movie movie) {
            ArrayList<Transaction> allData = new ArrayList<Transaction>();
            File tempFile = new File(FILENAME);
            if (tempFile.exists()) {
                allData = read();
            }
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(new Transaction(cinemaCode, name, email, mobileNumber, movie));
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {
                // ignore error
            }
	}
    
	
	/**
	 * READ and return every transaction in database
	 * If datebase not found, ignore error and return empty list
	 * @return Model{@link Transaction}  Return list of transaction if any, else empty list
	 */
	 public ArrayList<Transaction> read() {
	        try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
	            ArrayList<Transaction> allData = (ArrayList<Transaction>) ois.readObject();
	            ois.close();
	            return allData;
	        } catch (ClassNotFoundException | IOException e) {
	            // ignore error
	        }
	        return new ArrayList<Transaction>();
	    }
	 
	 
	 /**
	  * READ and return every transaction with given TID in database
	  * @param TID		ID of transaction 
	  * @return Model{@link Transaction}  Return list of transaction if any, else empty list
	  */
	 public ArrayList<Transaction> readByTID(String TID) {
	        ArrayList<Transaction> allData = read();
	        Transaction transaction = null;
	        ArrayList<Transaction> returnData = new ArrayList<Transaction>();

	        for (int i=0; i<allData.size(); i++) {
	            transaction = allData.get(i);
	            if (transaction.getTID().equals(TID))
	                returnData.add(transaction);
	        }
	        return returnData;
	    }
	 
	 
	 /**
	  * READ and return every transaction with given moviegoer name in database
	  * @param movieGoerUsername  name of moviergoer to search for
	  * @return Model{@link Transaction}  Return list of transaction under movier goer name if any, else empty list
	  */
	 public ArrayList<Transaction> readByMovieGoerUsername(String movieGoerUsername) {
	        ArrayList<Transaction> allData = read();
	        Transaction transaction = null;
	        String dbUsername = null;
	        ArrayList<Transaction> returnData = new ArrayList<Transaction>();

	        for (int i=0; i<allData.size(); i++){
	            transaction = allData.get(i);
	            dbUsername = transaction.getEmail();
	            if (dbUsername.equals(movieGoerUsername))
	                returnData.add(transaction); 
	        }
	        return returnData;
	    }
	 
	 
	 /**
	  * Save and overwrite database with new transaction list
	  * @param filename  filename to check for
	  * @param returnData New arraylist of transaction to be written
	  */
	 public void replaceExistingFile(String filename, ArrayList<Transaction> returnData) {
	        File tempFile = new File(filename);
	        if (tempFile.exists())
	            tempFile.delete();
	        try {
	            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
	            out.writeObject(returnData);
	            out.flush();
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
