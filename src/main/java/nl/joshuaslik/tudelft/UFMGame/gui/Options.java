package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Class to implement different options for the game
 * @author Sander Benoist
 * @author Naomi de Ridder
 */
public class Options {
	@FXML
	private CheckBox checkboxfullscreen;

	@FXML
	private Button startgame;

	@FXML
	private Button newgame;

	@FXML
	private Button loadgame;

	/**
	 * Methods to control what happens on mouse-over. 
	 */
	@FXML
	private void initialize() {
		startgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		newgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		loadgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		startgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		newgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		loadgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		
		checkboxfullscreen.setSelected(Main.fullscreen);
		checkboxfullscreen.selectedProperty().addListener(new ChangeListener<Boolean> () {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            	Main.fullscreen = newValue;
            	BorderPane rootLayout = null;
            	AnchorPane page = null;
				try {
					rootLayout = (BorderPane) FXMLLoader.load(Class.class
							.getResource("/data/gui/pages-menu/RootLayout.fxml"));
					
					page = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Options.fxml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rootLayout.setCenter(page);
				Main.rootLayout = rootLayout;
        		Main.stage.setTitle("Ultimate Football Manager");
        		Scene scene = new Scene(rootLayout);
            	if(newValue){
           			Main.stage.setScene(scene);
        			Main.stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        			Main.stage.setFullScreen(true);
 
        			
        		}else{
        			ScrollPane scroll = new ScrollPane();
        			scroll.setContent(rootLayout);
        			scroll.setPrefSize(1000.0, 700.0);
        			scene = new Scene(scroll);
        			Main.stage.setScene(scene);
        		}
            }     
        });
	}

	/**
	 * Handles clicking on the new game button
	 * @param event of clicking on the button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleNewGame(ActionEvent event) throws IOException {
		UsernameController.start();
	}

	/**
	 * Handles clicking on the load game button
	 * @param event that occurs after clicking on the button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleLoadGame(ActionEvent event) throws IOException {
		LoadGameController.start();
	}

	/**
	 * Handles clicking on the options button
	 * @param event of clicking on the options button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleOptions(ActionEvent event) throws IOException {
		Options.start();
	}

	/**
	 * Handles clicking on the highscores button
	 * @param event of clicking on the highscores button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleHighscores(ActionEvent event) throws IOException {
		Highscores.start();
	}

	/**
	 * Handles clicking on the quite button
	 * @param event clicking on the quite button
	 */
	@FXML
	protected void handleQuitMenu(ActionEvent event) {
		System.exit(0);
	}
	/**
	 * Loads the option page.
	 * @throws IOException is thrown if the FXML file cannot be parsed. 
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Options.fxml"));
		Main.setCenter(scene);
	}
	
	/**
	 * handles return button
	 * @throws IOException is thrown when the fxml cannot be read
	 */
	@FXML
	protected void handleReturn() throws IOException {
		MainMenu.start();
	}
	
	/**
	 * Handles clicking on the start button
	 * @param event of clicking on the start button
	 * @throws IOException is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleStart(ActionEvent event) throws IOException {
		MainMenu.start();
	}

}
