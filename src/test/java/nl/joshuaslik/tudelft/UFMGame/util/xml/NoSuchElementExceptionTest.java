package nl.joshuaslik.UFMReckoning.util.xml;

import nl.joshuaslik.tudelft.UFMGame.util.xml.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests to check No such element exception class
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class NoSuchElementExceptionTest {

	/**
	 * General rule
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test to check if an exception is thrown when there's no such element.
	 */
	@Test
	public void testThrow() {
		thrown.expect(NoSuchElementException.class);
		throw new NoSuchElementException();
	}

	/**
	 * Test to check if a message is thrown when there's no such element.
	 */
	@Test
	public void testThrowMessage() {
		thrown.expect(NoSuchElementException.class);
		thrown.expectMessage("A message");
		throw new NoSuchElementException("A message");
	}

}
