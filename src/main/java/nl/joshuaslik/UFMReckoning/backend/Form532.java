package nl.joshuaslik.UFMReckoning.backend;

/**
 * @author Bryan van Wijk Formation met 4-4-2 where CB is Central Back RB is
 *         Right back player LB is Left back player CM is Central midfield
 *         player LM is left midfield player RM is right midfield player LW is
 *         left wing player RW is right wing player ST is
 */

public class Form532 extends Formation {

	private Fieldplayer CB1;
	private Fieldplayer CB2;
	private Fieldplayer CB3;
	private Fieldplayer RB;
	private Fieldplayer LB;
	private Fieldplayer CM;
	private Fieldplayer LM;
	private Fieldplayer RM;
	private Fieldplayer LW;
	private Fieldplayer RW;
	private String Name = "5-3-2";

	/**
	 * 
	 * @return the name of the team
	 */
	public String getName() {
		return Name;
	}

	public Form532(Team team) {
		super(team);
	}

	/**
	 * 
	 * @return central back player 1
	 */
	public Fieldplayer getCB1() {
		return CB1;
	}

	/**
	 * 
	 * @return central back player 2
	 */
	public Fieldplayer getCB2() {
		return CB2;
	}

	/**
	 * 
	 * @return central back player 3
	 */
	public Fieldplayer getCB3() {
		return CB3;
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
	 * @return central midfield player
	 */
	public Fieldplayer getCM() {
		return CM;
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
	public Fieldplayer getRW() {
		return RW;
	}

	/**
	 * 
	 * @return Left wing player
	 */
	public Fieldplayer getLW() {
		return LW;
	}

	/**
	 * Set the Centralback 1
	 * 
	 * @param CB1
	 *            new CB1
	 * @return old CB1
	 */
	public Fieldplayer setCB1(Fieldplayer CB1) {
		Fieldplayer tmp = this.CB1;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CB1 = CB1;
		team.setPlayerActive(CB1);
		return tmp;
	}

	/**
	 * Set the Centralback 2
	 * 
	 * @param CB2
	 *            new CB1
	 * @return old CB1
	 */
	public Fieldplayer setCB2(Fieldplayer CB2) {
		Fieldplayer tmp = this.CB2;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CB2 = CB2;
		team.setPlayerActive(CB2);
		return tmp;
	}

	/**
	 * Set the Centralback 3
	 * 
	 * @param CB3
	 *            new CB1
	 * @return old CB1
	 */
	public Fieldplayer setCB3(Fieldplayer CB3) {
		Fieldplayer tmp = this.CB3;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CB3 = CB3;
		team.setPlayerActive(CB3);
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
	 * @return LB old LB
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
	 * Set the Central midfield
	 * 
	 * @param CM
	 *            new CM
	 * @return old CM
	 */
	public Fieldplayer setCM(Fieldplayer CM) {
		Fieldplayer tmp = this.CM;
		if (tmp != null) {
			team.setPlayerBench(tmp);
		}
		this.CM = CM;
		team.setPlayerActive(CM);
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
	 * Set the left Wing
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
	 * Set the right Wing
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

}
