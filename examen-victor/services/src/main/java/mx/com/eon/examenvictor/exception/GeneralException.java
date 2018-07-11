package mx.com.eon.examenvictor.exception;

public class GeneralException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4454842170932471040L;
	
	private final String message;
	
	public GeneralException(String message) {
		this(message,null);
	}
	
	public GeneralException(String message, Throwable e) {
		super(message,e);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

}
