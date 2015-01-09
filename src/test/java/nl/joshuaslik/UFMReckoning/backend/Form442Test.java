package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Form442Test {
	
	@Test
	public void testConstructor() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		assertEquals(formation.getTeam(), team1);
	}
	
	@Test
	public void testGoalkeeper() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		formation.setGoalkeeper(goalkeeper1);
		Goalkeeper goalkeeper2 = new Goalkeeper("pietvelthuizen", "jan","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		formation.setGoalkeeper(goalkeeper2);
		assertEquals(formation.getGoalkeper(), goalkeeper2);
	}
	
	@Test
	public void testCB1() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB1(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB1(fieldplayer2);
		assertEquals(formation.getCB1(), fieldplayer2);
	}
	
	@Test
	public void testCB2() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB2(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCB2(fieldplayer2);
		assertEquals(formation.getCB2(), fieldplayer2);
	}
		
	@Test
	public void testRB() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRB(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRB(fieldplayer2);
		assertEquals(formation.getRB(), fieldplayer2);
	}
	
	@Test
	public void testLB() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLB(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLB(fieldplayer2);
		assertEquals(formation.getLB(), fieldplayer2);
	}
	
	@Test
	public void testCM1() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM1(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM1(fieldplayer2);
		assertEquals(formation.getCM1(), fieldplayer2);
	}
	
	@Test
	public void testCM2() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM2(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setCM2(fieldplayer2);
		assertEquals(formation.getCM2(), fieldplayer2);
	}
	
	@Test
	public void testRM() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRM(fieldplayer2);
		assertEquals(formation.getRM(), fieldplayer2);
	}
	
	@Test
	public void testLM() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLM(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLM(fieldplayer2);
		assertEquals(formation.getLM(), fieldplayer2);
	}
	
	@Test
	public void testRW() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRW(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setRW(fieldplayer2);
		assertEquals(formation.getRW(), fieldplayer2);
	}
	
	@Test
	public void testLW() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Form442 formation = new Form442(team1);
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLW(fieldplayer1);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		formation.setLW(fieldplayer2);
		assertEquals(formation.getLW(), fieldplayer2);
	}
	
}
