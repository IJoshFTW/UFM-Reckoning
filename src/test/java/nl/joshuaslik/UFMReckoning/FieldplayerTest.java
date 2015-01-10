package nl.joshuaslik.UFMReckoning;

import junit.framework.TestCase;
import nl.joshuaslik.UFMReckoning.backend.Fieldplayer;

import org.junit.Test;

public class FieldplayerTest extends TestCase {

	@Test
	public void testgetID(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getID(), "raivloet");
	}
	
	@Test
	public void testgetName(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getFullName(), "Rai Vloet");
	}
	
	@Test
	public void testgetCountry(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getCountry(), "Netherlands");
	}
	
	@Test
	public void testgetPrice(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getPrice(), 4000000);
	}
	
	@Test
	public void testgetAttackPower(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getAttackPower(), 62);
	}
	
	@Test
	public void testgetDefencePower(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getDefencePower(), 32);
	}
	
	@Test
	public void testgetStamina(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getStamina(), 63);
	}
	
	@Test
	public void testgetPosition(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		assertEquals(fieldplayer1.getPosition(), "CAM");
	}
	
	@Test
	public void testEquals(){
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet", "Netherlands", "CAM", 63, 32, 63, 4000000);
		assertEquals(fieldplayer1, fieldplayer1);
		assertNotSame(fieldplayer1, fieldplayer2);
	}
}
