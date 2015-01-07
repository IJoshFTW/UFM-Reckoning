package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nl.joshuaslik.UFMReckoning.backend.Fieldplayer;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;
import nl.joshuaslik.UFMReckoning.gui.MainMenu;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ViewPlayer {
	private static Player player;
	
	@FXML
	private ImageView playerPhoto;

	@FXML
	private void initialize() {
		Image image = new Image("/data/base/player/pictures/" + player.getID()
				+ ".png");
		playerPhoto.setImage(image);

	}


	public static void start(Player inputPlayer) throws IOException {
		AnchorPane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/ViewPlayer.fxml"));
		
		player = inputPlayer;

		if (player instanceof Fieldplayer) {
			Fieldplayer fieldplayer = (Fieldplayer) player;
			
			// AttackPower bar inladen
			Image atkPwrImg = new Image("/data/gui/img/attackpowerbar.png");
			ImageView atkPwrImgView = new ImageView();
			atkPwrImgView.setImage(atkPwrImg);
			atkPwrImgView.prefHeight(20);
			atkPwrImgView.prefWidth(fieldplayer.getAttackPower());
			atkPwrImgView.setFitWidth(fieldplayer.getAttackPower());
			atkPwrImgView.setLayoutX(1140);
			atkPwrImgView.setLayoutY(580);


			// Defence bar inladen
			Image defPwrImg = new Image("/data/gui/img/defencepowerbar.png");
			ImageView defPwrImgView = new ImageView();
			defPwrImgView.setImage(defPwrImg);
			defPwrImgView.prefHeight(20);
			defPwrImgView.prefWidth(fieldplayer.getDefencePower());
			defPwrImgView.setFitWidth(fieldplayer.getDefencePower());
			defPwrImgView.setLayoutX(1140);
			defPwrImgView.setLayoutY(610);

			// Stamina bar inladen
			Image staminaImg = new Image("/data/gui/img/staminabar.png");
			ImageView staminaImgView = new ImageView();
			staminaImgView.setImage(staminaImg);
			staminaImgView.prefHeight(20);
			staminaImgView.prefWidth(fieldplayer.getStamina());
			staminaImgView.setFitWidth(fieldplayer.getStamina());
			staminaImgView.setLayoutX(1140);
			staminaImgView.setLayoutY(640);
			
			root.getChildren().addAll(atkPwrImgView, defPwrImgView, staminaImgView);
		}

		Main.setCenter(root);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}


	@FXML
	protected void handleReturnTeamBuilder(ActionEvent event)
			throws IOException {
		TeamBuilderController.start();
	}
}