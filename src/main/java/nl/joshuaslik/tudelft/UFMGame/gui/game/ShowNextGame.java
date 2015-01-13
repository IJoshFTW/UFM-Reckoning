package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;


public class ShowNextGame {

	public static void start() throws IOException {
		Parent root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/Competition.fxml"));
		Scene scene = new Scene(root, 1080, 1920);
		Main.stage.setScene(scene);
		Main.stage.setFullScreen(true);
	}
}
	// show the next game to be played. Competition -> Next game to be played. 

