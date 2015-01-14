package nl.joshuaslik.tudelft.UFMGame.backend.exceptions;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnableToSaveException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6160602694129829602L;

	public UnableToSaveException() {
		super();
	}
	
	public UnableToSaveException(String message) {
		super(message);
	}

}
