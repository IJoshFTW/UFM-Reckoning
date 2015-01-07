package nl.joshuaslik.UFMReckoning.backend;

/**
 * The Player class is an abstract class.
 * 
 * @author Sander Benoist
 */

public abstract class Player {
	private String playerID;
	private String fullName;
	private String lastName;
	private String country;
	private int price;
	public String active;
	public Boolean activeState;

	/**
	 * Is the superconstructor of the subclasses.
	 * 
	 * @param id
	 *            is the playerID as a String
	 * @param firstName
	 *            is the first name of the player as a String
	 * @param lastName
	 *            is the last name of the player as a String
	 * @param heritage
	 *            is the country of birth from the player as a String
	 * @param pr
	 *            is the price of the player as an int.
	 */
	public Player(String id, String firstName, String lastName,
			String heritage, int pr) {
		playerID = id;
		fullName = firstName + " " + lastName;
		this.lastName = lastName;
		country = heritage;
		price = pr;
		active = "✗";
		activeState = false;
	}

	public String getID() {
		return playerID;
	}

	public String getFullName() {
		return fullName;
	}

	public String getCountry() {
		return country;
	}

	public int getPrice() {
		return price;
	}

	public String getLastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getActive() {
		return active;
	}
	
	public Boolean getActiveState() {
		return activeState;
	}
	
	public void setActiveState(Boolean input) {
		activeState = input;
		if (input.equals(true))
			active = "✓";
		else 
			active = "✗";
	}
}
