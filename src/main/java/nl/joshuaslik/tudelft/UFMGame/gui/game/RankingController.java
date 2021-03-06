package nl.joshuaslik.tudelft.UFMGame.gui.game;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;

/**
 * Class to control the ranking
 * 
 * @author Naomi
 *
 */
public class RankingController {

	@FXML
	private TableView<Team> rankingtable;
	@FXML
	private TableColumn<Team, String> nr, team, totalWins, totalLosses, totalDraws, totalPoints, goals, goalsagainst;

	/**
	 * initialize the page is automatically called after the page is loaded
	 */
	@FXML
	private void initialize() {

		ObservableList<Team> teams = FXCollections
				.observableArrayList(MainGame.game.getTeams());
		rankingtable.setItems(teams);

		nr.setCellValueFactory(new PropertyValueFactory<Team, String>("ranking"));
		team.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"teamName"));
		totalWins.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"totalWins"));
		totalLosses.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"totalLosses"));
		totalDraws.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"totalDraws"));
		totalPoints.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"points"));
		goals.setCellValueFactory(new PropertyValueFactory<Team, String>(
				"totalGoals"));
		goalsagainst
				.setCellValueFactory(new PropertyValueFactory<Team, String>(
						"goalsAgainst"));
		MainGame.game.computeStandings();
		rankingtable.getSortOrder().add(nr);
		nr.setSortable(true);

		rankingtable
				.setRowFactory(new Callback<TableView<Team>, TableRow<Team>>() {
					@Override
					public TableRow<Team> call(TableView<Team> param) {
						return new TableRow<Team>() {
							@Override
							protected void updateItem(Team item, boolean empty) {
								super.updateItem(item, empty);
								int indexteam = 0;
								for (int i = 0; i < rankingtable.getItems()
										.size(); i++) {
									if (rankingtable
											.getItems()
											.get(i)
											.equals(MainGame.game.getUser()
													.getTeam())) {
										indexteam = i;
									}
								}
								if (getIndex() == indexteam) {
									getStyleClass().add("highlightedRow");
								} else {
									getStyleClass().remove("highlightedRow");
								}
							}
						};
					}
				});
	}

	/**
	 * Creates the ranking page
	 * 
	 * @throws IOException
	 *             is thrown when the fxml cannot be read
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/Ranking.fxml"));
		Main.setCenter(scene);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}
}
