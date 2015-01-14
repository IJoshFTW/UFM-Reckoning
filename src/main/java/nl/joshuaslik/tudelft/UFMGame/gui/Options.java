package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

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
		AnchorPane topmenu = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/TopMenu.fxml"));
		Main.setCenter(scene);
		Label label = (Label) topmenu.lookup("#title");
		label.setText("Options");
		Main.setTop(topmenu);
	}

}
