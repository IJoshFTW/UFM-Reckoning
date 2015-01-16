package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nl.joshuaslik.tudelft.UFMGame.backend.Match;

/**
 * Class to control the top menu bar
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TopMenuBarController {

	/**
	 * declaring variables 
	 */
	@FXML
	private Label username, round;

	
	@FXML
	private void initialize() {
		username.setText(MainGame.game.getUser().getUserName());
		ArrayList<Match> matches = MainGame.game.getPlayround(MainGame.game.getCurrentRound()).getMatches();
		for(int i = 0; i < matches.size(); i++){
			if(matches.get(i).contains(MainGame.game.getUser().getTeam())){
				round.setText(" " + MainGame.game.getCurrentRound() + ". " + "Next match: " + matches.get(i).getHometeam() + " VS " + matches.get(i).getAwayteam());
			}
		}
	}
}