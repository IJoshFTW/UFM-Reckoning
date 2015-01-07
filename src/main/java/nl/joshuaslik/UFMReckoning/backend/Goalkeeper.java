package nl.joshuaslik.UFMReckoning.backend;

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

	public int getReflexes() {
		return reflexes;
	}

	public int getDiving() {
		return diving;
	}

	public int getPositioning() {
		return positioning;
	}
	
	public String getPosition() {
		return position;
	}
}
