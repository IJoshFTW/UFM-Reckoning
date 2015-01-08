package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**5
 * @author Naomi de Ridder
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Competition {


	public static void start() throws IOException {	
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/Competition.fxml"));
		AnchorPane topmenu = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/TopMenu.fxml"));
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		topmenu.setPrefWidth(visualBounds.getWidth());
		Label label = (Label) topmenu.lookup("#title");
		label.setText("Competition");
		Main.setCenter(scene);
		Main.setTop(topmenu);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}
	
	/*When pushing this button a new game has to start. In page shownextgame!!
	 * 
	 * @FXML
	protected void handlePlayNextRound(ActionEvent event) throws IOException {
		System.out.println("btn_PlayNextRound pressed");
		System.out.println(event.getSource());
		PlayNextRound.start();
	}*/
}
