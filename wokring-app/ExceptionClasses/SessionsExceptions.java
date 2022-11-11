package ExceptionClasses;


public class SessionsExceptions {

	@SuppressWarnings("serial")
    public static class InvalidDateTimeException extends Exception {
        public InvalidDateTimeException() {
            super("Show cannot be created (due to conflicting datetime)");
        }
    }
}

