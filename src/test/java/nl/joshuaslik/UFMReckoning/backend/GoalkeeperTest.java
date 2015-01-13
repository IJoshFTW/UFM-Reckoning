package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;

import org.junit.Test;

public class GoalkeeperTest {

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
	public void testEquals1() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuize", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals2() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "Pie",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals3() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Belgium", 74, 72, 84, 3000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals4() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 73, 72, 84, 3000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals5() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 71, 84, 3000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals6() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 83, 3000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals7() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 4000000);
		assertFalse(goalkeeper1.equals(goalkeeper2));
	}

	@Test
	public void testEquals8() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		String name = "";
		assertFalse(goalkeeper1.equals(name));
	}

	@Test
	public void testEquals9() {
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		assertEquals(goalkeeper1, goalkeeper1);
	}
}
