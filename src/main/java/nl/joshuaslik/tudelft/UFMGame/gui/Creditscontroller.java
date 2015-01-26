package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;

/**
 * Controller for the credits dialog.
 * @author Bryan van Wijk
 */
public class Creditscontroller {
	
	private static Popup popup;
	private static AnchorPane page;

	/**
	 * handles when the ok button is pressed
	 */
	@FXML
	protected void handleOk() {
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

	/**
	 * THe start method to load the credits dialog
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-menu/CreditsDialog.fxml"));
		page = (AnchorPane) loader.load();
		FadeTransition ft = new FadeTransition(Duration.millis(500), page);
		ft.setFromValue(0.0);
		ft.setToValue(0.97);
		ft.play();
		page.setOpacity(0.85);
		popup = new Popup();
		popup.setOnAutoHide( new EventHandler<Event>() {
	    	public void handle(Event event) {
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
	    });
		popup.setAutoHide(true);
		popup.getContent().add(page);
		popup.show(Main.stage);
	}

}
