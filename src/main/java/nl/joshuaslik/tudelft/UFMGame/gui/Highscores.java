package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.backend.Player;
import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 * @author Sander Benoist
 *
 */
public class Highscores {
	
	@FXML
	private void initialize(){
		
		
	}
	
	/**
	 * Loads the highscore page
	 * @throws IOException is thrown if the FXML file cannot be parsed. 
	 */
	public static void start() throws IOException {	
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Highscores.fxml"));
		LinkedHashMap<String, Integer> result = Save.getHighscore();
		 for (String key : result.keySet()) {
			 Label label = new Label();
			 label.setText(key +" " + result.get(key));
			 label.setFont(Font.font("Verdana", 30));
			 AnchorPane.setTopAnchor(label, 192.0);
			 AnchorPane.setLeftAnchor(label, 486.0);
			 AnchorPane pane = (AnchorPane) scene.lookup("#main");
			 pane.getChildren().add(label);
		 }
		Main.setCenter(scene);
		Topbar.start("HighScores");
	}
	
	/**
	 * handles clicking on the return button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleReturn() throws IOException {
		MainMenu.start();
	}

}
