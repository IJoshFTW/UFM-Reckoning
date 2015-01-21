package nl.joshuaslik.tudelft.UFMGame.backend;

import static org.junit.Assert.assertEquals;
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form433;

import org.junit.Test;

/**
 * Test to check the 4-3-3 formation
 * @author Naomi
 * @author Bryan
 *
 */
public class Form433Test {

	/**
	 * testing the constructor
	 */
	@Test
	public void testConstructor() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
	}

	/**
	 * Test to check if you can get the goalkeeper of a team
	 */
	@Test
	public void testGoalkeeper() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		formation.setGoalkeeper(goalkeeper1);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "jan",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		formation.setGoalkeeper(goalkeeper2);
		assertEquals(formation.getGoalkeper(), goalkeeper2);
	}

	/**
	 * Test to check if you can get the CB
	 */
	@Test
	public void testCB1() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB1(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB1(fieldplayer2);
		assertEquals(formation.getCB1(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the CB
	 */
	@Test
	public void testCB2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB2(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB2(fieldplayer2);
		assertEquals(formation.getCB2(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the RB
	 */
	@Test
	public void testRB() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRB(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRB(fieldplayer2);
		assertEquals(formation.getRB(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the LB
	 */
	@Test
	public void testLB() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLB(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLB(fieldplayer2);
		assertEquals(formation.getLB(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the CM
	 */
	@Test
	public void testCM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM(fieldplayer2);
		assertEquals(formation.getCM(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the RM
	 */
	@Test
	public void testRM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRM(fieldplayer2);
		assertEquals(formation.getRM(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the LM
	 */
	@Test
	public void testLM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLM(fieldplayer2);
		assertEquals(formation.getLM(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the RW
	 */
	@Test
	public void testRW() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRW(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRW(fieldplayer2);
		assertEquals(formation.getRW(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the LW
	 */
	@Test
	public void testLW() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLW(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLW(fieldplayer2);
		assertEquals(formation.getLW(), fieldplayer2);
	}

	/**
	 * Test to check if you can get the ST
	 */
	@Test
	public void testST() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form433 formation = new Form433(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setST(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setST(fieldplayer2);
		assertEquals(formation.getST(), fieldplayer2);
	}

}
