package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import nl.joshuaslik.UFMReckoning.backend.Match;
import nl.joshuaslik.UFMReckoning.backend.Playround;
import nl.joshuaslik.UFMReckoning.gui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ResultRoundDialogcontroller {
	
	@FXML
	private Button okbutton;
	@FXML
	private Label score;
	@FXML
	private Label round;
	@FXML
	private Label rankinghome;
	@FXML
	private Label rankingaway;
	@FXML
	private ImageView homelogo;
	@FXML
	private ImageView awaylogo;
	
	private Match match;
	
	@FXML
	private void initialize() throws IOException {
		ArrayList<Match> matches = MainGame.game.getPlayround(MainGame.game.currentround - 1).getMatches();
		for(int i= 0; i<matches.size(); i++){
			if(matches.get(i).contains(MainGame.game.getUser().getTeam())){
				match = matches.get(i);
			}
		}
		Image imagehome = new Image("/data/base/teams/pictures/" + match.getHomeTeam().getid()+ ".png");
		homelogo.setImage(imagehome);
		Image imageaway = new Image("/data/base/teams/pictures/" + match.getAwayTeam().getid()+ ".png");
		awaylogo.setImage(imageaway);
		score.setText(match.getHomegoals() + " - " + match.getAwaygoals());
		round.setText("Result Round: " + match.getPlayround());
		rankinghome.setText("" + match.getHomeTeam().getRanking());
		rankingaway.setText("" + match.getAwayTeam().getRanking());
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
		
	}
	
	
	@FXML
	protected void handleOK(ActionEvent event) throws IOException {
		Stage stage = (Stage) okbutton.getScene().getWindow();
		stage.close();
	}
	
	public static void start() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/ResultRoundDialog.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage dialogStage = new Stage(StageStyle.UNDECORATED);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(Main.stage);
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.show();
		TeamBuilderController.start();
	}

}