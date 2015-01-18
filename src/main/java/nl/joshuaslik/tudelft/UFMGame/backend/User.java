package nl.joshuaslik.tudelft.UFMGame.backend;

/**
 * @author Naomi de Ridder
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public abstract class User {

	protected Team team;
	protected String userName;
	protected int budget;

	/**
	 * Contructor of a use
	 * @param team team of the user
	 * @param userName the user chosen name
	 * @param budget start budget of a user
	 */
	public User(Team team, String userName, int budget) {
		this.team = team;
		this.userName = userName;
		this.budget = budget;
	}

	/**
	 * get the team of this user
	 * @return the team of this user
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Method to get the username of this user
	 * @return String of the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Method to get the current budget of this user
	 * @return current budget
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * Method to add money to the budget of this user
	 * @param amount of money to add
	 * @return the budget after adding
	 */
	public int addMoney(int amount) {
		budget = budget + amount;
		return budget;
	}

	/**
	 * Method to subtract money of the budget
	 * @param amount to subtract
	 * @return budget after subtraction
	 */
	public int subMoney(int amount) {
		budget = budget - amount;
		return budget;
	}

	/**
	 * Checks of the budget is enough to buy the player with a price of amount
	 * @param amount to check
	 * @return true if the budget is enough
	 */
	public boolean checkCost(int amount) {
		if (budget >= amount) {
			return true;
		}
		return false;
	}

	/**
	 * Checks of the user is human
	 * @return true if the user is human
	 */
	public boolean isHuman() {
		if (this instanceof Human) {
			return true;
		}
		return false;
	}


}