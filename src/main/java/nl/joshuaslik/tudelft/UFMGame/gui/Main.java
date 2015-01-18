package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * The main screne for the application
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Main extends Application {

	/**
	 * Create new variables
	 */
	public static Stage stage;
	public static BorderPane rootLayout;
	public static boolean fullscreen;
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Method to load the rootlayout of the game
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.loadFonts();
		rootLayout = (BorderPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-menu/RootLayout.fxml"));
		primaryStage.setTitle("Ultimate Football Manager");
		Scene scene = new Scene(rootLayout);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		primaryStage.setFullScreen(true);

		primaryStage.setScene(scene);
		
		primaryStage.show();
		stage = primaryStage;
		MainMenu.start();
	}
	
	/**
	 * Sets te scene of main
	 * 
	 * @param scn
	 */
	public static void setScene(Scene scn) {
		stage.setScene(scn);
	}

	/**
	 * Set the center of the border pane 
	 * @param scene to be displayed in the center
	 */
	public static void setCenter(AnchorPane scene) {
		rootLayout.setCenter(scene);
	}

	/**
	 * Sets the Top of the border pane
	 * @param pane to be displayed in the top of the screen
	 */
	public static void setTop(AnchorPane pane) {
		rootLayout.setTop(pane);
	}

	/**
	 * Sets the bottom of the border pane
	 * @param pane to be displayed in the bottom
	 */
	public static void setBottom(AnchorPane pane) {
		rootLayout.setBottom(pane);
	}

	/**
	 * Get the stage of the game
	 * @return current stage
	 */
	public static Stage stage() {
		return stage;
	}

	/**
	 * Method to load the quicksand font
	 */
	public static void loadFonts() {
		Font.loadFont(Class.class.getResource("/data/gui/fonts/Quicksand.ttf")
				.toExternalForm(), 10);
	}

}
