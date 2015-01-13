package nl.joshuaslik.tudelft.UFMGame.backend.formation;

import nl.joshuaslik.tudelft.UFMGame.backend.Fieldplayer;
import nl.joshuaslik.tudelft.UFMGame.backend.Team;

/**
 * Formation met 4-4-2 where<br>
 * CB is Central Back<br>
 * RB is Right back player<br>
 * LB is Left back player<br>
 * CM is Central midfield player<br>
 * LM is left midfield player<br>
 * RM is right midfield player<br>
 * LW is left wing player<br>
 * RW is right wing player<br>
 * ORM is offensive right midfield<br>
 * OLM is offensive left midfield<br>
 * ST is striker
 * 
 * @author Bryan van Wijk
 */

public class Form343 extends Formation {

	private Fieldplayer CB;
	private Fieldplayer RB;
	private Fieldplayer LB;
	private Fieldplayer CM1;
	private Fieldplayer CM2;
	private Fieldplayer LM;
	private Fieldplayer RM;
	private Fieldplayer RW;
	private Fieldplayer LW;
	private Fieldplayer ST;
	private String Name = "3-4-3";

	/**
	 * 
	 * @return The name of this Formation
	 */
	public String getName() {
		return Name;
	}

	public Form343(Team team) {
		super(team);
	}

	/**
	 * 
	 * @return central back player
	 */
	public Fieldplayer getCB() {
		return CB;
	}

	/**
	 * 
	 * @return left back player
	 */
	public Fieldplayer getLB() {
		return LB;
	}

	/**
	 * 
	 * @return right back player
	 */
	public Fieldplayer getRB() {
		return RB;
	}

	/**
	 * 
	 * @return central midfield player1
	 */
	public Fieldplayer getCM1() {
		return CM1;
	}

	/**
	 * 
	 * @return central midfield player2
	 */
	public Fieldplayer getCM2() {
		return CM2;
	}

	/**
	 * 
	 * @return right midfield player
	 */
	public Fieldplayer getRM() {
		return RM;
	}

	/**
	 * 
	 * @return Left midfield player
	 */
	public Fieldplayer getLM() {
		return LM;
	}

	/**
	 * 
	 * @return Right wing player
	 */
	public Fieldplayer getLW() {
		return LW;
	}

	/**
	 * 
	 * @return Left wing player
	 */
	public Fieldplayer getRW() {
		return RW;
	}

	/**
	 * 
	 * @return Striker player
	 */
	public Fieldplayer getST() {
		return ST;
	}

	/**
	 * Set the Centralback
	 * 
	 * @param CB
	 *            new CB1
	 * @return old CB1
	 */
	public Fieldplayer setCB(Fieldplayer CB) {
		Fieldplayer tmp = this.CB;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CB = CB;
		team.setPlayerActive(CB);
		return tmp;
	}

	/**
	 * Set the rightback
	 * 
	 * @param RB
	 *            new RB
	 * @return old RB
	 */
	public Fieldplayer setRB(Fieldplayer RB) {
		Fieldplayer tmp = this.RB;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.RB = RB;
		team.setPlayerActive(RB);
		return tmp;
	}

	/**
	 * Set the leftback
	 * 
	 * @param LB
	 *            new LB
	 * @return old LB
	 */
	public Fieldplayer setLB(Fieldplayer LB) {
		Fieldplayer tmp = this.LB;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.LB = LB;
		team.setPlayerActive(LB);
		return tmp;
	}

	/**
	 * Set the Central midfield 1
	 * 
	 * @param CM1
	 *            CM1
	 * @return old CM1
	 */
	public Fieldplayer setCM1(Fieldplayer CM1) {
		Fieldplayer tmp = this.CM1;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CM1 = CM1;
		team.setPlayerActive(CM1);
		return tmp;
	}

	/**
	 * Set the Central midfield 2
	 * 
	 * @param CM2
	 *            new CM2
	 * @return old CM2
	 */
	public Fieldplayer setCM2(Fieldplayer CM2) {
		Fieldplayer tmp = this.CM2;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CM2 = CM2;
		team.setPlayerActive(CM2);
		return tmp;
	}

	/**
	 * Set the left midfield
	 * 
	 * @param LM
	 *            new LM
	 * @return old LM
	 */
	public Fieldplayer setLM(Fieldplayer LM) {
		Fieldplayer tmp = this.LM;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.LM = LM;
		team.setPlayerActive(LM);
		return tmp;
	}

	/**
	 * Set the right midfield
	 * 
	 * @param RM
	 *            new RM
	 * @return old RM
	 */
	public Fieldplayer setRM(Fieldplayer RM) {
		Fieldplayer tmp = this.RM;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.RM = RM;
		team.setPlayerActive(RM);
		return tmp;
	}

	/**
	 * Set the left wing
	 * 
	 * @param LW
	 *            new LW
	 * @return old LW
	 */
	public Fieldplayer setLW(Fieldplayer LW) {
		Fieldplayer tmp = this.LW;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.LW = LW;
		team.setPlayerActive(LW);
		return tmp;
	}

	/**
	 * Set the right wing
	 * 
	 * @param RW
	 *            new RW
	 * @return old RW
	 */
	public Fieldplayer setRW(Fieldplayer RW) {
		Fieldplayer tmp = this.RW;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.RW = RW;
		team.setPlayerActive(RW);
		return tmp;
	}

	/**
	 * Set the
	 * 
	 * @param ST
	 *            new ST
	 * @return old ST
	 */
	public Fieldplayer setST(Fieldplayer ST) {
		Fieldplayer tmp = this.ST;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.ST = ST;
		team.setPlayerActive(ST);
		return tmp;
	}

}