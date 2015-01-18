package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;
import nl.joshuaslik.tudelft.UFMGame.backend.Match;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

public class ResultRoundDialogcontroller {
	private static Popup popup;
	private static AnchorPane page;
	
	@FXML
	private Button okbutton;
	@FXML
	private Label score, hometeamname, awayteamname, round, rankinghome, rankingaway;
	@FXML
	private ImageView homelogo, awaylogo;
	
	private Match match;
	
	/**
	 * initialize the result dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	private void initialize() throws IOException {
		ArrayList<Match> matches = MainGame.game.getPlayround(MainGame.game.getCurrentRound() - 1).getMatches();
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
		hometeamname.setText(match.getHomeTeam().getTeamName());
		awayteamname.setText(match.getAwayTeam().getTeamName());
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
		
	}
	
	/**
	 * handles clicking on the ok button in the dialog
	 */
	@FXML
	protected void handleOK() {
		FadeTransition ft = new FadeTransition(Duration.millis(500), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
	}
	
	/**
	 * Loads the result of a round dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/ResultRoundDialog.fxml"));
		page = (AnchorPane) loader.load();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.0);
		ft.setToValue(0.97);
		ft.play();
		popup = new Popup();
		popup.setAutoHide(true);
		page.setOpacity(0.85);
		popup.getContent().add(page);
		popup.show(Main.stage);
		TeamBuilderController.start();
	}

}