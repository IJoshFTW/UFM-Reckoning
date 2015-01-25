package nl.joshuaslik.tudelft.UFMGame.backend;

import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form343;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form4321;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form433;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form442;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form532;
import nl.joshuaslik.tudelft.UFMGame.gui.game.MainGame;

/**
 * @author Bryan van Wijk
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Match {
	private Team hometeam, awayteam;
	private Team winner, loser;
	private boolean draw = false;
	private int homegoals = -1, awaygoals = -1;
	private int playround;

	/**
	 * Constructor for a match
	 * 
	 * @param hometeam
	 *            the team playing home
	 * @param awayteam
	 *            the team playing away
	 */
	public Match(Team hometeam, Team awayteam) {
		if (!hometeam.equals(awayteam)) {
			this.hometeam = hometeam;
			this.awayteam = awayteam;
		}
	}

	/**
	 * Method to determine the amount of goals
	 * 
	 * @param goalchance
	 *            chance to have a goal
	 * @return amount of goals
	 */
	public int determinegoals(double goalchance) {
		if (goalchance >= 0) {
			if (goalchance <= 810) {
				return 0;
			} else if (goalchance < 1530) {
				return 1;
			} else if (goalchance < 2130) {
				return 2;
			} else if (goalchance < 2430) {
				return 3;
			} else if (goalchance < 2640) {
				return 4;
			} else if (goalchance < 2850) {
				return 5;
			} else if (goalchance < 2910) {
				return 6;
			} else if (goalchance < 2940) {
				return 7;
			} else if (goalchance < 2970) {
				return 8;
			} else if (goalchance < 2985) {
				return 9;
			} else if (goalchance <= 3000) {
				return 10;
			} else {
				return 11;
			}
		}
		return -1;
	}

	/**
	 * Method to determine the results of this match
	 */
	public void determineResult(int difficulty) {
		int attackhome = hometeam.getAttackPower();
		int defencehome = hometeam.getDefencePower();
		int staminahome = hometeam.getStamina();

		int attackaway = awayteam.getAttackPower();
		int defenceaway = awayteam.getDefencePower();
		int staminaaway = awayteam.getStamina();
		if(hometeam.getFormation() instanceof Form532){
			defencehome = (int) (defencehome * 1.6);
			attackhome = (int) (attackhome * 0.4);
		}
		if(awayteam.getFormation() instanceof Form532){
			defenceaway = (int) (defenceaway * 1.6);
			attackaway = (int) (attackaway * 0.4);
		}
		if(hometeam.getFormation() instanceof Form433){
			defencehome = (int) (defencehome * 0.9);
			attackhome = (int) (attackhome * 1.1);
		}
		if(awayteam.getFormation() instanceof Form433){
			defenceaway = (int) (defenceaway * 0.9);
			attackaway = (int) (attackaway * 1.1);
		}
		if(hometeam.getFormation() instanceof Form4321){
			defencehome = (int) (defencehome * 0.7);
			attackhome = (int) (attackhome * 1.3);
		}
		if(awayteam.getFormation() instanceof Form4321){
			defenceaway = (int) (defenceaway * 0.7);
			attackaway = (int) (attackaway * 1.3);
		}
		if(hometeam.getFormation() instanceof Form442){
			defencehome = (int) (defencehome * 1.4);
			attackhome = (int) (attackhome * 0.6);
		}
		if(awayteam.getFormation() instanceof Form442){
			defenceaway = (int) (defenceaway * 1.4);
			attackaway = (int) (attackaway * 0.6);
		}
		if(hometeam.getFormation() instanceof Form343){
			defencehome = (int) (defencehome * 0.4);
			attackhome = (int) (attackhome * 1.6);
		}
		if(awayteam.getFormation() instanceof Form343){
			defenceaway = (int) (defenceaway * 0.4);
			attackaway = (int) (attackaway * 1.6);
		}
		
		int attackpowerhome = (attackhome - defenceaway);
		double homechance = Math.random() * 3000;
		double homegoalschance = (
				(homechance * (difficulty * 0.1)) +
				(
					((((attackpowerhome + staminahome) * 1.35)  - 
					((awayteam.getActiveGoalkeeper().getDiving() + awayteam.getActiveGoalkeeper().getPositioning() + awayteam.getActiveGoalkeeper().getReflexes())))) * ((10-difficulty) * 0.1)
				)
				);
		
		int attackpoweraway = (attackaway - defencehome);
		int awaychance = (int) (Math.random() * 3000);
		double awaygoalschance = (
				(awaychance * (difficulty * 0.1)) + 
				(
				((((attackpoweraway + staminaaway) * 1.35 ) - 
				((hometeam.getActiveGoalkeeper().getDiving() + hometeam.getActiveGoalkeeper().getPositioning() + hometeam.getActiveGoalkeeper().getReflexes())))) * ((10-difficulty) * 0.1)
				)
				);

		homegoals = determinegoals(homegoalschance);
		awaygoals = determinegoals(awaygoalschance);
		if (homegoals > awaygoals) {
			winner = hometeam;
			loser = awayteam;
			hometeam.addGoals(homegoals);
			hometeam.addGoalsAgainst(awaygoals);
			awayteam.addGoalsAgainst(homegoals);
			awayteam.addGoals(awaygoals);
			hometeam.addPoints(3);
			hometeam.incTotalWins();
			awayteam.incTotalLosses();
			MainGame.game.getUser(hometeam).addMoney(20000);
		} else if (homegoals == awaygoals) {
			hometeam.addGoals(homegoals);
			hometeam.addGoalsAgainst(awaygoals);
			awayteam.addGoalsAgainst(homegoals);
			awayteam.addGoals(awaygoals);
			hometeam.addPoints(1);
			awayteam.addPoints(1);
			hometeam.incTotalDraws();
			awayteam.incTotalDraws();
			draw = true;
			MainGame.game.getUser(hometeam).addMoney(10000);
			MainGame.game.getUser(awayteam).addMoney(10000);
		} else {
			winner = awayteam;
			loser = hometeam;
			hometeam.addGoals(homegoals);
			hometeam.addGoalsAgainst(awaygoals);
			awayteam.addGoalsAgainst(homegoals);
			awayteam.addGoals(awaygoals);
			awayteam.addPoints(3);
			hometeam.incTotalLosses();
			awayteam.incTotalWins();
			MainGame.game.getUser(awayteam).addMoney(20000);
		}

	}

	/**
	 * 
	 * @return gives team of the winner back or if the match isn't played yet it
	 *         gives null back
	 */
	public Team getWinner() {
		return winner;
	}

	/**
	 * 
	 * @return gives team of the loser back or if the match isn't played yet it
	 *         gives null back
	 */
	public Team getLoser() {
		return loser;
	}

	/**
	 * 
	 * @return gives the amount of goals from the hometeam back or if the match
	 *         isn't played yet it gives -1 back
	 */
	public Integer getHomegoals() {
		if (homegoals != -1) {
			return homegoals;
		}
		return null;
	}

	/**
	 * 
	 * @return gives the amount of goals from the awayteam back or if the match
	 *         isn't played yet it gives -1 back
	 */
	public Integer getAwaygoals() {
		if (awaygoals != -1) {
			return awaygoals;
		}
		return null;
	}

	/**
	 * 
	 * @return gives the hometeam
	 */
	public String getHometeam() {
		return hometeam.getTeamName();
	}

	/**
	 * 
	 * @return gives the awayteam
	 */
	public String getAwayteam() {
		return awayteam.getTeamName();
	}

	/**
	 * Setter
	 * @param goals is the awaygoals to set
	 */
	public void setawaygoals(int goals) {
		awaygoals = goals;
	}

	/**
	 * Setter
	 * @param team is the team to set
	 */
	public void setWinner(Team team) {
		winner = team;
	}

	/**
	 * Setter
	 * @param team is the team to set
	 */
	public void setLoser(Team team) {
		loser = team;
	}

	/**
	 * Setter
	 * @param goals are the goals to set
	 */
	public void setHomegoals(int goals) {
		homegoals = goals;
	}

	/**
	 * Getter
	 * @return the team playing HOME this match
	 */
	public Team getHomeTeam() {
		return hometeam;
	}

	/**
	 * Getter
	 * @return true or false depending on if it was a draw
	 */
	public boolean getDraw() {
		return draw;
	}

	/**
	 * Getter
	 * @return the team playing AWAY this match
	 */
	public Team getAwayTeam() {
		return awayteam;
	}

	/**
	 * Test if two match objects are equal
	 */
	public boolean equals(Object other) {
		if (other instanceof Match & (other != null)) {
			Match that = (Match) other;
			if (this.winner != null & this.loser != null & that.winner != null
					& that.loser != null) {
				if (this.hometeam.equals(that.hometeam)
						& this.awayteam.equals(that.awayteam)
						& this.awaygoals == that.awaygoals
						& this.homegoals == that.homegoals
						& this.loser == that.loser & this.winner == that.winner) {
					return true;
				}
			} else if (this.winner == null & that.winner == null
					& this.hometeam.equals(that.hometeam)
					& this.awayteam.equals(that.awayteam)
					& this.awaygoals == that.awaygoals
					& this.homegoals == that.homegoals) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getter for playround
	 * 
	 * @return the play round of this match
	 */
	public int getPlayround() {
		return playround;
	}

	/**
	 * Setter for playround
	 * 
	 * @param playround
	 *            the Playround to set
	 */
	public void setPlayround(int playround) {
		this.playround = playround;
	}

	/**
	 * Checker if this Match contains the team specified
	 * 
	 * @param team
	 *            the Team to check
	 * @return true or false depening on if the team specified is playing in
	 *         this Match
	 */
	public boolean contains(Team team) {
		if (hometeam.equals(team)) {
			return true;
		} else if (awayteam.equals(team)) {
			return true;
		}
		return false;
	}
}
