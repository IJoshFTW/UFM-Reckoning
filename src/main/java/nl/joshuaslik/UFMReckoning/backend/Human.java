package nl.joshuaslik.UFMReckoning.backend;

public class Human extends User {

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