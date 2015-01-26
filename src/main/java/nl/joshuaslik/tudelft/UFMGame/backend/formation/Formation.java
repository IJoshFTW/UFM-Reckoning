package nl.joshuaslik.tudelft.UFMGame.backend.formation;

import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Goalkeeper;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;

/**
 * @author Bryan van Wijk abstract class for formation
 */
public abstract class Formation {

	protected Goalkeeper goalkeeper;
	protected Team team;

	/**
	 * Super constructor of all the formation types
	 * 
	 * @param team
	 *            Team that is using this Formation
	 */
	public Formation(Team team) {
		this.team = team;
	}

	/**
	 * Set the goalkeeper of the formation. and remove the old
	 * 
	 * @param goalkeeper
	 *            is the goalkeeper that will be playing.
	 * @return the goalkeeper
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

	/**
	 * get the goalkeeper of this formation
	 * 
	 * @return Goalkeeper of this formation
	 */
	public Goalkeeper getGoalkeper() {
		return goalkeeper;
	}

	/**
	 * Super method of this abstract class
	 * 
	 * @return name of this formation type
	 */
	public String getName() {
		return null;
	}

	/**
	 * Sets the striker player of a formation
	 * 
	 * @param fieldplayer
	 *            new striker player
	 * @return old striker player
	 */
	public Fieldplayer setST(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * Sets the centralback player of this formation
	 * 
	 * @param fieldplayer
	 *            new central back player
	 * @return old central back player
	 */
	public Fieldplayer setCB(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * Sets the right back player
	 * 
	 * @param fieldplayer
	 *            new right back player
	 * @return old right back player
	 */
	public Fieldplayer setRB(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the left back player
	 * 
	 * @param fieldplayer
	 *            new left back player
	 * @return old left back player
	 */
	public Fieldplayer setLB(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the central back player 1 of this formation
	 * 
	 * @param fieldplayer
	 *            new central back player 1
	 * @return old central back player 1
	 */
	public Fieldplayer setCB1(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the central back player 2
	 * 
	 * @param fieldplayer
	 *            new central back player 2
	 * @return old central back player 2
	 */
	public Fieldplayer setCB2(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the central midfield player
	 * 
	 * @param fieldplayer
	 *            new central midfield player
	 * @return old central midfield player
	 */
	public Fieldplayer setCM(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the central midfield player 1
	 * 
	 * @param fieldplayer
	 *            new central midfield player 1
	 * @return old central midfield player 1
	 */
	public Fieldplayer setCM1(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the central midfield player 2
	 * 
	 * @param fieldplayer
	 *            new central midfield player 2
	 * @return old central midfield player 2
	 */
	public Fieldplayer setCM2(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * Sets the Right midfield player
	 * 
	 * @param fieldplayer
	 *            new right midfield player
	 * @return old right midfield player
	 */
	public Fieldplayer setRM(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the left midfield player
	 * 
	 * @param fieldplayer
	 *            new left midfield player
	 * @return old left midfield player
	 */
	public Fieldplayer setLM(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * Sets the right wing player
	 * 
	 * @param fieldplayer
	 *            new right wing player
	 * @return old right wing player
	 */
	public Fieldplayer setRW(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the left wing player
	 * 
	 * @param fieldplayer
	 *            new left wing player
	 * @return old left wing player
	 */
	public Fieldplayer setLW(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the offensive left midfield player
	 * 
	 * @param fieldplayer
	 *            new offensive left midfield player
	 * @return old offensive left midield player
	 */
	public Fieldplayer setOLM(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * Sets the offensive right midfield player
	 * 
	 * @param fieldplayer
	 *            new offensive right midfield player
	 * @return old offensive right midfield player
	 */
	public Fieldplayer setORM(Fieldplayer fieldplayer) {
		return null;
	}

	/**
	 * sets the central back 3
	 * 
	 * @param fieldplayer
	 *            new central back 3
	 * @return old central back 3
	 */
	public Fieldplayer setCB3(Fieldplayer fieldplayer) {
		return null;
	}

}
