package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Main extends Application {

	public static Stage stage;
	private static BorderPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
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

	public static void setScene(Scene scn) {
		stage.setScene(scn);
	}

	public static void setCenter(AnchorPane pane) {
		rootLayout.setCenter(pane);
	
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

}
