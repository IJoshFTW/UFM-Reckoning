package nl.joshuaslik.tudelft.UFMGame.backend;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates the games for the competition
 * 
 * @author Bryan van Wijk
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 */
public class Competition {
	ArrayList<Playround> playrounds = new ArrayList<Playround>();
	Game game;
	ArrayList<User> users;

	/**
	 * @param game
	 *            the game object where this competition is for
	 */
	public Competition(Game game) {
		this.game = game;
		users = game.getUsers();
	}

	/**
	 * 
	 * @return users in this competition
	 */
	public ArrayList<User> getusers() {
		return users;
	}

	/**
	 * Compute the current standings of all the teams in this competition
	 */
	public void ComputeStandings() {
		int ranking = 1;
		for (int i = 0; i < users.size(); i++) {

			ranking = 1;
			for (int j = 0; j < users.size(); j++) {
				if ((users.get(i).getTeam().getPoints() < users.get(j).getTeam().getPoints())
						|| (users.get(i).getTeam().getPoints() == users.get(j).getTeam().getPoints() && users.get(i).getTeam().getTotalGoals() < users.get(j).getTeam().getTotalGoals())) {
					ranking = ranking + 1;
				}
			}
			users.get(i).getTeam().setRanking(ranking);
		}

	}

	/**
	 * add all matches of this competition to random playrounds
	 */
	public void definePlayrounds() {
		playrounds = new ArrayList<Playround>();

		int i = 0;
		int j = 0;
		int k = 0;
		int p = 0;
		int round = 0;
		ArrayList<User> usersindelen = users;
		Collections.shuffle(usersindelen);
		User user = usersindelen.get(0);
		usersindelen.remove(0);
		usersindelen.add(user);

		for (i = 0; i < (users.size() * (users.size() - 1) / (users.size() / 2)); i++) {
			Playround newplayround = new Playround();
			if (i % 2 == 0) {
				round = p + 1;
			} else if (i % 2 != 0) {
				round = (users.size() * (users.size() - 1) / (users.size() / 2)) - (p);
				p = p + 1;
			}
			newplayround.setPlayroundnr(round);
			for (j = 0; j < (users.size() / 2); j++) {
				if (k == users.size()) {
					usersindelen.remove(user);
					Collections.rotate(usersindelen, 1);
					usersindelen.add(user);
					k = 0;
				}
				Match newmatch = new Match(usersindelen.get(k).getTeam(), usersindelen.get(users.size() - 1 - k).getTeam());
				newmatch.setPlayround(round);
				newplayround.addmatch(newmatch);
				k = k + 1;

			}
			playrounds.add(newplayround);
		}
	}

	/**
	 * Compute the result of the total competition
	 * 
	 * @param difficulty
	 *            difficulty setting of the game
	 */
	public void computeresultCompetition(int difficulty) {
		for (int i = 0; i < playrounds.size(); i++) {
			playrounds.get(i).determineResultPlayround(difficulty);
		}
	}

	/**
	 * 
	 * @param index
	 *            between 0 and total playrounds
	 * @return playround index of this competition stating from 0
	 */
	public Playround getPlayround(int index) {
		for (int i = 0; i < playrounds.size(); i++) {
			if (playrounds.get(i).getPlayroundnr() == index) {
				return playrounds.get(i);
			}
		}
		return null;
	}

	/**
	 * 
	 * @return arraylist of all the playrounds in this competition
	 */
	public ArrayList<Playround> getPlayrounds() {
		return playrounds;
	}

	/**
	 * checks of two competition are equal
	 */
	public boolean equals(Object other) {
		if (other instanceof Competition) {
			Competition that = (Competition) other;
			if (this.game.equals(that.game) & this.playrounds.equals(that.playrounds)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Setter
	 * 
	 * @param playrounds
	 *            are the playrounds to be played in the competition
	 */
	public void setPlayrounds(ArrayList<Playround> playrounds) {
		this.playrounds = playrounds;
	}
}
