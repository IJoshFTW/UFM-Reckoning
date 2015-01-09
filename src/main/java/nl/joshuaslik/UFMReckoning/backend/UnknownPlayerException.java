package nl.joshuaslik.UFMReckoning.backend;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class UnknownPlayerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6578535519190213510L;

	public UnknownPlayerException() {
		super();
	}
	
	public UnknownPlayerException(String message) {
		super(message);
	}

}