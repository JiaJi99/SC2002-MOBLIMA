package ManagerClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import BaseClasses.*;

public class HolidaysCtrl {
    
    /**
     * File name of Database file to access
     */
    public final static String FILENAME = "./holidays.txt";

    
    /** 
     * CREATE a new holiday and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new holiday object is aopended before saving
     * If Database file does not exist, holiday object will be written to a new file and saved
     * @param holidayDate   date of a holiday
     */
    public void create(LocalDate holidayDate) {
        Holiday holiday = new Holiday(holidayDate);
        ArrayList<Holiday> allData = new ArrayList<Holiday>();
        File tempFile = new File(FILENAME);
        if (tempFile.exists()) 
            allData = read();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
            allData.add(holiday);
            out.writeObject(allData);
            out.flush();
            out.close();
        } catch (IOException e) {
            // ignore error
        }
    } 

    
    /** 
     * READ and return every Holiday in the Database file
     * If Database file not found, ignore error and return empty list
     * @return Model.{@link Holiday}   Return list of Holidays if any, else empty list
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Holiday> read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Holiday> holidayListing = (ArrayList<Holiday>) ois.readObject();
            ois.close();
            return holidayListing;
        } catch (ClassNotFoundException | IOException e) {
            // ignore error
        } 
        return new ArrayList<Holiday>();
    }

    
    /** 
     * Delete a Holiday in the Database file, based on the date attribute passed
     * @param valueToSearch     Date of Holiday to be deleted
     */
    public void delete(LocalDate valueToSearch) {
        ArrayList<Holiday> allData = read();
        ArrayList<Holiday> returnData = new ArrayList<Holiday>();
        
        for (int i=0; i<allData.size(); i++){
            Holiday h = allData.get(i);
            if (!(h.getHolidayDate().equals(valueToSearch)))
                returnData.add(h);
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Check if a date is an holiday by checking against every data in the Database file
     * @param valueToSearch     Date of Holiday to be check
     * @return boolean          Return true if valueToSearch is in database, else false
     */
    public boolean isHoliday(LocalDate valueToSearch) {
        ArrayList<Holiday> allData = read();
        for (int i=0; i<allData.size(); i++){
            if (allData.get(i).getHolidayDate().equals(valueToSearch))
                return true;
        }
        return false;
    }

    
    /** 
     * Overwrite Database file with new data of list of Holidays
s     * @param filename      Filename to check for
     * @param data          New ArrayList of Holiday to be written to the file
     */
    public void replaceExistingFile(String filename, ArrayList<Holiday> data){
        File tempFile = new File(filename);
        if (tempFile.exists()) 
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            // ignore error
        }
    }
}