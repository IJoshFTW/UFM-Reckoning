package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
	private static BorderPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.loadFonts();
		rootLayout = (BorderPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-menu/RootLayout.fxml"));
		primaryStage.setFullScreen(true);
		primaryStage.getIcons().add(
				new Image("file:recources/images/Address_book.png"));
		primaryStage.setTitle("Ultimate Football Manager");
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		Scene scene = new Scene(rootLayout);
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

	public static void setCenter(AnchorPane scene) {
		rootLayout.setCenter(scene);
	}

	public static void setTop(AnchorPane pane) {
		rootLayout.setTop(pane);
	}

	public static void setBottom(AnchorPane pane) {
		rootLayout.setBottom(pane);
	}

	public static Stage stage() {
		return stage;
	}

	public static void loadFonts() {
		Font.loadFont(Class.class.getResource("/data/gui/fonts/Quicksand.ttf")
				.toExternalForm(), 10);
	}

}
