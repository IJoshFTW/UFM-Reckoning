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
 * ORM is offensive right midfield
 * OLM is offensive left midfield
 * st is 
 */

public class Form4321 extends Formation {
		
	private Fieldplayer CB1;
	private Fieldplayer CB2;
	private Fieldplayer RB;
	private Fieldplayer LB;
	private Fieldplayer CM;
	private Fieldplayer LM;
	private Fieldplayer RM;
	private Fieldplayer OLM;
	private Fieldplayer ORM;
	private Fieldplayer ST;
	private String Name = "4-3-2-1";
	
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return Name;
	}
	
	public Form4321(Team team){
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
	 * @return central midfield player
	 */
	public Fieldplayer getCM(){
		return CM;
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
	public Fieldplayer getOLM(){
		return OLM;
	}
	
	/**
	 * 
	 * @return Left wing player
	 */
	public Fieldplayer getORM(){
		return ORM;
	}
	
	/**
	 * 
	 * @return 
	 */
	public Fieldplayer getST(){
		return ST;
	}
	
	/**
	 * Set the Centralback 1
	 * @param new CB1
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
	 * @param new CB1
	 *  @retun old CB1
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
	 * @param new RB
	 * @retun old RB
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
	 * @param new LB
	 *  @retun old LB
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
	 * Set the Central midfield 
	 * @param new CM
	 *  @retun old CM
	 */
	public Fieldplayer setCM(Fieldplayer CM){
		Fieldplayer tmp = this.CM;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.CM = CM;
		team.setPlayerActive(CM);
		return tmp;
	}
	
	
	/**
	 * Set the left midfield
	 * @param new LM
	 * @retun old LM
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
	 * @param new RM
	 *  @retun old RM
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
	 * Set the offensive left midfield
	 * @param new OLM
	 * @retun old OLM
	 */
	public Fieldplayer setOLM(Fieldplayer OLM){
		Fieldplayer tmp = this.OLM;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.OLM = OLM;
		team.setPlayerActive(OLM);
		return tmp;
	}
	
	/**
	 * Set the offensive right midfield 
	 * @param new ORM
	 *  @retun old ORM
	 */
	public Fieldplayer setORM(Fieldplayer ORM){
		Fieldplayer tmp = this.ORM;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.ORM = ORM;
		team.setPlayerActive(ORM);
		return tmp;
	}
	
	/**
	 * Set the 
	 * @param new ST
	 * @retun old ST
	 */
	public Fieldplayer setST(Fieldplayer ST){
		Fieldplayer tmp = this.ST;
		if(tmp != null){
			team.setPlayerBench(tmp);
		}
		this.ST = ST;
		team.setPlayerActive(ST);
		return tmp;
	}
	
}