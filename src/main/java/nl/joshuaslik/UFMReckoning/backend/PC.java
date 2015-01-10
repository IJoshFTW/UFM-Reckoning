package nl.joshuaslik.UFMReckoning.backend;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class PC extends User {

	/**
	 * Constructor for PC player
	 * 
	 * @param team
	 *            the team of this player
	 * @param userName
	 *            the username of this player
	 * @param budget
	 *            the budget of this player
	 */
	public PC(Team team, String userName, int budget) {
		super(team, userName, budget);

	}

	public boolean equals(Object obj) {
		if (obj instanceof PC) {
			PC that = (PC) obj;
			return (this.team.equals(that.team)
					&& this.userName.equals(that.userName) && this.budget == that.budget);
		}

		return false;
	}
}
