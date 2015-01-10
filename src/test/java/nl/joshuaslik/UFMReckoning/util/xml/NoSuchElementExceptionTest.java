package nl.joshuaslik.UFMReckoning.util.xml;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class NoSuchElementExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testThrow() {
		thrown.expect(NoSuchElementException.class);
		throw new NoSuchElementException();
	}

	@Test
	public void testThrowMessage() {
		thrown.expect(NoSuchElementException.class);
		thrown.expectMessage("A message");
		throw new NoSuchElementException("A message");
	}

}
