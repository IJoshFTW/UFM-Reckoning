package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * Main Class of the GUI. This one will be called when the application starts
 * 
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class MainMenu {

	
	/**
	 * Loading the MainMenu
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/MainMenu.fxml"));
		Main.setCenter(scene);
		Main.setBottom(null);
		Main.setTop(null);
		
		Main.rootLayout.getStyleClass().removeAll("maingame");
		
		Main.rootLayout.getStyleClass().add("mainmenu");
	}
}