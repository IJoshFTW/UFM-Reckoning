package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;
import nl.joshuaslik.UFMReckoning.gui.MainMenu;

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
	private TableColumn<Player, String> active;

	@FXML
	private TableColumn<Player, String> name;

	@FXML
	private TableColumn<Player, String> country;
	
	@FXML
	private TableColumn<Player, String> position;

	@FXML
	private Label showTotalGamesPlayed;

	@FXML
	private Label showTotalWins;

	@FXML
	private Label showTotalLosses;

	@FXML
	private Label showTotalDraws;

	@FXML
	private Label showTotalGoals;

	@FXML
	private ImageView teamlogo;

	@FXML
	private void initialize() {
		Image image = new Image("/data/base/teams/pictures/" + team.getid()
				+ ".png");
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
	}

	public void selectedPlayer(Player player) {
		selectedplayer = player;
	}

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();

		AnchorPane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/TeamBuilder.fxml"));

		// AttackPower bar inladen
		Image atkPwrImg = new Image("/data/gui/img/attackpowerbar.png");
		ImageView atkPwrImgView = new ImageView();
		atkPwrImgView.setImage(atkPwrImg);
		atkPwrImgView.prefHeight(20);
		atkPwrImgView.prefWidth(team.getAttackPower() / 3);
		atkPwrImgView.setFitWidth(team.getAttackPower() / 3);
		atkPwrImgView.setLayoutX(1140);
		atkPwrImgView.setLayoutY(389);

		// Defence bar inladen
		Image defPwrImg = new Image("/data/gui/img/defencepowerbar.png");
		ImageView defPwrImgView = new ImageView();
		defPwrImgView.setImage(defPwrImg);
		defPwrImgView.prefHeight(20);
		defPwrImgView.prefWidth(team.getDefencePower() / 3);
		defPwrImgView.setFitWidth(team.getDefencePower() / 3);
		defPwrImgView.setLayoutX(1140);
		defPwrImgView.setLayoutY(419);

		// Stamina bar inladen
		Image staminaImg = new Image("/data/gui/img/staminabar.png");
		ImageView staminaImgView = new ImageView();
		staminaImgView.setImage(staminaImg);
		staminaImgView.prefHeight(20);
		staminaImgView.prefWidth(team.getStamina() / 3);
		staminaImgView.setFitWidth(team.getStamina() / 3);
		staminaImgView.setLayoutX(1140);
		staminaImgView.setLayoutY(449);

		root.getChildren().addAll(atkPwrImgView, defPwrImgView, staminaImgView);

		Main.setCenter(root);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}

	@FXML
	protected void handleChangeSetup(ActionEvent event) throws IOException {
		ChangeSetup.start();
	}

	@FXML
	protected void handleViewPlayer(ActionEvent event) throws IOException {
		ViewPlayer.start(selectedplayer);
	}

	@FXML
	protected void handleTransferMarket(ActionEvent event) throws IOException {
		TransferMarket.start();
	}

	@FXML
	protected void handlePlayerList(ActionEvent event) throws IOException {

	}

	@FXML
	protected void handleReturnTeamBuilder(ActionEvent event)
			throws IOException {
		TeamBuilderController.start();
	}

	@FXML
	protected void handleSellPlayer(ActionEvent event) {

	}

	@FXML
	protected void handleBuyPlayer(ActionEvent event) {

	}

	@FXML
	protected void handlePlayerToField(ActionEvent event) {

	}

	@FXML
	protected void handlePlayerToBench(ActionEvent event) {

	}
}