package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CompetitionController {
	
	@SuppressWarnings("unused")
	@FXML
	protected void handlePlayrounds(ActionEvent event) throws IOException {
		Playrounds.start();
	}

	@SuppressWarnings("unused")
	@FXML
	protected void handleRanking(ActionEvent event) throws IOException {
		RankingController.start();
	}
	
	@SuppressWarnings("unused")
	@FXML
	protected void handleOtherTeams(ActionEvent event) throws IOException {
		OtherTeams.start();
	}

}
