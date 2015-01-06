package nl.joshuaslik.UFMReckoning.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsernameController {
	@FXML
	private Button cancelbutton;
	private TextField usertextfield;
	
	@FXML
	protected void handleUsername(ActionEvent event) throws IOException {
		System.out.println("btn_OK pressed");
		System.out.println(event.getSource());

		String username = usertextfield.getText();
		if (username.length()>0) {
			NewGameController.start(username);
			Stage stage = (Stage) cancelbutton.getScene().getWindow();
			stage.close();
		}
		else {
			//t2.setText("Your name should at least have one character!");
		}
	}
	
	@FXML
	protected void handleReturnMainMenu(ActionEvent event) throws IOException {
		System.out.println("btn_ReturnMainMenu pressed");
		System.out.println(event.getSource());
		
		Stage stage = (Stage) cancelbutton.getScene().getWindow();
		stage.close();
	}

}
