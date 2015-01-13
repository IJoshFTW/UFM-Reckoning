package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.joshuaslik.tudelft.UFMGame.gui.game.MainGame;

/**
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ActionController {
	

	@FXML
	protected void handleReturnMainMenu(ActionEvent event) throws IOException {
		System.out.println("btn_ReturnMainMenu pressed");
		System.out.println(event.getSource());
		
		MainMenu.start();
	}

	@FXML
	protected void handleMainGame(ActionEvent event) throws IOException {
		System.out.println(event.getSource());
		MainGame.start();
	}

}
