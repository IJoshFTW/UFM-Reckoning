package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * @author Sander Benoist
 *
 */
public class Highscores {

	/**
	 * Loads the highscore page
	 * @throws IOException is thrown if the FXML file cannot be parsed. 
	 */
	public static void start() throws IOException {	
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Highscores.fxml"));
		Main.setCenter(scene);
	}
	
	@FXML
	protected void handleReturn() throws IOException {
		MainMenu.start();
	}

}
