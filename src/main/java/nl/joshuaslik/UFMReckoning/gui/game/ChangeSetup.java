package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
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
import javafx.util.StringConverter;
import nl.joshuaslik.UFMReckoning.backend.Fieldplayer;
import nl.joshuaslik.UFMReckoning.backend.Goalkeeper;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.backend.formation.Form343;
import nl.joshuaslik.UFMReckoning.backend.formation.Form4321;
import nl.joshuaslik.UFMReckoning.backend.formation.Form433;
import nl.joshuaslik.UFMReckoning.backend.formation.Form442;
import nl.joshuaslik.UFMReckoning.backend.formation.Form532;
import nl.joshuaslik.UFMReckoning.backend.formation.Formation;
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
			if(formation343.getCB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getCB().getID() + ".png");
				IMG1.setImage(image);
			}
			if(formation343.getLB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getLB().getID() + ".png");
				IMG2.setImage(image);
			}
			if(formation343.getRB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getRB().getID() + ".png");
				IMG3.setImage(image);
			}
			if(formation343.getCM1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getCM1().getID() + ".png");
				IMG4.setImage(image);
			}
			if(formation343.getCM2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getCM2().getID() + ".png");
				IMG5.setImage(image);
			}
			if(formation343.getRM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getRM().getID() + ".png");
				IMG6.setImage(image);
			}
			if(formation343.getLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getLM().getID() + ".png");
				IMG7.setImage(image);
			}
			if(formation343.getLW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getLW().getID() + ".png");
				IMG8.setImage(image);
			}
			if(formation343.getRW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getRW().getID() + ".png");
				IMG9.setImage(image);
			}
			if(formation343.getST() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getST().getID() + ".png");
				IMG10.setImage(image);
			}
			
		}	
		ArrayList<Formation> forms = new ArrayList<Formation>();
		forms.add(new Form343(MainGame.game.getUser().getTeam()));
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
   					form.setValue(newValue);
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
		
		IMG1.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG1.setImage(image);
					if(formation instanceof Form343){
						formation.setCB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG2.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG2.setImage(image);
					if(formation instanceof Form343){
						formation.setLB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG3.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG3.setImage(image);
					if(formation instanceof Form343){
						formation.setRB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG4.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG4.setImage(image);
					if(formation instanceof Form343){
						formation.setCM1((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG5.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG5.setImage(image);
					if(formation instanceof Form343){
						formation.setCM2((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG6.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG6.setImage(image);
					if(formation instanceof Form343){
						formation.setRM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG7.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG7.setImage(image);
					if(formation instanceof Form343){
						formation.setLM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG8.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG8.setImage(image);
					if(formation instanceof Form343){
						formation.setLW((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG9.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				if(player instanceof Fieldplayer){
					Fieldplayer fieldplayer = (Fieldplayer) player;
					Image image = new Image("/data/base/players/pictures/" + fieldplayer.getID() + ".png");
					IMG9.setImage(image);
					if(formation instanceof Form343){
						formation.setRW((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
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
					if(formation instanceof Form343){
						formation.setST((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
					}
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					playertable.getSelectionModel().selectFirst();
				}
			}
		});
		
		IMG1.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG1 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG2.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG2 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG3.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG3 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG4.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG4 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG5.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG5 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG6.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG6 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG7.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG7 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG8.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG8 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG9.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG9 && event.getDragboard().hasString()) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
			
		IMG10.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG10 && event.getDragboard().hasString()) {
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
	protected void handleReturnTeamBuilder() throws IOException {
		TeamBuilderController.start();
	}
	
}
