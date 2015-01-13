package nl.joshuaslik.tudelft.UFMGame.backend;

/**
 * A goalkeeper is a special kind of player with different stats. It has
 * reflexes, diving and positioning variables.
 * 
 * @author Sander Benoist
 *
 */
public class Goalkeeper extends Player {
	private int reflexes, diving, positioning;
	private String position = "Goal";

	/**
	 * Initialises the Object.
	 * 
	 * @param id
	 *            is the playerID as a String
	 * @param firstName
	 *            is the first name of the player as a String
	 * @param lastName
	 *            is the last name of the player as a String
	 * @param country
	 *            is the country of birth of the player as a String
	 * @param refl
	 *            are the reflexes of the player as an int (1...100)
	 * @param dive
	 *            are the diving skills of the player as an int (1...100)
	 * @param pos
	 *            are the positioning skills of the player as an int (1...100)
	 * @param price
	 *            is the price of the player as an int
	 */
	public Goalkeeper(String id, String firstName, String lastName,
			String country, int refl, int dive, int pos, int price) {

		super(id, firstName, lastName, country, price);

		reflexes = refl;
		diving = dive;
		positioning = pos;
	}

	public boolean equals(Object other) {
		if (other instanceof Goalkeeper) {
			Goalkeeper that = (Goalkeeper) other;
			if (this.getID().equals(that.getID())
					&& this.getFullName().equals(that.getFullName())
					&& this.getCountry().equals(that.getCountry())
					&& this.getPrice() == that.getPrice()
					&& this.reflexes == that.reflexes
					&& this.diving == that.diving
					&& this.positioning == that.positioning
					&& this.position == that.position) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getter for reflexes skill
	 * 
	 * @return the reflexes of this goalkeeper
	 */
	public int getReflexes() {
		return reflexes;
	}

	/**
	 * Getter for diving skill
	 * 
	 * @return the diving of this goalkeeper
	 */
	public int getDiving() {
		return diving;
	}

	/**
	 * Getter for positioning skill
	 * 
	 * @return the positioning of this goalkeeper
	 */
	public int getPositioning() {
		return positioning;
	}

	/**
	 * Getter for position
	 * 
	 * @return the position of this goalkeeper
	 */
	public String getPosition() {
		return position;
	}
}
