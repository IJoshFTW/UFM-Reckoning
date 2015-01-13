package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nl.joshuaslik.tudelft.UFMGame.gui.MainMenu;

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
		currentround.setText("Currentround: " + MainGame.game.getCurrentRound());

	}

	@FXML
	protected void handleNextround() throws IOException {
		if(MainGame.game.getUser().getTeam().getActivePlayers().size() == 11 && MainGame.game.getUser().getTeam().getTeamCaptain() != null){
			MainGame.game.resultplayround();
			MainGame.game.computeStandings();
			ResultRoundDialogcontroller.start();
		}
		else{
			Popupscreen.start();
			Popupscreen.setTitle("Error in Team Setup");
			String message = new String();
			if(MainGame.game.getUser().getTeam().getTeamCaptain() == null){
				message = message + "\nYour team need a team captain.";
			}
			if(MainGame.game.getUser().getTeam().getActivePlayers().size() != 11){
				message = message + "\nYour team need at least 11 players.\nGo to Change setup to add players to your formation.";
			}	
			Popupscreen.setMessage(message);
		}
	}

	@FXML
	protected void handleQuitGame() throws IOException {
		MainMenu.start();
	}

	@FXML
	protected void handleMainGame() throws IOException {
		MainGame.start();
	}

	@FXML
	protected void handleTeamBuilder() throws IOException {
		MainGame.start();
	}

	@FXML
	protected void handlePlayrounds() throws IOException {
		Playrounds.start();
	}

	@FXML
	protected void handleRanking() throws IOException {
		RankingController.start();
	}

	@FXML
	protected void handleOtherTeams() throws IOException {
		OtherTeams.start();
	}
}