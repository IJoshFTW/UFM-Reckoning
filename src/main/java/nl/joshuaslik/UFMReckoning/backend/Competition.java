package nl.joshuaslik.UFMReckoning.backend;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Bryan van Wijk
 * 
 *
 */
public class Competition {
	ArrayList<Playround> playrounds = new ArrayList<Playround>();
	Game game;
	ArrayList<User> users;

	public Competition(Game game){
		this.game = game;
		users  = game.getUsers();
	}
	
	/**
	 * 
	 * @return users in this competition
	 */
	public ArrayList<User> getusers(){
		return users;
	}
	
	/**
	 * Compute the current standings of all the teams in this competition
	 */
	public void ComputeStandings(){
		int ranking=1;
		for (int i = 0; i < users.size(); i++){
			ranking = 1;
			for(int j = 0; j < users.size(); j++){
				if((users.get(i).getTeam().getPoints() < users.get(j).getTeam().getPoints()) ||
						( users.get(i).getTeam().getPoints() == users.get(j).getTeam().getPoints() && users.get(i).getTeam().getTotalGoals() < users.get(j).getTeam().getTotalGoals() )){
					ranking = ranking + 1;
				}
			}
			users.get(i).getTeam().setRanking(ranking);
		}
		
	}
	
	/**
	 * add all matches of this competition to random playrounds
	 */
	public void definePlayrounds(){
		playrounds = new ArrayList<Playround>();

		int i = 0;
		int j = 0;
		int k = 0;
		ArrayList<User> usersindelen = users;
		Collections.shuffle(usersindelen);
		User user = usersindelen.get(0);
		usersindelen.remove(0);
		usersindelen.add(user);
		
		for(i=0; i < (users.size()*(users.size()-1)/(users.size()/2)); i++){
			Playround newplayround = new Playround();
			newplayround.setPlayroundnr(i+1);
			for(j=0; j < (users.size()/2); j++){
				if(k == users.size()){
					usersindelen.remove(user);
					Collections.rotate(usersindelen, 1);
					usersindelen.add(user);
					k = 0;
				}
				Match newmatch = new Match(usersindelen.get(k).getTeam(), usersindelen.get(users.size()-1-k).getTeam());
				newmatch.setPlayround(i+1);
				newplayround.addmatch(newmatch);
				k = k+1;
				
				
			}
			playrounds.add(newplayround);
			Collections.shuffle(playrounds);
		}
	}
	
	/**
	 * check for dublicates in playrounds
	 */
	public void check(){
		int k = 0;
		for(int i = 0; i<users.size(); i++){
			for(int j =0; j<playrounds.size(); j++){
				if(playrounds.get(i).contains(users.get(i).getTeam())!= 1){
					System.out.println("fout neeeee " + users.get(i).getTeam().getTeamName()+k);
				}
			}
		}
	}
	
	/**
	 * Compte the result of the total competition
	 */
	public void computeresultCompetition(){
		for(int i =0; i<playrounds.size(); i++){
			playrounds.get(i).determineResultPlayround();
		}
	}
	
	/**
	 * 
	 * @param i between 0 and total playrounds
	 * @return playround i of this competition stating from 0
	 */
	public Playround getPlayround(int nr){
		for(int i =0; i<playrounds.size(); i++){
			if(playrounds.get(i).getPlayroundnr() == nr){
				return playrounds.get(i);	
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return arraylist of all the playrounds in this competition
	 */
	public ArrayList<Playround> getPlayrounds(){
		return playrounds;
	}
	
	/**
	 * checks of two competition are equal
	 */
	public boolean equals(Object other) {
		if (other instanceof Competition) {
			Competition that = (Competition) other;
			if (this.game.equals(that.game)&
					this.playrounds.equals(that.playrounds)){
				return true;
			}
		}
		return false;
	}
}
