package nl.joshuaslik.tudelft.UFMGame.backend;

/**
 * Class for a human player
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Human extends User {

	/**
	 * Constructor for a human player
	 * 
	 * @param team
	 *            the team of this player
	 * @param userName
	 *            the username of this player
	 * @param budget
	 *            the budget of this player
	 */
	public Human(Team team, String userName, int budget) {
		super(team, userName, budget);

	}

	public boolean equals(Object obj) {
		if (obj instanceof Human) {
			Human that = (Human) obj;
			return (this.team.equals(that.team)
					&& this.userName.equals(that.userName) && this.budget == that.budget);
		}

		return false;
	}
}