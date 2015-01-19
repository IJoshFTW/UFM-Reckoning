package nl.joshuaslik.tudelft.UFMGame;

import junit.framework.TestCase;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;

import org.junit.Test;

/**
 * Test to check the goalkeeper class
 * 
 * @author Naomi
 *
 */
public class GoalkeeperTest extends TestCase {

	/**
	 * Test to check if you can get the ID of a goalkeeper
	 */
	@Test
	public void testgetID() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getID(), "pietvelthuizen");
	}

	/**
	 * Test to check if you can get the name of a goalkeeper
	 */
	@Test
	public void testgetName() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getFullName(), "Piet Velthuizen");
	}

	/**
	 * Test to check if you can get the country of a goalkeeper
	 */
	@Test
	public void testgetCountry() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getCountry(), "Netherlands");
	}

	/**
	 * Test to check if you can get the price of a goalkeeper
	 */
	@Test
	public void testgetPrice() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getPrice(), 3000000);
	}

	/**
	 * Test to check if you can get the number for reflexes
	 */
	@Test
	public void testgetReflexes() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getReflexes(), 74);
	}

	/**
	 * Test to check if you can get the number for diving
	 */
	@Test
	public void testgetDiving() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getDiving(), 72);
	}

	/**
	 * Test to check if you can get the number for positioning 
	 */
	@Test
	public void testgetPositioning() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getPositioning(), 84);
	}

	/**
	 * Test to check if two goalkeepers are the same
	 */
	@Test
	public void testEquals() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuize", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1, goalkeeper1);
		assertNotSame(goalkeeper1, goalkeeper2);
	}
}
