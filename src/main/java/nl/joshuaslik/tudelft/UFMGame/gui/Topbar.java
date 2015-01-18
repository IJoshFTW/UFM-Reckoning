package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Topbar {
	private static String title;
	@FXML
	private Label page;
	
	@FXML
	private void initialize() {
		page.setText(title);
	}
	
	public static void start(String name) throws IOException{
		title = name;
		AnchorPane top = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-menu/TopBar.fxml"));
		Main.setTop(top);
	}

}
