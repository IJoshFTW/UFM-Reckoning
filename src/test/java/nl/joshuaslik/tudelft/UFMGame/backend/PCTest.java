package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.joshuaslik.tudelft.UFMGame.backend.Human;
import nl.joshuaslik.tudelft.UFMGame.backend.PC;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;

import org.junit.Before;
import org.junit.Test;

/**
 * Test to check the PC class
 * 
 * @author Naomi
 *
 */
public class PCTest {

	/**
	 * Declaring PC user
	 */
	PC user;

	/**
	 * Adding a user
	 */
	@Before
	public void construct() {
		user = new PC(new Team("id", "tmname", "cchname"), "username", 100);
	}

	/**
	 * Testing the constructor of the pc class
	 */
	@Test
	public void testConstructor() {
		construct();
	}

	/**
	 * Test to check if you can get the username of the pc
	 */
	@Test
	public void testGetUserName() {
		construct();
		assertTrue(user.getUserName().equals("username"));
	}

	/**
	 * Test to check if you can get the team of the pc
	 */
	@Test
	public void testGetTeam() {
		construct();
		assertTrue(user.getTeam().getTeamName().equals("tmname"));
		assertTrue(user.getTeam().getCoachName().equals("cchname"));
	}

	/**
	 * Test to check if you can get the budget of the pc
	 */
	@Test
	public void testGetBudget() {
		construct();
		assertEquals(user.getBudget(), 100);
	}

	/**
	 * Test to check if two PCs are the same
	 */
	@Test
	public void testEquals() {
		construct();
		assertFalse(user.equals("test"));
	}

	/**
	 * Test to check if two PCs are the same
	 */
	@Test
	public void testEquals2() {
		construct();
		assertTrue(user.equals(user));
	}

	/**
	 * Test to check if two PCs are the same
	 */
	@Test
	public void testEquals3() {
		construct();
		PC user2 = new PC(new Team("id", "ado", "cchname"), "username", 1000000);
		assertFalse(user.equals(user2));
	}

	/**
	 * Test to check if two PCs are the same
	 */
	@Test
	public void testEquals4() {
		construct();
		PC user2 = new PC(new Team("id", "tmname", "cchname"), "test", 1000000);
		assertFalse(user.equals(user2));
	}

	/**
	 * Test to check if two PCs are the same
	 */
	@Test
	public void testEquals5() {
		construct();
		PC user2 = new PC(new Team("id", "tmname", "cchname"), "username",
				10030000);
		assertFalse(user.equals(user2));
	}

	/**
	 * Test to chck if you can add money to a pc
	 */
	@Test
	public void testAddMoney() {
		construct();
		user.addMoney(500);
		assertEquals(user.getBudget(), 600);
	}

	/**
	 * test to check if you can substract money from a pc
	 */
	@Test
	public void testSubMoney() {
		construct();
		user.subMoney(60);
		assertEquals(user.getBudget(), 40);
	}

	/**
	 * test to check if a user is human
	 */
	@Test
	public void testisHuman() {
		construct();
		user.subMoney(60);
		assertFalse(user.isHuman());
	}

	/**
	 * test to check if a user is human
	 */
	@Test
	public void testisHuman2() {
		construct();
		Human user2 = new Human(new Team("id", "tmname", "cchname"),
				"username", 10030000);
		assertTrue(user2.isHuman());
	}

	/**
	 * Test to check the costs
	 */
	@Test
	public void testCheckCost() {
		construct();
		assertFalse(user.checkCost(600));
	}

	/**
	 * Test to check the costs
	 */
	@Test
	public void testCheckCost2() {
		construct();
		assertTrue(user.checkCost(50));
	}

}
