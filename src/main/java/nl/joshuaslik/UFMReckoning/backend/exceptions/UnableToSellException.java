package nl.joshuaslik.UFMReckoning.backend.exceptions;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnableToSellException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2255178286901436485L;
	
	public UnableToSellException() {
		super();
	}
	
	public UnableToSellException(String message) {
		super(message);
	}

}
