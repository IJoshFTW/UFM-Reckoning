package nl.joshuaslik.UFMReckoning.backend.formation;

import nl.joshuaslik.UFMReckoning.backend.Fieldplayer;
import nl.joshuaslik.UFMReckoning.backend.Goalkeeper;
import nl.joshuaslik.UFMReckoning.backend.Team;

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
	
	public Team getTeam(){
		return team;
	}
	
	public Goalkeeper getGoalkeper(){
		return goalkeeper;
	}
	
	public String getName(){
		return null;
	}
	
	public String getType(){
		return null;
	}
	
	public Fieldplayer setST(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setCB(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setRB(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setLB(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setCB1(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setCB2(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setCM(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setCM1(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setCM2(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setRM(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setLM(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setRW(Fieldplayer fieldplayer){
		return null;
	}
	
	public Fieldplayer setLW(Fieldplayer fieldplayer){
		return null;
	}
	

}
