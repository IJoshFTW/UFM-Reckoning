package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.joshuaslik.UFMReckoning.gui.game.MainGame;

/**
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ActionController {

	@FXML
	protected void handleStartGame(ActionEvent event) throws IOException {
		System.out.println("Handle [Start game] event yo! Do it nao!");
		System.out.println(event.getSource());
		StartGame.start();
	}
	
	@FXML
	protected void handleNewGame(ActionEvent event) {
		System.out.println("btn_NewGame pressed");
		System.out.println(event.getSource());
		
	}
	
	@FXML
	protected void handleLoadGame(ActionEvent event) {
		System.out.println("btn_LoadGame pressed");
		System.out.println(event.getSource());
		
	}
	
	@FXML
	protected void handleReturnMainMenu(ActionEvent event) throws IOException {
		System.out.println("btn_ReturnMainMenu pressed");
		System.out.println(event.getSource());
		MainMenu.start();
	}

	@FXML
	protected void handleOptions(ActionEvent event) throws IOException {
		System.out.println("Handle [Options] event yo! Do it nao!");
		System.out.println(event.getSource());
		Options.start();
	}

	@FXML
	protected void handleHighscores(ActionEvent event) throws IOException{
		System.out.println("Handle [Highscore] event yo! Do it nao!");
		System.out.println(event.getSource());
		Highscores.start();
	}

	@FXML
	protected void handleQuitGame(ActionEvent event) {
		System.out.println("Handle [Quit Game] event yo! Do it nao!");
		System.out.println(event.getSource());
		System.exit(0);
	}
	
	@FXML
	protected void handleMainGame(ActionEvent event) {
		MainGame.start();
	}

}
