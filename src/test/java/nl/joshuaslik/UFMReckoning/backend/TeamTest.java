package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TeamTest {

	@Test
	public void testgetCoachName() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team.getCoachName(), "Frank de Boer");
	}

	@Test
	public void testgetTeamName() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team.getTeamName(), "ajax");
	}

	@Test
	public void testaddActivePlayer1() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addActivePlayer(fieldplayer1);
		assertTrue(team.getActivePlayers().contains(fieldplayer1));
	}

	@Test
	public void testaddActivePlayer2() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team.addActivePlayer(goalkeeper1);
		assertTrue(team.getActivePlayers().contains(goalkeeper1));
	}

	@Test
	public void testaddActivePlayer3() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		Goalkeeper goalkeeper2 = new Goalkeeper("piet", "Jan", "Velthuizen",
				"Netherlands", 45, 78, 80, 4000000);
		team.addActivePlayer(goalkeeper1);
		team.addActivePlayer(goalkeeper2);
		assertEquals(team.getActivePlayers().size(), 1);
	}

	@Test
	public void testaddActivePlayer4() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addActivePlayer(fieldplayer1);
		team.addActivePlayer(fieldplayer2);
		assertEquals(team.getActivePlayers().size(), 1);
	}

	@Test
	public void testaddActivePlayer5() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("klaassen", "Davy", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer3 = new Fieldplayer("lucas", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer4 = new Fieldplayer("stefan", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer5 = new Fieldplayer("nick", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer6 = new Fieldplayer("ruben", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer7 = new Fieldplayer("kenny", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer8 = new Fieldplayer("ruben", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer9 = new Fieldplayer("peter", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer10 = new Fieldplayer("nicki", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer11 = new Fieldplayer("rober", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer12 = new Fieldplayer("tobias", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team.addActivePlayer(fieldplayer1);
		team.addActivePlayer(fieldplayer2);
		team.addActivePlayer(fieldplayer3);
		team.addActivePlayer(fieldplayer4);
		team.addActivePlayer(fieldplayer5);
		team.addActivePlayer(fieldplayer6);
		team.addActivePlayer(fieldplayer7);
		team.addActivePlayer(fieldplayer8);
		team.addActivePlayer(fieldplayer9);
		team.addActivePlayer(fieldplayer10);
		team.addActivePlayer(fieldplayer11);
		team.addActivePlayer(fieldplayer12);
		team.addActivePlayer(goalkeeper1);
		assertEquals(team.getActivePlayers().size(), 11);
	}

	@Test
	public void testaddBenchPlayer1() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addBenchPlayer(fieldplayer1);
		assertTrue(team.getBenchPlayers().contains(fieldplayer1));
	}

	@Test
	public void testaddBenchPlayer2() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addBenchPlayer(fieldplayer1);
		team.addBenchPlayer(fieldplayer2);
		assertEquals(team.getBenchPlayers().size(), 1);
	}

	@Test
	public void testremoveActivePlayer1() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("piet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addActivePlayer(fieldplayer1);
		team.addActivePlayer(fieldplayer2);
		assertTrue(team.getActivePlayers().contains(fieldplayer2));
		team.removeActivePlayer(fieldplayer2);
		assertFalse(team.getActivePlayers().contains(fieldplayer2));
	}

	@Test
	public void testremoveActivePlayer2() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("piet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team.addActivePlayer(fieldplayer1);
		team.addActivePlayer(goalkeeper1);
		team.removeActivePlayer(fieldplayer2);
		assertEquals(team.getActivePlayers().size(), 2);
	}

	@Test
	public void testremoveActivePlayer3() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team.addActivePlayer(fieldplayer1);
		team.addActivePlayer(goalkeeper1);
		team.removeActivePlayer(goalkeeper1);
		assertEquals(team.getActivePlayers().size(), 1);
	}

	@Test
	public void testremoveBenchPlayer1() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("piet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addBenchPlayer(fieldplayer1);
		team.addBenchPlayer(fieldplayer2);
		assertTrue(team.getBenchPlayers().contains(fieldplayer2));
		team.removeBenchPlayer(fieldplayer2);
		assertFalse(team.getBenchPlayers().contains(fieldplayer2));
	}

	@Test
	public void testremoveBenchPlayer2() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("piet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.addBenchPlayer(fieldplayer1);
		team.removeBenchPlayer(fieldplayer2);
		assertEquals(team.getBenchPlayers().size(), 1);
	}

	@Test
	public void testTeamCaptain() {
		Team team = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team.setTeamCaptain(fieldplayer1);
		assertEquals(team.getTeamCaptain(), fieldplayer1);
	}

	@Test
	public void testEquals() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("klaassen", "Davy", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer3 = new Fieldplayer("lucas", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer4 = new Fieldplayer("stefan", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer5 = new Fieldplayer("nick", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer6 = new Fieldplayer("ruben", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer7 = new Fieldplayer("kenny", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer8 = new Fieldplayer("ruben", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer9 = new Fieldplayer("peter", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer10 = new Fieldplayer("nicki", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer11 = new Fieldplayer("rober", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer12 = new Fieldplayer("tobias", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer12);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(fieldplayer2);
		team1.addActivePlayer(fieldplayer3);
		team1.addActivePlayer(fieldplayer4);
		team1.addActivePlayer(fieldplayer5);
		team2.addActivePlayer(fieldplayer6);
		team2.addActivePlayer(fieldplayer7);
		team2.addActivePlayer(fieldplayer8);
		team2.addActivePlayer(fieldplayer9);
		team2.addActivePlayer(fieldplayer10);
		team2.addActivePlayer(fieldplayer11);
		team2.addActivePlayer(fieldplayer12);
		team2.addActivePlayer(goalkeeper1);
		assertEquals(team1, team1);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertFalse(team1.equals(fieldplayer1));
	}

	@Test
	public void testEquals3() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		assertNotSame(fieldplayer1, team1);
	}

	@Test
	public void testEquals4() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addBenchPlayer(fieldplayer1);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals5() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals6() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals7() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Ronald de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals8() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.setAttackPower(30);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals9() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.setDefencePower(60);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals10() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.setStamina(60);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals11() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.incTotalDraws();
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals12() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.addGoals(5);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals13() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.incTotalLosses();
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testEquals14() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.incTotalWins();
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals15() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Team team2 = new Team("ajax","ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.setRanking(5);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals16() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Team team2 = new Team("ajax","ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.addGoalsAgainst(4);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals17() {
		Team team1 = new Team("ajax","ajax", "Frank de Boer");
		Team team2 = new Team("ajax","ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.setTeamCaptain(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		team1.addPoints(3);
		assertFalse(team1.equals(team2));
	}

	@Test
	public void testgetAttackPower() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("klaassen", "Davy", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer3 = new Fieldplayer("lucas", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer4 = new Fieldplayer("stefan", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer5 = new Fieldplayer("nick", "Rai", "Vloet",
				"Netherlands", "CAM", 63, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(fieldplayer2);
		team1.addActivePlayer(fieldplayer3);
		team1.addActivePlayer(fieldplayer4);
		team1.addActivePlayer(fieldplayer5);
		assertEquals(team1.getAttackPower(), 311);
	}

	@Test
	public void testgetDefencePower() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("klaassen", "Davy", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer3 = new Fieldplayer("lucas", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer4 = new Fieldplayer("stefan", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 33, 63, 4000000);
		Fieldplayer fieldplayer5 = new Fieldplayer("nick", "Rai", "Vloet",
				"Netherlands", "CAM", 63, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(fieldplayer2);
		team1.addActivePlayer(fieldplayer3);
		team1.addActivePlayer(fieldplayer4);
		team1.addActivePlayer(fieldplayer5);
		assertEquals(team1.getDefencePower(), 161);
	}

	@Test
	public void testgetStamina() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 64, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("klaassen", "Davy", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer3 = new Fieldplayer("lucas", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer4 = new Fieldplayer("stefan", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 33, 63, 4000000);
		Fieldplayer fieldplayer5 = new Fieldplayer("nick", "Rai", "Vloet",
				"Netherlands", "CAM", 63, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(fieldplayer2);
		team1.addActivePlayer(fieldplayer3);
		team1.addActivePlayer(fieldplayer4);
		team1.addActivePlayer(fieldplayer5);
		assertEquals(team1.getStamina(), 316);
	}

	@Test
	public void testgetTotalDraws() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getTotalDraws(), 0);
	}

	@Test
	public void testgetTotalGoals() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getTotalGoals(), 0);
	}
	
	@Test
	public void testgetPoints() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getPoints(), 0);
	}
	
	@Test
	public void testgetRanking() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getRanking(), 0);
	}
	
	@Test
	public void testgetGoalsAgainst() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getGoalsAgainst(), 0);
	}
	

	@Test
	public void testgetTotalLosses() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getTotalLosses(), 0);
	}

	@Test
	public void testgetTotalWins() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getTotalWins(), 0);
	}
	
	@Test
	public void testgetID() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getid(), "ajax");
	}
	
	@Test
	public void testgetPlayers() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getPlayers(), 0);
	}
	
	@Test
	public void testgetAverageStamina() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getAverageStamina(), 0);
	}
	
	@Test
	public void testgetAverageDefencePower() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getAverageDefencePower(), 0);
	}
	
	@Test
	public void testgetAverageAttackPower() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		assertEquals(team1.getAverageAttackPower(), 0);
	}
	
	@Test
	public void testgetAllplayers() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addBenchPlayer(fieldplayer1);
		assertEquals(team1.getAllPlayers().size(), 1);
	}
	
	@Test
	public void testCalcAverageStamina() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addBenchPlayer(fieldplayer1);
		team1.addBenchPlayer(goalkeeper1);
		assertEquals(team1.getAllPlayers().size(), 2);
	}

	@Test
	public void testChangeFormation1() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(goalkeeper1);
		Formation formation = new Form343(team1);
		team1.changeFormationType(formation);
		assertEquals(team1.getFormation().getTeam(), team1);
	}
	
	
	@Test
	public void testSetPlayerBench() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addBenchPlayer(fieldplayer1);
		team1.addBenchPlayer(goalkeeper1);
		team1.setPlayerBench(goalkeeper1);
		assertEquals(team1.getBenchPlayers().size(), 2);
	}
	
	@Test
	public void testSetPlayerBench2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addBenchPlayer(fieldplayer1);
		team1.addActivePlayer(goalkeeper1);
		team1.setPlayerBench(goalkeeper1);
		assertEquals(team1.getBenchPlayers().size(), 2);
	}
	
	@Test
	public void testSetPlayerBench3() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addBenchPlayer(fieldplayer1);
		team1.setPlayerBench(goalkeeper1);
		assertEquals(team1.getBenchPlayers().size(), 2);
	}
	
	
	@Test
	public void testSetPlayerActive() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addBenchPlayer(goalkeeper1);
		team1.setPlayerActive(goalkeeper1);
		assertEquals(team1.getBenchPlayers().size(), 0);
	}
	
	@Test
	public void testSetPlayerActive2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(goalkeeper1);
		team1.addBenchPlayer(goalkeeper1);
		team1.setPlayerActive(goalkeeper1);
		assertEquals(team1.getBenchPlayers().size(), 1);
	}
	
	@Test
	public void testSetPlayerActive3() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addBenchPlayer(fieldplayer1);
		team1.addActivePlayer(goalkeeper1);
		team1.setPlayerActive(fieldplayer1);
		assertEquals(team1.getBenchPlayers().size(), 0);
	}
	
	@Test
	public void testSetPlayerActive4() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addActivePlayer(goalkeeper1);
		team1.setPlayerActive(fieldplayer1);
		assertEquals(team1.getBenchPlayers().size(), 0);
	}
	
	@Test
	public void testSetPlayerActive5() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team1.setPlayerActive(fieldplayer1);
		assertEquals(team1.getActivePlayers().size(), 1);
	}
	
	@Test
	public void testGetActiveGoalkeeper() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet","Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(goalkeeper1);
		assertEquals(team1.getActiveGoalkeeper(), goalkeeper1);
	}
	
	@Test
	public void testGetActiveGoalkeeper2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet","Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		assertEquals(team1.getActiveGoalkeeper(), null);
	}
	
	@Test
	public void testEquals18() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer2 = new Fieldplayer("klaassen", "Davy", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer3 = new Fieldplayer("lucas", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer4 = new Fieldplayer("stefan", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer5 = new Fieldplayer("nick", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer6 = new Fieldplayer("ruben", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer7 = new Fieldplayer("kenny", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer8 = new Fieldplayer("ruben", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer9 = new Fieldplayer("peter", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer10 = new Fieldplayer("nicki", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer11 = new Fieldplayer("rober", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Fieldplayer fieldplayer12 = new Fieldplayer("tobias", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Goalkeeper goalkeeper1 = new Goalkeeper("pietvelthuizen", "Piet",
				"Velthuizen", "Netherlands", 74, 72, 84, 3000000);
		team1.addActivePlayer(fieldplayer1);
		team1.addActivePlayer(fieldplayer2);
		team1.addActivePlayer(fieldplayer3);
		team1.addActivePlayer(fieldplayer4);
		team1.addActivePlayer(fieldplayer5);
		team2.addActivePlayer(fieldplayer6);
		team2.addActivePlayer(fieldplayer7);
		team2.addActivePlayer(fieldplayer8);
		team2.addActivePlayer(fieldplayer9);
		team2.addActivePlayer(fieldplayer10);
		team2.addActivePlayer(fieldplayer11);
		team2.addActivePlayer(fieldplayer12);
		team2.addActivePlayer(goalkeeper1);
		assertEquals(team1, team1);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals19() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team2.setTeamCaptain(fieldplayer1);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals20() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals21() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Fank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals22() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.incTotalWins();
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals23() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.incTotalLosses();
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals24() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.incTotalDraws();
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals25() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.addGoals(2);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals26() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.addPoints(2);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals27() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.setRanking(3);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals28() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.addGoalsAgainst(3);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals29() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.setStamina(15);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals30() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.setDefencePower(62);
		assertFalse(team1.equals(team2));
	}
	
	@Test
	public void testEquals31() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ajax", "ajax", "Frank de Boer");
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		team1.addActivePlayer(fieldplayer1);
		team2.addActivePlayer(fieldplayer1);
		team1.setAttackPower(63);
		assertFalse(team1.equals(team2));
	}
}
