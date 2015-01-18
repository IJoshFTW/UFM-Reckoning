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
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	public static void initialize() {
		MainGame.game.getCompetition().definePlayrounds();
		MainGame.game.computeStandings();
	}

}
