package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import nl.joshuaslik.UFMReckoning.backend.Game;
import nl.joshuaslik.UFMReckoning.backend.Save;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.game.MainGame;

public class NewGameController {
	
		private Team choosenteam;
		private static String username;
	
	 	@FXML
	    private TableView<Team> teamtable;
	    @FXML
	    private TableColumn<Team, String> teamColumn;
	    @FXML
	    private TableColumn<Team, String> coachColumn;
	    @FXML
	    private TableColumn<Team, String> averagedefence;
	    @FXML
	    private TableColumn<Team, String> averagestamina;
	    @FXML
	    private TableColumn<Team, String> averageattack;
	    @FXML
	    private TableColumn<Team, String> totalplayers;
	    @FXML
	    private TableColumn<Team, String> teamvalue;
	    
	    /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML
	    private void initialize() {
	    	
	    	ObservableList<Team> teams = FXCollections.observableArrayList(Save.loadTeams());
	    	teamtable.setItems(teams);
	    	
	    	teamColumn.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"teamName"));
			coachColumn.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"coachName"));
			averagedefence.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"averageDefencePower"));
			averagestamina.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"averageStamina"));
			averageattack.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"averageAttackPower"));
			totalplayers.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"totalPlayers"));
			teamvalue.setCellValueFactory(new PropertyValueFactory<Team, String>(
					"teamValue"));
	    
	        // Listen for selection changes 
			teamtable.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> selectedTeam(newValue));
	    }
	    
	    
	    @FXML
		protected void handleChooseTeam(ActionEvent event) throws IOException {
	    	if (choosenteam != null) {
				Team chosenTeam = teamtable.getSelectionModel().getSelectedItem();
				Game Game1 = Save.newGame(chosenTeam, username);
				MainGame.setGame(Game1);
				MainGame.initialize();
				try {
					MainGame.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    
	    public void selectedTeam(Team team){
	    	choosenteam = team;
	    }
	    
	    public static void start(String user) throws IOException {
	    	username = user;
	 
			AnchorPane scene = FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/NewGame.fxml"));
			Main.setCenter(scene);
		}

}
