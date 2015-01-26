package nl.joshuaslik.tudelft.UFMGame.util.xml;

import nl.joshuaslik.tudelft.UFMGame.util.xml.NoSuchAttributeException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test to check the No such attribute exception class
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 */
public class NoSuchAttributeExceptionTest {

	/**
	 * The general rule for an expection
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test to check if an exception is thrown when there's no such attribute
	 */
	@Test
	public void testThrows() {
		thrown.expect(NoSuchAttributeException.class);
		throw new NoSuchAttributeException();
	}

	/**
	 * Test to check if a message is thrown when there's no such attribute.
	 */
	@Test
	public void testThrowMessage() {
		thrown.expect(NoSuchAttributeException.class);
		thrown.expectMessage("A message");
		throw new NoSuchAttributeException("A message");
	}

}