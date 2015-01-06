package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import nl.joshuaslik.UFMReckoning.backend.Game;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TeamBuilderControl {

	private Player selectedplayer;
	private static Team team;
	private ObservableList<Player> players;
	
 	@FXML
    private TableView<Player> playertable;
 	
    @FXML
    private TableColumn<Player, String> fullname;
    
    @FXML
    private TableColumn<Player, String> country;
    
    @FXML
    private ImageView playerimg;
    @FXML
    private ImageView teamimg;
    @FXML
    private TableColumn<Player, String> price;

    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	Image image = new Image("/data/base/teams/pictures/"+team.getid()+".png");
    	teamimg.setImage(image);
    	ArrayList<Player> playerslist = team.getAllPlayers();
    	players = FXCollections.observableArrayList(playerslist);
    	playertable.setItems(players);
    	
    	
		country.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
		price.setCellValueFactory(new PropertyValueFactory<Player, String>("price"));
		fullname.setCellValueFactory(new PropertyValueFactory<Player, String>("fullName"));
    
        // Listen for selection changes 
		playertable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> selectedPlayer(newValue));
    }
    
    
    
    public void selectedPlayer(Player player){
    	selectedplayer = player;
    	Image image = new Image("/data/base/players/pictures/"+selectedplayer.getID()+".png");
    	playerimg.setImage(image);
    }
    
    public static void start(Game game) throws IOException {
    	team = game.getUser().getTeam();
    	AnchorPane topmenu = FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/TopMenu.fxml"));
		Label label = (Label) topmenu.lookup("#title");
		label.setText("MainGamemenu");
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		topmenu.setPrefWidth(visualBounds.getWidth());
		Main.setTop(topmenu);
		AnchorPane scene = FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/TeamBuilder.fxml"));
		Main.setCenter(scene);
		AnchorPane bottom = FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}


}
