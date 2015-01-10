package nl.joshuaslik.UFMReckoning.backend.formation;

import nl.joshuaslik.UFMReckoning.backend.Fieldplayer;
import nl.joshuaslik.UFMReckoning.backend.Goalkeeper;
import nl.joshuaslik.UFMReckoning.backend.Team;

/**
 * abstract class for formation
 * 
 * @author Bryan van Wijk
 */
public abstract class Formation {

	Goalkeeper goalkeeper;
	Team team;

	public Formation(Team team) {
		this.team = team;
	}

	/**
	 * Set the goalkeeper of the formation. and remove the old
	 * 
	 * @param goalkeeper
	 *            new goalkeeper
	 * @return old goalkeeper
	 */
	public Goalkeeper setGoalkeeper(Goalkeeper goalkeeper) {
		Goalkeeper tmp = this.goalkeeper;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.goalkeeper = goalkeeper;
		team.setPlayerActive(goalkeeper);
		return tmp;
	}

	public Team getTeam() {
		return team;
	}

	public Goalkeeper getGoalkeper() {
		return goalkeeper;
	}

	public String getName() {
		return null;
	}

	public String getType() {
		return null;
	}

	public Fieldplayer setST(Fieldplayer fieldplayer) {
		System.out.println(fieldplayer.getFullName() + " was set as the striker for this team");
		return null;
	}

}
