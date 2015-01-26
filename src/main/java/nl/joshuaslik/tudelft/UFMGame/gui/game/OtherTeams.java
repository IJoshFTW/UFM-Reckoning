package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import nl.joshuaslik.tudelft.UFMGame.backend.Player;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

/**
 * @author Bryan van Wijk
 * @author Sander Benoist
 */
public class OtherTeams {
	
	private Team otherteam;
	private Player selectedplayer;
	private ObservableList<Player> observablelistplayers;
	@FXML
    private ComboBox<Team> teams;

	@FXML
	private TableView<Player> playertable;

	@FXML
	private TableColumn<Player, String> active, name, country, position;
	
	@FXML
	private Label showTotalWins, showTotalLosses, showTotalDraws, showTotalGoals, showTotalGamesPlayed, coach, formationlabel, attack, defence, stamina;

	@FXML
	private ImageView otherteamlogo, staminaImg, defPwrImg, atkPwrImg;

	/**
	 *  Initializes the controller class. This method is automatically called
	 *  after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		ObservableList<Team> teamslist = FXCollections.observableArrayList(getteamList());
    	teams.setItems(teamslist);
    	teams.setConverter(new StringConverter<Team>(){
   		 @Override
   		 public String toString(Team team){
   			return team.getTeamName();
   		 }
   		 
   		 @Override
   		 public Team fromString(String nr){
   			 return null;
   		 }
   	 });
   	 
   	 
   	 teams.valueProperty().addListener(new ChangeListener<Team>() {
   		@Override
		public void changed(
				ObservableValue<? extends Team> observable,
				Team oldValue, Team newValue) {
					otherteam = newValue;
					ArrayList<Player> playerslist = otherteam.getAllPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers); 
					Image image = new Image("/data/base/teams/pictures/" + otherteam.getid()
							+ ".png");
					otherteamlogo.setImage(image);
					
					int totalGamesPlayed = otherteam.getTotalWins() + otherteam.getTotalLosses()
							+ otherteam.getTotalDraws();

					showTotalGamesPlayed.setText("Total Games Played: "+totalGamesPlayed);
					showTotalWins.setText("Total Wins: "+otherteam.getTotalWins());
					showTotalLosses.setText("Total Losses: "+otherteam.getTotalLosses());
					showTotalDraws.setText("Total Draws: "+otherteam.getTotalDraws());
					showTotalGoals.setText("Total goals: "+otherteam.getTotalGoals());
					
					// AttackPower bar inladen
					atkPwrImg.setFitWidth(otherteam.getAttackPower() / 3);
					attack.setText(((int)(otherteam.getAttackPower()*0.1))+"");

					// Defence bar inladen
					defPwrImg.setFitWidth(otherteam.getDefencePower() / 3);
					defence.setText(((int)(otherteam.getDefencePower()*0.1))+"");

					// Stamina bar inladen
					staminaImg.setFitWidth(otherteam.getStamina() / 3);
					stamina.setText(((int)(otherteam.getStamina()*0.1))+"");
					
					coach.setText("Coach: " + otherteam.getCoachName());
					formationlabel.setText("Formation: "+ otherteam.getFormation().getName());
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
		active.setCellFactory(new Callback<TableColumn<Player, String>, TableCell<Player, String>>(){
			@Override
			public TableCell<Player, String> call(TableColumn<Player, String> param){
				TableCell<Player, String> cell = new TableCell<Player, String>(){
					@Override
					public void updateItem(String item, boolean empty){
						if(item!= null){
							boolean active = false;
							for(int i = 0; i<otherteam.getActivePlayers().size(); i++){
								if(otherteam.getActivePlayers().get(i).getID().equals(item)){
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
		playertable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectedPlayer(newValue));
		Image image = new Image("/data/base/teams/pictures/" + otherteam.getid()
				+ ".png");
		otherteamlogo.setImage(image);
		
		int totalGamesPlayed = otherteam.getTotalWins() + otherteam.getTotalLosses()
				+ otherteam.getTotalDraws();

		showTotalGamesPlayed.setText("Total Games Played: "+totalGamesPlayed);
		showTotalWins.setText("Total Wins: "+otherteam.getTotalWins());
		showTotalLosses.setText("Total Losses: "+otherteam.getTotalLosses());
		showTotalDraws.setText("Total Draws: "+otherteam.getTotalDraws());
		showTotalGoals.setText("Total goals: "+otherteam.getTotalGoals());
		
		// AttackPower bar inladen
		atkPwrImg.setFitWidth(otherteam.getAttackPower() / 3);

		// Defence bar inladen
		defPwrImg.setFitWidth(otherteam.getDefencePower() / 3);

		// Stamina bar inladen
		staminaImg.setFitWidth(otherteam.getStamina() / 3);
		
		coach.setText("Coach: " + otherteam.getCoachName());
		formationlabel.setText("Formation: "+ otherteam.getFormation().getName());
	}
	
	/**
	 * Method to get a observable list of all the teams except the users his team
	 * @return observable list of teams
	 */
	private ObservableList<Team> getteamList() {
		ArrayList<Team> teamarraylist = MainGame.game.getTeams();
		teamarraylist.remove(MainGame.game.getUser().getTeam());
		ObservableList<Team> res = FXCollections.observableArrayList(teamarraylist);
		return res;
	}

	/**
	 * Selects a player from a team
	 * @param player
	 */
	public void selectedPlayer(Player player){
		selectedplayer = player;
	}
	
	/**
	 * Handles when the key to view the selected player is pressed
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleViewPlayer() throws IOException {
		ViewPlayer.start(selectedplayer);
	}

	/**
	 * Creates the page that shows the other teams
	 * @throws IOException is thrown when the fxml cannot be read. 
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/OtherTeams.fxml"));
		
		Main.setCenter(scene);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}

}