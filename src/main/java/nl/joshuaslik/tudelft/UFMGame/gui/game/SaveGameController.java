package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;
import java.util.LinkedHashMap;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;
import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

/**
 * Controller of the save game class
 * @author Naomi
 *
 */
public class SaveGameController {
	private static Popup popup;
	private static AnchorPane page;
	private static LinkedHashMap<Integer, String> usernames;
	
	@FXML
	private Label username1, username2, username3;

	
	@FXML
	private void initialize(){
		usernames = Save.getUsernames();
		if(usernames.get(1) != null){
			username1.setText(usernames.get(1));
		}
		if(usernames.get(2) != null){
			username2.setText(usernames.get(2));
		}
		if(usernames.get(3) != null){
			username3.setText(usernames.get(3));
		}

	}
	
	/**
	 * THe start method to load the Save game dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/SaveGameDialog.fxml"));
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
	 * handles when the return button is pressed
	 */
	@FXML
	protected void handleReturnMainGame() {
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
	
	private void saveGame(int slot){
		if(usernames.containsKey(slot)){
			FadeTransition ft = new FadeTransition(Duration.millis(900), page);
			ft.setFromValue(0.97);
			ft.setToValue(0.0);
			ft.play();
			ft.setOnFinished(new EventHandler<ActionEvent>() {
    		    public void handle(ActionEvent actionevent) {
    		    		popup.hide(); 
    		    	}
    		 });
			try {
				OverwriteController.start(slot);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			Save.saveGame(MainGame.game, slot);
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

	/**
	 * handles clicking on the Slot 1 button
	 */
	@FXML
	protected void handleSlot1()  {
		saveGame(1);
	}
	
	/**
	 * handles clicking on the Slot 2 button
	*/
	@FXML
	protected void handleSlot2() {
		saveGame(2);
	}
	
	/**
	 * handles clicking on the Slot 3 button
	 */
	@FXML
	protected void handleSlot3() {
		saveGame(3);
	}
	
	
}
