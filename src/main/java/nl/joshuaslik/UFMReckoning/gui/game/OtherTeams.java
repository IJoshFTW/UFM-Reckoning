package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.util.Callback;
import nl.joshuaslik.UFMReckoning.backend.Save;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * 5
 * 
 * @author Bryan van Wijk
 *
 */
public class OtherTeams {

	@FXML
	private TableView<Team> otherteamstable;
	@FXML
	private TableColumn<Team, String> otherteam;

	@FXML
	private void initialize() {

		ObservableList<Team> teams = FXCollections.observableArrayList(MainGame.game.getTeams());
			otherteamstable.setItems(teams);

		otherteam.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"teamName"));

	}

	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/OtherTeams.fxml"));
		
		Main.setCenter(scene);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}

}