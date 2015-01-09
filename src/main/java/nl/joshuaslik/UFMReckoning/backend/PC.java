package nl.joshuaslik.UFMReckoning.backend;

public class PC extends User {

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
