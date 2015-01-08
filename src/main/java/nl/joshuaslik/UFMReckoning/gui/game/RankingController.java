package nl.joshuaslik.UFMReckoning.gui.game;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.util.Callback;
import nl.joshuaslik.UFMReckoning.backend.Team;
import nl.joshuaslik.UFMReckoning.gui.Main;

public class RankingController {
	
	@FXML
    private TableView<Team> rankingtable;
    @FXML
    private TableColumn<Team, String> nr;
    @FXML
    private TableColumn<Team, String> team;
	
    @FXML
    private void initialize() {
    	
    	ObservableList<Team> teams = FXCollections.observableArrayList(MainGame.game.getTeams());
    	rankingtable.setItems(teams);
    	
    	nr.setCellValueFactory(new PropertyValueFactory<Team, String>("ranking"));
		team.setCellValueFactory(new PropertyValueFactory<Team, String>("teamName"));
		MainGame.game.computeStandings();
		rankingtable.getSortOrder().add(nr);
        nr.setSortable(true);
        
        rankingtable.setRowFactory(new Callback<TableView<Team>, TableRow<Team>>() {
            @Override public TableRow<Team> call(TableView<Team> param) {
                return new TableRow<Team>() {
                    @Override protected void updateItem(Team item, boolean empty) {
                        super.updateItem(item, empty);
                        int indexteam =0;
                        for(int i =0; i<rankingtable.getItems().size(); i++){
                        	if(rankingtable.getItems().get(i).equals(MainGame.game.getUser().getTeam())){
                        		indexteam = i;
                        	}
                        }
                        if (getIndex() ==  indexteam ) {
                            getStyleClass().add("highlightedRow");
                        } else {
                            getStyleClass().remove("highlightedRow");
                        }
                    }
                };
            }
        });
    }
    
	
	public static void start() throws IOException {
		AnchorPane topmenu = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-menu/TopMenu.fxml"));
		Label label = (Label) topmenu.lookup("#title");
		label.setText("Ranking");
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		topmenu.setPrefWidth(visualBounds.getWidth());
		Main.setTop(topmenu);
		AnchorPane scene = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/Ranking.fxml"));
		Main.setCenter(scene);
		AnchorPane bottom = (AnchorPane) FXMLLoader.load(Class.class.getResource("/data/gui/pages-game/GameBottomMenuBar.fxml"));
		Main.setBottom(bottom);
	}
}
