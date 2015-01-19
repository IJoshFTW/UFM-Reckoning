package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Controller for main menu.
 * @author Naomi
 *
 */
public class ControllerMainMenu {

	@FXML
	private Button startgame;

	@FXML
	private Button newgame;

	@FXML
	private Button loadgame;

	/**
	 * Methods to control what happens on mouse-over. 
	 */
	@FXML
	private void initialize() {
		startgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		newgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		loadgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		startgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		newgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		loadgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
	}

	/**
	 * Handles clicking on the new game button
	 * @param event of clicking on the button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleNewGame(ActionEvent event) throws IOException {
		UsernameController.start();
	}

	/**
	 * Handles clicking on the load game button
	 * @param event that occurs after clicking on the button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleLoadGame(ActionEvent event) throws IOException {
		System.out.println("load game button pressed");
		LoadGameController.start();

	}

	/**
	 * Handles clicking on the options button
	 * @param event of clicking on the options button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleOptions(ActionEvent event) throws IOException {
		Options.start();
	}

	/**
	 * Handles clicking on the highscores button
	 * @param event of clicking on the highscores button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleHighscores(ActionEvent event) throws IOException {
		Highscores.start();
	}

	/**
	 * Handles clicking on the quite button
	 * @param event clicking on the quite button
	 */
	@FXML
	protected void handleQuitMenu(ActionEvent event) {
		System.exit(0);
	}
}
