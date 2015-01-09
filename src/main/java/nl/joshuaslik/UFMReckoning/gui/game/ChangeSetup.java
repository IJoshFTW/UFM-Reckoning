package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
import javafx.util.StringConverter;
import nl.joshuaslik.UFMReckoning.backend.*;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ChangeSetup {
	private Player selectedplayer;
	private static Formation formation;
	private static Team team;
	private ObservableList<Player> observablelistplayers;
	
	@FXML
    private ComboBox<Formation> form;
	@FXML
	private TableView<Player> playertable;
	@FXML
	private AnchorPane POS1;
	@FXML
	private AnchorPane POS2;
	@FXML
	private AnchorPane POS3;
	@FXML
	private AnchorPane POS4;
	@FXML
	private AnchorPane POS5;
	@FXML
	private AnchorPane POS6;
	@FXML
	private AnchorPane POS7;
	@FXML
	private AnchorPane POS8;
	@FXML
	private AnchorPane POS9;
	@FXML
	private AnchorPane POS10;
	@FXML
	private ImageView IMG1;
	@FXML
	private ImageView IMG2;
	@FXML
	private ImageView IMG3;
	@FXML
	private ImageView IMG4;
	@FXML
	private ImageView IMG5;
	@FXML
	private ImageView IMG6;
	@FXML
	private ImageView IMG7;
	@FXML
	private ImageView IMG8;
	@FXML
	private ImageView IMG9;
	@FXML
	private ImageView IMG10;
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
		if(formation instanceof Form343){
			Form343 formation343 = (Form343) formation;
			if(formation343.getGoalkeper() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getGoalkeper().getID() + ".png");
				gkIMG.setImage(image);
			}
			if(formation343.getST() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getST().getID() + ".png");
				IMG10.setImage(image);
			}
			
		}	
		ArrayList<Formation> forms = new ArrayList<Formation>();
		if(!(formation instanceof Form343)){
			forms.add(new Form343(MainGame.game.getUser().getTeam()));
		}
		forms.add(new Form4321(MainGame.game.getUser().getTeam()));
		forms.add(new Form433(MainGame.game.getUser().getTeam()));
		forms.add(new Form442(MainGame.game.getUser().getTeam()));
		forms.add(new Form532(MainGame.game.getUser().getTeam()));
		ObservableList<Formation> formlist = FXCollections.observableArrayList(forms);
    	form.setItems(formlist);
    	form.setValue(formation);
    	form.setConverter(new StringConverter<Formation>(){
   		 @Override
   		 public String toString(Formation formation){
   			return formation.getName(); 
   		 }
   		 
   		 @Override
   		 public Formation fromString(String nr){
   			 return null;
   		 }
   	 });
   	 
   	 form.valueProperty().addListener(new ChangeListener<Formation>() {
   		@Override
		public void changed(
				ObservableValue<? extends Formation> observable,
				Formation oldValue, Formation newValue) {
					formation = newValue;
					MainGame.game.getUser().getTeam().changeFormationType(formation);
					playertable.setItems(observablelistplayers);
					IMG1.setImage(null);
					IMG2.setImage(null);
					IMG3.setImage(null);
					IMG4.setImage(null);
					IMG5.setImage(null);
					IMG6.setImage(null);
					IMG7.setImage(null);
					IMG8.setImage(null);
					IMG9.setImage(null);
					IMG10.setImage(null);
					gkIMG.setImage(null);
				}   
   	});
   	 
	ArrayList<Player> playerslist = team.getBenchPlayers();
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
				content.putString(selectedplayer.getID()); 
				dragBoard.setContent(content);
			}
		});
		IMG10.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG10.setImage(image);
					formation.setST((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG10.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG10 && event.getDragboard().hasString()) {
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		gkIMG.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Goalkeeper){
					Goalkeeper goalkeeper = (Goalkeeper) player;
					Image image = new Image("/data/base/players/pictures/" + goalkeeper.getID() + ".png");
					gkIMG.setImage(image);
					formation.setGoalkeeper((Goalkeeper) MainGame.game.getPlayer(goalkeeper.getID()));
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		gkIMG.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != gkIMG && event.getDragboard().hasString()) {
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
				 		
		playertable.getSelectionModel().selectedItemProperty().addListener(
						(observable, oldValue, newValue) -> selectedPlayer(newValue));
	}

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		formation = team.getFormation();
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
