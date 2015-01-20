package nl.joshuaslik.tudelft.UFMGame.backend;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form343;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form4321;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form433;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form442;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form532;

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
		System.out.println("testNewGame()");
		
		Team team1 = new Team("ajax", "ajax", "Frank de Boer");

		assertEquals(Save.newGame(team1, "Bryan").getUsers().size(), 18);
		System.out.println("testNewGame() </>");
	}

	/**
	 * Test to check if you can load teams
	 */
	@Test
	public void testLoadTeams() {
		System.out.println("testLoadTeams()");
		
		assertEquals(Save.loadTeams().size(), 18);
		
		System.out.println("testLoadTeams() </>");
	}

	/**
	 * Test to check if you can load players from an arraylist after they've been saved
	 */
	@Test
	public void testLoadPlayersArrayList() {
		System.out.println("testLoadPlayersArrayList()");
		
		assertEquals(Save.loadplayersArrayList().size(), 443);
		
		System.out.println("testLoadPlayersArrayList() </>");
	}
	
	/**
	 * Test to check if you can load players from an arraylist after they've been saved
	 */
	@Test
	public void testgetUsernames() {
		System.out.println("testgetUsernames()");
		// TODO Figure out a way to properly test this, without relying on the user having saves
		System.out.println(Save.getUsernames());
		
		System.out.println("testgetUsernames() </>");
	}
	
	/**
	 * 
	 */
	@Test
	public void testLoadGame1(){
		System.out.println("testLoadGame1()");
		
		Game game = Save.newGame(Save.loadTeams().get(0), "test");
		game.getCompetition().definePlayrounds();
		Form343 form343 = new Form343(game.getTeam("ajax"));
		game.getTeam("ajax").changeFormationType(form343);
		Form4321 form4321 = new Form4321(game.getTeam("ado-den-haag"));
		game.getTeam("ado-den-haag").changeFormationType(form4321);
		Form433 form433 = new Form433(game.getTeam("psv"));
		game.getTeam("psv").changeFormationType(form433);
		Form442 form442 = new Form442(game.getTeam("az"));
		game.getTeam("az").changeFormationType(form442);
		Form532 form532 = new Form532(game.getTeam("vitesse"));
		game.getTeam("vitesse").changeFormationType(form532);
		Save.saveGame(game, 98);
		assertEquals(Save.loadGame(98).getUsers().size(), 18);
		
		System.out.println("testLoadGame1() </>");
	}
	
	/**
	 * 
	 */
	@Test
	public void testLoadGame2(){
		System.out.println("testLoadGame2()");
		
		LinkedHashMap<String, Player> players = Save.loadPlayers();
		Game game = Save.newGame(Save.loadTeams().get(0), "test");
		game.getCompetition().definePlayrounds();
		Form343 form343 = new Form343(game.getTeam("ajax"));
		game.getTeam("ajax").changeFormationType(form343);
		game.getTeam("ajax").getFormation().setCB((Fieldplayer) players.get("alimessaoud"));
		game.getTeam("ajax").getFormation().setRB((Fieldplayer) players.get("ricardoippel"));
		game.getTeam("ajax").getFormation().setLB((Fieldplayer) players.get("aaronmeijers"));
		game.getTeam("ajax").getFormation().setLM((Fieldplayer) players.get("adammaher"));
		game.getTeam("ajax").getFormation().setCM1((Fieldplayer) players.get("bartschenkeveld"));
		game.getTeam("ajax").getFormation().setCM2((Fieldplayer) players.get("baskuipers"));
		game.getTeam("ajax").getFormation().setRM((Fieldplayer) players.get("bensahar"));
		game.getTeam("ajax").getFormation().setRW((Fieldplayer) players.get("berendschootstra"));
		game.getTeam("ajax").getFormation().setLW((Fieldplayer) players.get("henkbos"));
		game.getTeam("ajax").getFormation().setST((Fieldplayer) players.get("jetrowillems"));
		game.getTeam("ajax").getFormation().setGoalkeeper((Goalkeeper) players.get("jaspercillessen"));
		Form4321 form4321 = new Form4321(game.getTeam("ado-den-haag"));
		game.getTeam("ado-den-haag").changeFormationType(form4321);
		game.getTeam("ado-den-haag").getFormation().setCB1((Fieldplayer) players.get("alimessaoud"));
		game.getTeam("ado-den-haag").getFormation().setRB((Fieldplayer) players.get("ricardoippel"));
		game.getTeam("ado-den-haag").getFormation().setLB((Fieldplayer) players.get("aaronmeijers"));
		game.getTeam("ado-den-haag").getFormation().setLM((Fieldplayer) players.get("adammaher"));
		game.getTeam("ado-den-haag").getFormation().setCM((Fieldplayer) players.get("bartschenkeveld"));
		game.getTeam("ado-den-haag").getFormation().setCB2((Fieldplayer) players.get("baskuipers"));
		game.getTeam("ado-den-haag").getFormation().setRM((Fieldplayer) players.get("bensahar"));
		game.getTeam("ado-den-haag").getFormation().setORM((Fieldplayer) players.get("berendschootstra"));
		game.getTeam("ado-den-haag").getFormation().setOLM((Fieldplayer) players.get("henkbos"));
		game.getTeam("ado-den-haag").getFormation().setST((Fieldplayer) players.get("jetrowillems"));
		game.getTeam("ado-den-haag").getFormation().setGoalkeeper((Goalkeeper) players.get("jaspercillessen"));
		Form433 form433 = new Form433(game.getTeam("psv"));
		game.getTeam("psv").changeFormationType(form433);
		game.getTeam("psv").getFormation().setCB1((Fieldplayer) players.get("alimessaoud"));
		game.getTeam("psv").getFormation().setRB((Fieldplayer) players.get("ricardoippel"));
		game.getTeam("psv").getFormation().setLB((Fieldplayer) players.get("aaronmeijers"));
		game.getTeam("psv").getFormation().setLM((Fieldplayer) players.get("adammaher"));
		game.getTeam("psv").getFormation().setCM((Fieldplayer) players.get("bartschenkeveld"));
		game.getTeam("psv").getFormation().setCB2((Fieldplayer) players.get("baskuipers"));
		game.getTeam("psv").getFormation().setRM((Fieldplayer) players.get("bensahar"));
		game.getTeam("psv").getFormation().setRW((Fieldplayer) players.get("berendschootstra"));
		game.getTeam("psv").getFormation().setLW((Fieldplayer) players.get("henkbos"));
		game.getTeam("psv").getFormation().setST((Fieldplayer) players.get("jetrowillems"));
		game.getTeam("psv").getFormation().setGoalkeeper((Goalkeeper) players.get("jaspercillessen"));
		Form442 form442 = new Form442(game.getTeam("az"));
		game.getTeam("az").changeFormationType(form442);
		game.getTeam("az").getFormation().setCB1((Fieldplayer) players.get("alimessaoud"));
		game.getTeam("az").getFormation().setRB((Fieldplayer) players.get("ricardoippel"));
		game.getTeam("az").getFormation().setLB((Fieldplayer) players.get("aaronmeijers"));
		game.getTeam("az").getFormation().setLM((Fieldplayer) players.get("adammaher"));
		game.getTeam("az").getFormation().setCM1((Fieldplayer) players.get("bartschenkeveld"));
		game.getTeam("az").getFormation().setCM2((Fieldplayer) players.get("baskuipers"));
		game.getTeam("az").getFormation().setRM((Fieldplayer) players.get("bensahar"));
		game.getTeam("az").getFormation().setRW((Fieldplayer) players.get("berendschootstra"));
		game.getTeam("az").getFormation().setLW((Fieldplayer) players.get("henkbos"));
		game.getTeam("az").getFormation().setCB2((Fieldplayer) players.get("jetrowillems"));
		game.getTeam("az").getFormation().setGoalkeeper((Goalkeeper) players.get("jaspercillessen"));
		Form532 form532 = new Form532(game.getTeam("vitesse"));
		game.getTeam("vitesse").changeFormationType(form532);
		game.getTeam("vitesse").getFormation().setCB1((Fieldplayer) players.get("alimessaoud"));
		game.getTeam("vitesse").getFormation().setRB((Fieldplayer) players.get("ricardoippel"));
		game.getTeam("vitesse").getFormation().setLB((Fieldplayer) players.get("aaronmeijers"));
		game.getTeam("vitesse").getFormation().setLM((Fieldplayer) players.get("adammaher"));
		game.getTeam("vitesse").getFormation().setCM((Fieldplayer) players.get("bartschenkeveld"));
		game.getTeam("vitesse").getFormation().setCB3((Fieldplayer) players.get("baskuipers"));
		game.getTeam("vitesse").getFormation().setRM((Fieldplayer) players.get("bensahar"));
		game.getTeam("vitesse").getFormation().setRW((Fieldplayer) players.get("berendschootstra"));
		game.getTeam("vitesse").getFormation().setLW((Fieldplayer) players.get("henkbos"));
		game.getTeam("vitesse").getFormation().setCB2((Fieldplayer) players.get("jetrowillems"));
		game.getTeam("vitesse").getFormation().setGoalkeeper((Goalkeeper) players.get("jaspercillessen"));
		Save.saveGame(game, 99);
		assertEquals(Save.loadGame(99).getUsers().size(), 18);
		
		System.out.println("testLoadGame2() </>");
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
