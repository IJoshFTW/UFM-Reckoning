package nl.joshuaslik.tudelft.UFMGame.backend.exceptions;

/**
 * Class for the exception unable to sell
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnableToSellException extends RuntimeException {

	private static final long serialVersionUID = -2255178286901436485L;

	/**
	 * super for the exception when you're unable to sell a player
	 */
	public UnableToSellException() {
		super();
	}

	/**
	 * Super with a message in it
	 * 
	 * @param message
	 *            that is sent when you're unable to sell a player
	 */
	public UnableToSellException(String message) {
		super(message);
	}

}
