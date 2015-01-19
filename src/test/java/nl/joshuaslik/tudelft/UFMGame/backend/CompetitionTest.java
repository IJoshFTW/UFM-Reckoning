package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import nl.joshuaslik.tudelft.UFMGame.backend.Competition;
import nl.joshuaslik.tudelft.UFMGame.backend.Game;
import nl.joshuaslik.tudelft.UFMGame.backend.Human;
import nl.joshuaslik.tudelft.UFMGame.backend.PC;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.User;

import org.junit.Test;

/**
 * Testing the competition class
 * @author Naomi
 *
 */
public class CompetitionTest {

	/**
	 * Testing the constructor of the competition class
	 */
	@Test
	public void testConstructor() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc1", 5000));
		Game game1 = new Game(users);
		Competition competition1 = new Competition(game1);
		assertEquals(competition1, competition1);
	}

	/**
	 *  Testing if all matches of this competition are added to random playrounds
	 */
	@Test
	public void testDefineplayrounds1() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		Team team5 = new Team("excelsior", "excelsior", "Frank de Boer");
		Team team6 = new Team("Heracles", "heracles", "Frank de Boer");
		Team team7 = new Team("PEC", "PEC", "piet");
		Team team8 = new Team("nac", "nac", "jan");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc2", 5000));
		users.add(new PC(team3, "pc3", 500));
		users.add(new PC(team4, "pc4", 5000));
		users.add(new PC(team5, "pc5", 500));
		users.add(new PC(team6, "pc6", 5000));
		users.add(new PC(team7, "pc7", 500));
		users.add(new PC(team8, "pc8", 5000));
		Game game1 = new Game(users);
		game1.getCompetition().definePlayrounds();
		assertEquals(game1.getPlayrounds().size(), 14);
	}

	/**
	 * Testing if you can get all playrounds.
	 */
	@Test
	public void testGetPlayround() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		Team team5 = new Team("excelsior", "excelsior", "Frank de Boer");
		Team team6 = new Team("Heracles", "heracles", "Frank de Boer");
		Team team7 = new Team("PEC", "PEC", "piet");
		Team team8 = new Team("nac", "nac", "jan");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc2", 5000));
		users.add(new PC(team3, "pc3", 500));
		users.add(new PC(team4, "pc4", 5000));
		users.add(new PC(team5, "pc5", 500));
		users.add(new PC(team6, "pc6", 5000));
		users.add(new PC(team7, "pc7", 500));
		users.add(new PC(team8, "pc8", 5000));
		Game game1 = new Game(users);
		game1.getCompetition().definePlayrounds();
		assertEquals(
				game1.getCompetition().getPlayround(1).getMatches().size(), 4);
	}

	/**
	 * A second test for getting playrounds
	 */
	@Test
	public void testGetPlayround2() {
		ArrayList<User> users = new ArrayList<User>();
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");
		Team team2 = new Team("ado", "ado", "Frank de Boer");
		Team team3 = new Team("az", "az", "piet");
		Team team4 = new Team("psv", "psv", "jan");
		Team team5 = new Team("excelsior", "excelsior", "Frank de Boer");
		Team team6 = new Team("Heracles", "heracles", "Frank de Boer");
		Team team7 = new Team("PEC", "PEC", "piet");
		Team team8 = new Team("nac", "nac", "jan");
		users.add(new Human(team1, "Bryan", 5000));
		users.add(new PC(team2, "pc2", 5000));
		users.add(new PC(team3, "pc3", 500));
		users.add(new PC(team4, "pc4", 5000));
		users.add(new PC(team5, "pc5", 500));
		users.add(new PC(team6, "pc6", 5000));
		users.add(new PC(team7, "pc7", 500));
		users.add(new PC(team8, "pc8", 5000));
		Game game1 = new Game(users);
		game1.getCompetition().definePlayrounds();
		assertEquals(game1.getCompetition().getPlayround(0), null);
	}

	/**
	 * Testing if compute standings works
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
		Competition competition1 = new Competition(game1);
		team3.addPoints(3);
		team4.addGoals(5);
		competition1.ComputeStandings();
		assertEquals(team1.getRanking(), 3);
		assertEquals(team2.getRanking(), 3);
		assertEquals(team3.getRanking(), 1);
		assertEquals(team4.getRanking(), 2);
	}
	/**
	 * Testing if compute standings works
	 */	
	@Test
	public void testComputeStandings1() {
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
		Competition competition1 = new Competition(game1);
		team1.addGoals(5);
		team2.addGoals(1);
		team3.addGoals(6);
		team4.addGoals(10);

		team1.addPoints(0);
		team2.addPoints(0);
		team3.addPoints(3);
		team4.addPoints(3);
		competition1.ComputeStandings();
		assertEquals(team1.getRanking(), 3);
		assertEquals(team2.getRanking(), 4);
		assertEquals(team3.getRanking(), 2);
		assertEquals(team4.getRanking(), 1);
	}

	/**
	 * Testing if you can get users. 
	 */
	@Test
	public void testGetUsers() {
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
		Competition competition1 = new Competition(game1);
		assertEquals(competition1.getusers().size(), 4);

	}

}