package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.joshuaslik.tudelft.UFMGame.backend.Human;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests to check the Human class
 * @author Naomi
 *
 */
public class HumanTest {

	/**
	 * Define Human
	 */
	Human user;

	/**
	 * Defining a user
	 */
	@Before
	public void construct() {
		user = new Human(new Team("id", "tmname", "cchname"), "username",
				1000000);
	}

	/**
	 * Testing the constructor of the human class
	 */
	@Test
	public void testConstructor() {
		construct();
	}

	/**
	 * Test to check if you can get the username of a human
	 */
	@Test
	public void testGetUserName() {
		construct();
		assertTrue(user.getUserName().equals("username"));
	}

	/**
	 * Test to check if you can get the team of a user
	 */
	@Test
	public void testGetTeam() {
		construct();
		assertTrue(user.getTeam().getTeamName().equals("tmname"));
		assertTrue(user.getTeam().getCoachName().equals("cchname"));
	}

	/**
	 * Test to check if you can get the budget of a user
	 */
	@Test
	public void testGetBudget() {
		construct();
		assertEquals(user.getBudget(), 1000000);
	}

	/**
	 * Test to check if two users are the same
	 */
	@Test
	public void testEquals() {
		construct();
		assertFalse(user.equals("test"));
	}

	/**
	 * Test to check if two users are the same
	 */
	@Test
	public void testEquals2() {
		construct();
		assertTrue(user.equals(user));
	}

	/**
	 * Test to check if two users are the same
	 */
	@Test
	public void testEquals3() {
		construct();
		Human user2 = new Human(new Team("id", "ado", "cchname"), "username",
				1000000);
		assertFalse(user.equals(user2));
	}

	/**
	 * Test to check if two users are the same
	 */
	@Test
	public void testEquals4() {
		construct();
		Human user2 = new Human(new Team("id", "tmname", "cchname"), "test",
				1000000);
		assertFalse(user.equals(user2));
	}

	/**
	 * Test to check if two users are the same
	 */
	@Test
	public void testEquals5() {
		construct();
		Human user2 = new Human(new Team("id", "tmname", "cchname"),
				"username", 10030000);
		assertFalse(user.equals(user2));
	}
}
