package moblima.customException;

public class PriceException {
	@SuppressWarnings("serial")
	public static class NegativePriceException extends Exception {
        public NegativePriceException() {
            super("Price must be positive");
        }
    }
}
