package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
		
		try {
			Image teamLogoImg = new Image("/data/base/teams/pictures/" + team.getTeamName() + ".png");
			ImageView teamLogoImgView = new ImageView();
			teamLogoImgView.setImage(teamLogoImg);
			teamLogoImgView.prefHeight(300);
			teamLogoImgView.prefWidth(300);
			teamLogoImgView.setLayoutX(1050);
			teamLogoImgView.setLayoutY(260);
		
			root.getChildren().addAll(teamLogoImgView);
		}
		
		catch(Exception e) {
			System.out.println("TEAMLOGO NOT FOUND!");
		}
		
		Image atkPwrImg = new Image("/data/gui/img/attackpowerbar.png");
		ImageView atkPwrImgView = new ImageView();
		atkPwrImgView.setImage(atkPwrImg);
		atkPwrImgView.prefHeight(20);
		atkPwrImgView.prefWidth(team.getAttackPower()/3);
		atkPwrImgView.setFitWidth(team.getAttackPower()/3);
		atkPwrImgView.setLayoutX(1140);
		atkPwrImgView.setLayoutY(580);
		
		Image defPwrImg = new Image("/data/gui/img/defencepowerbar.png");
		ImageView defPwrImgView = new ImageView();
		defPwrImgView.setImage(defPwrImg);
		defPwrImgView.prefHeight(20);
		defPwrImgView.prefWidth(team.getDefencePower()/3);
		defPwrImgView.setFitWidth(team.getDefencePower()/3);
		defPwrImgView.setLayoutX(1140);
		defPwrImgView.setLayoutY(610);
		
		Image staminaImg = new Image("/data/gui/img/staminabar.png");
		ImageView staminaImgView = new ImageView();
		staminaImgView.setImage(staminaImg);
		staminaImgView.prefHeight(20);
		staminaImgView.prefWidth(team.getStamina()/3);
		staminaImgView.setFitWidth(team.getStamina()/3);
		staminaImgView.setLayoutX(1140);
		staminaImgView.setLayoutY(640);
		
		Font statsFont = new Font(20);
		statsFont.loadFont("/data/gui/pages-menu/fonts/Quicksand.otf", 20);
		
		Text totalGames = new Text("not implemented");
		totalGames.prefHeight(20);
		totalGames.setFont(statsFont);
		totalGames.setLayoutX(1202);
		totalGames.setLayoutY(687);
		
		Text totalWins = new Text(Integer.toString(team.getTotalWins()));
		totalWins.prefHeight(20);
		totalWins.setFont(statsFont);
		totalWins.setLayoutX(1122);
		totalWins.setLayoutY(718);
		
		Text totalLosses = new Text(Integer.toString(team.getTotalLosses()));
		totalLosses.prefHeight(20);
		totalLosses.setFont(statsFont);
		totalLosses.setLayoutX(1136);
		totalLosses.setLayoutY(748);
		
		Text totalDraws = new Text(Integer.toString(team.getTotalDraws()));
		totalDraws.prefHeight(20);
		totalDraws.setFont(statsFont);
		totalDraws.setLayoutX(1134);
		totalDraws.setLayoutY(778);
		
		Text totalGoals = new Text(Integer.toString(team.getTotalGoals()));
		totalGoals.prefHeight(20);
		totalGoals.setFont(statsFont);
		totalGoals.setLayoutX(1130);
		totalGoals.setLayoutY(808);
		
		root.getChildren().addAll(atkPwrImgView, defPwrImgView, staminaImgView, totalGames, totalWins, totalLosses, totalDraws, totalGoals);
		
		Scene scene = new Scene(root, 1080, 1920);
		Main.setScene(scene);
		Main.stage.setFullScreen(true);
	}

}
