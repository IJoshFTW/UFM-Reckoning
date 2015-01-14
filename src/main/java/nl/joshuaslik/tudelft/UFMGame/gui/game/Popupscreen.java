package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.util.Duration;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;


public class Popupscreen {

	private static Popup popup;
	private static AnchorPane page;
	
	@FXML
	private void initialize(){
		
	}
	
	public static void start(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/Popup.fxml"));
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.0);
		ft.setToValue(0.97);
		ft.play();
		popup = new Popup();
		popup.getContent().add(page);
		popup.show(Main.stage);
	}
	
	public static void setTitle(String input){
		Label changetitle = (Label) page.lookup("#title");
		changetitle.setText(input);
	}
	
	public static void setMessage(String input){
		Text text = new Text(input);
	    text.setFill(Color.WHITE);
	    text.setFont(Font.font(20));
	    TextFlow message  = new TextFlow(text);
	    AnchorPane.setTopAnchor(message, 99.0);
	    AnchorPane.setLeftAnchor(message, 0.0);
	    AnchorPane.setRightAnchor(message, 0.0);
		message.setTextAlignment(TextAlignment.CENTER);
	    page.getChildren().add(message);
	}
	
	@FXML
	protected void handleOK() {
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}
}
