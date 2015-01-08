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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Save;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ChangeSetup {
	private Player selectedplayer;
	private static Team team;
	private ObservableList<Player> observablelistplayers;
	
	@FXML
	private TableView<Player> playertable;

	@FXML
	private Circle GK;
	@FXML
	private ImageView gkIMG;

	@FXML
	private TableColumn<Player, String> name;

	@FXML
	private TableColumn<Player, String> country;
	
	@FXML
	private TableColumn<Player, String> position;
	
	
	@FXML
	private void initialize(){
		ArrayList<Player> playerslist = team.getAllPlayers();
		observablelistplayers = FXCollections.observableArrayList(playerslist);
		playertable.setItems(observablelistplayers);
		
		name.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"fullName"));
		country.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"country"));
		position.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"position"));
		
		playertable.setOnDragDetected(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event){
				System.out.println("setOnDragDetected");
				Dragboard dragBoard = playertable.startDragAndDrop(TransferMode.MOVE); 
				ClipboardContent content = new ClipboardContent();
				content.putString(playertable.getSelectionModel().getSelectedItem().getID()); 
				dragBoard.setContent(content);
			}
		});
		
		GK.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
		
				System.out.println("Dragdroped on circle playerid: " + Dragboard.getSystemClipboard().getString());
				Image image = new Image("/data/base/players/pictures/" + Dragboard.getSystemClipboard().getString() + ".png");
				gkIMG.setImage(image);
				observablelistplayers.remove(MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()));
				
			}
		});
		
		GK.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != GK && event.getDragboard().hasString()) {
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		  
		    }
		});
				 		
		playertable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> selectedPlayer(newValue));
	}

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		AnchorPane root = FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/ChangeSetup.fxml"));
		Main.setCenter(root);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}
	
	public void selectedPlayer(Player player) {	
		selectedplayer = player;
	}
	
	@FXML
	protected void handleReturnTeamBuilder(ActionEvent event) throws IOException {
		TeamBuilderController.start();
	}
	
}
