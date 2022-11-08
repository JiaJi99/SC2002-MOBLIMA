package moblima.BusinessLayer;

import moblima.customException.PriceException.NegativePriceException;

public class PriceLayer {
	
	public static boolean isPriceValid(double student,double adult,double senior,double weekend,double after6,double _3D) {
		if(!isPriceValid(student)) {
			return false;	
		}
		if(!isPriceValid(adult)) {
			return false;
		}
		if(!isPriceValid(senior)) {
			return false;
		}
		if(!isPriceValid(weekend)) {
			return false;
		}
		if(!isPriceValid(after6)) {
			return false;
		}
		if(!isPriceValid(_3D)) {
			return false;
		}
		return true;
	}
	
	public static boolean isPriceValid(double price) {
		if (price<0){
			try {
				throw new NegativePriceException();
			} catch (NegativePriceException e) {
				System.out.println(e.getMessage());
			}
			return false;
		}
		return true;
	}

}
