package nl.joshuaslik.UFMReckoning.backend;

/**
 * @author Naomi de Ridder
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
abstract class User {

	private Team team;
	private String userName;
	private int budget;

	public User(Team team, String userName, int budget) {
		this.team = team;
		this.userName = userName;
		this.budget = budget;
	}

	public Team getTeam() {
		return team;
	}

	public String getUserName() {
		return userName;
	}

	public int getBudget() {
		return budget;
	}

	public int addMoney(int amount) {
		budget = budget + amount;
		return budget;
	}

	public int subMoney(int amount) {
		budget = budget - amount;
		return budget;
	}

	public boolean checkCost(int amount) {
		if (budget >= amount) {
			return true;
		}
		return false;
	}

	public boolean equals() {
		if (this instanceof Human) {
			return true;
		}
		return false;
	}
}
