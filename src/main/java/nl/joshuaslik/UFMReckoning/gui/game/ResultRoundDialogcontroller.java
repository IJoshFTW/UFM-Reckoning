package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import nl.joshuaslik.UFMReckoning.gui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ResultRoundDialogcontroller {
	
	@FXML
	private Button okbutton;
	
	
	@FXML
	protected void handleOK(ActionEvent event) throws IOException {
		Stage stage = (Stage) okbutton.getScene().getWindow();
		stage.close();
	}
	
	public static void start() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Class.class
				.getResource("/data/gui/pages-game/ResultRoundDialog.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage dialogStage = new Stage(StageStyle.UNDECORATED);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(Main.stage);
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.show();
		Playrounds.start();
	}

}