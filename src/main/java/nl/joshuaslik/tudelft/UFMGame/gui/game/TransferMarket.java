package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import nl.joshuaslik.tudelft.UFMGame.backend.Player;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.exceptions.UnableToBuyException;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

/**
 * Class to control the transfermarket
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 * @author Lisette Veldkamp
 * @author Bryan van Wijk
 * @author Sander Benoist
 */
public class TransferMarket {
	private static Team team;
	private Team otherteam;
	private Player selectedplayer;
	private ObservableList<Player> observablelistplayers;
	private ObservableList<Player> observablelistteamplayers;

	// otherteams table variables
	@FXML
	private ComboBox<Team> teams;
	@FXML
	private TableView<Player> playertable;
	@FXML
	private TableColumn<Player, String> name, country, position, price;
	@FXML
	private Button buyplayerbutton, sellplayerbutton;

	// yourteam table variables
	@FXML
	private TableView<Player> yourteamtable;
	@FXML
	private TableColumn<Player, String> active2, name2, position2,
			value;

	/**
	 * all tables are created
	 */
	@FXML
	private void initialize() {
		//Combobox team items in list
		ObservableList<Team> teamslist = FXCollections
				.observableArrayList(getteamList());
		Team nonContractedTeam = new Team("Non-Contracted Players", "Non-Contracted Players", "Non-Contracted Players");
		nonContractedTeam.setAllBenchPlayers(MainGame.game.getNonContractedPlayers());
		teamslist.add(nonContractedTeam);
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

		//Combobox selected team
		teams.valueProperty().addListener(new ChangeListener<Team>() {
			@Override
			public void changed(ObservableValue<? extends Team> observable,
					Team oldValue, Team newValue) {
				otherteam = newValue;
				ArrayList<Player> playerslist = otherteam.getBenchPlayers();
				observablelistplayers = FXCollections
						.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
			}
		});
		teams.setValue(teamslist.get(0));
		
		//otherteams table
		ArrayList<Player> playerslist = otherteam.getBenchPlayers();
		observablelistplayers = FXCollections.observableArrayList(playerslist);
		playertable.setItems(observablelistplayers);
		
		name.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"fullName"));
		country.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"country"));
		position.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"position"));
		price.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"price"));

		playertable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> selectedPlayer(newValue, "otherteamtable"));

		//your teamplayers table
		ArrayList<Player> teamplayerslist = team.getAllPlayers();
		observablelistteamplayers = FXCollections
				.observableArrayList(teamplayerslist);
		yourteamtable.setItems(observablelistteamplayers);
		
		active2.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"ID"));
		active2.setCellFactory(new Callback<TableColumn<Player, String>, TableCell<Player, String>>() {
			@Override
			public TableCell<Player, String> call(
					TableColumn<Player, String> param) {
				TableCell<Player, String> cell = new TableCell<Player, String>() {
					@Override
					public void updateItem(String item, boolean empty) {
						if (item != null) {
							boolean active = false;
							for (int i = 0; i < team.getActivePlayers().size(); i++) {
								if (team.getActivePlayers().get(i).getID()
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
		
		name2.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"fullName"));
				position2.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"position"));
		value.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"price"));

		// Listen for selection changes to player
		yourteamtable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> selectedPlayer(newValue, "yourteam"));
	}

	/**
	 * get ObservableList of all other teams
	 */
	private ObservableList<Team> getteamList() {
		ArrayList<Team> teamarraylist = MainGame.game.getTeams();
		teamarraylist.remove(MainGame.game.getUser().getTeam());
		ObservableList<Team> res = FXCollections
				.observableArrayList(teamarraylist);
		return res;
	}

	/**
	 * Selected player in tableit 
	 * @param player that is selected
	 * @param selectedtable is the table that is selected in the transfermarket 
	 */
	public void selectedPlayer(Player player, String selectedtable) {
		if(selectedtable.equals("yourteam")){
			buyplayerbutton.setDisable(true);
			sellplayerbutton.setDisable(false);
		}
		else if(selectedtable.equals("otherteamtable")){
			buyplayerbutton.setDisable(false);
			sellplayerbutton.setDisable(true);
		}
		selectedplayer = player;
	}

	/**
	 * View the selected player
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleViewPlayer() throws IOException {
		ViewPlayer.start(selectedplayer);
	}

	/**
	 * Selling the selected player
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void sellingPlayer() throws IOException {
		/**
		if (!selectedplayer.getActiveState()) {
		MainGame.game.sellPlayer(selectedplayer.getID());
		}
		start();
		*/
		
		if(!team.getActivePlayers().contains(selectedplayer)){
			MainGame.game.setNonContracted(selectedplayer.getID());
			ArrayList<Player> teamplayerslist = team.getAllPlayers();
			observablelistteamplayers = FXCollections
					.observableArrayList(teamplayerslist);
			yourteamtable.setItems(observablelistteamplayers);
			ArrayList<Player> playerslist = otherteam.getBenchPlayers();
			observablelistplayers = FXCollections
					.observableArrayList(playerslist);
			playertable.setItems(observablelistplayers);
			sellplayerbutton.setDisable(true);
			AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
					.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
			Main.setBottom(bottom);
			buyplayerbutton.setDisable(true);
			playertable.getSelectionModel().select(null);
			playertable.getFocusModel().focus(null);
			yourteamtable.getSelectionModel().select(null);
			yourteamtable.getFocusModel().focus(null);
		}
		else{
			Popupscreen.start();
			Popupscreen.setTitle("Unable to sell");
			Popupscreen.setMessage("You can not sell an active player.");
		}
	}

	/**
	 * Buying the selected player and reloading page
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void buyingPlayer() throws IOException {

		/**
		if (!selectedplayer.getActiveState()) {
		User user = MainGame.game.getUser(otherteam);
		MainGame.game.buyPlayer(selectedplayer.getID(), user);
		}
		start();
		*/

		try{
			if(otherteam.getTeamName().equals("Non-Contracted Players")){
				MainGame.game.buyNonContractedPlayer(selectedplayer.getID(), MainGame.game.getUser());
			}
			else{
				MainGame.game.buyPlayer(selectedplayer.getID(), MainGame.game.getUser());
				MainGame.game.sellPlayer(selectedplayer.getID(), MainGame.game.getUser(otherteam));
			}
			ArrayList<Player> teamplayerslist = team.getAllPlayers();
			observablelistteamplayers = FXCollections
					.observableArrayList(teamplayerslist);
			yourteamtable.setItems(observablelistteamplayers);
			ArrayList<Player> playerslist = otherteam.getBenchPlayers();
			observablelistplayers = FXCollections
					.observableArrayList(playerslist);
			playertable.setItems(observablelistplayers);
			AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
					.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
			Main.setBottom(bottom);
			buyplayerbutton.setDisable(true);
			playertable.getSelectionModel().select(null);
			playertable.getFocusModel().focus(null);
			yourteamtable.getSelectionModel().select(null);
			yourteamtable.getFocusModel().focus(null);
		}
		catch(UnableToBuyException e){
			Popupscreen.start();
			Popupscreen.setTitle("Not enough money");
			Popupscreen.setMessage("You must first get enough money to buy this player");
		}
	}

	/**
	 * Go back to the Main Game
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void returnToTeam() throws IOException {
		MainGame.start();
	}

	/**
	 * Load Transfermarket page
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		AnchorPane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/TransferMarket.fxml"));
		Main.setCenter(root);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}
	
	
}
