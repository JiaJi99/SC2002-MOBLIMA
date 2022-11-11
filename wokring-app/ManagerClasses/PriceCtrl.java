package ManagerClasses;

import BaseClasses.*;
import ValidInput.PriceLayer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PriceCtrl {
	
   public final static String FILENAME = "MOBLIMA/database/price.txt";
	
	/**
	 * Assigning constants to attributes for easy readability
	 */
    public final static int STUDENT = 0;
    public final static int ADULT = 1;
    public final static int SENIOR = 2;
    public final static int WEEKEND = 3;
    public final static int AFTER6 = 4;
    public final static int _3D = 5;
    
    /**
     * Create new price based on given attributes
     * attributes are valided before creation
     * If invalid, error is thrown and do nothing
     * else price list is created and save to data file
     * @param student
     * @param adult
     * @param senior
     * @param weekend
     * @param after6
     * @param _3D
     */
    public void create(double student,double adult,double senior,double weekend,double after6,double _3D) {
    	if (PriceLayer.isPriceValid(student,adult,senior,weekend,after6,_3D)) {
    		Price p = new Price(student, adult, senior, weekend, after6, _3D);
    		try {
    			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
    			out.writeObject(p);
    			out.flush();
                out.close();
    		}catch (IOException e) {
                // ignore error
            }
        } else {
            // do nothing
        }
    }
    
    /**
     * Read and return price list from database
     * @return Model.{@link Price} 
     */
    public Price read() {
    	try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
            Price p = (Price) ois.readObject();
            ois.close();
            return p;
    	}catch (ClassNotFoundException | IOException e) {
            // ignore error
        } 
    	return new Price();
    	
    }
    
    
    
    
    
    /**
     * Update price of paramter based on given attribute code
     * @param priceobj 	price object to be updated
     * @param modify	Attributes to be updated based on constants
     * @param price		new price of given attribute
     */
    public void changePrice(Price priceobj, int modify, double price) {
    	if (PriceLayer.isPriceValid(price)) {
    		switch(modify) {
        	case STUDENT:
        		priceobj.setStudent(price);
        		break;
        	case ADULT:
        		priceobj.setAdult(price);
        		break;
        	case SENIOR:
        		priceobj.setSenior(price);
        		break;
        	case WEEKEND:
        		priceobj.setWeekend(price);
        		break;
        	case AFTER6:
        		priceobj.setAfter6(price);
        		break;
        	case _3D:
        		priceobj.set3D(price);
        		break;
        	}
    	}
    }
    
    
    /**
     * Cal and return the ticket price based on Movie type, age of movie goer and session time
     * @param session  Session that is booked
     * @param age	   Age of movie goer
     * @param p		   price list to use for calculated final price
     * @return double  Final calculated price
     */
    public double calPrice(Sessions session,int age,Price p) {
    	double finalprice=0;
    	if (session.getMovie().getType().equals(MovieType.IN_3D)) {
    		finalprice+= p.get3D();
    	}
    	if(session.isWeekend()) {
    		finalprice+=p.getWeekend();
    	}
    	else {
    		finalprice += getAgePrice(age,p);
    	}
    	if (session.getStartTime().getHour()<18) {
    		return finalprice;
    	}
    	else {
    		return finalprice+p.getAfter6();   	
    	}
    }
    
    
    /**
     * Get price based on age of movie goer and price list to read from
     * @param age  age of movie goer
     * @param p		price list to read
     * @return double  Price based on age
     */
    public double getAgePrice(int age,Price p) {
    	if (age <=16) {
    		return p.getStudent();}
    	else if(age>=55) {	
    	return p.getAdult();
    	}
    	else {
    	return p.getSenior();
    	}
    }
    
}
