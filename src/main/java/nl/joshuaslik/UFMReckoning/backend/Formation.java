package nl.joshuaslik.UFMReckoning.backend;
/**
 * @author Bryan van Wijk
 * abstract class for formation
 */
public abstract class Formation {
	
	Goalkeeper goalkeeper;
	Team team;
	
	public Formation(Team team){
		this.team = team;
	}
	
	/**
	 * Set the goalkeeper of the formation. and remove the old
	 * @param new goalkeeper
	 * @return old goalkeeper
	 */
	public Goalkeeper setGoalkeeper(Goalkeeper goalkeeper){
		Goalkeeper tmp = this.goalkeeper;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.goalkeeper = goalkeeper;
		team.setPlayerActive(goalkeeper);
		return tmp;
	}
	

}
