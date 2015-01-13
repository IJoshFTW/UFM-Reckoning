package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

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
import nl.joshuaslik.UFMReckoning.backend.Fieldplayer;
import nl.joshuaslik.UFMReckoning.backend.Goalkeeper;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ViewPlayer {
	private static Player player;
	private static Popup popup;
	private static AnchorPane page;

	@FXML
	private Label playerName;
	@FXML
	private Label playerRole;
	@FXML
	private Label attackLable;
	@FXML
	private Label defenceLable;
	@FXML
	private Label staminaLable;
	@FXML
	private Label divingLable;
	@FXML
	private Label reflexesLable;
	@FXML
	private Label positioningLable;
	@FXML
	private Label showCountryLable;
	@FXML
	private Label showPriceLable;
	@FXML
	private ImageView playerPhoto;
	@FXML
	private ImageView staminaImg;
	@FXML
	private ImageView defPwrImg;
	@FXML
	private ImageView atkPwrImg;
	@FXML
	private ImageView positioningImg;
	@FXML
	private ImageView reflexesImg;
	@FXML
	private ImageView divingImg;
	@FXML
	private Button returnbutton;

	@FXML
	private void initialize() {
		playerName.setText(player.getFullName());

		Image image = new Image("/data/base/players/pictures/" + player.getID()
				+ ".png");
		playerPhoto.setImage(image);

		if (player instanceof Fieldplayer) {
			Fieldplayer fieldplayer = (Fieldplayer) player;
			playerRole.setText("Role: Fieldplayer");

			// AttackPower bar inladen
			attackLable.setVisible(true);
			atkPwrImg.prefHeight(20);
			atkPwrImg.minWidth(fieldplayer.getAttackPower() * 3);
			atkPwrImg.setFitWidth(fieldplayer.getAttackPower() * 3);
			atkPwrImg.setVisible(true);

			// Defence bar inladen
			defenceLable.setVisible(true);
			defPwrImg.prefHeight(20);
			defPwrImg.minWidth(fieldplayer.getDefencePower() * 3);
			defPwrImg.setFitWidth(fieldplayer.getDefencePower() * 3);
			defPwrImg.setVisible(true);

			// Stamina bar inladen
			staminaLable.setVisible(true);
			staminaImg.prefHeight(20);
			staminaImg.minWidth(fieldplayer.getStamina() * 3);
			staminaImg.setFitWidth(fieldplayer.getStamina() * 3);
			staminaImg.setVisible(true);
		}

		if (player instanceof Goalkeeper) {
			Goalkeeper goalkeeper = (Goalkeeper) player;
			playerRole.setText("Role: Goalkeeper");

			// Diving bar inladen
			divingLable.setVisible(true);
			divingImg.prefHeight(20);
			divingImg.minWidth(goalkeeper.getDiving() * 3);
			divingImg.setFitWidth(goalkeeper.getDiving() * 3);
			divingImg.setVisible(true);

			// Reflexes bar inladen
			reflexesLable.setVisible(true);
			reflexesImg.prefHeight(20);
			reflexesImg.minWidth(goalkeeper.getReflexes() * 3);
			reflexesImg.setFitWidth(goalkeeper.getReflexes() * 3);
			reflexesImg.setVisible(true);

			// Positioning bar inladen
			positioningLable.setVisible(true);
			positioningImg.prefHeight(20);
			positioningImg.minWidth(goalkeeper.getPositioning() * 3);
			positioningImg.setFitWidth(goalkeeper.getPositioning() * 3);
			positioningImg.setVisible(true);
		}
		showCountryLable.setText(player.getCountry());
		showPriceLable.setText(Integer.toString(player.getPrice()));

	}

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
			popup.getContent().add(page);
			popup.show(Main.stage);
		}
	}	

	@FXML
	protected void handleReturn() {
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}

}