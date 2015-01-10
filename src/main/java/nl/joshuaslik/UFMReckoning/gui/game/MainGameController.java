package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

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
	protected void handleNextround() throws IOException {

		MainGame.game.resultplayround();
		MainGame.game.computeStandings();
		ResultRoundDialogcontroller.start();
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