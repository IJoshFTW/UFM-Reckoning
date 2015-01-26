package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

/**
 * Class to control the result per round
 * @author Naomi
 * @author Bryan van Wijk
 */
public class ResultRoundDialogcontroller {
	private static Popup popup;
	private static AnchorPane page;
	
	@FXML
	private Button okbutton;
	@FXML
	private Label score, hometeamname, awayteamname, round, rankinghome, rankingaway;
	@FXML
	private ImageView homelogo, awaylogo;
	@FXML
	private Boolean last = false;
	private int endrank;
	
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
		if((((MainGame.game.getUsers().size()*(MainGame.game.getUsers().size()-1))/(MainGame.game.getUsers().size()/2))+1) == MainGame.game.getCurrentRound()){
			last = true;
			endrank = MainGame.game.getUser().getTeam().getRanking();
			MainGame.game.newCompetition();
			MainGame.game.getCompetition().definePlayrounds();
			MainGame.game.computeStandings();
		}
		AnchorPane top = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameTopMenuBar.fxml"));
		Main.setTop(top);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
		
		
	}
	
	/**
	 * handles clicking on the ok button in the dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleOK() throws IOException {
		FadeTransition ft = new FadeTransition(Duration.millis(500), page);
     	ft.setFromValue(0.97);
     	ft.setToValue(0.0);
     	ft.play();
	    ft.setOnFinished(new EventHandler<ActionEvent>() {
	    	public void handle(ActionEvent event) {
	    		popup.hide(); 
	    	}
	    });
	  
		if(last){
			Popupscreen.start();
			Popupscreen.setTitle("Last round played");
			Popupscreen.setMessage("This season has come to an end.\n You're end rank of this season is: " + endrank 
					+ "\nThere is automatically started a new competition.");
			TeamBuilderController.start();
			last = false;
		}
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