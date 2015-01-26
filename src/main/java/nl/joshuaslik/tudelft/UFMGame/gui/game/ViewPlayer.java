package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

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
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;
import nl.joshuaslik.tudelft.UFMGame.backend.Player;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

/**
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 */
public class ViewPlayer {
	private static Player player;
	private static Popup popup;
	private static AnchorPane page;

	@FXML
	private Label playerName, playerRole, attackLable, defenceLable, staminaLable, reflexesLable, positioningLable, showCountryLable, showPriceLable, divingLable, position, stamina, attack, defence, positioning, diving, reflexes;
	@FXML
	private ImageView playerPhoto, staminaImg, defPwrImg, atkPwrImg, positioningImg, reflexesImg, divingImg;
	@FXML
	private Button returnbutton;

	/**
	 * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		playerName.setText(player.getFullName());

		Image image = new Image("/data/base/players/pictures/" + player.getID()
				+ ".png");
		playerPhoto.setImage(image);

		if (player instanceof Fieldplayer) {
			Fieldplayer fieldplayer = (Fieldplayer) player;
			playerRole.setText("Role: Fieldplayer");
			position.setText("Position: " + fieldplayer.getPosition());
			if(fieldplayer.getPosition().equals("RW")){
				position.setText("Position: Right Wing");
			}
			else if(fieldplayer.getPosition().equals("LW")){
				position.setText("Position: Left Wing");
			}
			else if(fieldplayer.getPosition().equals("RB")){
				position.setText("Position: Right Back");
			}
			else if(fieldplayer.getPosition().equals("LB")){
				position.setText("Position: Left Back");
			}
			else if(fieldplayer.getPosition().equals("CB")){
				position.setText("Position: Central Back");
			}
			else if(fieldplayer.getPosition().equals("LM")){
				position.setText("Position: Left Midfield");
			}
			else if(fieldplayer.getPosition().equals("RM")){
				position.setText("Position: Right Midfield");
			}
			else if(fieldplayer.getPosition().equals("CM")){
				position.setText("Position: Central Midfield");
			}
			// AttackPower bar inladen
			attackLable.setVisible(true);
			atkPwrImg.prefHeight(20);
			atkPwrImg.minWidth(fieldplayer.getAttackPower() * 3);
			atkPwrImg.setFitWidth(fieldplayer.getAttackPower() * 3);
			atkPwrImg.setVisible(true);
			attack.setText(fieldplayer.getAttackPower()+"");

			// Defence bar inladen
			defenceLable.setVisible(true);
			defPwrImg.prefHeight(20);
			defPwrImg.minWidth(fieldplayer.getDefencePower() * 3);
			defPwrImg.setFitWidth(fieldplayer.getDefencePower() * 3);
			defPwrImg.setVisible(true);
			defence.setText(fieldplayer.getDefencePower()+"");


			// Stamina bar inladen
			staminaLable.setVisible(true);
			staminaImg.prefHeight(20);
			staminaImg.minWidth(fieldplayer.getStamina() * 3);
			staminaImg.setFitWidth(fieldplayer.getStamina() * 3);
			staminaImg.setVisible(true);
			stamina.setText(fieldplayer.getStamina()+"");

		}

		if (player instanceof Goalkeeper) {
			Goalkeeper goalkeeper = (Goalkeeper) player;
			playerRole.setText("Role: Goalkeeper");
			position.setText("");
			// Diving bar inladen
			divingLable.setVisible(true);
			divingImg.prefHeight(20);
			divingImg.minWidth(goalkeeper.getDiving() * 3);
			divingImg.setFitWidth(goalkeeper.getDiving() * 3);
			divingImg.setVisible(true);
			diving.setText(goalkeeper.getDiving()+"");


			// Reflexes bar inladen
			reflexesLable.setVisible(true);
			reflexesImg.prefHeight(20);
			reflexesImg.minWidth(goalkeeper.getReflexes() * 3);
			reflexesImg.setFitWidth(goalkeeper.getReflexes() * 3);
			reflexesImg.setVisible(true);
			reflexes.setText(goalkeeper.getReflexes()+"");

			// Positioning bar inladen
			positioningLable.setVisible(true);
			positioningImg.prefHeight(20);
			positioningImg.minWidth(goalkeeper.getPositioning() * 3);
			positioningImg.setFitWidth(goalkeeper.getPositioning() * 3);
			positioningImg.setVisible(true);
			positioning.setText(goalkeeper.getPositioning()+"");
		}
		
		showCountryLable.setText("Country: "+ player.getCountry());
		showPriceLable.setText("Price: " + Integer.toString(player.getPrice()));

	}

	/**
	 * Method to load the viewplayer popup
	 * @param inputPlayer player to be displayed in the popup
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start(Player inputPlayer) throws IOException {
		player = inputPlayer;
		if(player != null){
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/ViewPlayer.fxml"));
			page = (AnchorPane) loader.load();
			FadeTransition ft = new FadeTransition(Duration.millis(900), page);
			ft.setFromValue(0.0);
			ft.setToValue(0.97);
			ft.play();
			popup = new Popup();
			popup.setAutoHide(true);
			popup.getContent().add(page);
			popup.show(Main.stage);
		}
	}	

	/**
	 * Closes the popup 
	 */
	@FXML
	protected void handleReturn() {
		System.out.println("return");
		FadeTransition ft = new FadeTransition(Duration.millis(500), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		    		popup.hide(); 
		    	}
		});
	}
}