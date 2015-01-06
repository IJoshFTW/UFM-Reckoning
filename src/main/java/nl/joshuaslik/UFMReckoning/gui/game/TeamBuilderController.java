package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private TableColumn<Player, String> attack;
    
    @FXML
    private TableColumn<Player, String> defence;
    
    @FXML
    private TableColumn<Player, String> stamina;

	@FXML
    private ImageView teamlogo;
	
	 @FXML
	 private void initialize() {
	    	Image image = new Image("/data/base/teams/pictures/"+team.getid()+".png");
	    	teamlogo.setImage(image);
	    	ArrayList<Player> playerslist = team.getAllPlayers();
	    	System.out.println(playerslist.get(0));
	    	observablelistplayers = FXCollections.observableArrayList(playerslist);
	    	playertable.setItems(observablelistplayers);
	    	
	    	
			active.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
			name.setCellValueFactory(new PropertyValueFactory<Player, String>("fullName"));
			attack.setCellValueFactory(new PropertyValueFactory<Player, String>("attackPower"));
			defence.setCellValueFactory(new PropertyValueFactory<Player, String>("defencePower"));
			stamina.setCellValueFactory(new PropertyValueFactory<Player, String>("stamina"));
	        // Listen for selection changes 
			playertable.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> selectedPlayer(newValue));
	 }
	 
	 public void selectedPlayer(Player player){
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
		atkPwrImgView.setLayoutY(580);

		// Defence bar inladen
		Image defPwrImg = new Image("/data/gui/img/defencepowerbar.png");
		ImageView defPwrImgView = new ImageView();
		defPwrImgView.setImage(defPwrImg);
		defPwrImgView.prefHeight(20);
		defPwrImgView.prefWidth(team.getDefencePower() / 3);
		defPwrImgView.setFitWidth(team.getDefencePower() / 3);
		defPwrImgView.setLayoutX(1140);
		defPwrImgView.setLayoutY(610);

		// Stamina bar inladen
		Image staminaImg = new Image("/data/gui/img/staminabar.png");
		ImageView staminaImgView = new ImageView();
		staminaImgView.setImage(staminaImg);
		staminaImgView.prefHeight(20);
		staminaImgView.prefWidth(team.getStamina() / 3);
		staminaImgView.setFitWidth(team.getStamina() / 3);
		staminaImgView.setLayoutX(1140);
		staminaImgView.setLayoutY(640);

		// Font voorbereiden voor de Text objecten
		Font statsFont = Font.loadFont("/data/gui/pages-menu/fonts/Quicksand.otf", 20);

		// Total Games Played: Text
		Text totalGames = new Text("not implemented");
		totalGames.prefHeight(20);
		totalGames.setFont(statsFont);
		totalGames.setLayoutX(1202);
		totalGames.setLayoutY(687);

		// Total Wins: Text
		Text totalWins = new Text(Integer.toString(team.getTotalWins()));
		totalWins.prefHeight(20);
		totalWins.setFont(statsFont);
		totalWins.setLayoutX(1122);
		totalWins.setLayoutY(718);

		// Total Losses: Text
		Text totalLosses = new Text(Integer.toString(team.getTotalLosses()));
		totalLosses.prefHeight(20);
		totalLosses.setFont(statsFont);
		totalLosses.setLayoutX(1136);
		totalLosses.setLayoutY(748);

		// Total Draws: Text
		Text totalDraws = new Text(Integer.toString(team.getTotalDraws()));
		totalDraws.prefHeight(20);
		totalDraws.setFont(statsFont);
		totalDraws.setLayoutX(1134);
		totalDraws.setLayoutY(778);

		// Total Goals: Text
		Text totalGoals = new Text(Integer.toString(team.getTotalGoals()));
		totalGoals.prefHeight(20);
		totalGoals.setFont(statsFont);
		totalGoals.setLayoutX(1130);
		totalGoals.setLayoutY(808);

		// Funds: Text
		Text funds = new Text("$"
				+ Integer.toString(MainGame.game.getUser().getBudget()));
		funds.prefHeight(30);
		funds.setFont(statsFont);
		funds.setLayoutX(1350);
		funds.setLayoutY(882);


		root.getChildren().addAll( atkPwrImgView, defPwrImgView,
				staminaImgView, totalGames, totalWins, totalLosses, totalDraws,
				totalGoals, funds);

		Main.setCenter(root);
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

	public static ObservableList<Player> getPlayerlist() {
		ObservableList<Player> data = FXCollections.observableArrayList(team
				.getAllPlayersList());
		return data;
	}
	
	@FXML
	protected void handleChangeSetup(ActionEvent event) throws IOException {
		ChangeSetup.start();
	}
	
	@FXML
	protected void handleViewPlayer(ActionEvent event) throws IOException {
		MainMenu.start();
	}
	
	@FXML
	protected void handleTransferMarket(ActionEvent event) throws IOException {
		TransferMarket.start();
	}
	
	@FXML
	protected void handlePlayerList(ActionEvent event) throws IOException {
		
	}
	
	@FXML
	protected void handleReturnTeamBuilder(ActionEvent event) throws IOException {
		TeamBuilder.start();
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