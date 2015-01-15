package nl.joshuaslik.tudelft.UFMGame.backend;

/**
 * Fieldplayer is a subclass from the Player class.
 * 
 * Fieldplayers are non-goalkeeper players.
 * 
 * @author Sander Benoist
 */
public class Fieldplayer extends Player {
	private String position, firstname;
	private int attackPower, defencePower, stamina;

	/**
	 * Initializes the Fieldplayer Object.
	 * 
	 * @param id
	 *            is the playerID as a String
	 * @param firstName
	 *            is the first name of the player as a String
	 * @param lastName
	 *            is the last name of the player as a String
	 * @param country
	 *            is the country of birth of the player as a String
	 * @param pos
	 *            is the player position on the field. as a String
	 * @param atkP
	 *            is the attackpower of the player as an int
	 * @param defP
	 *            is the defencepower of the player as an int
	 * @param sta
	 *            is the stamina of the player as an int
	 * @param price
	 *            is the price of the player as an int
	 */
	public Fieldplayer(String id, String firstName, String lastName,
			String country, String pos, int atkP, int defP, int sta, int price) {
		super(id, firstName, lastName, country, price);

		position = pos;
		attackPower = atkP;
		defencePower = defP;
		stamina = sta;
		this.setfirstname(firstName);
	}

	public boolean equals(Object other) {
		if (other instanceof Fieldplayer) {
			Fieldplayer that = (Fieldplayer) other;
			if (this.getID().equals(that.getID())
					&& this.getFullName().equals(that.getFullName())
					&& this.getCountry().equals(that.getCountry())
					&& this.getPrice() == that.getPrice()
					&& this.attackPower == that.attackPower
					&& this.defencePower == that.defencePower
					&& this.stamina == that.stamina
					&& this.position.equals(that.position)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getter for position
	 * 
	 * @return the position of this player
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Getter for attackPower
	 * 
	 * @return the attack power of this player
	 */
	public int getAttackPower() {
		return attackPower;
	}

	/**
	 * Getter for defencePower
	 * 
	 * @return the defence power of this player
	 */
	public int getDefencePower() {
		return defencePower;
	}

	/**
	 * Getter for stamina
	 * 
	 * @return the stamina of this player
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * Getter for firstname
	 * 
	 * @return the first name of this player
	 */
	public String getfirstname() {
		return firstname;
	}

	/**
	 * Setter for firstname
	 * 
	 * @param firstname
	 *            name to set this player's first name to
	 */
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
}
