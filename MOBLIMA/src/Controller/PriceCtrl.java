package moblima.Manager;
import moblima.BusinessLayer.PriceLayer;
import moblima.Model.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class PriceCtrl {
	
	public final static String FILENAME = "MOBLIMA/database/price.txt";

	
	public final static int STUDENT = 0;
    public final static int ADULT = 1;
    public final static int SENIOR = 2;
    public final static int WEEKEND = 3;
    public final static int AFTER6 = 4;
    public final static int _3D = 5;
    
    
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
