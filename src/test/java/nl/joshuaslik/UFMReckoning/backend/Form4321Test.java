package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form4321;

import org.junit.Test;

public class Form4321Test {

	@Test
	public void testConstructor() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		assertEquals(formation.getTeam(), team1);
	}

	@Test
	public void testGoalkeeper() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		formation.setGoalkeeper(goalkeeper1);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "jan",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		formation.setGoalkeeper(goalkeeper2);
		assertEquals(formation.getGoalkeper(), goalkeeper2);
	}

	@Test
	public void testCB1() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB1(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB1(fieldplayer2);
		assertEquals(formation.getCB1(), fieldplayer2);
	}

	@Test
	public void testCB2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB2(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB2(fieldplayer2);
		assertEquals(formation.getCB2(), fieldplayer2);
	}

	@Test
	public void testRB() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRB(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRB(fieldplayer2);
		assertEquals(formation.getRB(), fieldplayer2);
	}

	@Test
	public void testLB() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLB(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLB(fieldplayer2);
		assertEquals(formation.getLB(), fieldplayer2);
	}

	@Test
	public void testCM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM(fieldplayer2);
		assertEquals(formation.getCM(), fieldplayer2);
	}

	@Test
	public void testRM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRM(fieldplayer2);
		assertEquals(formation.getRM(), fieldplayer2);
	}

	@Test
	public void testLM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLM(fieldplayer2);
		assertEquals(formation.getLM(), fieldplayer2);
	}

	@Test
	public void testORM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setORM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setORM(fieldplayer2);
		assertEquals(formation.getORM(), fieldplayer2);
	}

	@Test
	public void testOLM() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setOLM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setOLM(fieldplayer2);
		assertEquals(formation.getOLM(), fieldplayer2);
	}

	@Test
	public void testST() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Form4321 formation = new Form4321(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setST(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setST(fieldplayer2);
		assertEquals(formation.getST(), fieldplayer2);
	}
}
