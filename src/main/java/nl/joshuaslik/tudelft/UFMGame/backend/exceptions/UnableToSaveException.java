package nl.joshuaslik.tudelft.UFMGame.backend.exceptions;

/**
 * class for the exception if a game cannot be saved
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnableToSaveException extends RuntimeException {
	
	private static final long serialVersionUID = 6160602694129829602L;

	/**
	 * super for an unable to save exception
	 */
	public UnableToSaveException() {
		super();
	}
	
	/**
	 * message that is generated when a game cannot be saved
	 * @param message that says that a game cannot be saved. 
	 */
	public UnableToSaveException(String message) {
		super(message);
	}

}
