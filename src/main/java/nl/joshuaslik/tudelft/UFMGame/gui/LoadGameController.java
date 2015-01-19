package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.gui.game.MainGame;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;

public class LoadGameController {
	private static Popup popup;
	private static AnchorPane page;
	
	/**
	 * THe start method to load the loadgame dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-menu/LoadGameDialog.fxml"));
		page = (AnchorPane) loader.load();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.0);
		ft.setToValue(0.97);
		ft.play();
		page.setOpacity(0.85);
		popup = new Popup();
		popup.getContent().add(page);
		popup.show(Main.stage);
	}
	
	/**
	 * handles when the return button is pressed
	 */
	@FXML
	protected void handleReturnMainMenu() {
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}

	/**
	 * handles clicking on the Slot 1 button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleSlot1() throws IOException {
		MainGame.setGame(Save.loadGame(1));
		MainGame.start();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}
	
	/**
	 * handles clicking on the Slot 2 button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleSlot2() throws IOException {
		MainGame.setGame(Save.loadGame(2));
		MainGame.start();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}
	
	/**
	 * handles clicking on the Slot 3 button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleSlot3() throws IOException {
		MainGame.setGame(Save.loadGame(3));
		MainGame.start();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}
	
	
}
