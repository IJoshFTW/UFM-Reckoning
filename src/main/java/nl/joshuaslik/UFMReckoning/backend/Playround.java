package nl.joshuaslik.UFMReckoning.backend;

import java.util.ArrayList;

/**
 * @author Bryan van Wijk
 * 
 *
 */
public class Playround implements Comparable<Object> {

	ArrayList<Match> matches = new ArrayList<Match>();
	int playroundnr;

	public Playround() {

	}

	public void setPlayroundnr(int nr) {
		playroundnr = nr;
	}

	public int getPlayroundnr() {
		return playroundnr;
	}

	/**
	 * Determines the result of this playround
	 */
	public void determineResultPlayround() {
		for (int i = 0; i < matches.size(); i++) {
			matches.get(i).determineResult();
		}
	}

	/**
	 * add a match to this playround
	 * 
	 * @param match
	 */
	public void addmatch(Match match) {
		matches.add(match);
	}

	/**
	 * 
	 * @return matches of this playround in arrayList
	 */
	public ArrayList<Match> getMatches() {
		return matches;
	}

	/**
	 * Checks how many times a team is in this Playround
	 * 
	 * @param team
	 * @return How many times the specified Team is in this Playround
	 */
	public int contains(Team team) {
		int result = 0;
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i).getHomeTeam().equals(team)
					| matches.get(i).getAwayTeam().equals(team)) {
				result = result + 1;
			}
		}
		return result;
	}

	/**
	 * returns true if two playrounds are equal
	 */
	public boolean equals(Object other) {
		if (other instanceof Playround) {
			Playround that = (Playround) other;
			if (this.matches.equals(that.matches)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Playround) {
			Playround that = (Playround) o;
			return this.playroundnr - that.playroundnr;
		}
		return 0;
	}

}
