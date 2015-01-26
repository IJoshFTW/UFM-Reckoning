package nl.joshuaslik.tudelft.UFMGame.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import nl.joshuaslik.tudelft.UFMGame.backend.Human;
import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;
import nl.joshuaslik.tudelft.UFMGame.backend.User;

/**
 * Class to handle the highscore page
 * 
 * @author Sander Benoist
 *
 */
public class Highscores {

	@FXML
	private TableView<User> highscoretable;
	@FXML
	private TableColumn<User, Double> goals;

	@FXML
	private TableColumn<User, String> usernames;

	@FXML
	private Button startgame;

	@FXML
	private Button newgame;

	@FXML
	private Button loadgame;

	/**
	 * Handles clicking on the new game button
	 * 
	 * @param event
	 *            of clicking on the button
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleNewGame(ActionEvent event) throws IOException {
		UsernameController.start();
	}

	/**
	 * Handles clicking on the load game button
	 * 
	 * @param event
	 *            that occurs after clicking on the button
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleLoadGame(ActionEvent event) throws IOException {
		LoadGameController.start();
	}

	/**
	 * Handles clicking on the options button
	 * 
	 * @param event
	 *            of clicking on the options button
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleOptions(ActionEvent event) throws IOException {
		Options.start();
	}

	/**
	 * Handles clicking on the highscores button
	 * 
	 * @param event
	 *            of clicking on the highscores button
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleHighscores(ActionEvent event) throws IOException {
		Highscores.start();
	}

	/**
	 * Handles clicking on the start button
	 * 
	 * @param event
	 *            of clicking on the start button
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleStart(ActionEvent event) throws IOException {
		MainMenu.start();
	}

	/**
	 * Handles clicking on the credits button
	 * 
	 * @param event
	 *            of clicking on the credits button
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	@FXML
	protected void handleCredits(ActionEvent event) throws IOException {
		Creditscontroller.start();
	}

	/**
	 * Handles clicking on the quite button
	 * 
	 * @param event
	 *            clicking on the quite button
	 */
	@FXML
	protected void handleQuitMenu(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	private void initialize() {
		startgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		newgame.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		loadgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});
		startgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		newgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		loadgame.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				newgame.setVisible(false);
				loadgame.setVisible(false);
			}
		});
		LinkedHashMap<String, Double> result = Save.getHighscore();
		ArrayList<User> arraylistusernames = new ArrayList<User>();
		for (String key : result.keySet()) {
			Human human = new Human(new Team("test", "test", "test"), key, 5);
			human.setHighscore(result.get(key));
			arraylistusernames.add(human);
		}
		ObservableList<User> observableUsernames = FXCollections.observableArrayList(arraylistusernames);

		highscoretable.setItems(observableUsernames);
		usernames.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
		goals.setCellValueFactory(new PropertyValueFactory<User, Double>("highscore"));

		goals.setSortType(SortType.DESCENDING);
		highscoretable.getSortOrder().add(goals);
		goals.setSortable(true);
	}

	/**
	 * Loads the highscore page
	 * 
	 * @throws IOException
	 *             is thrown if the FXML file cannot be parsed.
	 */
	public static void start() throws IOException {
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/Highscores.fxml"));
		Main.setCenter(scene);
	}

}
