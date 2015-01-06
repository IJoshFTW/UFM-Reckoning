package nl.joshuaslik.UFMReckoning.backend;

import java.util.ArrayList;

/**
 * The Team Object stores all players in a given team. It divides them into
 * active and bench players.
 * 
 * The Object also keeps track of the team statistics.
 * 
 * @author Sander Benoist
 *
 */
public class Team {
	private ArrayList<Player> activePlayers = new ArrayList<Player>();
	private ArrayList<Player> benchPlayers = new ArrayList<Player>();
	private Player teamCaptain;
	private String teamName, coachName, id;
	private Formation formation;
	private int totalWins, totalLosses, totalDraws, points, goalsagainst, ranking, totalGoals = 0;
	private int attackPower, defencePower, stamina = 0;
	private int averageAttackPower, averageDefencePower, averageStamina;
	private int teamValue;

	/**
	 * Initialises the Object
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
	
	public void removePlayer(String id) {
		Player player = this.getPlayer(id);
		if (benchPlayers.contains(player))
			this.removeBenchPlayer(player);
		else
			this.removeActivePlayer(player);
	}
	
	public Goalkeeper getActiveGoalkeeper(){
		Goalkeeper res = null;
		for(int i = 0; i < activePlayers.size(); i++){
			if(activePlayers.get(i) instanceof Goalkeeper){
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

				if (player instanceof Fieldplayer) {
					attackPower -= ((Fieldplayer) player).getAttackPower();
					defencePower -= ((Fieldplayer) player).getDefencePower();
					stamina -= ((Fieldplayer) player).getStamina();
				}
			}
		}	
		calcAverageStats();
	}

	public boolean equals(Object other) {
		if (other instanceof Team) {
			Team that = (Team) other;
			if(this.teamCaptain != null && that.teamCaptain != null){
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
			}
			else if(this.activePlayers.equals(that.activePlayers)
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
					&& (this.goalsagainst == that.goalsagainst)){
				return true;
			}
		}
		return false;
	}

	public int getTotalPlayers() {
		return activePlayers.size() + benchPlayers.size();
	}
	
	public ArrayList<Player> getActivePlayers() {
		return activePlayers;
	}

	public ArrayList<Player> getBenchPlayers() {
		return benchPlayers;
	}
	
	public ArrayList<Player> getAllPlayers() {
		ArrayList<Player> list = new ArrayList<Player>();
		list.addAll(activePlayers);
		list.addAll(benchPlayers);
		return list;
	}
	
	public Player getPlayer(String id) {
		ArrayList<Player> list = this.getAllPlayers();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID().equals(id))
				return list.get(i);
		}
		throw new UnknownPlayerException(id + " does not exist");
	}

	public String getTeamName() {
		return teamName;
	}

	public Player getTeamCaptain() {
		return teamCaptain;
	}

	public String getCoachName() {
		return coachName;
	}

	public int getTotalWins() {
		return totalWins;
	}

	/**
	 * increments totalwins with 1
	 */
	public void incTotalWins() {
		this.totalWins = this.totalWins + 1;
	}

	public int getTotalLosses() {
		return totalLosses;
	}
	
	public void addGoalsAgainst(int goals){
		goalsagainst = goalsagainst + goals;
	}
	
	public int getGoalsAgainst(){
		return goalsagainst;
	}
	
	public int getRanking(){
		return ranking;
	}
	
	public void setRanking(int ranking){
		this.ranking = ranking;
	}
	
	/**
	 * add points 
	 * @param points to add
	 */
	public void addPoints(int points){
		this.points = points + this.points;
	}
	
	public int getPoints(){
		return points;
	}
	
	/**
	 * increments totalLosses with 1
	 */
	public void incTotalLosses() {
		this.totalLosses = this.totalLosses + 1;
	}

	public int getTotalDraws() {
		return totalDraws;
	}
	
	/**
	 * increments totalDraws with 1
	 */
	public void incTotalDraws() {
		this.totalDraws = this.totalDraws + 1;
	}

	public int getTotalGoals() {
		return totalGoals;
	}
	
	/**
	 * add goals to totalgoals
	 * @param goals to add
	 */
	public void addGoals(int goals) {
		this.totalGoals = this.totalGoals + goals;
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
		
		for(int i = 0; i < activePlayers.size(); i++) {
			if(activePlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer)activePlayers.get(i);
				result += player.getAttackPower();
			}
		}
		
		for(int i = 0; i < benchPlayers.size(); i++) {
			if(benchPlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer)benchPlayers.get(i);
				result += player.getAttackPower();
			}
		}
		
		result = result/getTotalPlayers();
		averageAttackPower = result;
	}
	
	public int getAverageAttackPower() {
		return averageAttackPower;
	}
	
	/**
	 * Change the type of formation of the team
	 * choos out 442
	 */
	public void changeFormationType(int type){
		if(type == 442){
			for(int i = 0; i < activePlayers.size(); i++){
				setPlayerBench(activePlayers.get(i));
			}
			formation = new Form442(this);
		}
		else if(type == 433){
			for(int i = 0; i < activePlayers.size(); i++){
				setPlayerBench(activePlayers.get(i));
			}
			formation = new Form433(this);
		}
		else if(type == 532){
			for(int i = 0; i < activePlayers.size(); i++){
				setPlayerBench(activePlayers.get(i));
			}
			formation = new Form532(this);
		}
		else if(type == 4321){
			for(int i = 0; i < activePlayers.size(); i++){
				setPlayerBench(activePlayers.get(i));
			}
			formation = new Form4321(this);
		}
		else if(type == 343){
			for(int i = 0; i < activePlayers.size(); i++){
				setPlayerBench(activePlayers.get(i));
			}
			formation = new Form343(this);
		}
	}
	
	public Formation getFormation(){
		return formation;
	}

	public int getAttackPower() {
		return attackPower;
	}
	
	public void setAttackPower(int attack) {
		this.attackPower = attack;
	}

	/**
	 * Calculates the average defencepower and stores it
	 */
	public void calcTotalAverageDefencePower() {
		int result = 0;
		
		for(int i = 0; i < activePlayers.size(); i++) {
			if(activePlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer)activePlayers.get(i);
				result += player.getDefencePower();
			}
		}
		
		for(int i = 0; i < benchPlayers.size(); i++) {
			if(benchPlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer)benchPlayers.get(i);
				result += player.getDefencePower();
			}
		}
		
		result = result/getTotalPlayers();
		averageDefencePower = result;
	}	
	
	public int getAverageDefencePower() {
		return averageDefencePower;
	}
	
	public int getDefencePower() {
		return defencePower;
	}

	public void setDefencePower(int defence) {
		this.defencePower = defence;
	}

	/**
	 * Calculates the total average stamina and stores it
	 */
	public void calcTotalAverageStamina() {
		int result = 0;
		
		for(int i = 0; i < activePlayers.size(); i++) {
			if(activePlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer)activePlayers.get(i);
				result += player.getStamina();
			}
		}
		
		for(int i = 0; i < benchPlayers.size(); i++) {
			if(benchPlayers.get(i) instanceof Fieldplayer) {
				Fieldplayer player = (Fieldplayer)benchPlayers.get(i);
				result += player.getStamina();
			}
		}
		
		result = result/getTotalPlayers();
		averageStamina = result;
	}
	
	public int getAverageStamina() {
		return averageStamina;
	}
	
	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public String getid(){
		return id;
	}
	
	public int getPlayers(){
		return getActivePlayers().size()+getBenchPlayers().size();
	}
	
	/**
	 * Calculates the value of a team
	 */
	public void calcTeamValue() {
		int result = 0;
		for(int i = 0; i < activePlayers.size(); i++) {
				Player player = activePlayers.get(i);
				result += player.getPrice();
		}	
		for(int i = 0; i < benchPlayers.size(); i++) {
				Player player = benchPlayers.get(i);
				result += player.getPrice();
		}
		teamValue = result;
	}

	public int getTeamValue() {
		return teamValue;
	}

	public void setTeamValue(int teamValue) {
		this.teamValue = teamValue;
	}
}
