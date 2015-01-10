package nl.joshuaslik.UFMReckoning.backend;

/**
 * @author Bryan van Wijk
 * Formation met 4-4-2
 * where CB is Central Back
 * RB is Right back player
 * LB is Left back player
 * CM is Central midfield player
 * LM is left midfield player
 * RM is right midfield player
 * LW is left wing player
 * RW is right wing player
 */

public class Form442 extends Formation {
		
	private Fieldplayer CB1;
	private Fieldplayer CB2;
	private Fieldplayer RB;
	private Fieldplayer LB;
	private Fieldplayer CM1;
	private Fieldplayer CM2;
	private Fieldplayer LM;
	private Fieldplayer RM;
	private Fieldplayer LW;
	private Fieldplayer RW;
	private String Name = "4-4-2";
	
	/**
	 * 
	 * @return The name of the formation
	 */
	public String getName(){
		return Name;
	}
	
	public Form442(Team team){
		super(team);
	}
	
	/**
	 * 
	 * @return central back player 1
	 */
	public Fieldplayer getCB1(){
		return CB1;
	}
	
	/**
	 * 
	 * @return central back player 2
	 */
	public Fieldplayer getCB2(){
		return CB2;
	}
	
	
	/**
	 * 
	 * @return left back player
	 */
	public Fieldplayer getLB(){
		return LB;
	}
	
	/**
	 * 
	 * @return right back player
	 */
	public Fieldplayer getRB(){
		return RB;
	}
	
	/**
	 * 
	 * @return central midfield player 1
	 */
	public Fieldplayer getCM1(){
		return CM1;
	}
	
	/**
	 * 
	 * @return central midfield player 2
	 */
	public Fieldplayer getCM2(){
		return CM2;
	}
	
	/**
	 * 
	 * @return right midfield player
	 */
	public Fieldplayer getRM(){
		return RM;
	}
	
	/**
	 * 
	 * @return Left midfield player
	 */
	public Fieldplayer getLM(){
		return LM;
	}
	
	/**
	 * 
	 * @return Right wing player
	 */
	public Fieldplayer getRW(){
		return RW;
	}
	
	/**
	 * 
	 * @return Left wing player
	 */
	public Fieldplayer getLW(){
		return LW;
	}
	
	/**
	 * Set the Centralback 1
	 * @param CB1 new CB1
	 * @return old CB1
	 */
	public Fieldplayer setCB1(Fieldplayer CB1){
		Fieldplayer tmp = this.CB1;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.CB1 = CB1;
		team.setPlayerActive(CB1);
		return tmp;
	}
	
	/**
	 * Set the Centralback 2
	 * @param CB1 new CB1
	 *  @return old CB1
	 */
	public Fieldplayer setCB2(Fieldplayer CB2){
		Fieldplayer tmp = this.CB2;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.CB2 = CB2;
		team.setPlayerActive(CB2);
		return tmp;
	}
	
	/**
	 * Set the rightback
	 * @param RB new RB
	 * @return old RB
	 */
	public Fieldplayer setRB(Fieldplayer RB){
		Fieldplayer tmp = this.RB;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.RB = RB;
		team.setPlayerActive(RB);
		return tmp;
	}
	
	/**
	 * Set the leftback
	 * @param LB new LB
	 *  @return old LB
	 */
	public Fieldplayer setLB(Fieldplayer LB){
		Fieldplayer tmp = this.LB;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.LB = LB;
		team.setPlayerActive(LB);
		return tmp;
	}
	
	/**
	 * Set the Central midfield 1
	 * @param CM1 new CM1
	 *  @return old CM1
	 */
	public Fieldplayer setCM1(Fieldplayer CM1){
		Fieldplayer tmp = this.CM1;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.CM1 = CM1;
		team.setPlayerActive(CM1);
		return tmp;
	}
	
	/**
	 * Set the Central midfield 1
	 * @param CM2 new CM2
	 *  @return old CM2
	 */
	public Fieldplayer setCM2(Fieldplayer CM2){
		Fieldplayer tmp = this.CM2;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.CM2 = CM2;
		team.setPlayerActive(CM2);
		return tmp;
	}
	
	/**
	 * Set the left midfield
	 * @param LM new LM
	 * @return old LM
	 */
	public Fieldplayer setLM(Fieldplayer LM){
		Fieldplayer tmp = this.LM;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.LM = LM;
		team.setPlayerActive(LM);
		return tmp;
	}
	
	/**
	 * Set the right midfield 
	 * @param RM new RM
	 *  @return old RM
	 */
	public Fieldplayer setRM(Fieldplayer RM){
		Fieldplayer tmp = this.RM;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.RM = RM;
		team.setPlayerActive(RM);
		return tmp;
	}
	
	/**
	 * Set the left Wing
	 * @param LW new LW
	 *  @return old LW
	 */
	public Fieldplayer setLW(Fieldplayer LW){
		Fieldplayer tmp = this.LW;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.LW = LW;
		team.setPlayerActive(LW);
		return tmp;
	}
	
	/**
	 * Set the right Wing
	 * @param RW new RW
	 * @return old RW
	 */
	public Fieldplayer setRW(Fieldplayer RW){
		Fieldplayer tmp = this.RW;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.RW = RW;
		team.setPlayerActive(RW);
		return tmp;
	}
	
}
