package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import nl.joshuaslik.tudelft.UFMGame.gui.game.TeamBuilderController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * @author Sander Benoist
 * @author Naomi de Ridder
 */
public class Options {

	/**
	 * Loads the option page.
	 * @throws IOException is thrown if the FXML file cannot be parsed. 
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Options.fxml"));
		Main.setCenter(scene);
	}
	
	@FXML
	protected void handleReturn() throws IOException {
		MainMenu.start();
	}

}
