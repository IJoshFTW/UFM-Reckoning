package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.util.Duration;

public class UsernameController {
	private static Popup popup;
	private static AnchorPane page;
	@FXML
	private Button cancelbutton;
	@FXML
	private Button okbutton;
	@FXML
	private TextField textfield;

	@FXML
	protected void initialize() {
		textfield.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				if (newValue.length() > 1) {
					okbutton.setDisable(false);
				} else {
					okbutton.setDisable(true);
				}
			}
		});
	}

	@FXML
	protected void handleUsername() throws IOException {
		String username = textfield.getText();
		NewGameController.start(username);
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		
		popup.hide();
	}

	@FXML
	protected void handleUsernamekey(KeyEvent event) throws IOException {
		if (event.getCode().equals(KeyCode.ENTER) && !okbutton.isDisabled()) {
			String username = textfield.getText();
			NewGameController.start(username);
			FadeTransition ft = new FadeTransition(Duration.millis(900), page);
			ft.setFromValue(0.97);
			ft.setToValue(0.0);
			ft.play();
			popup.hide();
		}
	}

	@FXML
	protected void handleReturnMainMenu() {
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.97);
		ft.setToValue(0.0);
		ft.play();
		popup.hide();
	}

	public static void start() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-menu/ChooseUsernameDialog.fxml"));
		page = (AnchorPane) loader.load();
		FadeTransition ft = new FadeTransition(Duration.millis(900), page);
		ft.setFromValue(0.0);
		ft.setToValue(0.97);
		ft.play();
		page.setOpacity(0.85);
		popup = new Popup();
		popup.getContent().add(page);
		popup.show(Main.stage);
	}

}
