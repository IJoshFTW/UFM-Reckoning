package nl.joshuaslik.tudelft.UFMGame.backend.exceptions;

/**
 * class for players that are unknown
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnknownPlayerException extends RuntimeException {

	private static final long serialVersionUID = 6578535519190213510L;

	/**
	 * super for an unknown player
	 */
	public UnknownPlayerException() {
		super();
	}
	
	/**
	 * generate a message when there's an unknown player
	 * @param message is returned when there's an unknown player
	 */
	public UnknownPlayerException(String message) {
		super(message);
	}

}