package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class Playroundtest {
	
	@Test
	public void testConstructor() {
		Playround playround1 = new Playround();
		assertEquals(playround1, playround1);
	}
	
	@Test
	public void testaddmatch() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado","ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		Playround playround2 = new Playround();
		assertFalse(playround1.equals(playround2));
	}
	
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
	
	@Test
	public void testconatains() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		assertEquals(playround1.contains(team1), 1);
	}
	
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
	
	@Test
	public void testgetMatches() {
		Playround playround1 = new Playround();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Match match = new Match(team1, team2);
		playround1.addmatch(match);
		assertEquals(playround1.getMatches().size(), 1);
	}
	
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
	
	