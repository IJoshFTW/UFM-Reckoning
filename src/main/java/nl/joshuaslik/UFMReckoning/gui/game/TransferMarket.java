package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nl.joshuaslik.UFMReckoning.backend.Player;
import nl.joshuaslik.UFMReckoning.backend.Save;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class TransferMarket {
	private static Team team;
	private static TableView sellList;
	private static TableView buyList;

	public static void start() throws IOException {
		team = MainGame.game.getUser().getTeam();
		init();

		Pane root = FXMLLoader.load(Class.class
				.getResource("/data/gui/pages-game/TransferMarket.fxml"));


		// Font voorbereiden voor de Text objecten
		Font statsFont = new Font(20);
		statsFont.loadFont("/data/gui/pages-menu/fonts/Quicksand.otf", 20);

		// sellList TableView aanpassen
		sellList.prefHeight(550);
		sellList.prefWidth(550);
		sellList.minHeight(550);
		sellList.setLayoutX(390);
		sellList.setLayoutY(260);

		// buyList TableView aanpassen
		buyList.prefHeight(550);
		buyList.prefWidth(550);
		buyList.minHeight(550);
		buyList.setLayoutX(1240);
		buyList.setLayoutY(260);
		
		// Funds: Text
		Text funds = new Text("$" + Integer.toString(MainGame.game.getUser().getBudget()));
		funds.prefHeight(30);
		funds.setFont(statsFont);
		funds.setLayoutX(1350);
		funds.setLayoutY(882);
				
		root.getChildren().addAll(sellList, buyList, funds);

		Scene scene = new Scene(root, 1080, 1920);
		Main.setScene(scene);
		Main.stage.setFullScreen(true);
	}

	public static void init() {
		sellList = new TableView<Player>();
		sellList.getColumns().addAll(getColumn( sellList));
		sellList.setItems(getsellList());

		sellList
				.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 0) {
							if (sellList.getSelectionModel()
									.getSelectedIndex() >= 0) {
								sellList.getSelectionModel()
										.getSelectedItem();
							}
						}
					}
				});
		
		buyList = new TableView<Player>();
		buyList.getColumns().addAll(getColumn(buyList));
		buyList.setItems(getbuyList());

		buyList
				.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 0) {
							if (buyList.getSelectionModel()
									.getSelectedIndex() >= 0) {
								buyList.getSelectionModel()
										.getSelectedItem();
							}
						}
					}
				});
	}

	public static ArrayList<TableColumn<Player, ?>> getColumn(
			TableView<Player> playertable) {
		int i;

		ArrayList<TableColumn<Player, ?>> columns = new ArrayList<TableColumn<Player, ?>>();

		// De te gebruiken gegevens
		String[] columnNames = { "Price", "Name", "Attack", "Defence",
				"Stamina" };
		String[] variableNames = { "playerPrice", "playerName", "atkPwr",
				"def", "sta" };

		// Kolommen aanmaken
		i = 0;
		TableColumn<Player, Integer> playerPrice = new TableColumn<>(
				columnNames[i++]);
		TableColumn<Player, String> playerName = new TableColumn<>(
				columnNames[i++]);
		TableColumn<Player, Integer> atkPwr = new TableColumn<>(
				columnNames[i++]);
		TableColumn<Player, Integer> def = new TableColumn<>(columnNames[i++]);
		TableColumn<Player, Integer> sta = new TableColumn<>(columnNames[i++]);

		// Kolom breedtes instellen
		playerPrice.setPrefWidth(75);
		playerName.setPrefWidth(235);
		atkPwr.setPrefWidth(90);
		def.setPrefWidth(90);
		sta.setPrefWidth(90);

		// Hier loop ik vast
		i = 0;
		playerPrice
				.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
						variableNames[i++]));
		playerName
				.setCellValueFactory(new PropertyValueFactory<Player, String>(
						variableNames[i++]));
		atkPwr.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
				variableNames[i++]));
		def.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
				variableNames[i++]));
		sta.setCellValueFactory(new PropertyValueFactory<Player, Integer>(
				variableNames[i++]));

		columns.add(playerPrice);
		columns.add(playerName);
		columns.add(atkPwr);
		columns.add(def);
		columns.add(sta);

		return columns;
	}

	public static ObservableList<Player> getsellList() {
		ObservableList<Player> data = FXCollections.observableArrayList(team.getActivePlayers());
		return data;
	}
	
	public static ObservableList<Player> getbuyList() {
		ObservableList<Player> data = FXCollections.observableArrayList(team.getBenchPlayers());
		return data;
	}
}
