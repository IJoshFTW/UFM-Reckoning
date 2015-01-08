package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nl.joshuaslik.UFMReckoning.gui.MainMenu;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class MainGameController {

	@FXML
	private Label budgetlabel;
	
	@FXML
	 private void initialize() {
		budgetlabel.setText("Budget: " + MainGame.game.getUser().getBudget());
	}
	
	@SuppressWarnings("unused")
	@FXML
	protected void handleQuitGame(ActionEvent event) throws IOException {
		MainMenu.start();
	}

	@FXML
	protected void handleMainGame(ActionEvent event) throws IOException {
		System.out.println(event.getSource());
		MainGame.start();
	}
	
	@FXML
	protected void handleTeamBuilder(ActionEvent event) throws IOException {
		MainGame.start();
	
	}
	
	@FXML
	protected void handleCompetition(ActionEvent event) throws IOException {
		Competition.start();
	}
}