package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TransferMarket {

	private static Team team;
	private static Team otherteam;
	private static Player selectedplayer;
	private static ObservableList<Player> observablelistplayers;

	@FXML
	private static ComboBox<Team> teams;

	@FXML
	private static TableView<Player> playertable;

	@FXML
	private static TableColumn<Player, String> active;

	@FXML
	private static TableColumn<Player, String> name;

	@FXML
	private static TableColumn<Player, String> country;

	@FXML
	private static TableColumn<Player, String> position;

	@FXML
	private static TableColumn<Player, String> price;

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		AnchorPane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/TransferMarket.fxml"));
		Main.setCenter(root);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}

	@FXML
	public static void initialize() {
		ObservableList<Team> teamslist = FXCollections
				.observableArrayList(getteamList());
		teams.setItems(teamslist);
		teams.setConverter(new StringConverter<Team>() {
			@Override
			public String toString(Team team) {
				return team.getTeamName();
			}

			@Override
			public Team fromString(String nr) {
				return null;
			}
		});

		teams.valueProperty().addListener(new ChangeListener<Team>() {
			@Override
			public void changed(ObservableValue<? extends Team> observable,
					Team oldValue, Team newValue) {
				otherteam = newValue;
				ArrayList<Player> playerslist = otherteam.getAllPlayers();
				observablelistplayers = FXCollections
						.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
			}
		});

		ArrayList<Team> teamarraylist = MainGame.game.getTeams();
		teamarraylist.remove(MainGame.game.getUser().getTeam());
		teams.setValue(teamarraylist.get(0));
		ArrayList<Player> playerslist = otherteam.getAllPlayers();
		observablelistplayers = FXCollections.observableArrayList(playerslist);
		playertable.setItems(observablelistplayers);
		active.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"ID"));
		active.setCellFactory(new Callback<TableColumn<Player, String>, TableCell<Player, String>>() {
			@Override
			public TableCell<Player, String> call(
					TableColumn<Player, String> param) {
				TableCell<Player, String> cell = new TableCell<Player, String>() {
					@Override
					public void updateItem(String item, boolean empty) {
						if (item != null) {
							boolean active = false;
							for (int i = 0; i < otherteam.getActivePlayers()
									.size(); i++) {
								if (otherteam.getActivePlayers().get(i).getID()
										.equals(item)) {
									setText("✓");
									active = true;
								}
							}
							if (!active) {
								setText("✗");
							}
						}
					}
				};
				return cell;
			}
		});
		name.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"fullName"));
		country.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"country"));
		position.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"position"));
		playertable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> selectedPlayer(newValue));
	}

	public static void selectedPlayer(Player player) {
		selectedplayer = player;
	}

	@FXML
	protected void handleViewPlayer() throws IOException {
		ViewPlayer.start(selectedplayer);
	}
	
	@FXML
	protected void returnToTeam() throws IOException {
		MainGame.start();
	}
	
	private static ObservableList<Team> getteamList() {
		ArrayList<Team> teamarraylist = MainGame.game.getTeams();
		teamarraylist.remove(MainGame.game.getUser().getTeam());
		ObservableList<Team> res = FXCollections.observableArrayList(teamarraylist);
		return res;
	}

}
