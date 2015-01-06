package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Save;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ChangeSetup {
	private static Team team;
	private static TableView ActivePlayerList;
	private static TableView BenchPlayerList;

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		init();

		AnchorPane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/ChangeSetup.fxml"));

		// Font voorbereiden voor de Text objecten
		Font statsFont = new Font(20);
		statsFont.loadFont("/data/gui/pages-menu/fonts/Quicksand.otf", 20);
		
		// ActivePlayerList TableView aanpassen
		ActivePlayerList.prefHeight(550);
		ActivePlayerList.prefWidth(550);
		ActivePlayerList.minHeight(550);
		ActivePlayerList.setLayoutX(390);
		ActivePlayerList.setLayoutY(260);

		// BenchPlayerList TableView aanpassen
		BenchPlayerList.prefHeight(550);
		BenchPlayerList.prefWidth(550);
		BenchPlayerList.minHeight(550);
		BenchPlayerList.setLayoutX(1240);
		BenchPlayerList.setLayoutY(260);
				
		root.getChildren().addAll(ActivePlayerList, BenchPlayerList);

		Main.setCenter(root);
	}

	public static void init() {
		ActivePlayerList = new TableView<Player>();
		ActivePlayerList.getColumns().addAll(getColumn(ActivePlayerList));
		ActivePlayerList.setItems(getActivePlayerlist());

		ActivePlayerList
				.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 0) {
							if (ActivePlayerList.getSelectionModel()
									.getSelectedIndex() >= 0) {
								ActivePlayerList.getSelectionModel()
										.getSelectedItem();
							}
						}
					}
				});
		
		BenchPlayerList = new TableView<Player>();
		BenchPlayerList.getColumns().addAll(getColumn(BenchPlayerList));
		BenchPlayerList.setItems(getBenchPlayerlist());

		BenchPlayerList
				.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 0) {
							if (BenchPlayerList.getSelectionModel()
									.getSelectedIndex() >= 0) {
								BenchPlayerList.getSelectionModel()
										.getSelectedItem();
							}
						}
					}
				});
	}

	public static ArrayList<TableColumn<Player, ?>> getColumn(
			TableView<Player> playertable) {
		int i;

		ArrayList<TableColumn<Player, ?>> columns = new ArrayList<TableColumn<Player, ?>>();

		// De te gebruiken gegevens
		String[] columnNames = { "Active", "Name", "Attack", "Defence",
				"Stamina" };
		String[] variableNames = { "activeStatus", "playerName", "atkPwr",
				"def", "sta" };

		// Kolommen aanmaken
		i = 0;
		TableColumn<Player, String> activeStatus = new TableColumn<>(
				columnNames[i++]);
		TableColumn<Player, String> playerName = new TableColumn<>(
				columnNames[i++]);
		TableColumn<Player, Integer> atkPwr = new TableColumn<>(
				columnNames[i++]);
		TableColumn<Player, Integer> def = new TableColumn<>(columnNames[i++]);
		TableColumn<Player, Integer> sta = new TableColumn<>(columnNames[i++]);

		// Kolom breedtes instellen
		activeStatus.setPrefWidth(75);
		playerName.setPrefWidth(235);
		atkPwr.setPrefWidth(90);
		def.setPrefWidth(90);
		sta.setPrefWidth(90);

		// Hier loop ik vast
		i = 0;
		activeStatus
				.setCellValueFactory(new PropertyValueFactory<Player, String>(
						variableNames[i++]));
		playerName
				.setCellValueFactory(new PropertyValueFactory<Player, String>(
						variableNames[i++]));
		atkPwr.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
				variableNames[i++]));
		def.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
				variableNames[i++]));
		sta.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
				variableNames[i++]));

		columns.add(activeStatus);
		columns.add(playerName);
		columns.add(atkPwr);
		columns.add(def);
		columns.add(sta);

		return columns;
	}

	public static ObservableList<Player> getActivePlayerlist() {
		ObservableList<Player> data = FXCollections.observableArrayList(team.getActivePlayers());
		return data;
	}
	
	public static ObservableList<Player> getBenchPlayerlist() {
		ObservableList<Player> data = FXCollections.observableArrayList(team.getBenchPlayers());
		return data;
	}
	
	@FXML
	protected void handleReturnTeamBuilder(ActionEvent event) throws IOException {
		TeamBuilderController.start();
	}
	
	@FXML
	protected void handlePlayerToField(ActionEvent event) {
		
	}
	
	@FXML
	protected void handlePlayerToBench(ActionEvent event) {
		
	}
}
