package nl.joshuaslik.tudelft.UFMGame.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import nl.joshuaslik.tudelft.UFMGame.backend.Match;
import nl.joshuaslik.tudelft.UFMGame.backend.Playround;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;

import org.junit.Test;

/**
 * Tests to check the playround class
 * 
 * @author Naomi
 * @author Bryan
 *
 */
public class Playroundtest {

	/**
	 * Testing the constructor of the playround class
	 */
	@Test
	public void testConstructor() {
		Playround playround1 = new Playround();
		assertEquals(playround1, playround1);
	}

	/**
	 * Test to check if you can add a match to a playround
	 */
	@Test
	public void testaddmatch() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		Playround playround2 = new Playround();
		assertFalse(playround1.equals(playround2));
	}

	/**
	 * Test to check if two playrounds are equal
	 */
	@Test
	public void testequals() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		Playround playround2 = new Playround();
		playround2.addmatch(match);
		assertEquals(playround1, playround2);
	}

	/**
	 * Test to check if two playrounds are equal
	 */
	@Test
	public void testequals2() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		Playround playround2 = new Playround();
		playround2.addmatch(match);
		assertFalse(playround1.equals(team1));
	}

	/**
	 * Test to check if a playround contains a team
	 */
	@Test
	public void testconatains() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		assertEquals(playround1.contains(team1), 1);
	}

	/**
	 * Test to check if a playround contains a team
	 */
	@Test
	public void testconatains2() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		assertEquals(playround1.contains(team3), 0);
	}

	/**
	 * Test to check if you can get the matches of a playround
	 */
	@Test
	public void testgetMatches() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		assertEquals(playround1.getMatches().size(), 1);
	}

	/**
	 * Test to check if you can get the number of the playround
	 */
	@Test
	public void testPlayroundnr() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		playround1.setPlayroundnr(5);
		assertEquals(playround1.getPlayroundnr(), 5);
	}

}
