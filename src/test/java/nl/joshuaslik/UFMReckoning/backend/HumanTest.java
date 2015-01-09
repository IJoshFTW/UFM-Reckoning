package nl.joshuaslik.UFMReckoning.backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
	
	Human user;
	
	@Before
	public void construct() {
		user = new Human(new Team("id", "tmname", "cchname"), "username", 1000000);
	}
	
	@Test
	public void testConstructor() {
		construct();
	}

	@Test
	public void testGetUserName() {
		construct();
		assertTrue(user.getUserName().equals("username"));
	}
	
	@Test
	public void testGetTeam() {
		construct();
		assertTrue(user.getTeam().getTeamName().equals("tmname"));
		assertTrue(user.getTeam().getCoachName().equals("cchname"));
	}
	
	@Test
	public void testGetBudget() {
		construct();
		assertEquals(user.getBudget(), 1000000);
	}
	
	@Test
	public void testEquals() {
		construct();
		assertFalse(user.equals("test"));
	}
	
	@Test
	public void testEquals2() {
		construct();
		assertTrue(user.equals(user));
	}
	
	@Test
	public void testEquals3() {
		construct();
		Human user2 = new Human(new Team("id", "ado", "cchname"), "username", 1000000);
		assertFalse(user.equals(user2));
	}
	
	@Test
	public void testEquals4() {
		construct();
		Human user2 = new Human(new Team("id", "tmname", "cchname"), "test", 1000000);
		assertFalse(user.equals(user2));
	}
	
	@Test
	public void testEquals5() {
		construct();
		Human user2 = new Human(new Team("id", "tmname", "cchname"), "username", 10030000);
		assertFalse(user.equals(user2));
	}
}
