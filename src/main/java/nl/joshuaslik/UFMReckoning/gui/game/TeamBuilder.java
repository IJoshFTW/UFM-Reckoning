package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TeamBuilder {
	private static Team team;

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		
		Pane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/TeamBuilder.fxml"));
		
		Image teamLogoImg = new Image("/data/base/teams/pictures/ajax.png");
		ImageView teamLogoImgView = new ImageView();
		teamLogoImgView.prefHeight(300);
		teamLogoImgView.prefWidth(300);
		teamLogoImgView.setLayoutX(10);
		teamLogoImgView.setLayoutY(10);
		
		root.getChildren().addAll(teamLogoImgView);
		
		Scene scene = new Scene(root, 1080, 1920);
		Main.setScene(scene);
		Main.stage.setFullScreen(true);
	}

}
