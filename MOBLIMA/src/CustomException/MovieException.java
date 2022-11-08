package moblima.customException;

public class MovieException {
	
	@SuppressWarnings("serial")
	public static class ExistingMovieException extends Exception {
        public ExistingMovieException() {
            super("Movie already existed");
        }
    }

    @SuppressWarnings("serial")
    public static class EndBeforeReleaseException extends Exception {
        public EndBeforeReleaseException() {
            super("End Date is before Release Date");
        }
    }

    @SuppressWarnings("serial")
    public static class NegativeDurationException extends Exception {
        public NegativeDurationException() {
            super("Duration is negative");
        }
    }
    @SuppressWarnings("serial")
    public static class NegativeNumberException extends Exception {
        public NegativeNumberException() {
            super("number is negative");
        }
    }
    @SuppressWarnings("serial")
    public static class EmptyCastException extends Exception {
        public EmptyCastException() {
            super("Cast list size is invalid");
        }
    }

    @SuppressWarnings("serial")
    public static class EmptyStringException extends Exception {
        public EmptyStringException(String errorMessage){
            super(errorMessage);
        }
    }
    
    @SuppressWarnings("serial")
    public static class OutofRangeException extends Exception{
    	public OutofRangeException() {
    		super("Invalid selection");
    	}
    }
    @SuppressWarnings("serial")
    public static class SmallCastException extends Exception{
    	public SmallCastException() {
    		super("Cast size minimum of 2");
    	}
    }
    
    
}

