package nl.joshuaslik.tudelft.UFMGame.backend.exceptions;

/**
 * class for an exception: unable to buy a player. 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnableToBuyException extends RuntimeException {

	private static final long serialVersionUID = -2255178286901436485L;
	
	/**
	 * super for an unable to buy exception
	 */
	public UnableToBuyException() {
		super();
	}
	
	/**
	 * Message that is generated when a player cannot be bought. 
	 * @param message that says that a player cannot be bought. 
	 */
	public UnableToBuyException(String message) {
		super(message);
	}

}
