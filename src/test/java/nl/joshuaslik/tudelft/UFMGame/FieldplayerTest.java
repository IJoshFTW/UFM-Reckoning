package nl.joshuaslik.tudelft.UFMGame;

import junit.framework.TestCase;
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;

import org.junit.Test;

/**
 * Tests to check the fieldplayer class
 * @author Naomi
 *
 */
public class FieldplayerTest extends TestCase {

	/**
	 * Test to check if you can get the ID of a player
	 */
	@Test
	public void testgetID() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getID(), "raivloet");
	}

	/**
	 * Test to check if you can get the name of the player
	 */
	@Test
	public void testgetName() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getFullName(), "Rai Vloet");
	}

	/**
	 * Test to check if you can get the country of the player
	 */
	@Test
	public void testgetCountry() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getCountry(), "Netherlands");
	}

	/**
	 * Test to get the pri
	 */
	@Test
	public void testgetPrice() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getPrice(), 4000000);
	}

	/**
	 * Test to check if you can get the attack power of a player
	 */
	@Test
	public void testgetAttackPower() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getAttackPower(), 62);
	}

	/**
	 * Test to check if you can get the defence power of a player
	 */
	@Test
	public void testgetDefencePower() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getDefencePower(), 32);
	}

	/**
	 * Test to check if you can get the stamina of a player
	 */
	@Test
	public void testgetStamina() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getStamina(), 63);
	}

	/**
	 * Test to check if you can get the position of a player
	 */
	@Test
	public void testgetPosition() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getPosition(), "CAM");
	}

	/**
	 * Test to check if 2 players are the same
	 */
	@Test
	public void testEquals() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 63, 32, 63, 4000000);
		assertEquals(fieldplayer1, fieldplayer1);
		assertNotSame(fieldplayer1, fieldplayer2);
	}
}
