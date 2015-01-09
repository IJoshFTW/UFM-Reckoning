package nl.joshuaslik.UFMReckoning.backend;

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

	public String getPosition() {
		return position;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public int getDefencePower() {
		return defencePower;
	}

	public int getStamina() {
		return stamina;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
}
