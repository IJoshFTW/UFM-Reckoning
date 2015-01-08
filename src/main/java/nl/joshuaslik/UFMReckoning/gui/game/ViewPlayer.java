package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
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
	private static Popup popup;
	private static AnchorPane page;
	
	@FXML
	private ImageView playerPhoto;
	@FXML
	private ImageView staminaImg;
	@FXML
	private ImageView defPwrImg;
	@FXML
	private ImageView atkPwrImg;
	@FXML
	private Button returnbutton;

	@FXML
	private void initialize() {
		System.out.println(player.getID());
		Image image = new Image("/data/base/players/pictures/" + player.getID()
				+ ".png");
		playerPhoto.setImage(image);
		if (player instanceof Fieldplayer) {
			
			Fieldplayer fieldplayer = (Fieldplayer) player;
			
			// AttackPower bar inladen
			atkPwrImg.prefHeight(20);
			atkPwrImg.minWidth(fieldplayer.getAttackPower() * 3);
			atkPwrImg.setFitWidth(fieldplayer.getAttackPower() * 3);

			// Defence bar inladen
			defPwrImg.prefHeight(20);
			defPwrImg.minWidth(fieldplayer.getDefencePower() * 3);
			defPwrImg.setFitWidth(fieldplayer.getDefencePower() * 3);

			// Stamina bar inladen
			staminaImg.prefHeight(20);
			staminaImg.minWidth(fieldplayer.getStamina() * 3);
			staminaImg.setFitWidth(fieldplayer.getStamina() * 3);
		}

	}

	public static void start(Player inputPlayer) throws IOException {
		player = inputPlayer;	
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
	
	@FXML
	protected void handleReturn(ActionEvent event) throws IOException {
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
	}

}