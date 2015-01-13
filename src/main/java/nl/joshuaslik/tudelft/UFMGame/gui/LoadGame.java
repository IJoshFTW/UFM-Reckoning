package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * @author Bryan van Wijk
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class LoadGame {

	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource(""));
		Main.setCenter(scene);
		Main.setTop(null);
	}

}
