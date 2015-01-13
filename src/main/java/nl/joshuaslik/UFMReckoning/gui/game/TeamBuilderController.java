package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TeamBuilderController {
	private Player selectedplayer;
	private static Team team;
	private ObservableList<Player> observablelistplayers;

	@FXML
	private TableView<Player> playertable;

	@FXML
	private TableColumn<Player, String> active, name, country, position, captain;

	@FXML
	private Label showTotalWins, showTotalLosses, showTotalDraws, showTotalGoals, showTotalGamesPlayed, coach;

	@FXML
	private ImageView teamlogo, staminaImg, defPwrImg, atkPwrImg;

	@FXML
	private void initialize() {
		coach.setText("Coach: "+ MainGame.game.getUser().getTeam().getCoachName());
		Image image = new Image("/data/base/teams/pictures/" + team.getid()+ ".png");
		teamlogo.setImage(image);
		ArrayList<Player> playerslist = team.getAllPlayers();
		observablelistplayers = FXCollections.observableArrayList(playerslist);
		playertable.setItems(observablelistplayers);

		active.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"ID"));
		active.setCellFactory(new Callback<TableColumn<Player, String>, TableCell<Player, String>>(){
			@Override
			public TableCell<Player, String> call(TableColumn<Player, String> param){
				TableCell<Player, String> cell = new TableCell<Player, String>(){
					@Override
					public void updateItem(String item, boolean empty){
						if(item!= null){
							boolean active = false;
							for(int i = 0; i<team.getActivePlayers().size(); i++){
								if(team.getActivePlayers().get(i).getID().equals(item)){
										setText("✓");
											active = true;
											}
										}
										if(!active){
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
		captain.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"ID"));
		captain.setCellFactory(new Callback<TableColumn<Player, String>, TableCell<Player, String>>(){
			@Override
			public TableCell<Player, String> call(TableColumn<Player, String> param){
				TableCell<Player, String> cell = new TableCell<Player, String>(){
					@Override
					public void updateItem(String item, boolean empty){
						if(item!= null){
							CheckBox checkbox = new CheckBox();
							Player player = MainGame.game.getPlayer(item);
							if(MainGame.game.getUser().getTeam().getTeamCaptain() != null && (MainGame.game.getUser().getTeam().getTeamCaptain().equals(player))){
								checkbox.setSelected(true);
							}
							else{
								checkbox.setSelected(false);
							}
							checkbox.selectedProperty().addListener(new ChangeListener<Boolean> () {
				                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				                	if(newValue == true){
				                		if(MainGame.game.getUser().getTeam().getActivePlayers().contains(player)){
				                			MainGame.game.getUser().getTeam().setTeamCaptain(player);
				                		}
				                		else{
				                			Popupscreen.start();
				                			Popupscreen.setTitle("Captain must be Active");
				                			Popupscreen.setMessage("Set the player you want to be captain in your formation\n before you can set him captain.");
				                		}
				                	}
				                	initialize();
				                }     
				            });
							this.setGraphic(checkbox);
						}
					}
				};
				return cell;
			}
		});

		// Listen for selection changes
		playertable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> selectedPlayer(newValue));

		int totalGamesPlayed = team.getTotalWins() + team.getTotalLosses()
				+ team.getTotalDraws();

		showTotalGamesPlayed.setText(Integer.toString(totalGamesPlayed));
		showTotalWins.setText(Integer.toString(team.getTotalWins()));
		showTotalLosses.setText(Integer.toString(team.getTotalLosses()));
		showTotalDraws.setText(Integer.toString(team.getTotalDraws()));
		showTotalGoals.setText(Integer.toString(team.getTotalGoals()));
		
		// AttackPower bar inladen
		atkPwrImg.setFitWidth(team.getAttackPower() / 3);

		// Defence bar inladen
		defPwrImg.setFitWidth(team.getDefencePower() / 3);

		// Stamina bar inladen
		staminaImg.setFitWidth(team.getStamina() / 3);
	}

	public void selectedPlayer(Player player) {
		selectedplayer = player;
	}

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();

		AnchorPane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/TeamBuilder.fxml"));

		Main.setCenter(root);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}

	@FXML
	protected void handleChangeSetup() throws IOException {
		ChangeSetup.start();
	}

	@FXML
	protected void handleViewPlayer() throws IOException {
		ViewPlayer.start(selectedplayer);
	}

	@FXML
	protected void handleTransferMarket() throws IOException {
		TransferMarket.start();
	}

	@FXML
	protected void handlePlayerList() {

	}

	@FXML
	protected void handleReturnTeamBuilder()
			throws IOException {
		TeamBuilderController.start();
	}

	@FXML
	protected void handleSellPlayer() {

	}

	@FXML
	protected void handleBuyPlayer() {

	}

	@FXML
	protected void handlePlayerToField() {

	}

	@FXML
	protected void handlePlayerToBench() {

	}
}