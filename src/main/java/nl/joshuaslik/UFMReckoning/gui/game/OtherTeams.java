package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**5
 * @author Bryan van Wijk
 *
 */
public class OtherTeams {


	public static void start() throws IOException {	
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/OtherTeams.fxml"));
		AnchorPane topmenu = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/TopMenu.fxml"));
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		topmenu.setPrefWidth(visualBounds.getWidth());
		Label label = (Label) topmenu.lookup("#title");
		label.setText("Other Teams");
		Main.setCenter(scene);
		Main.setTop(topmenu);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}
	
	
}