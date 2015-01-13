package nl.joshuaslik.tudelft.UFMGame.gui.game;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.util.Callback;
import javafx.util.StringConverter;
import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;
import nl.joshuaslik.tudelft.UFMGame.backend.Player;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form343;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form4321;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form433;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form442;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form532;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Formation;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

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
	private Label LB1, LB2, LB3, LB4, LB5, LB6, LB7, LB8, LB9, LB10, attack, stamina, defence, diving, reflexes, positioning;
	@FXML
	private AnchorPane POS1, POS2, POS3, POS4, POS5, POS6, POS7, POS8, POS9, POS10, field;
	@FXML
	private ImageView IMG1, IMG2, IMG3, IMG4, IMG5, IMG6, IMG7, IMG8, IMG9, IMG10, gkIMG;
	@FXML
	private TableColumn<Player, String> name, country, position, captain;
	
	@FXML
	private void initialize(){
		
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
					ArrayList<Player> playerslist = team.getBenchPlayers();
					observablelistplayers = FXCollections.observableArrayList(playerslist);
					playertable.setItems(observablelistplayers);
					initField();
				}   
   	});
   	initField();
	ArrayList<Player> playerslist = team.getBenchPlayers();
	observablelistplayers = FXCollections.observableArrayList(playerslist);
	playertable.setItems(observablelistplayers);
	stamina.setText(""+team.getStamina());
	defence.setText(""+team.getDefencePower());
	attack.setText(""+team.getAttackPower());
	
	name.setCellValueFactory(new PropertyValueFactory<Player, String>(
			"fullName"));
	country.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"country"));
	position.setCellValueFactory(new PropertyValueFactory<Player, String>(
				"position"));
	
	playertable.setOnDragDetected(new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent event){
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
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343){
					formation.setCB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321 || formation instanceof Form433 || formation instanceof Form442 || formation instanceof Form532){
					formation.setLB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG2.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343){
					formation.setLB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321 || formation instanceof Form433 || formation instanceof Form442 || formation instanceof Form532){
					formation.setCB1((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG3.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343){
					formation.setRB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321 || formation instanceof Form433 || formation instanceof Form442 || formation instanceof Form532){
					formation.setCB2((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());;
			}
		});
		
		IMG4.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343){
					formation.setCM1((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321 || formation instanceof Form433 || formation instanceof Form442){
					formation.setRB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form532){
					formation.setCB3((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG5.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343){
					formation.setCM2((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321 || formation instanceof Form433){
					formation.setCM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form442){
					formation.setCM1((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form532){
					formation.setRB((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG6.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343 || formation instanceof Form4321 || formation instanceof Form433){
					formation.setRM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form442){
					formation.setCM2((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form532){
					formation.setCM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG7.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343 || formation instanceof Form4321 || formation instanceof Form433){
					formation.setLM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form442 || formation instanceof Form532){
					formation.setRM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG8.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343 || formation instanceof Form433){
					formation.setLW((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321){
					formation.setOLM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form442 || formation instanceof Form532){
					formation.setLM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG9.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343 || formation instanceof Form433 || formation instanceof Form532 || formation instanceof Form442){
					formation.setRW((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form4321){
					formation.setORM((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		IMG10.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Fieldplayer fieldplayer = (Fieldplayer) player;
				if(formation instanceof Form343 || formation instanceof Form433 || formation instanceof Form4321 ){
					formation.setST((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				else if(formation instanceof Form532 || formation instanceof Form442){
					formation.setLW((Fieldplayer) MainGame.game.getPlayer(fieldplayer.getID()));
				}
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				stamina.setText(""+team.getStamina());
				defence.setText(""+team.getDefencePower());
				attack.setText(""+team.getAttackPower());
			}
		});
		
		gkIMG.setOnDragDropped(new EventHandler<DragEvent>(){
			@Override
			public void handle(DragEvent event){
				Player player = MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString());
				Goalkeeper goalkeeper = (Goalkeeper) player;
				formation.setGoalkeeper((Goalkeeper) MainGame.game.getPlayer(goalkeeper.getID()));
				initField();
				ArrayList<Player> playerslist = team.getBenchPlayers();
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				observablelistplayers = FXCollections.observableArrayList(playerslist);
				playertable.setItems(observablelistplayers);
				playertable.getSelectionModel().selectFirst();
				diving.setText("Diving: "+goalkeeper.getDiving());
				positioning.setText("Positioning: "+goalkeeper.getPositioning());
				reflexes.setText("Reflexes: "+goalkeeper.getReflexes());
			}
		});
		
		IMG1.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG1 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG2.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG2 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG3.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG3 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG4.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG4 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG5.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG5 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG6.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG6 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG7.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG7 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG8.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG8 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		IMG9.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG9 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
			
		IMG10.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != IMG10 && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Fieldplayer)) {
		            event.acceptTransferModes(TransferMode.MOVE);
		        }
		    }
		});
		
		gkIMG.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        if (event.getGestureSource() != gkIMG && event.getDragboard().hasString() && (MainGame.game.getPlayer(Dragboard.getSystemClipboard().getString()) instanceof Goalkeeper)) {
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
	
	public void initField(){
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
		if(formation.getGoalkeper() != null){
			Image image = new Image("/data/base/players/pictures/" + formation.getGoalkeper().getID() + ".png");
			gkIMG.setImage(image);
			gkIMG.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
						try {
							ViewPlayer.start(formation.getGoalkeper());
						} catch (IOException e) {
							e.printStackTrace();
						}
	            }
	        });
		}
		if(formation instanceof Form343){
			Form343 formation343 = (Form343) formation;
			LB1.setText("CB");
			LB2.setText("LB");
			LB3.setText("RB");
			LB4.setText("CM1");
			LB5.setText("CM2");
			LB6.setText("RM");
			LB7.setText("LM");
			LB8.setText("LW");
			LB9.setText("RW");
			LB10.setText("ST");
			AnchorPane.setTopAnchor(POS10, 59.0);
			AnchorPane.setLeftAnchor(POS10, 171.0);
			AnchorPane.setTopAnchor(POS9, 114.0);
			AnchorPane.setLeftAnchor(POS9, 279.0);
			AnchorPane.setTopAnchor(POS8, 114.0);
			AnchorPane.setLeftAnchor(POS8, 66.0);
			AnchorPane.setTopAnchor(POS7, 226.0);
			AnchorPane.setLeftAnchor(POS7, 33.0);
			AnchorPane.setTopAnchor(POS6, 226.0);
			AnchorPane.setLeftAnchor(POS6, 307.0);
			AnchorPane.setTopAnchor(POS5, 284.0);
			AnchorPane.setLeftAnchor(POS5, 229.0);
			AnchorPane.setTopAnchor(POS4, 284.0);
			AnchorPane.setLeftAnchor(POS4, 117.0);
			AnchorPane.setTopAnchor(POS3, 388.0);
			AnchorPane.setLeftAnchor(POS3, 279.0);
			AnchorPane.setTopAnchor(POS2, 384.0);
			AnchorPane.setLeftAnchor(POS2, 56.0);
			AnchorPane.setTopAnchor(POS1, 430.0);
			AnchorPane.setLeftAnchor(POS1, 171.0);
			if(formation343.getCB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getCB().getID() + ".png");
				IMG1.setImage(image);
				IMG1.setOnDragDetected(new EventHandler<MouseEvent>(){
					@Override
					public void handle(MouseEvent event){
						Dragboard dragBoard = playertable.startDragAndDrop(TransferMode.MOVE); 
						ClipboardContent content = new ClipboardContent();
						content.putString(formation343.getCB().getID()); 
						dragBoard.setContent(content);
						IMG1.setImage(null);
						formation343.setCB(null);
					}
				});
				IMG1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getCB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getLB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getLB().getID() + ".png");
				IMG2.setImage(image);
				IMG2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getLB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getRB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getRB().getID() + ".png");
				IMG3.setImage(image);
				IMG3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getRB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getCM1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getCM1().getID() + ".png");
				IMG4.setImage(image);
				IMG4.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getCM1());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getCM2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getCM2().getID() + ".png");
				IMG5.setImage(image);
				IMG5.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getCM2());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getRM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getRM().getID() + ".png");
				IMG6.setImage(image);
				IMG6.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getRM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getLM().getID() + ".png");
				IMG7.setImage(image);
				IMG7.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getLM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getLW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getLW().getID() + ".png");
				IMG8.setImage(image);
				IMG8.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getLW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getRW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getRW().getID() + ".png");
				IMG9.setImage(image);
				IMG9.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getRW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation343.getST() != null){
				Image image = new Image("/data/base/players/pictures/" + formation343.getST().getID() + ".png");
				IMG10.setImage(image);
				IMG10.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation343.getST());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}		
		}	
		else if(formation instanceof Form4321){
			Form4321 formation4321 = (Form4321) formation;
			LB1.setText("LB");
			LB2.setText("CB1");
			LB3.setText("CB2");
			LB4.setText("RB");
			LB5.setText("CM");
			LB6.setText("RM");
			LB7.setText("LM");
			LB8.setText("OLM");
			LB9.setText("ORM");
			LB10.setText("ST");
			AnchorPane.setTopAnchor(POS10, 81.0);
			AnchorPane.setLeftAnchor(POS10, 171.0);
			AnchorPane.setTopAnchor(POS9, 174.0);
			AnchorPane.setLeftAnchor(POS9, 239.0);
			AnchorPane.setTopAnchor(POS8, 174.0);
			AnchorPane.setLeftAnchor(POS8, 111.0);
			AnchorPane.setTopAnchor(POS7, 274.0);
			AnchorPane.setLeftAnchor(POS7, 55.0);
			AnchorPane.setTopAnchor(POS6, 274.0);
			AnchorPane.setLeftAnchor(POS6, 292.0);
			AnchorPane.setTopAnchor(POS5, 334.0);
			AnchorPane.setLeftAnchor(POS5, 175.0);
			AnchorPane.setTopAnchor(POS4, 388.0);
			AnchorPane.setLeftAnchor(POS4, 308.0);
			AnchorPane.setTopAnchor(POS3, 434.0);
			AnchorPane.setLeftAnchor(POS3, 223.0);
			AnchorPane.setTopAnchor(POS2, 434.0);
			AnchorPane.setLeftAnchor(POS2, 117.0);
			AnchorPane.setTopAnchor(POS1, 384.0);
			AnchorPane.setLeftAnchor(POS1, 33.0);

			if(formation4321.getLB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getLB().getID() + ".png");
				IMG1.setImage(image);
				IMG1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getLB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getCB1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getCB1().getID() + ".png");
				IMG2.setImage(image);
				IMG2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getCB1());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getCB2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getCB2().getID() + ".png");
				IMG3.setImage(image);
				IMG3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getCB2());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getRB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getRB().getID() + ".png");
				IMG4.setImage(image);
				IMG4.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getRB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getCM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getCM().getID() + ".png");
				IMG5.setImage(image);
				IMG5.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getCM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getRM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getRM().getID() + ".png");
				IMG6.setImage(image);
				IMG6.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getRM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getLM().getID() + ".png");
				IMG7.setImage(image);
				IMG7.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getLM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getOLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getOLM().getID() + ".png");
				IMG8.setImage(image);
				IMG8.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getOLM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getORM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getORM().getID() + ".png");
				IMG9.setImage(image);
				IMG9.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getORM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation4321.getST() != null){
				Image image = new Image("/data/base/players/pictures/" + formation4321.getST().getID() + ".png");
				IMG10.setImage(image);
				IMG10.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation4321.getST());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}		
		}
		else if(formation instanceof Form433){
			Form433 formation433 = (Form433) formation;
			LB1.setText("LB");
			LB2.setText("CB1");
			LB3.setText("CB2");
			LB4.setText("RB");
			LB5.setText("CM");
			LB6.setText("RM");
			LB7.setText("LM");
			LB8.setText("LW");
			LB9.setText("RW");
			LB10.setText("ST");
			AnchorPane.setTopAnchor(POS10, 59.0);
			AnchorPane.setLeftAnchor(POS10, 171.0);
			AnchorPane.setTopAnchor(POS9, 101.0);
			AnchorPane.setLeftAnchor(POS9, 279.0);
			AnchorPane.setTopAnchor(POS8, 101.0);
			AnchorPane.setLeftAnchor(POS8, 56.0);
			AnchorPane.setTopAnchor(POS7, 242.0);
			AnchorPane.setLeftAnchor(POS7, 56.0);
			AnchorPane.setTopAnchor(POS6, 242.0);
			AnchorPane.setLeftAnchor(POS6, 290.0);
			AnchorPane.setTopAnchor(POS5, 284.0);
			AnchorPane.setLeftAnchor(POS5, 172.0);
			AnchorPane.setTopAnchor(POS4, 388.0);
			AnchorPane.setLeftAnchor(POS4, 308.0);
			AnchorPane.setTopAnchor(POS3, 434.0);
			AnchorPane.setLeftAnchor(POS3, 223.0);
			AnchorPane.setTopAnchor(POS2, 434.0);
			AnchorPane.setLeftAnchor(POS2, 117.0);
			AnchorPane.setTopAnchor(POS1, 384.0);
			AnchorPane.setLeftAnchor(POS1, 33.0);
			if(formation433.getLB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getLB().getID() + ".png");
				IMG1.setImage(image);
				IMG1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getLB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getCB1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getCB1().getID() + ".png");
				IMG2.setImage(image);
				IMG2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getCB1());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getCB2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getCB2().getID() + ".png");
				IMG3.setImage(image);
				IMG3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getCB2());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getRB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getRB().getID() + ".png");
				IMG4.setImage(image);
				IMG4.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getRB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getCM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getCM().getID() + ".png");
				IMG5.setImage(image);
				IMG5.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getCM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getRM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getRM().getID() + ".png");
				IMG6.setImage(image);
				IMG6.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getRM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getLM().getID() + ".png");
				IMG7.setImage(image);
				IMG7.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getLM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getLW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getLW().getID() + ".png");
				IMG8.setImage(image);
				IMG8.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getLW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getRW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getRW().getID() + ".png");
				IMG9.setImage(image);
				IMG9.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getRW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation433.getST() != null){
				Image image = new Image("/data/base/players/pictures/" + formation433.getST().getID() + ".png");
				IMG10.setImage(image);
				IMG10.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation433.getST());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}		
		}
		else if(formation instanceof Form442){
			Form442 formation442 = (Form442) formation;
			LB1.setText("LB");
			LB2.setText("CB1");
			LB3.setText("CB2");
			LB4.setText("RB");
			LB5.setText("CM1");
			LB6.setText("CM2");
			LB7.setText("RM");
			LB8.setText("LM");
			LB9.setText("RW");
			LB10.setText("LW");
			AnchorPane.setTopAnchor(POS10, 88.0);
			AnchorPane.setLeftAnchor(POS10, 85.0);
			AnchorPane.setTopAnchor(POS9, 88.0);
			AnchorPane.setLeftAnchor(POS9, 262.0);
			AnchorPane.setTopAnchor(POS8, 226.0);
			AnchorPane.setLeftAnchor(POS8, 33.0);
			AnchorPane.setTopAnchor(POS7, 226.0);
			AnchorPane.setLeftAnchor(POS7, 307.0);
			AnchorPane.setTopAnchor(POS6, 284.0);
			AnchorPane.setLeftAnchor(POS6, 229.0);
			AnchorPane.setTopAnchor(POS5, 284.0);
			AnchorPane.setLeftAnchor(POS5, 117.0);
			AnchorPane.setTopAnchor(POS4, 388.0);
			AnchorPane.setLeftAnchor(POS4, 308.0);
			AnchorPane.setTopAnchor(POS3, 434.0);
			AnchorPane.setLeftAnchor(POS3, 223.0);
			AnchorPane.setTopAnchor(POS2, 434.0);
			AnchorPane.setLeftAnchor(POS2, 117.0);
			AnchorPane.setTopAnchor(POS1, 384.0);
			AnchorPane.setLeftAnchor(POS1, 33.0);
			if(formation442.getLB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getLB().getID() + ".png");
				IMG1.setImage(image);
				IMG1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getLB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getCB1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getCB1().getID() + ".png");
				IMG2.setImage(image);
				IMG2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getCB1());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getCB2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getCB2().getID() + ".png");
				IMG3.setImage(image);
				IMG3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getCB2());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getRB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getRB().getID() + ".png");
				IMG4.setImage(image);
				IMG4.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getRB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getCM1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getCM1().getID() + ".png");
				IMG5.setImage(image);
				IMG5.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getCM1());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getCM2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getCM2().getID() + ".png");
				IMG6.setImage(image);
				IMG6.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getCM2());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getRM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getRM().getID() + ".png");
				IMG7.setImage(image);
				IMG7.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getRM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getLM().getID() + ".png");
				IMG8.setImage(image);
				IMG8.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getLM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getRW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getRW().getID() + ".png");
				IMG9.setImage(image);
				IMG9.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getRW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation442.getLW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation442.getLW().getID() + ".png");
				IMG10.setImage(image);
				IMG10.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation442.getLW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
		}
		else if(formation instanceof Form532){
			Form532 formation532 = (Form532) formation;
			LB1.setText("LB");
			LB2.setText("CB1");
			LB3.setText("CB2");
			LB4.setText("CB3");
			LB5.setText("RB");
			LB6.setText("CM");
			LB7.setText("RM");
			LB8.setText("LM");
			LB9.setText("RW");
			LB10.setText("LW");
			AnchorPane.setTopAnchor(POS10, 87.0);
			AnchorPane.setLeftAnchor(POS10, 111.0);
			AnchorPane.setTopAnchor(POS9, 87.0);
			AnchorPane.setLeftAnchor(POS9, 229.0);
			AnchorPane.setTopAnchor(POS8, 227.0);
			AnchorPane.setLeftAnchor(POS8, 72.0);
			AnchorPane.setTopAnchor(POS7, 227.0);
			AnchorPane.setLeftAnchor(POS7, 271.0);
			AnchorPane.setTopAnchor(POS6, 284.0);
			AnchorPane.setLeftAnchor(POS6, 172.0);
			AnchorPane.setTopAnchor(POS5, 350.0);
			AnchorPane.setLeftAnchor(POS5, 310.0);
			AnchorPane.setTopAnchor(POS4, 419.0);
			AnchorPane.setLeftAnchor(POS4, 260.0);
			AnchorPane.setTopAnchor(POS3, 438.0);
			AnchorPane.setLeftAnchor(POS3, 172.0);
			AnchorPane.setTopAnchor(POS2, 419.0);
			AnchorPane.setLeftAnchor(POS2, 84.0);
			AnchorPane.setTopAnchor(POS1, 346.0);
			AnchorPane.setLeftAnchor(POS1, 33.0);
			if(formation532.getLB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getLB().getID() + ".png");
				IMG1.setImage(image);
				IMG1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getLB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getCB1() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getCB1().getID() + ".png");
				IMG2.setImage(image);
				IMG2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getCB1());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getCB2() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getCB2().getID() + ".png");
				IMG3.setImage(image);
				IMG3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getCB2());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getCB3() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getCB3().getID() + ".png");
				IMG4.setImage(image);
				IMG4.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getCB3());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getRB() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getRB().getID() + ".png");
				IMG5.setImage(image);
				IMG5.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getRB());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getCM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getCM().getID() + ".png");
				IMG6.setImage(image);
				IMG6.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getCM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getRM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getRM().getID() + ".png");
				IMG7.setImage(image);
				IMG7.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getRM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getLM() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getLM().getID() + ".png");
				IMG8.setImage(image);
				IMG8.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getLM());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getRW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getRW().getID() + ".png");
				IMG9.setImage(image);
				IMG9.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getRW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
			if(formation532.getLW() != null){
				Image image = new Image("/data/base/players/pictures/" + formation532.getLW().getID() + ".png");
				IMG10.setImage(image);
				IMG10.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
							try {
								ViewPlayer.start(formation532.getLW());
							} catch (IOException e) {
								e.printStackTrace();
							}
		            }
		        });
			}
		}
	}
	
	@FXML
	protected void handleReturnTeamBuilder() throws IOException {
		TeamBuilderController.start();
	}
	
	@FXML
	protected void handleViewPlayer() throws IOException {
		ViewPlayer.start(selectedplayer);
	}
	
	@FXML
	protected void handleActiveplayerview() throws IOException{
		ViewPlayer.start(selectedplayer);
	}
	
}
