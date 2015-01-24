package nl.joshuaslik.tudelft.UFMGame.backend;

import static org.junit.Assert.*;

import java.util.ArrayList;

import nl.joshuaslik.tudelft.UFMGame.backend.Competition;
import nl.joshuaslik.tudelft.UFMGame.backend.Game;
import nl.joshuaslik.tudelft.UFMGame.backend.Human;
import nl.joshuaslik.tudelft.UFMGame.backend.PC;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.User;

import org.junit.Test;

/**
 * Test to check the Game class
 * @author Naomi
 */
public class GameTest {

	/**
	 * Testing the constructor of the game class
	 */
	@Test
	public void testConstructor() {
		ArrayList<User> users = new ArrayList<User>();
		Game game1 = new Game(users);
		assertEquals(game1, game1);
	}

	/**
	 * Testing the constructor of the game class
	 */
	@Test
	public void testConstructor2() {
		ArrayList<User> users = new ArrayList<User>();
		Game game1 = new Game(users);
		assertEquals(game1.getUsers(), users);
	}

	/**
	 * Test to check if you can get the competition
	 */
	@Test
	public void testgetCompetition() {
		ArrayList<User> users = new ArrayList<User>();
		Game game1 = new Game(users);
		assertEquals(game1.getCompetition(), new Competition(game1));
	}

	/**
	 * Test to check if you can get users
	 */
	@Test
	public void testgetUser() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Human human1 = new Human(team1, "Bryan", 5000);
		Game game1 = new Game(users);
		game1.addUser(human1);
		game1.addUser(human1);
		assertEquals(game1.getUser(), human1);
	}

	/**
	 * Test to check if you can get users
	 */
	@Test
	public void testgetUser2() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		PC pc2 = new PC(team1, "test2", 50000);
		Game game1 = new Game(users);
		game1.addUser(pc1);
		game1.addUser(pc2);
		assertEquals(game1.getUser(), null);
	}

	/**
	 * Test to check if you can get users
	 */
	@Test
	public void testgetUser3() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		PC pc2 = new PC(team1, "test2", 50000);
		Game game1 = new Game(users);
		game1.addUser(pc1);
		game1.addUser(pc2);
		assertEquals(game1.getUser("test1"), pc1);
	}

	/**
	 * Test to check if you can get users
	 */
	@Test
	public void testgetUser4() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		PC pc2 = new PC(team1, "test2", 50000);
		Game game1 = new Game(users);
		game1.addUser(pc1);
		game1.addUser(pc2);
		assertEquals(game1.getUser("test3"), null);
	}

	/**
	 * Test to check if you can get users
	 */
	@Test
	public void testgetUser5() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		PC pc2 = new PC(team1, "test2", 50000);
		Game game1 = new Game(users);
		game1.addUser(pc1);
		game1.addUser(pc2);
		assertEquals(game1.getUser(team1), pc1);
	}

	/**
	 * Test to check if you can get users
	 */
	@Test
	public void testgetUser6() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		PC pc2 = new PC(team1, "test2", 50000);
		Game game1 = new Game(users);
		game1.addUser(pc1);
		game1.addUser(pc2);
		assertEquals(game1.getUser(team2), null);
	}

	/**
	 * Test to check if you can get the soccer teams 
	 */
	@Test
	public void testgetTeams() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		Game game1 = new Game(users);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		game1.addUser(pc1);
		assertEquals(game1.getTeams(), teams);
	}

	/**
	 * Test to check if you can get the soccer teams 
	 */
	@Test
	public void testgetTeam() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		Game game1 = new Game(users);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		game1.addUser(pc1);
		assertEquals(game1.getTeam("ajax"), team1);
	}
	
/**
 * Test to check if you can get the soccer teams 
 */
	@Test
	public void testgetTeam2() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		Game game1 = new Game(users);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		game1.addUser(pc1);
		assertEquals(game1.getTeam("ado"), null);
	}

	/**
	 * Test to check if you can get the players 
	 */
	@Test
	public void testgetPlayer() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		Game game1 = new Game(users);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		game1.addUser(pc1);
		assertEquals(game1.getPlayer(""), null);
	}

	/**
	 * Test to check if you can get the players by name
	 */
	@Test
	public void testgetPlayerbyName() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		Game game1 = new Game(users);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		game1.addUser(pc1);
		assertEquals(game1.getPlayerByName(""), null);
	}

	/**
	 * Test to check if you can get the players by name
	 */
	@Test
	public void testgetPlayerbyName2() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		PC pc1 = new PC(team1, "test1", 5000);
		Game game1 = new Game(users);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1);
		game1.addUser(pc1);
		assertFalse(game1.getPlayerByName("Aaron Meijers").equals(null));
	}

	/**
	 * Test to check if the standings can be computed
	 */
	@Test
	public void testComputeStandings() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc1", 5000));
		users.add(new PC(team3, "pc2", 500));
		users.add(new PC(team4, "pc3", 5000));
		Game game1 = new Game(users);
		assertFalse(game1.computeStandings().equals(null));
	}

	/**
	 * Test to check if you can get the playrounds
	 */
	@Test
	public void testGetPlayround() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc1", 5000));
		users.add(new PC(team3, "pc2", 500));
		users.add(new PC(team4, "pc3", 5000));
		Game game1 = new Game(users);
		game1.getCompetition().definePlayrounds();
		assertFalse(game1.getPlayround(1).equals(null));
	}

	/**
	 * Test to check if you can get the playrounds
	 */
	@Test
	public void testGetPlayrounds() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc1", 5000));
		users.add(new PC(team3, "pc2", 500));
		users.add(new PC(team4, "pc3", 5000));
		Game game1 = new Game(users);
		game1.getCompetition().definePlayrounds();
		assertEquals(game1.getPlayrounds().size(), 6);
	}
	
	/**
	 * test to buy a player
	 */
	@Test
	public void testbuyPlayer(){
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		users.add(new Human(team1, "Bryan", 500000000));
		users.add(new PC(team2, "pc1", 5000));
		users.add(new PC(team3, "pc2", 500));
		users.add(new PC(team4, "pc3", 5000));
		Game game1 = new Game(users);
		game1.buyPlayer("jaspercillessen", game1.getUser());
		assertTrue(game1.getUser().getTeam().getBenchPlayers().contains(game1.getPlayer("jaspercillessen")));
	}
	
	/**
	 * test to buy a non contracted player
	 */
	@Test
	public void testbuyNonContractedPlayer(){
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		users.add(new Human(team1, "Bryan", 500000000));
		users.add(new PC(team2, "pc1", 5000));
		users.add(new PC(team3, "pc2", 500));
		users.add(new PC(team4, "pc3", 5000));
		Game game1 = new Game(users);
		game1.getUser("Bryan").getTeam().addBenchPlayer(game1.getPlayer("jaspercillessen"));
		game1.getUser("Bryan").getTeam().addBenchPlayer(game1.getPlayer("aaronmeijers"));
		game1.setNonContracted("jaspercillessen");
		game1.buyNonContractedPlayer("jaspercillessen", game1.getUser());
		assertTrue(game1.getUser().getTeam().getBenchPlayers().contains(game1.getPlayer("jaspercillessen")));
	}
	
	/**
	 * test to sell a player
	 */
	@Test
	public void testSellPlayer(){
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		users.add(new Human(team1, "Bryan", 500000000));
		users.add(new PC(team2, "pc1", 5000));
		users.add(new PC(team3, "pc2", 500));
		users.add(new PC(team4, "pc3", 5000));
		Game game1 = new Game(users);
		game1.getUser("Bryan").getTeam().addBenchPlayer(game1.getPlayer("jaspercillessen"));
		game1.getUser("Bryan").getTeam().addBenchPlayer(game1.getPlayer("aaronmeijers"));
		game1.sellPlayer("jaspercillessen", game1.getUser());
		assertFalse(game1.getUser().getTeam().getBenchPlayers().contains(game1.getPlayer("jaspercillessen")));
	}
	
	/**
	 * test to change the formation of all the other teams as the human player
	 */
	@Test
	public void testChangeFormationRound(){
		Game game1 = Save.newGame(Save.loadTeam().get("ajax"), "Bryan");
		game1.changeFormationRound();
		game1.getUser("pc1").getTeam();
		assertEquals(game1.getUser("pc1").getTeam().getActivePlayers().size(), 11);
	}

}