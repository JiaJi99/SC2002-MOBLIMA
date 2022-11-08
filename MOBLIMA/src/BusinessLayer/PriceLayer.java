package moblima.BusinessLayer;

import moblima.customException.PriceException.NegativePriceException;

public class PriceLayer {
	
	public static boolean isPriceinValid(double price) {
		if (price<0){
			try {
				throw new NegativePriceException();
			} catch (NegativePriceException e) {
				System.out.println(e.getMessage());
			}
			return true;
		}
		return false;
	}

}
