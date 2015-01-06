package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.joshuaslik.UFMReckoning.gui.MainMenu;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TeamBuilderController {

	@FXML
	protected void handleChangeSetup(ActionEvent event) throws IOException {
		ChangeSetup.start();
	}
	
	@FXML
	protected void handleViewPlayer(ActionEvent event) throws IOException {
		MainMenu.start();
	}
	
	@FXML
	protected void handleTransferMarket(ActionEvent event) throws IOException {
		TransferMarket.start();
	}
	
	@FXML
	protected void handlePlayerList(ActionEvent event) throws IOException {
		
	}
	
	@FXML
	protected void handleReturnTeamBuilder(ActionEvent event) throws IOException {
		TeamBuilder.start();
	}
	
	@FXML
	protected void handleSellPlayer(ActionEvent event) {
		
	}
	
	@FXML
	protected void handleBuyPlayer(ActionEvent event) {
		
	}
	
	@FXML
	protected void handlePlayerToField(ActionEvent event) {
		
	}
	
	@FXML
	protected void handlePlayerToBench(ActionEvent event) {
		
	}
}