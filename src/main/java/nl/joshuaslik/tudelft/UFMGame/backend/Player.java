package nl.joshuaslik.tudelft.UFMGame.backend;

/**
 * The Player class is an abstract class which stores common information about
 * the players.
 * 
 * @author Sander Benoist
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 */

public abstract class Player {
	private String playerID;
	private String fullName;
	private String firstName;
	private String lastName;
	private String country;
	private int price;
	private String active;
	private Boolean activeState;

	/**
	 * Is the superconstructor of the subclasses.
	 * 
	 * @param id
	 *            is the playerID as a String
	 * @param firstName
	 *            is the first name of the player as a String
	 * @param lastName
	 *            is the last name of the player as a String
	 * @param country
	 *            is the country of the player as a string
	 * @param pr
	 *            is the price of the player as an int.
	 */
	public Player(String id, String firstName, String lastName, String country, int pr) {
		playerID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		fullName = firstName + " " + lastName;
		this.country = country;
		price = pr;
		active = "✗";
		activeState = false;
	}

	/**
	 * Getter for the player's ID
	 * 
	 * @return the ID of this player
	 */
	public String getID() {
		return playerID;
	}

	/**
	 * Getter for this player's first name
	 * 
	 * @return the first name of this player
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter for this player's last name
	 * 
	 * @return the last name of this player
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter for this player's full name
	 * 
	 * @return the full name of this player
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Getter for this player's nationality
	 * 
	 * @return the nationality of this player
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Getter for this player's price
	 * 
	 * @return the price of this player
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Getter for the activity icon of this player
	 * 
	 * @return A check mark or a cross depending on if this player is in his
	 *         team's active formation
	 */
	public String getActive() {
		return active;
	}

	/**
	 * Getter for the activity state of this player
	 * 
	 * @return true or false depending on if this player is in his team's active
	 *         formation
	 */
	public Boolean getActiveState() {
		return activeState;
	}

	/**
	 * Setter for the activity state of this player
	 * 
	 * @param input
	 *            the state of this player
	 */
	public void setActiveState(Boolean input) {
		activeState = input;
		if (input.equals(true))
			active = "✓";
		else
			active = "✗";
	}
}
