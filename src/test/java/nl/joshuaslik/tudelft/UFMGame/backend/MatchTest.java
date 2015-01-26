package nl.joshuaslik.tudelft.UFMGame.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Match;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;

import org.junit.Test;

/**
 * Tests to check the match class
 * @author Naomi
 *
 */
public class MatchTest {

	/**
	 * Testing the constructor
	 */
	@Test
	public void testConstructor() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		team1.setTeamCaptain(fieldplayer1);
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		team2.setTeamCaptain(fieldplayer1);
		Match match = new Match(team1, team2);
		assertEquals(match, match);
	}

	/**
	 * testing the constructor
	 */
	@Test
	public void testConstructor2() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		team1.setTeamCaptain(fieldplayer1);
		Match match = new Match(team1, team1);
		assertEquals(match.getHomeTeam(), null);
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals1() {
		Fieldplayer fieldplayer1 = new Fieldplayer("raivloet", "Rai", "Vloet",
				"Netherlands", "CAM", 62, 32, 63, 4000000);
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		team1.setTeamCaptain(fieldplayer1);
		Team team2 = new Team("ajax", "ado", "Ronald de Boer");
		team2.setTeamCaptain(fieldplayer1);
		Match match = new Match(team1, team2);
		Team team3 = new Team("psv", "psv", "Frank de Boer");
		team3.setTeamCaptain(fieldplayer1);
		Team team4 = new Team("az", "az", "Ronald de Boer");
		team4.setTeamCaptain(fieldplayer1);
		Match match2 = new Match(team3, team4);
		assertFalse(match.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertFalse(match.equals(team1));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals4() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team1);
		match2.setWinner(team1);
		match1.setLoser(team2);
		match2.setLoser(team2);
		assertEquals(match1, match2);
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals5() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match1 = new Match(team1, team2);
		match1.setWinner(team1);
		match1.setLoser(team2);
		match1.setHomegoals(4);
		match1.setawaygoals(3);
		assertFalse(match1.equals(null));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals6() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team1);
		match2.setWinner(team1);
		match1.setLoser(team2);
		match2.setLoser(team2);
		match1.setHomegoals(4);
		match1.setawaygoals(3);
		match2.setHomegoals(2);
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals7() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team1);
		match2.setWinner(team1);
		match1.setLoser(team2);
		match2.setLoser(team2);
		match1.setHomegoals(4);
		match1.setawaygoals(3);
		match2.setawaygoals(2);
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals8() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team1);
		match2.setWinner(team1);
		match2.setLoser(team2);
		;
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals9() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team1);
		match2.setWinner(team1);
		match1.setLoser(team2);
		match2.setLoser(team2);
		match1.setawaygoals(4);
		match1.setHomegoals(4);
		match2.setawaygoals(4);
		match2.setHomegoals(3);
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals10() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team2);
		match2.setWinner(team1);
		match1.setLoser(team2);
		match2.setLoser(team2);
		match1.setawaygoals(4);
		match1.setHomegoals(4);
		match2.setawaygoals(4);
		match2.setHomegoals(4);
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals11() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setWinner(team1);
		match2.setWinner(team1);
		match1.setLoser(team1);
		match2.setLoser(team2);
		match1.setawaygoals(4);
		match1.setHomegoals(4);
		match2.setawaygoals(4);
		match2.setHomegoals(4);
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if two matches are equal
	 */
	@Test
	public void testEquals12() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team1, team2);
		match1.setLoser(team1);
		match2.setLoser(team2);
		match1.setawaygoals(4);
		match1.setHomegoals(4);
		match2.setawaygoals(2);
		match2.setHomegoals(4);
		assertFalse(match1.equals(match2));
	}

	/**
	 * Test to check if you can get the home team of a match
	 */
	@Test
	public void testgetHomeTeam() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getHomeTeam(), team1);
	}

	/**
	 * Test to check if you can get the away team of a match
	 */
	@Test
	public void testgetAwayTeam() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getAwayTeam(), team2);
	}

	/**
	 * Test to check if you can get the home team of a match
	 */
	@Test
	public void testgetHometeam() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getHometeam(), team1.getTeamName());
	}

	/**
	 * Test to check if you can get the away team of a match
	 */
	@Test
	public void testgetAwayteam() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getAwayteam(), team2.getTeamName());
	}

	/**
	 * Test to check if you can get the goals made by the away team
	 */
	@Test
	public void testgetAwayGoals1() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		match.setawaygoals(5);
		assertEquals(match.getAwaygoals(), (Integer) 5);
	}

	/**
	 * Test to check if you can get the goals made by the away team
	 */
	@Test
	public void testgetAwayGoals2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getAwaygoals(), null);
	}

	/**
	 * Test to check if you can get the goals made by the home team
	 */
	@Test
	public void testgetHomeGoals1() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		match.setHomegoals(5);
		assertEquals(match.getHomegoals(), (Integer) 5);
	}

	/**
	 * Test to check if you can get the goals made by the home team
	 */
	@Test
	public void testgetHomeGoals2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getHomegoals(), null);
	}

	/**
	 * Test to check if you can get the winner of a match
	 */
	@Test
	public void testgetWinner() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		match.setWinner(team1);
		assertEquals(match.getWinner(), team1);
	}

	/**
	 * Test to check if you can get the loser of the match
	 */
	@Test
	public void testgetLoser() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		match.setLoser(team1);
		assertEquals(match.getLoser(), team1);
	}

	/**
	 * Test to check if a match can get a draw
	 */
	@Test
	public void testgetDraw() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.getDraw(), false);
	}

	/**
	 * Test to check if you can get a playround
	 */
	@Test
	public void testPlayround() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		match.setPlayround(5);
		assertEquals(match.getPlayround(), 5);
	}

	/**
	 * Test to check if a match contains a team
	 */
	@Test
	public void testContains() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertTrue(match.contains(team1));
	}

	/**
	 * Test to check if a match contains a team
	 */
	@Test
	public void testContains2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertTrue(match.contains(team2));
	}

	/**
	 * Test to check if a match contains a team
	 */
	@Test
	public void testContains3() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Team team3 = new Team("PSV", "PSV", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertFalse(match.contains(team3));
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals1() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(50), 0);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals2() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(811), 1);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals3() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(1531), 2);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals4() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2131), 3);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals5() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2431), 4);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals6() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2641), 5);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals7() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2851), 6);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals8() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2911), 7);
	}
	
	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals9() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2941), 8);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals10() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2971), 9);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals11() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(2986), 10);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals12() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(3001), 11);
	}

	/**
	 * Test to check if you can determine the goals of a match
	 */
	@Test
	public void testDetermineGoals13() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Ronald de Boer");
		Match match = new Match(team1, team2);
		assertEquals(match.determinegoals(-1), -1);
	}

}
