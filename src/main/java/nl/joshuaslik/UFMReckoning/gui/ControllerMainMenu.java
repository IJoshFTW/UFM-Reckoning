package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerMainMenu {

	@FXML
	private Button startgame;

	@FXML
	private Button newgame;

	@FXML
	private Button loadgame;

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
		//NewGameController.start("Joshua");
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
