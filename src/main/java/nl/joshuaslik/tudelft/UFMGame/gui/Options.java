package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCombination;
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

	/**
	 * Loads the option page.
	 * @throws IOException is thrown if the FXML file cannot be parsed. 
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Options.fxml"));
		Main.setCenter(scene);
		Topbar.start("Options");
	}
	
	/**
	 * initialize the page
	 */
	@FXML
	private void initialize() {
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
	 * handles return button
	 * @throws IOException is thrown when the fxml cannot be read
	 */
	@FXML
	protected void handleReturn() throws IOException {
		MainMenu.start();
	}

}
