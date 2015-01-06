package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UsernameController {
	@FXML
	private Button cancelbutton;
	
	@FXML
	protected void handleReturnMainMenu(ActionEvent event) throws IOException {
		System.out.println("btn_ReturnMainMenu pressed");
		System.out.println(event.getSource());
		
		Stage stage = (Stage) cancelbutton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	protected void handleUsername(ActionEvent event) throws IOException {
		System.out.println("btn_OK pressed");
		System.out.println(event.getSource());

		NewGameController.start();
		Stage stage = (Stage) cancelbutton.getScene().getWindow();
		stage.close();
	}

}
