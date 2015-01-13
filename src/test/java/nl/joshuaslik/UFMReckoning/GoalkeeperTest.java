package nl.joshuaslik.UFMReckoning;

import junit.framework.TestCase;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;

import org.junit.Test;

public class GoalkeeperTest extends TestCase {

	@Test
	public void testgetID() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getID(), "pietvelthuizen");
	}

	@Test
	public void testgetName() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getFullName(), "Piet Velthuizen");
	}

	@Test
	public void testgetCountry() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getCountry(), "Netherlands");
	}

	@Test
	public void testgetPrice() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getPrice(), 3000000);
	}

	@Test
	public void testgetReflexes() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getReflexes(), 74);
	}

	@Test
	public void testgetDiving() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getDiving(), 72);
	}

	@Test
	public void testgetPositioning() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1.getPositioning(), 84);
	}

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
