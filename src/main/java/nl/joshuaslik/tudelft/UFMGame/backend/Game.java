package nl.joshuaslik.tudelft.UFMGame.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.backend.exceptions.UnableToBuyException;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form343;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form4321;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form433;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form442;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form532;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 * @author Naomi de Ridder
 * @author <a href="http://www.bryangoulds.nl/" target="_blank">Bryan van
 *         Wijk</a>
 *
 */
public class Game {

	private ArrayList<User> users = new ArrayList<User>();
	private Competition competition;
	private LinkedHashMap<String, Player> players;
	private ArrayList<Player> nonContractedPlayers = new ArrayList<Player>();
	private static int difficulty;

	/**
	 * 
	 */
	private int currentround = 1;

	/**
	 * Constructor
	 * 
	 * @param users
	 *            the users playing in this game
	 */
	public Game(ArrayList<User> users) {
		this.users = users;
		this.players = Save.loadPlayers();
		competition = new Competition(this);
	}

	/**
	 * Set a player non contracted
	 * 
	 * @param id
	 *            player to set non contracted
	 */
	public void setNonContracted(String id) {
		getUser().addMoney(getUser().getTeam().getPlayer(id).getPrice());
		nonContractedPlayers.add(getUser().getTeam().getPlayer(id));
		getUser().getTeam().removePlayer(id);
	}

	/**
	 * Sell a player from user
	 * 
	 * @param id
	 *            player you want to sell
	 * @param user
	 *            from who the player belongs before selling
	 */
	public void sellPlayer(String id, User user) {
		user.addMoney(user.getTeam().getPlayer(id).getPrice());

		user.getTeam().removePlayer(id);
	}

	/**
	 * Buy a non contracted player if you have enough money
	 * 
	 * @param id
	 *            the non contracted player you want to buy
	 * @param user
	 *            who wants to buy the player
	 */
	public void buyNonContractedPlayer(String id, User user) {
		if (users.get(users.indexOf(user)).getBudget() >= players.get(id).getPrice()) {
			nonContractedPlayers.remove(nonContractedPlayers.indexOf(players.get(id)));
			users.get(users.indexOf(user)).subMoney(players.get(id).getPrice());
			users.get(users.indexOf(user)).getTeam().addBenchPlayer(players.get(id));
		} else {
			throw new UnableToBuyException("Not enough money");
		}
	}

	/**
	 * if the amount of money a user has is enough set this player at the
	 * benchplayers of this user
	 * 
	 * @param id
	 *            player to buy
	 * @param user
	 *            who wants to buy this player
	 */
	public void buyPlayer(String id, User user) {
		if (users.get(users.indexOf(user)).getBudget() >= players.get(id).getPrice()) {
			users.get(users.indexOf(user)).subMoney(players.get(id).getPrice());
			users.get(users.indexOf(user)).getTeam().addBenchPlayer(players.get(id));
		} else {
			throw new UnableToBuyException("Not enough money");
		}
	}

	/**
	 * Add a user if the users arraylist not contains this user already
	 * 
	 * @param user
	 *            the user to add
	 */
	public void addUser(User user) {
		if ((!users.contains(user))) {
			users.add(user);
		}
	}

	/**
	 * Get the Human user
	 * 
	 * @return the Human player
	 */
	public User getUser() {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof Human) {
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * Get a User by username
	 * 
	 * @param userName
	 *            the name of the User to get
	 * @return the user matching the userName specified
	 */
	public User getUser(String userName) {
		for (int i = 0; i < users.size(); i++)
			if (users.get(i).getUserName().equals(userName))
				return users.get(i);
		return null;
	}

	/**
	 * Get a User by Team
	 * 
	 * @param team
	 *            Team of the user to get
	 * @return the user who has the Team specified
	 */
	public User getUser(Team team) {
		for (int i = 0; i < users.size(); i++)
			if (users.get(i).getTeam().equals(team)) {
				return users.get(i);
			}
		return null;
	}

	/**
	 * 
	 * @return arraylist with all teams in this game
	 */
	public ArrayList<Team> getTeams() {
		ArrayList<Team> result = new ArrayList<Team>();
		for (int i = 0; i < users.size(); i++) {
			result.add(users.get(i).getTeam());
		}
		return result;
	}

	/**
	 * Gets the team
	 * 
	 * @param teamid
	 *            is the id of the team
	 * @return Team object where id is teamid
	 */
	public Team getTeam(String teamid) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getTeam().getid().equals(teamid)) {
				return users.get(i).getTeam();
			}
		}
		return null;
	}

	/**
	 * get the players
	 * 
	 * @param id
	 *            is the id of the players
	 * @return returns the player with id
	 */
	public Player getPlayer(String id) {
		return players.get(id);

	}

	/**
	 * 
	 * @param name
	 *            of the player
	 * @return player with that name
	 */
	public Player getPlayerByName(String name) {
		for (String key : players.keySet()) {
			if (players.get(key).getFullName().equals(name)) {
				return players.get(key);
			}
		}
		return null;

	}

	/**
	 * 
	 * @return gives the users in this game back
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * @return competition of this game
	 */
	public Competition getCompetition() {
		return competition;
	}

	/**
	 * Starts a new competition for this game
	 */
	public void newCompetition() {
		competition = new Competition(this);
		currentround = 1;
		for (int i = 0; i < users.size(); i++) {
			users.get(i).getTeam().setPoints(0);
			users.get(i).getTeam().setTotalLosses(0);
			users.get(i).getTeam().setTotalWins(0);
			users.get(i).getTeam().setTotalDraws(0);
			users.get(i).getTeam().setTotalGoals(0);
			users.get(i).getTeam().setGoalsAgainst(0);
		}
	}

	/**
	 * determine the current ranking of the teams in this game
	 * 
	 * @return linkedHashmap with ranking and team name
	 */
	public LinkedHashMap<Integer, String> computeStandings() {
		competition.ComputeStandings();
		LinkedHashMap<Integer, String> standings = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < users.size(); i++) {
			standings.put(users.get(i).getTeam().getRanking(), users.get(i).getTeam().getTeamName());
		}
		return standings;
	}

	/**
	 * returns 1 playround
	 * 
	 * @param round
	 *            is the round number of that playround
	 * @return the playround of a competition
	 */
	public Playround getPlayround(int round) {
		return competition.getPlayround(round);
	}

	/**
	 * returns all the playrounds of the current competition
	 * 
	 * @return the playround of a competition
	 */
	public ArrayList<Playround> getPlayrounds() {
		return competition.getPlayrounds();
	}

	/**
	 * determine the result of the currentround and returns the result of the
	 * currentround
	 * 
	 * @return the result of a playround
	 */
	public LinkedHashMap<String, String> resultplayround() {
		LinkedHashMap<String, String> result = null;
		if (currentround <= ((users.size() * (users.size() - 1)) / (users.size() / 2))) {
			ArrayList<Match> matches = getPlayround(currentround).getMatches();
			getPlayround(currentround).determineResultPlayround(difficulty);
			result = new LinkedHashMap<String, String>();
			for (int i = 0; i < matches.size(); i++) {
				Match match = matches.get(i);
				result.put(match.getHomeTeam().getTeamName() + " - " + match.getAwayTeam().getTeamName(), match.getHomegoals() + " - " + match.getAwaygoals());
			}
			currentround = currentround + 1;
		}
		return result;
	}

	/**
	 * determine the result of the specified round and returns the result of the
	 * 
	 * @param round
	 *            is the round to be played
	 * @return the result of the playround
	 *
	 */
	public LinkedHashMap<String, String> resultplayround(int round) {
		ArrayList<Match> matches = getPlayround(round).getMatches();
		this.getPlayround(round).determineResultPlayround(difficulty);
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		for (int i = 0; i < matches.size(); i++) {
			Match match = matches.get(i);
			result.put(match.getHomeTeam().getTeamName() + " - " + match.getAwayTeam().getTeamName(), match.getHomegoals() + " - " + match.getAwaygoals());
		}
		return result;
	}

	/**
	 * Getter for currentround
	 * 
	 * @return the current round of this game
	 */
	public int getCurrentRound() {
		return currentround;
	}

	/**
	 * Sets the currentround
	 * 
	 * @param round
	 *            that the currentround must be
	 */
	public void setCurrentRound(int round) {
		currentround = round;
	}

	/**
	 * Method to Change the formation of all the PC teams randomly
	 */
	public void changeFormationRound() {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof PC) {
				Team team = users.get(i).getTeam();
				ArrayList<Player> teamplayers = team.getAllPlayers();
				Collections.shuffle(teamplayers);
				ArrayList<Player> goalkeepers = new ArrayList<Player>();
				ArrayList<Player> fieldplayers = new ArrayList<Player>();

				for (int j = 0; j < teamplayers.size(); j++) {
					if (teamplayers.get(j) instanceof Fieldplayer) {
						fieldplayers.add(teamplayers.get(j));
					} else if (teamplayers.get(j) instanceof Goalkeeper) {
						goalkeepers.add(teamplayers.get(j));
					}
				}
				int formTypeChance = (int) (Math.random() * 5);

				if (formTypeChance == 0) {
					Form433 form = new Form433(team);
					team.changeFormationType(form);
					team.getFormation().setGoalkeeper((Goalkeeper) goalkeepers.get(0));
					team.getFormation().setCB1((Fieldplayer) fieldplayers.get(0));
					team.getFormation().setCB2((Fieldplayer) fieldplayers.get(1));
					team.getFormation().setRB((Fieldplayer) fieldplayers.get(2));
					team.getFormation().setLB((Fieldplayer) fieldplayers.get(3));
					team.getFormation().setLM((Fieldplayer) fieldplayers.get(4));
					team.getFormation().setCM((Fieldplayer) fieldplayers.get(5));
					team.getFormation().setRM((Fieldplayer) fieldplayers.get(6));
					team.getFormation().setRW((Fieldplayer) fieldplayers.get(7));
					team.getFormation().setLW((Fieldplayer) fieldplayers.get(8));
					team.getFormation().setST((Fieldplayer) fieldplayers.get(9));
				} else if (formTypeChance == 1) {
					Form343 form = new Form343(team);
					team.changeFormationType(form);
					team.getFormation().setGoalkeeper((Goalkeeper) goalkeepers.get(0));
					team.getFormation().setCB((Fieldplayer) fieldplayers.get(0));
					team.getFormation().setCM1((Fieldplayer) fieldplayers.get(1));
					team.getFormation().setRB((Fieldplayer) fieldplayers.get(2));
					team.getFormation().setLB((Fieldplayer) fieldplayers.get(3));
					team.getFormation().setLM((Fieldplayer) fieldplayers.get(4));
					team.getFormation().setCM2((Fieldplayer) fieldplayers.get(5));
					team.getFormation().setRM((Fieldplayer) fieldplayers.get(6));
					team.getFormation().setRW((Fieldplayer) fieldplayers.get(7));
					team.getFormation().setLW((Fieldplayer) fieldplayers.get(8));
					team.getFormation().setST((Fieldplayer) fieldplayers.get(9));
				} else if (formTypeChance == 2) {
					Form4321 form = new Form4321(team);
					team.changeFormationType(form);

					team.getFormation().setGoalkeeper((Goalkeeper) goalkeepers.get(0));
					team.getFormation().setCB1((Fieldplayer) fieldplayers.get(0));
					team.getFormation().setCB2((Fieldplayer) fieldplayers.get(1));
					team.getFormation().setRB((Fieldplayer) fieldplayers.get(2));
					team.getFormation().setLB((Fieldplayer) fieldplayers.get(3));
					team.getFormation().setLM((Fieldplayer) fieldplayers.get(4));
					team.getFormation().setCM((Fieldplayer) fieldplayers.get(5));
					team.getFormation().setRM((Fieldplayer) fieldplayers.get(6));
					team.getFormation().setORM((Fieldplayer) fieldplayers.get(7));
					team.getFormation().setOLM((Fieldplayer) fieldplayers.get(8));
					team.getFormation().setST((Fieldplayer) fieldplayers.get(9));
				} else if (formTypeChance == 3) {
					Form442 form = new Form442(team);
					team.changeFormationType(form);

					team.getFormation().setGoalkeeper((Goalkeeper) goalkeepers.get(0));
					team.getFormation().setCB1((Fieldplayer) fieldplayers.get(0));
					team.getFormation().setCB2((Fieldplayer) fieldplayers.get(1));
					team.getFormation().setRB((Fieldplayer) fieldplayers.get(2));
					team.getFormation().setLB((Fieldplayer) fieldplayers.get(3));
					team.getFormation().setLM((Fieldplayer) fieldplayers.get(4));
					team.getFormation().setCM1((Fieldplayer) fieldplayers.get(5));
					team.getFormation().setRM((Fieldplayer) fieldplayers.get(6));
					team.getFormation().setRW((Fieldplayer) fieldplayers.get(7));
					team.getFormation().setLW((Fieldplayer) fieldplayers.get(8));
					team.getFormation().setCM2((Fieldplayer) fieldplayers.get(9));
				} else if (formTypeChance == 4) {
					Form532 form = new Form532(team);
					team.changeFormationType(form);

					team.getFormation().setGoalkeeper((Goalkeeper) goalkeepers.get(0));
					team.getFormation().setCB1((Fieldplayer) fieldplayers.get(0));
					team.getFormation().setCB2((Fieldplayer) fieldplayers.get(1));
					team.getFormation().setRB((Fieldplayer) fieldplayers.get(2));
					team.getFormation().setLB((Fieldplayer) fieldplayers.get(3));
					team.getFormation().setLM((Fieldplayer) fieldplayers.get(4));
					team.getFormation().setCM((Fieldplayer) fieldplayers.get(5));
					team.getFormation().setRM((Fieldplayer) fieldplayers.get(6));
					team.getFormation().setRW((Fieldplayer) fieldplayers.get(7));
					team.getFormation().setLW((Fieldplayer) fieldplayers.get(8));
					team.getFormation().setCB3((Fieldplayer) fieldplayers.get(9));
				}
			}
		}
	}

	/**
	 * Set the difficulty of the game
	 * 
	 * @param diff
	 *            int of the difficulty
	 */
	static public void setDifficulty(int diff) {
		difficulty = diff;
	}

	/**
	 * Method to get all the non contracted players in this game
	 * 
	 * @return ArrayList with all the non contracted players
	 */
	public ArrayList<Player> getNonContractedPlayers() {
		return nonContractedPlayers;
	}

	/**
	 * Method to set the non Contracted players list
	 * 
	 * @param nonContractedPlayers
	 *            ArrayList with all the non Contracted Players
	 */
	public void setNonContractedPlayers(ArrayList<Player> nonContractedPlayers) {
		this.nonContractedPlayers = nonContractedPlayers;
	}

	/**
	 * Load all the players that are not in a team, but are in the files
	 */
	public void loadAllNonContractedPlayers() {
		ArrayList<Player> allnoncontractedplayers = Save.loadplayersArrayList();
		for (int i = 0; i < getUsers().size(); i++) {
			for (int j = 0; j < getUsers().get(i).getTeam().getAllPlayers().size(); j++) {
				if (allnoncontractedplayers.contains(getUsers().get(i).getTeam().getAllPlayers().get(j))) {
					allnoncontractedplayers.remove(getUsers().get(i).getTeam().getAllPlayers().get(j));
				}
			}
		}
		nonContractedPlayers.addAll(allnoncontractedplayers);
	}
}
