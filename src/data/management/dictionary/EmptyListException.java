package data.management.dictionary;

/**
 * Models the exception for an empty list
 * 
 * @author Ben Long
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception {

	/**
	 * Null constructor
	 */
	public EmptyListException() {
	}

	/**
	 * @param message
	 */
	public EmptyListException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EmptyListException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmptyListException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmptyListException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
