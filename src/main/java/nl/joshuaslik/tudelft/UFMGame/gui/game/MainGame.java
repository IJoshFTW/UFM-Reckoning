package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

import nl.joshuaslik.tudelft.UFMGame.backend.Game;

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

	/**
	 * Sets a game 
	 * @param game 
	 */
	public static void setGame(Game game) {
		MainGame.game = game;
	}
	
	/**
	 * initializes main game
	 */
	public static void initialize() {
		MainGame.game.getCompetition().definePlayrounds();
		MainGame.game.computeStandings();
	}

}
