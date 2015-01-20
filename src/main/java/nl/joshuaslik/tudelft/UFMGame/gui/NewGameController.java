package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nl.joshuaslik.tudelft.UFMGame.backend.Game;
import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.gui.game.MainGame;

/**
 * Controller for New Game.
 * @author Naomi
 *
 */
public class NewGameController {
	
		private Team choosenteam;
		private static String username;
	
	 	@FXML
	    private TableView<Team> teamtable;
	    @FXML
	    private TableColumn<Team, String> teamColumn, coachColumn, averagedefence, averagestamina, averageattack, totalplayers, teamvalue;
	    
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
	    
	    /**
	     * handles if someone clicks on the choose this team button
	     */
	    @FXML
		protected void handleChooseTeam() {
	    	if (choosenteam != null) {
				Team chosenTeam = teamtable.getSelectionModel().getSelectedItem();
				Game Game1 = Save.newGame(chosenTeam, username);
				Game1.changeFormationRound();
				MainGame.setGame(Game1);
			
				MainGame.initialize();
				try {
					MainGame.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    
	    
	    /**
	     * sets the choosen team as the parameter
	     * @param team the team that is chosen
	     */
	    public void selectedTeam(Team team){
	    	choosenteam = team;
	    }
	    
	    /**
	     * Loads the Page where you can choose a team
	     * @param user The username that is chosen in the previous dialog
	     * @throws IOException  is thrown if the FXML file cannot be parsed. 
	     */
	    public static void start(String user) throws IOException {
	    	username = user;
	 
			AnchorPane scene = FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/NewGame.fxml"));
			Main.setCenter(scene);
			Topbar.start(username);
		}

}
