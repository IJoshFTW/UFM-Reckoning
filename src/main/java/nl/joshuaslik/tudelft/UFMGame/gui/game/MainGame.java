package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

import nl.joshuaslik.tudelft.UFMGame.backend.Game;

/**
 * Class to handle maingame
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 * @author Naomi
 */
public class MainGame {

	/**
	 * Sets an empty game
	 */
	public static Game game = null;

	/**
	 * loads the teambuilder
	 * 
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		TeamBuilderController.start();

	}

	/**
	 * Sets a game
	 * 
	 * @param game
	 *            is the game to be set
	 * 
	 */
	public static void setGame(Game game) {
		MainGame.game = game;
		MainGame.game.loadAllNonContractedPlayers();
	}

	/**
	 * Initializes the controller class. 
	 */
	public static void initialize() {
		MainGame.game.getCompetition().definePlayrounds();
		MainGame.game.computeStandings();
		
	}

}
