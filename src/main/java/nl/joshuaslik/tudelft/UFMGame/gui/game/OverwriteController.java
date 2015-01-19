package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;
import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;

public class OverwriteController {
	private static Popup popup;
	private static AnchorPane page;
	private static int saveslot;

	
	@FXML
	private void initialize(){
		

	}
	
	/**
	 * THe start method to load the overwrite dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start(int slot) throws IOException {
		saveslot = slot;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/OverwriteDialog.fxml"));
		page = (AnchorPane) loader.load();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.0);
		ft.setToValue(0.97);
		ft.play();
		page.setOpacity(0.85);
		popup = new Popup();
		popup.setAutoHide(true);
		popup.getContent().add(page);
		popup.show(Main.stage);
	}
	
	/**
	 * handles clicking on the Slot 1 button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleCancel() throws IOException {
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent actionevent) {
		    		popup.hide(); 
		    	}
		 });
		SaveGameController.start();
	}
	
	/**
	 * handles clicking on the Slot 2 button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleOK() throws IOException {
		Save.saveGame(MainGame.game, saveslot);
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent actionevent) {
		    		popup.hide(); 
		    	}
		 });
	}	
}
