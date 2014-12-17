package nl.joshuaslik.UFMReckoning.backend;

import java.util.LinkedHashMap;

import org.junit.Test;

public class SaveTest {

	@Test
	public void testSave() {
		LinkedHashMap<String, Team> teams = Save.loadTeam();

//		for (String key : teams.keySet()) {
//			System.out.println(teams.get(key).getTeamName() +
//					"--" + teams.get(key).getActivePlayers().size() + "--" +
//					teams.get(key).getBenchPlayers().size() + "--");
//		}
//		Game game = Save.newGame(teams.get("ado-den-haag"), "bryan");
//		Save.SaveGame(game);

		Game game = Save.newGame(teams.get("ado-den-haag"), "bryan");
		game.getCompetition().definePlayrounds();

		for (int i = 0; i < game.getTeams().size(); i++) {
			System.out.println(game.getTeams().get(i).getTeamName() + "  "
					+ game.getTeams().get(i).getDefencePower() + "--"
					+ game.getTeams().get(i).getAttackPower() + "--"
					+ game.getTeams().get(i).getStamina());
		}
		System.out.println();

		System.out.println();
		game.getCompetition().check();
		int j = 0;
		for (j = 1; j <= game.getCompetition().getPlayrounds().size(); j++) {
			LinkedHashMap<String, String> result = game.resultplayround(j);
			for (String key : result.keySet()) {
				System.out.println(key + "    " + result.get(key));
			}
			System.out.println("");
		}
		System.out.println(j - 1);
		System.out.println();
		game.getCompetition().ComputeStandings();
		for (int i = 0; i < game.getUsers().size(); i++) {
			System.out.println(game.getUsers().get(i).getTeam().getTeamName()
					+ "-" + game.getUsers().get(i).getTeam().getRanking());
		}
	}

}
