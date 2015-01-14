package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.joshuaslik.tudelft.UFMGame.gui.game.MainGame;

/**
 * Controllers for main menu and main game. 
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ActionController {

	/**
	 * Handles return to the main menu
	 * @param event containing information about the GUI event
	 * @throws IOException is thrown if an XML cannot be parsed.
	 * 
	 */
	@FXML
	protected void handleReturnMainMenu(ActionEvent event) throws IOException {
		System.out.println("btn_ReturnMainMenu pressed");
		System.out.println(event.getSource());
		MainMenu.start();
	}

	/**
	 * Handles Main Game
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	protected void handleMainGame(ActionEvent event) throws IOException {
		System.out.println(event.getSource());
		MainGame.start();
	}

}
