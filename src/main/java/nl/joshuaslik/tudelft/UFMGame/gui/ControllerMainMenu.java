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

	@FXML
	protected void handleNewGame(ActionEvent event) throws IOException {
		UsernameController.start();
	}

	@FXML
	protected void handleLoadGame(ActionEvent event) {
		System.out.println("btn_LoadGame pressed");
		System.out.println(event.getSource());

	}

	@FXML
	protected void handleOptions(ActionEvent event) throws IOException {
		System.out.println("btn_Options pressed");
		System.out.println(event.getSource());
		Options.start();
	}

	@FXML
	protected void handleHighscores(ActionEvent event) throws IOException {
		System.out.println("btn_Highscores pressed");
		System.out.println(event.getSource());
		Highscores.start();
	}

	@FXML
	protected void handleQuitMenu(ActionEvent event) {
		System.out.println("btn_QuitMenu pressed");
		System.out.println(event.getSource());
		System.exit(0);
	}
}
