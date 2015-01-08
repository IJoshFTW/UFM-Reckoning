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
	private Label currentround;
	
	@FXML
	 private void initialize() {
		budgetlabel.setText("Budget: € " + MainGame.game.getUser().getBudget());
		currentround.setText("Currentround: " + MainGame.game.currentround);
		
	}
	
	@FXML
	protected void handleNextround(ActionEvent event) throws IOException {
		
    	MainGame.game.resultplayround();
    	Playrounds.start();
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
	protected void handlePlayrounds(ActionEvent event) throws IOException {
		Playrounds.start();
	}


	@FXML
	protected void handleRanking(ActionEvent event) throws IOException {
		RankingController.start();
	}
	

	@FXML
	protected void handleOtherTeams(ActionEvent event) throws IOException {
		OtherTeams.start();
	}
}