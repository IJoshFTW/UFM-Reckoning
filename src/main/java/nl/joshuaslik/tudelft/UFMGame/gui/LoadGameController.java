package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;
import java.util.LinkedHashMap;

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
import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.gui.game.MainGame;

/**
 * Class to control the load game function
 * @author Naomi
 *
 */
public class LoadGameController {
	private static Popup popup;
	private static AnchorPane page;
	@FXML
	private Label username1, username2, username3;
	@FXML
	private Button slot1, slot2, slot3;

	
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
		popup.setAutoHide(true);
		popup.getContent().add(page);
		popup.show(Main.stage);
	}
	
	/**
	 * Initialize the loadGame dialog
	 */
	@FXML
	private void initialize(){
		LinkedHashMap<Integer, String> usernames = Save.getUsernames();
		if(usernames.get(1) != null){
			username1.setText(usernames.get(1));
			slot1.setDisable(false);
		}
		if(usernames.get(2) != null){
			username2.setText(usernames.get(2));
			slot2.setDisable(false);
		}
		if(usernames.get(3) != null){
			username3.setText(usernames.get(3));
			slot3.setDisable(false);
		}
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
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent actionevent) {
		    		popup.hide(); 
		    	}
		 });
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
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent actionevent) {
		    		popup.hide(); 
		    	}
		 });
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
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent actionevent) {
		    		popup.hide(); 
		    	}
		 });
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
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent actionevent) {
		    		popup.hide(); 
		    	}
		 });
	}
	
	
}
