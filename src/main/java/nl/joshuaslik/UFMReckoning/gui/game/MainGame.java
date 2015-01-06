package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import nl.joshuaslik.UFMReckoning.backend.Game;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class MainGame {

	public static Game game = null;

	public static void start() throws IOException {
		System.out.println("I HAVE A GAME OBJECT!");
		System.out.println("USERNAME: " + game.getUser().getUserName());
		System.out.println("MY TEAM NAME: "
				+ game.getUser().getTeam().getTeamName());
		System.out.println("COACH NAME OF MY TEAM: "
				+ game.getUser().getTeam().getCoachName());
		
		TeamBuilderController.start();
		
	}

	public static void setGame(Game game) {
		System.out.println("GAME OBJECT SET!");
		MainGame.game = game;
	}
	
	public static void initialize() {
		MainGame.game.getCompetition().definePlayrounds();
	}

}
