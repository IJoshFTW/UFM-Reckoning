package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import nl.joshuaslik.UFMReckoning.backend.Match;
import nl.joshuaslik.UFMReckoning.backend.Playround;
import nl.joshuaslik.UFMReckoning.gui.Main;

public class Playrounds {

	private static int round;

	@FXML
	private TableView<Match> competitiontable;
	@FXML
	private ComboBox<Playround> playround;
	@FXML
	private TableColumn<Match, String> home;
	@FXML
	private TableColumn<Match, String> away;
	@FXML
	private TableColumn<Match, String> homegoals;
	@FXML
	private TableColumn<Match, String> awaygoals;

	@FXML
	private void initialize() {
		ObservableList<Playround> playroundnr = FXCollections
				.observableArrayList(getPlayroundList());
		round = MainGame.game.getCurrentRound();

		playround.setItems(playroundnr);
		playround.setConverter(new StringConverter<Playround>() {
			@Override
			public String toString(Playround playround) {
				return "Playround: " + playround.getPlayroundnr();
			}

			@Override
			public Playround fromString(String nr) {
				return null;
			}
		});

		playround.valueProperty().addListener(new ChangeListener<Playround>() {
			@Override
			public void changed(
					ObservableValue<? extends Playround> observable,
					Playround oldValue, Playround newValue) {
				round = newValue.getPlayroundnr();
				ObservableList<Match> matches = FXCollections
						.observableArrayList(getMatchList());
				competitiontable.setItems(matches);

			}
		});

		playround.setValue(MainGame.game.getPlayround(round));

		ObservableList<Match> matches = FXCollections
				.observableArrayList(getMatchList());
		competitiontable.setItems(matches);

		home.setCellValueFactory(new PropertyValueFactory<Match, String>(
				"hometeam"));
		away.setCellValueFactory(new PropertyValueFactory<Match, String>(
				"awayteam"));
		homegoals.setCellValueFactory(new PropertyValueFactory<Match, String>(
				"homegoals"));
		awaygoals.setCellValueFactory(new PropertyValueFactory<Match, String>(
				"awaygoals"));

		// Listen for selection changes
		competitiontable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> selectedMatch(newValue));

		/**
		 * home.setCellFactory(column -> { return new TableCell<Match,
		 * String>(){
		 * 
		 * @Override protected void updateItem(String item, boolean empty){
		 *           super.updateItem(item, empty); if(item == null || empty){
		 *           setText(null); setStyle(""); } else { setText(item);
		 *           if(item
		 *           .equals(MainGame.game.getUser().getTeam().getTeamName())){
		 *           setStyle("-fx-background-color: yellow"); } else{
		 *           setStyle(""); } } } }; }); away.setCellFactory(column -> {
		 *           return new TableCell<Match, String>(){
		 * @Override protected void updateItem(String item, boolean empty){
		 *           super.updateItem(item, empty); if(item == null || empty){
		 *           setText(null); setStyle(""); } else { setText(item);
		 *           if(item
		 *           .equals(MainGame.game.getUser().getTeam().getTeamName())){
		 *           setStyle("-fx-background-color: yellow"); } else{
		 *           setStyle(""); } } } }; });
		 */
		competitiontable
				.setRowFactory(new Callback<TableView<Match>, TableRow<Match>>() {
					@Override
					public TableRow<Match> call(TableView<Match> param) {
						return new TableRow<Match>() {
							@Override
							protected void updateItem(Match item, boolean empty) {
								super.updateItem(item, empty);
								if (getItem() != null
										&& getItem().contains(
												MainGame.game.getUser()
														.getTeam())) {
									setStyle("-fx-background-color: yellow");
								} else {
									setStyle("");
								}
							}
						};
					}
				});

	}

	public Integer getgoals(int goals) {
		if (goals != -1) {
			return goals;
		}
		return null;
	}

	public void selectedMatch(Match newValue) {
	}

	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/Playrounds.fxml"));
		Main.setCenter(scene);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}

	public static ObservableList<Match> getMatchList() {
		Playround pr = MainGame.game.getCompetition().getPlayround(round);
		ArrayList<Match> matches = new ArrayList<Match>();
		matches.addAll(pr.getMatches());

		ObservableList<Match> data = FXCollections.observableArrayList(matches);
		return data;
	}

	public static ObservableList<Playround> getPlayroundList() {
		ArrayList<Playround> pr = MainGame.game.getCompetition()
				.getPlayrounds();
		Collections.sort(pr);
		ObservableList<Playround> data = FXCollections.observableArrayList(pr);
		return data;
	}

}