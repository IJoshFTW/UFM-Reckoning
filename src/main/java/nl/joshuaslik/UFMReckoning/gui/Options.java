package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * @author Sander Benoist
 *
 */
public class Options {

	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Options.fxml"));
		AnchorPane topmenu = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/TopMenu.fxml"));
		Main.setCenter(scene);
		Label label = (Label) topmenu.lookup("#title");
		label.setText("Options");
		Main.setTop(topmenu);
	}

}
