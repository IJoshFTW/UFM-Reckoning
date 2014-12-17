package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class NewGame {
	/*
	 * Start
	 * Text, buttons en textfield + events die bij de scene horen
	 */
	public static void start() {
		
		Text t = new Text(400, 300, "Enter your name");
		t.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 60));
		Button btn_Submit = new Button("Submit");
		btn_Submit.setPrefHeight(100);
		btn_Submit.setPrefWidth(400);
		
		TextField txt = new TextField();
		txt.setMaxWidth(250);
		
		//submit button
		btn_Submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				t.setText("Loading...");
				String username = txt.getText();
				NewGame2.start(username);
			}
		});
		
		//return button
		Button btn_Return = new Button("Return");
		btn_Return.setPrefHeight(100);
		btn_Return.setPrefWidth(400);
		btn_Return.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				t.setText("Loading...");
				try {
					MainMenu.start();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		});

		VBox root = new VBox();
		root.getChildren().addAll(t, txt, btn_Submit, btn_Return);

		Scene scene = new Scene(root, 1080, 1920);
		scene.getStylesheets().add("/data/GUI/pages-menu/NewGame.css");
		Main.stage.setScene(scene);
		Main.stage.setFullScreen(true);
		
	}
}