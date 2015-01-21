package nl.joshuaslik.tudelft.UFMGame.backend;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nl.joshuaslik.tudelft.UFMGame.backend.exceptions.UnknownPlayerException;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Formation;

/**
 * The Team Object stores all players in a given team. It divides them into
 * active and bench players.
 * 
 * The Object also keeps track of the team statistics.
 * 
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Team {
	private ArrayList<Player> activePlayers = new ArrayList<Player>();
	private ArrayList<Player> benchPlayers = new ArrayList<Player>();
	private Player teamCaptain;
	private String teamName, coachName, id;
	private Formation formation;
	private int totalWins, totalLosses, totalDraws, points, goalsagainst,
			ranking, totalGoals = 0;
	private int attackPower, defencePower, stamina = 0;
	private int averageAttackPower, averageDefencePower, averageStamina;
	private int teamValue;
	private int totalPlayers;

	/**
	 * Constructs the Object
	 * 
	 * @param id
	 *            is the id of a team.
	 * 
	 * @param tmName
	 *            is the team name.
	 * @param cchName
	 *            is the coach name.
	 */
	public Team(String id, String tmName, String cchName) {
		this.id = id;
		teamName = tmName;
		coachName = cchName;
	}

	/**
	 * Adds a player to the Active Player list if the team has less than 11
	 * active players and the player aint already in the list.
	 * 
	 * When a goalkeeper is added, the method checks if the team doesn't already
	 * have an active goalkeeper.
	 * 
	 * Also updates the team statistics.
	 * 
	 * @param player
	 *            is a Player Object
	 */
	public void addActivePlayer(Player player) {
		if (!activePlayers.contains(player) && activePlayers.size() < 11) {

			if (player instanceof Goalkeeper && !checkActiveGoalkeeper()) {
				activePlayers.add(player);
			}

			if (player instanceof Fieldplayer) {
				activePlayers.add(player);

				attackPower += ((Fieldplayer) player).getAttackPower();
				defencePower += ((Fieldplayer) player).getDefencePower();
				stamina += ((Fieldplayer) player).getStamina();
			}

			player.setActiveState(true);
			calcAverageStats();
		}
	}

	/**
	 * Adds a player to the list of Bench Players if the player aint already in
	 * it.
	 * 
	 * @param player
	 *            is a Player Object.
	 */
	public void addBenchPlayer(Player player) {
		if (!benchPlayers.contains(player)) {
			benchPlayers.add(player);

			calcAverageStats();
			player.setActiveState(false);
		}
	}

	/**
	 * Checks if a team has an active goalkeeper.
	 * 
	 * @return true when the team has an active goalkeeper,
	 */
	public boolean checkActiveGoalkeeper() {
		for (int i = 0; i < activePlayers.size(); i++) {
			if (activePlayers.get(i) instanceof Goalkeeper) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes a player from the Active Player list. Also updates the team
	 * statistics.
	 * 
	 * @param player
	 *            is a Player Object.
	 */
	public void removeActivePlayer(Player player) {
		if (activePlayers.contains(player)) {
			activePlayers.remove(activePlayers.indexOf(player));

			if (player instanceof Fieldplayer) {
				attackPower -= ((Fieldplayer) player).getAttackPower();
				defencePower -= ((Fieldplayer) player).getDefencePower();
				stamina -= ((Fieldplayer) player).getStamina();
			}

			calcAverageStats();
		}
	}

	/**
	 * Removes a player from the Bench Player list.
	 * 
	 * @param player
	 *            is a Player Object.
	 */
	public void removeBenchPlayer(Player player) {
		if (benchPlayers.contains(player)) {
			benchPlayers.remove(benchPlayers.indexOf(player));
		}

		calcAverageStats();
	}

	/**
	 * Removes a player from this team, regardless of if he is a bench player or
	 * an active player
	 * 
	 * @param id
	 *            the ID of the player to remove
	 */
	public void removePlayer(String id) {
		Player player = this.getPlayer(id);
		if (benchPlayers.contains(player))
			this.removeBenchPlayer(player);
		else
			this.removeActivePlayer(player);
	}

	/**
	 * Get the active Goalkeeper of this team
	 * 
	 * @return the active Goalkeeper
	 */
	public Goalkeeper getActiveGoalkeeper() {
		Goalkeeper res = null;
		for (int i = 0; i < activePlayers.size(); i++) {
			if (activePlayers.get(i) instanceof Goalkeeper) {
				return (Goalkeeper) activePlayers.get(i);
			}
		}
		return res;
	}

	/**
	 * Assigns the given player as the Team Captain
	 * 
	 * @param player
	 *            is a Player Object.
	 */
	public void setTeamCaptain(Player player) {
		teamCaptain = player;
	}

	/**
	 * Adds the player to the active player list and removes him from the bench
	 * player list.
	 * 
	 * @param player
	 *            is a Player Object.
	 */
	public void setPlayerActive(Player player) {
		if (!activePlayers.contains(player) & activePlayers.size() < 11) {

			if (player instanceof Goalkeeper & !checkActiveGoalkeeper()) {
				activePlayers.add(player);
			}

			if (player instanceof Fieldplayer) {
				activePlayers.add(player);

				attackPower += ((Fieldplayer) player).getAttackPower();
				defencePower += ((Fieldplayer) player).getDefencePower();
				stamina += ((Fieldplayer) player).getStamina();
			}

			if (benchPlayers.contains(player)) {
				benchPlayers.remove(benchPlayers.indexOf(player));
			}

			player.setActiveState(true);
			calcAverageStats();
		}
	}

	/**
	 * Removes the Player from the active playerlist and adds him to the bench
	 * playerlist.
	 * 
	 * @param player
	 *            is a Player Object
	 */
	public void setPlayerBench(Player player) {
		if (!benchPlayers.contains(player)) {
			benchPlayers.add(player);

			if (activePlayers.contains(player)) {
				activePlayers.remove(activePlayers.indexOf(player));
				if (player.equals(teamCaptain)) {
					teamCaptain = null;
				}

				if (player instanceof Fieldplayer) {
					attackPower -= ((Fieldplayer) player).getAttackPower();
					defencePower -= ((Fieldplayer) player).getDefencePower();
					stamina -= ((Fieldplayer) player).getStamina();
				}
			}
		}

		player.setActiveState(false);
		calcAverageStats();
	}

	public boolean equals(Object other) {
		if (other instanceof Team) {
			Team that = (Team) other;
			if (this.teamCaptain != null && that.teamCaptain != null) {
				if (this.activePlayers.equals(that.activePlayers)
						&& this.benchPlayers.equals(that.benchPlayers)
						&& this.teamCaptain.equals(that.teamCaptain)
						&& this.teamName.equals(that.teamName)
						&& this.coachName.equals(that.coachName)
						&& (this.totalWins == that.totalWins)
						&& (this.totalLosses == that.totalLosses)
						&& (this.totalDraws == that.totalDraws)
						&& (this.totalGoals == that.totalGoals)
						&& (this.attackPower == that.attackPower)
						&& (this.defencePower == that.defencePower)
						&& (this.stamina == that.stamina)
						&& (this.points == that.points)
						&& (this.ranking == that.ranking)
						&& (this.goalsagainst == that.goalsagainst)) {
					return true;
				}
			} else if (this.activePlayers.equals(that.activePlayers)
					&& this.benchPlayers.equals(that.benchPlayers)
					&& (this.teamCaptain == null && that.teamCaptain == null)
					&& this.teamName.equals(that.teamName)
					&& this.coachName.equals(that.coachName)
					&& (this.totalWins == that.totalWins)
					&& (this.totalLosses == that.totalLosses)
					&& (this.totalDraws == that.totalDraws)
					&& (this.totalGoals == that.totalGoals)
					&& (this.attackPower == that.attackPower)
					&& (this.defencePower == that.defencePower)
					&& (this.stamina == that.stamina)
					&& (this.points == that.points)
					&& (this.ranking == that.ranking)
					&& (this.goalsagainst == that.goalsagainst)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the active players of this team
	 * 
	 * @return the list of active players
	 */
	public ArrayList<Player> getActivePlayers() {
		return activePlayers;
	}

	/**
	 * Get the bench players of this team
	 * 
	 * @return the list of bench players
	 */
	public ArrayList<Player> getBenchPlayers() {
		return benchPlayers;
	}

	/**
	 * Get all players of this team
	 * 
	 * @return the list of all players
	 */
	public ArrayList<Player> getAllPlayers() {
		ArrayList<Player> list = new ArrayList<Player>();
		list.addAll(activePlayers);
		list.addAll(benchPlayers);
		return list;
	}

	/**
	 * Get a player from this team by ID
	 * 
	 * @param id
	 *            the ID of the player to get
	 * @return the player matching the id provided
	 */
	public Player getPlayer(String id) {
		ArrayList<Player> list = this.getAllPlayers();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID().equals(id))
				return list.get(i);
		}
		throw new UnknownPlayerException(id + " does not exist in " + teamName);
	}

	/**
	 * Get the name of this team
	 * 
	 * @return the name of this team
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * Get the captain of this team
	 * 
	 * @return the team's captain
	 */
	public Player getTeamCaptain() {
		return teamCaptain;
	}

	/**
	 * Get the name of this team's coach
	 * 
	 * @return the name of the coach
	 */
	public String getCoachName() {
		return coachName;
	}

	/**
	 * Get the amount of wins this team has
	 * 
	 * @return the amount of wins of this team
	 */
	public int getTotalWins() {
		return totalWins;
	}

	/**
	 * Increments this team's wins by 1
	 */
	public void incTotalWins() {
		this.totalWins = this.totalWins + 1;
	}

	/**
	 * sets the total wins
	 * 
	 * @param wins
	 *            is the amount of wins by a team
	 */
	public void setTotalWins(int wins) {
		this.totalWins = wins;
	}

	/**
	 * Get the amount of losses this team has
	 * 
	 * @return the amount of losses of this team
	 */
	public int getTotalLosses() {
		return totalLosses;
	}

	/**
	 * Increments this team's losses by 1
	 */
	public void incTotalLosses() {
		this.totalLosses = this.totalLosses + 1;
	}

	/**
	 * sets the total losses
	 * 
	 * @param losses
	 *            is the amount of losses by a team
	 */
	public void setTotalLosses(int losses) {
		this.totalLosses = losses;
	}

	/**
	 * Get the amount of draws this team has
	 * 
	 * @return the amount of draws of this team
	 */
	public int getTotalDraws() {
		return totalDraws;
	}

	/**
	 * Increments this team's draws by 1
	 */
	public void incTotalDraws() {
		this.totalDraws = this.totalDraws + 1;
	}

	/**
	 * sets the total draws
	 * 
	 * @param draws
	 *            is the amount of draws played by a team
	 */
	public void setTotalDraws(int draws) {
		this.totalDraws = draws;
	}

	/**
	 * Get the amount of goals this team has scored
	 * 
	 * @return the amount of goals
	 */
	public int getTotalGoals() {
		return totalGoals;
	}

	/**
	 * add goals to totalgoals
	 * 
	 * @param goals
	 *            to add
	 */
	public void addGoals(int goals) {
		this.totalGoals = this.totalGoals + goals;
	}

	/**
	 * Set the total amount of goals 
	 * @param goals amount to set
	 */
	public void setTotalGoals(int goals){
		totalGoals = goals;
	}
	
	/**
	 * Add to this team's goal count
	 * 
	 * @param goals
	 *            amount of goals to add
	 */
	public void addGoalsAgainst(int goals) {
		goalsagainst = goalsagainst + goals;
	}
	
	/**
	 * Set the total amount of goals against
	 * @param goals amount to set
	 */
	public void setGoalsAgainst(int goals){
		goalsagainst = goals;
	}

	/**
	 * Get how many goals against this team has
	 * 
	 * @return number of goals against
	 */
	public int getGoalsAgainst() {
		return goalsagainst;
	}

	/**
	 * Get the ranking of this team
	 * 
	 * @return the ranking of this team
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * Set the ranking of this team
	 * 
	 * @param ranking
	 *            rank to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/**
	 * Add points to this team total points
	 * 
	 * @param points
	 *            amount of points to add
	 */
	public void addPoints(int points) {
		this.points = points + this.points;
	}
	
	/**
	 * Set the amount of points for this team
	 * @param points amount of points to set
	 */
	public void setPoints(int points){
		this.points = points;
	}

	/**
	 * Get the amount of points this team has
	 * 
	 * @return the points of this team
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Calculates the total average stats and stores it
	 */
	public void calcAverageStats() {
		calcTotalAverageAttackPower();
		calcTotalAverageDefencePower();
		calcTotalAverageStamina();
	}

	/**
	 * Calculates the total average attackpower and stores it.
	 */
	public void calcTotalAverageAttackPower() {
		int result = 0;

		for (int i = 0; i < activePlayers.size(); i++) {
			if (activePlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer) activePlayers.get(i);
				result += player.getAttackPower();
			}
		}

		for (int i = 0; i < benchPlayers.size(); i++) {
			if (benchPlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer) benchPlayers.get(i);
				result += player.getAttackPower();
			}
		}

		result = result / getTotalPlayers();
		averageAttackPower = result;
	}

	/**
	 * Get the average attack power of this team
	 * 
	 * @return the average attack power
	 */
	public int getAverageAttackPower() {
		return averageAttackPower;
	}

	/**
	 * Change the type of formation of the team
	 * 
	 * @param form
	 *            is the formation chosen by a team
	 */
	public void changeFormationType(Formation form) {
		for (int i = 0; i < activePlayers.size(); i++) {
			benchPlayers.add(activePlayers.get(i));
		}
		activePlayers.clear();
		teamCaptain = null;
		stamina = 0;
		attackPower = 0;
		defencePower = 0;
		formation = form;
	}

	/**
	 * Get the Formation of this team
	 * 
	 * @return the Formation
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * Get the total attack power of this team
	 * 
	 * @return the total attack power
	 */
	public int getAttackPower() {
		return attackPower;
	}

	/**
	 * Set the total attack power of this team
	 * 
	 * @param attpower
	 *            the attack power to assign to this team
	 */
	public void setAttackPower(int attpower) {
		this.attackPower = attpower;
	}

	/**
	 * Calculates the average defence power and stores it
	 */
	public void calcTotalAverageDefencePower() {
		int result = 0;

		for (int i = 0; i < activePlayers.size(); i++) {
			if (activePlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer) activePlayers.get(i);
				result += player.getDefencePower();
			}
		}

		for (int i = 0; i < benchPlayers.size(); i++) {
			if (benchPlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer) benchPlayers.get(i);
				result += player.getDefencePower();
			}
		}

		result = result / getTotalPlayers();
		averageDefencePower = result;
	}

	/**
	 * Get the average defence power of this team
	 * 
	 * @return the average defence power
	 */
	public int getAverageDefencePower() {
		return averageDefencePower;
	}

	/**
	 * Get the total defence power of this team
	 * 
	 * @return the total defence power
	 */
	public int getDefencePower() {
		return defencePower;
	}

	/**
	 * Set the total defence power of this team
	 * 
	 * @param defpower
	 *            the defence power to assign to this team
	 */
	public void setDefencePower(int defpower) {
		this.defencePower = defpower;
	}

	/**
	 * Calculates the average stamina and stores it
	 */
	public void calcTotalAverageStamina() {
		int result = 0;

		for (int i = 0; i < activePlayers.size(); i++) {
			if (activePlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer) activePlayers.get(i);
				result += player.getStamina();
			}
		}

		for (int i = 0; i < benchPlayers.size(); i++) {
			if (benchPlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer) benchPlayers.get(i);
				result += player.getStamina();
			}
		}

		result = result / getTotalPlayers();
		averageStamina = result;
	}

	/**
	 * Get the average stamina of this team
	 * 
	 * @return the average stamina
	 */
	public int getAverageStamina() {
		return averageStamina;
	}

	/**
	 * Get the total stamina of this team
	 * 
	 * @return the total stamina
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * Set the total stamina of this team
	 * 
	 * @param stamina
	 *            the stamina to assign to this team
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	/**
	 * Get the ID of this team
	 * 
	 * @return the ID of this team
	 */
	public String getid() {
		return id;
	}

	/**
	 * Calculates the value of this team
	 */
	public void calcTeamValue() {
		int result = 0;
		for (int i = 0; i < activePlayers.size(); i++) {
			Player player = activePlayers.get(i);
			result += player.getPrice();
		}
		for (int i = 0; i < benchPlayers.size(); i++) {
			Player player = benchPlayers.get(i);
			result += player.getPrice();
		}
		teamValue = result;
	}

	/**
	 * Get the value of this team
	 * 
	 * @return the team value
	 */
	public int getTeamValue() {
		this.calcTeamValue();
		return teamValue;
	}

	/**
	 * Set the value of this team
	 * 
	 * @param teamValue
	 *            the value to set this team's value to
	 */
	public void setTeamValue(int teamValue) {
		this.teamValue = teamValue;
	}

	/**
	 * Recalculate the amount of players in this team
	 */
	public void calcTotalPlayers() {
		int result = activePlayers.size() + benchPlayers.size();
		totalPlayers = result;
	}

	/**
	 * Get the amount of players in this team
	 * 
	 * @return the amount of players in this team
	 */
	public int getTotalPlayers() {
		calcTotalPlayers();
		return totalPlayers;
	}

	/**
	 * Get all players in this team as an ArrayList
	 * 
	 * @return ArrayList of this team's players
	 */
	public ArrayList<Player> getAllPlayersList() {
		ArrayList<Player> players = new ArrayList<Player>();

		for (int i = 0; i < activePlayers.size(); i++) {
			players.add(activePlayers.get(i));
		}

		for (int i = 0; i < benchPlayers.size(); i++) {
			players.add(benchPlayers.get(i));
		}

		return players;
	}

	/**
	 * Get all active players in this team as an ObservableList
	 * 
	 * @return ObservableList of this team's active players
	 */
	public ObservableList<Player> getObservableActivePlayersList() {
		return FXCollections.observableArrayList(activePlayers);
	}

	/**
	 * Get all bench players in this team as an ObservableList
	 * 
	 * @return ObservableList of this team's bench players
	 */
	public ObservableList<Player> getObservableBenchPlayersList() {
		return FXCollections.observableArrayList(benchPlayers);
	}
	
	/**
	 * Set all the Bench Players
	 * @param playerlist the list to set
	 */
	public void setAllBenchPlayers(ArrayList<Player> playerlist){
		benchPlayers = playerlist;
	}
}
