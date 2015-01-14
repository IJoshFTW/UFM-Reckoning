package nl.joshuaslik.tudelft.UFMGame.backend;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.backend.exceptions.UnableToBuyException;

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
	/**
	 * 
	 */
	private int currentround = 1;

	/**
	 * Constructor
	 */
	public Game(ArrayList<User> users) {
		this.users = users;
		this.players = Save.loadPlayers();
		newCompetition();
	}

	/**
	 * 
	 * @param id
	 */
	public void sellPlayer(String id) {
		getUser().addMoney(getUser().getTeam().getPlayer(id).getPrice());
		getUser().getTeam().removePlayer(id);
	}

	/**
	 * 
	 * @param id
	 * @param user
	 */
	public void sellPlayer(String id, User user) {
		getUser().addMoney(
				users.get(users.indexOf(user)).getTeam().getPlayer(id)
						.getPrice());
		users.get(users.indexOf(user)).getTeam().removePlayer(id);
	}

	/**
	 * 
	 * @param id
	 */
	public void buyPlayer(String id) {
		if (getUser().getBudget() >= players.get(id).getPrice()) {
			getUser().subMoney(players.get(id).getPrice());
			getUser().getTeam().addBenchPlayer(players.get(id));
		}
		throw new UnableToBuyException("Not enough money");
	}

	/**
	 * 
	 * @param id
	 * @param user
	 */
	public void buyPlayer(String id, User user) {
		if (users.get(users.indexOf(user)).getBudget() > players.get(id)
				.getPrice()) {
			users.get(users.indexOf(user)).subMoney(players.get(id).getPrice());
			users.get(users.indexOf(user)).getTeam()
					.addBenchPlayer(players.get(id));
		}
		throw new UnableToBuyException("Not enough money");
	}

	/**
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		if ((!users.contains(user))) {
			users.add(user);
		}
	}

	/**
	 * Let the PC buy and sell players
	 */
	public void PCBuy() {

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
	 * 
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
	 * 
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
			standings.put(users.get(i).getTeam().getRanking(), users.get(i)
					.getTeam().getTeamName());
		}
		return standings;
	}

	/**
	 * returns 1 playround
	 * 
	 * @param round
	 */
	public Playround getPlayround(int round) {
		return competition.getPlayround(round);
	}

	/**
	 * returns all the playrounds of the current competition
	 */
	public ArrayList<Playround> getPlayrounds() {
		return competition.getPlayrounds();
	}

	/**
	 * determine the result of the currentround and returns the result of the
	 * currentround
	 */
	public LinkedHashMap<String, String> resultplayround() {
		LinkedHashMap<String, String> result = null;
		if (currentround <= ((users.size() * (users.size() - 1)) / (users
				.size() / 2))) {
			ArrayList<Match> matches = getPlayround(currentround).getMatches();
			getPlayround(currentround).determineResultPlayround();
			result = new LinkedHashMap<String, String>();
			for (int i = 0; i < matches.size(); i++) {
				Match match = matches.get(i);
				result.put(match.getHomeTeam().getTeamName() + " - "
						+ match.getAwayTeam().getTeamName(),
						match.getHomegoals() + " - " + match.getAwaygoals());
			}
			currentround = currentround + 1;
		}
		return result;
	}

	/**
	 * determine the result of the specified round and returns the result of the
	 *
	 */
	public LinkedHashMap<String, String> resultplayround(int round) {
		ArrayList<Match> matches = getPlayround(round).getMatches();
		this.getPlayround(round).determineResultPlayround();
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		for (int i = 0; i < matches.size(); i++) {
			Match match = matches.get(i);
			result.put(match.getHomeTeam().getTeamName() + " - "
					+ match.getAwayTeam().getTeamName(), match.getHomegoals()
					+ " - " + match.getAwaygoals());
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

}
