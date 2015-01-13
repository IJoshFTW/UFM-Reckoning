package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;

import org.junit.Test;

public class FieldplayerTest {

	@Test
	public void testgetID() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getID(), "raivloet");
	}

	@Test
	public void testgetName() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getFullName(), "Rai Vloet");
	}

	@Test
	public void testgetCountry() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getCountry(), "Netherlands");
	}

	@Test
	public void testgetPrice() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getPrice(), 4000000);
	}

	@Test
	public void testgetAttackPower() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getAttackPower(), 62);
	}

	@Test
	public void testgetDefencePower() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getDefencePower(), 32);
	}

	@Test
	public void testgetStamina() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getStamina(), 63);
	}

	@Test
	public void testgetPosition() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getPosition(), "CAM");
	}

	@Test
	public void testEquals1() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 63, 32, 63, 4000000);
		assertEquals(fieldplayer1, fieldplayer1);
		assertNotSame(fieldplayer1, fieldplayer2);
	}

	@Test
	public void testEquals2() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloe", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals3() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloe",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals4() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Belgium", "CAM", 62, 32, 63, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals5() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CM", 62, 32, 63, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals6() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 61, 32, 63, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals7() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 31, 63, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals8() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 61, 4000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}

	@Test
	public void testEquals9() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 3000000);
		assertFalse(fieldplayer1.equals(fieldplayer2));
	}
}
