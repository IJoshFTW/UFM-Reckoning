package nl.joshuaslik.UFMReckoning.backend;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import nl.joshuaslik.tudelft.UFMGame.backend.Game;
import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.User;

import org.junit.Test;

/**
 * Tests to check the save class
 * @author Naomi
 *
 */
public class SaveTest {

	/**
	 * Test to check if you can save a new game
	 */
	@Test
	public void testnewGame() {
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");

		assertEquals(Save.newGame(team1, "Bryan").getUsers().size(), 18);
	}

	/**
	 * Test to check if you can load teams
	 */
	@Test
	public void testLoadTeams() {
		assertEquals(Save.loadTeams().size(), 18);
	}

	/**
	 * Test to check if you can load players from an arraylist after they've been saved
	 */
	@Test
	public void testLoadPlayersArrayList() {
		assertEquals(Save.loadplayersArrayList().size(), 443);
	}
	
	/**
	 * 
	 */
	@Test
	public void testLoadGame(){
	
		Game game = Save.newGame(Save.loadTeams().get(0), "test");
		game.getCompetition().definePlayrounds();
		Save.saveGame(game, 1);
		assertEquals(Save.loadGame(1).getUsers().size(), 18);
	}
	


	// @Test
	// public void testSave() {
	// LinkedHashMap<String, Team> teams = Save.loadTeam();

	// for (String key : teams.keySet()) {
	// System.out.println(teams.get(key).getTeamName() +
	// "--" + teams.get(key).getActivePlayers().size() + "--" +
	// teams.get(key).getBenchPlayers().size() + "--");
	// }
	// Game game = Save.newGame(teams.get("ado-den-haag"), "bryan");
	// Save.SaveGame(game);

	// Game game = Save.newGame(teams.get("ado-den-haag"), "bryan");
	// game.getCompetition().definePlayrounds();
	//
	// for (int i = 0; i < game.getTeams().size(); i++) {
	// System.out.println(game.getTeams().get(i).getTeamName() + "  "
	// + game.getTeams().get(i).getDefencePower() + "--"
	// + game.getTeams().get(i).getAttackPower() + "--"
	// + game.getTeams().get(i).getStamina());
	// }
	// System.out.println();
	//
	// System.out.println();
	// game.getCompetition().check();
	// int j = 0;
	// for (j = 1; j <= game.getCompetition().getPlayrounds().size(); j++) {
	// LinkedHashMap<String, String> result = game.resultplayround(j);
	// for (String key : result.keySet()) {
	// System.out.println(key + "    " + result.get(key));
	// }
	// System.out.println("");
	// }
	// System.out.println(j - 1);
	// System.out.println();
	// game.getCompetition().ComputeStandings();
	// for (int i = 0; i < game.getUsers().size(); i++) {
	// System.out.println(game.getUsers().get(i).getTeam().getTeamName()
	// + "-" + game.getUsers().get(i).getTeam().getRanking());
	// }
	// }

}
