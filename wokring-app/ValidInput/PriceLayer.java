package ValidInput;
import ExceptionClasses.PriceException.NegativePriceException;

public class PriceLayer {
	
	
	/**
	 * Check of attributes passed are vaild
	 * @param student   Student price
	 * @param adult		Adult price
	 * @param senior	Senior price
	 * @param weekend	Weekend price
	 * @param after6	After 6 price
	 * @param _3D		3D movie price
	 * @return boolean  Return true if all attributes are valid, else false
	 */
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
	
	
	/**
	 * Check if attribute is negative double number
	 * @param price   	price to check
	 * @return	boolean Return true if price is positive,else false 
	 */
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
