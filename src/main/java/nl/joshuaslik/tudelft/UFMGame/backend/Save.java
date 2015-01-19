package nl.joshuaslik.tudelft.UFMGame.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.backend.exceptions.UnableToSaveException;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form343;
import nl.joshuaslik.tudelft.UFMGame.backend.formation.Form433;
import nl.joshuaslik.tudelft.UFMGame.util.xml.SAXParser;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLFile;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLTag;

/**
 * @author Bryan van Wijk
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Save {

	/**
	 * Creates new Game object where team is the human and a username of the
	 * person who is playing the game
	 * 
	 * @param team
	 *            is the team you play with
	 * @param username
	 *            is the name the user inserts
	 * @return a game object with the user and pc teams
	 */
	public static Game newGame(Team team, String username) {
		Human human = new Human(team, username, 50000);
		LinkedHashMap<String, Team> teams = loadTeam();
		ArrayList<User> users = new ArrayList<User>();
		users.add(human);
		teams.remove(team.getid());
		int i = 1;
		for (String key : teams.keySet()) {
			users.add(new PC(teams.get(key), "pc" + i, 50000));
			i = i + 1;
		}
		Game game = new Game(users);
		return game;
	}

	/**
	 * load all the basic teams
	 * 
	 * @return a LinkedHashMap with as key String the team names and as value a
	 *         Team Object
	 */
	public static LinkedHashMap<String, Team> loadTeam() {
		String current = System.getProperty("user.dir");
		File folder = new File(current + "/src/main/resources/data/base/teams/");
		File[] listofFiles = folder.listFiles();
		LinkedHashMap<String, Player> players = loadPlayers();
		LinkedHashMap<String, Team> teams = new LinkedHashMap<String, Team>();
		for (int j = 0; j < listofFiles.length; j++) {
			if (listofFiles[j].isFile()) {
				XMLFile file = SAXParser.parseFile("/data/base/teams/"
						+ listofFiles[j].getName());
				String id = file.getElement("TEAM").getAttribute("id");
				String name = file.getElement("TEAM").getAttribute("name");
				String coach = file.getElement("TEAM").getAttribute("coach");
				Team team = new Team(id, name, coach);
				Form343 formation = new Form343(team);
				team.changeFormationType(formation);
				for (int i = 1; i < file.getElement("TEAM.PLAYERS").elements(); i++) {
					if (players.get(file.getElement("TEAM.PLAYERS.PLAYER", i)
							.getAttribute("id")) == null) {
						System.out.println(file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id")
								+ " is niet in the file");
					}
					if (file.getElement("TEAM.PLAYERS.PLAYER", i)
							.getContent("ACTIVE").equals("true")) {
						team.addActivePlayer(players.get(file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					} else if (file.getElement("TEAM.PLAYERS.PLAYER", i)
							.getContent("ACTIVE").equals("false")) {
						team.addBenchPlayer(players.get(file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					} else {
						System.out.println("er is een fout in players " + file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id"));
					}
				}
				
				for(int i =0; i<team.getActivePlayers().size(); i++){
					if(team.getActivePlayers().get(i) instanceof Goalkeeper){
						team.getFormation().setGoalkeeper((Goalkeeper)team.getActivePlayers().get(i));
					}
					else{
						Fieldplayer fieldplayer = (Fieldplayer) team.getActivePlayers().get(i);
						if(fieldplayer.getPosition().equals("ST")){
							team.getFormation().setST(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("RW")){
							team.getFormation().setRW(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("LW")){
							team.getFormation().setLW(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("RM")){
							team.getFormation().setRM(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("LM")){
							team.getFormation().setLM(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("CM") && formation.getCM1() == null){
							team.getFormation().setCM1(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("CM") && formation.getCM2() == null){
							team.getFormation().setCM2(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("RB")){
							team.getFormation().setRB(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("LB")){
							team.getFormation().setLB(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("CB")){
							team.getFormation().setCB(fieldplayer);
						}
					}
				}
				teams.put(id, team);
			}
		}
		return teams;
	}

	/**
	 * load all the basic teams
	 * 
	 * @return a arraylist with all the teams objects
	 */
	public static ArrayList<Team> loadTeams() {
		String current = System.getProperty("user.dir");
		File folder = new File(current + "/src/main/resources/data/base/teams/");
		File[] listofFiles = folder.listFiles();
		LinkedHashMap<String, Player> players = loadPlayers();
		ArrayList<Team> teams = new ArrayList<Team>();
		for (int j = 0; j < listofFiles.length; j++) {
			if (listofFiles[j].isFile()) {
				XMLFile file = SAXParser.parseFile("/data/base/teams/"
						+ listofFiles[j].getName());
				String id = file.getElement("TEAM").getAttribute("id");
				String name = file.getElement("TEAM").getAttribute("name");
				String coach = file.getElement("TEAM").getAttribute("coach");
				Team team = new Team(id, name, coach);
				Form343 formation = new Form343(team);
				team.changeFormationType(formation);
				for (int i = 1; i < file.getElement("TEAM.PLAYERS").elements(); i++) {
					if (players.get(file.getElement("TEAM.PLAYERS.PLAYER", i)
							.getAttribute("id")) == null) {
						System.out.println(file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id")
								+ " is niet in the file");
					}
					if (file.getElement("TEAM.PLAYERS.PLAYER", i)
							.getContent("ACTIVE").equals("true")) {
						team.addActivePlayer(players.get(file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					} else if (file.getElement("TEAM.PLAYERS.PLAYER", i)
							.getContent("ACTIVE").equals("false")) {
						team.addBenchPlayer(players.get(file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					} else {
						System.out.println("er is een fout in players " + file.getElement(
								"TEAM.PLAYERS.PLAYER", i).getAttribute("id"));
					}
				}
				
				for(int i =0; i<team.getActivePlayers().size(); i++){
					if(team.getActivePlayers().get(i) instanceof Goalkeeper){
						team.getFormation().setGoalkeeper((Goalkeeper)team.getActivePlayers().get(i));
					}
					else{
						Fieldplayer fieldplayer = (Fieldplayer) team.getActivePlayers().get(i);
						if(fieldplayer.getPosition().equals("ST")){
							team.getFormation().setST(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("RW")){
							team.getFormation().setRW(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("LW")){
							team.getFormation().setLW(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("RM")){
							team.getFormation().setRM(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("LM")){
							team.getFormation().setLM(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("CM") && formation.getCM1() == null){
							team.getFormation().setCM1(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("CM") && formation.getCM2() == null){
							team.getFormation().setCM2(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("RB")){
							team.getFormation().setRB(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("LB")){
							team.getFormation().setLB(fieldplayer);
						}
						else if(fieldplayer.getPosition().equals("CB")){
							team.getFormation().setCB(fieldplayer);
						}
					}
				}
				
				teams.add(team);
			}
		}
		return teams;

	}

	/**
	 * method to load all the players of the game
	 * 
	 * @return linkedHashmap with all the players as value and their id as key
	 */
	public static LinkedHashMap<String, Player> loadPlayers() {
		String current = System.getProperty("user.dir");
		File folder = new File(current
				+ "/src/main/resources/data/base/players/");
		File[] listofFiles = folder.listFiles();
		ArrayList<Player> players = new ArrayList<Player>();
		LinkedHashMap<String, Player> playerslist = new LinkedHashMap<String, Player>();
		for (int i = 0; i < listofFiles.length; i++) {
			if (listofFiles[i].isFile()) {
				XMLFile file = SAXParser.parseFile("/data/base/players/"
						+ listofFiles[i].getName());
				String id = file.getElement("PLAYER").getAttribute("id");
				String last = file.getElement("PLAYER.NAME").getAttribute(
						"last");
				String first = file.getElement("PLAYER.NAME").getAttribute(
						"first");
				String country = file.getContent("PLAYER.COUNTRY");
				String type = file.getContent("PLAYER.TYPE");
				String pos = file.getContent("PLAYER.POS");
				int price = Integer.parseInt(file.getContent("PLAYER.TPRICE"));
				if (type.equals("GK")) {
					int DIV = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("DIV"));
					int POS = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("POS"));
					int REF = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("REF"));
					playerslist.put(id, new Goalkeeper(id, first, last,
							country, REF, DIV, POS, price));
					players.add(new Goalkeeper(id, first, last, country, REF,
							DIV, POS, price));

				} else {
					int ATT = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("ATT"));
					int DEF = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("DEF"));
					int STA = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("STA"));
					playerslist.put(id, new Fieldplayer(id, first, last,
							country, pos, ATT, DEF, STA, price));
					players.add(new Fieldplayer(id, first, last, country, pos,
							ATT, DEF, STA, price));
				}
			}
		}
		return playerslist;
	}

	/**
	 * load all the players
	 * 
	 * @return Arraylist with all the players
	 */
	public static ArrayList<Player> loadplayersArrayList() {
		String current = System.getProperty("user.dir");
		File folder = new File(current
				+ "/src/main/resources/data/base/players/");
		File[] listofFiles = folder.listFiles();
		ArrayList<Player> players = new ArrayList<Player>();

		for (int i = 0; i < listofFiles.length; i++) {
			if (listofFiles[i].isFile()) {
				XMLFile file = SAXParser.parseFile("/data/base/players/"
						+ listofFiles[i].getName());
				String id = file.getElement("PLAYER").getAttribute("id");
				String last = file.getElement("PLAYER.NAME").getAttribute(
						"last");
				String first = file.getElement("PLAYER.NAME").getAttribute(
						"first");
				String country = file.getContent("PLAYER.COUNTRY");
				String type = file.getContent("PLAYER.TYPE");
				String pos = file.getContent("PLAYER.POS");
				int price = Integer.parseInt(file.getContent("PLAYER.TPRICE"));
				if (type.equals("GK")) {
					int DIV = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("DIV"));
					int POS = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("POS"));
					int REF = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("REF"));

					players.add(new Goalkeeper(id, first, last, country, REF,
							DIV, POS, price));

				} else {
					int ATT = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("ATT"));
					int DEF = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("DEF"));
					int STA = Integer.parseInt(file.getElement("PLAYER.STATS")
							.getContent("STA"));

					players.add(new Fieldplayer(id, first, last, country, pos,
							ATT, DEF, STA, price));
				}
			}
		}
		return players;
	}

	// /**
	// *
	// * @param game
	// */
	// public static void SaveGame(Game game, String location) {
	// ArrayList<User> users = game.getUsers();
	// new File(location + game.getUser().getUserName() + "/").mkdir();
	// // Unused?
	// // File folder = new File(current +
	// // "/src/main/resources/data/savedgames/"
	// // + game.getUser().getUserName() + "/");
	// LinkedHashMap<String, String> emptyatts = new LinkedHashMap<String,
	// String>();
	// for (int i = 0; i < users.size(); i++) {
	// Team team = users.get(i).getTeam();
	// LinkedHashMap<String, String> atts = new LinkedHashMap<String, String>();
	// atts.put("id", team.getid());
	// atts.put("name", team.getTeamName());
	// atts.put("coach", team.getCoachName());
	// XMLTag root = new XMLTag("TEAM", atts);
	// for (int j = 0; j < team.getActivePlayers().size(); j++) {
	// LinkedHashMap<String, String> playeratts = new LinkedHashMap<String,
	// String>();
	// playeratts.put("id", team.getActivePlayers().get(j).getID());
	// XMLTag player = new XMLTag("PLAYER", playeratts);
	// XMLTag active = new XMLTag("ACTIVE", emptyatts);
	// active.setContent("true");
	// player.addElement(active);
	// root.addElement(player);
	// }
	// for (int j = 0; j < team.getBenchPlayers().size(); j++) {
	// LinkedHashMap<String, String> playeratts = new LinkedHashMap<String,
	// String>();
	// playeratts.put("id", team.getBenchPlayers().get(j).getID());
	// XMLTag player = new XMLTag("PLAYER", playeratts);
	// XMLTag active = new XMLTag("ACTIVE", emptyatts);
	// active.setContent("false");
	// player.addElement(active);
	// root.addElement(player);
	// }
	// XMLFile teamfile = new XMLFile(root);
	// teamfile.save(location + game.getUser().getUserName() + "/"
	// + users.get(i).getUserName() + ".XML");
	// }
	// }

	/**
	 * Complicated save game shit
	 * 
	 * @param game
	 * @param SaveSlot
	 */
	public static void saveGame(Game game, int SaveSlot) {
		ArrayList<User> userlist = game.getUsers();
		XMLTag root = new XMLTag("savegame");

		// TODO Save game specific variables

		XMLTag users = new XMLTag("users");

		// Add all users
		for (int i = 0; i < userlist.size(); i++) {
			// TODO Distinguish between Human and PC
			User user = userlist.get(i);
			LinkedHashMap<String, String> atts = new LinkedHashMap<String, String>();
			atts.put("username", user.getUserName());
			atts.put("budget", Integer.toString(user.getBudget()));

			// Add team formation
			// TODO Formation
			Team team = user.getTeam();
			XMLTag teamtag = new XMLTag("team");
			
			//add formation
			XMLTag form = new XMLTag("formation");
			form.addAttribute("name", user.getTeam().getFormation().getName());
			if(user.getTeam().getFormation() instanceof Form433){
				Form433 formation433 = (Form433) user.getTeam().getFormation();
				XMLTag CB1 = new XMLTag("CB1");	
				XMLTag CB2 = new XMLTag("CB2");	
				XMLTag LB = new XMLTag("LB");	
				XMLTag RB = new XMLTag("RB");	
				XMLTag LM = new XMLTag("LM");	
				XMLTag RM = new XMLTag("RM");			
				XMLTag CM = new XMLTag("CM");			
				XMLTag LW = new XMLTag("LW");				
				XMLTag RW = new XMLTag("RW");
				XMLTag ST = new XMLTag("ST");
				
				try{
					CB1.setContent(formation433.getCB1().getID());
					CB2.setContent(formation433.getCB1().getID());
					LB.setContent(formation433.getLB().getID());
					RB.setContent(formation433.getCB1().getID());
					LM.setContent(formation433.getLM().getID());
					RM.setContent(formation433.getRM().getID());
					CM.setContent(formation433.getCM().getID());
					LW.setContent(formation433.getLW().getID());
					RW.setContent(formation433.getRW().getID());
					ST.setContent(formation433.getST().getID());
				}
				catch(Exception e){
					e.printStackTrace();
				}
				form.addElement(CB1);
				form.addElement(CB2);
				form.addElement(LB);
				form.addElement(RB);
				form.addElement(LM);
				form.addElement(RM);
				form.addElement(CM);
				form.addElement(LW);
				form.addElement(RW);
				form.addElement(ST);
			}
			XMLTag GK = new XMLTag("GK");
			try{
				GK.setContent(user.getTeam().getFormation().getGoalkeper().getID());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			form.addElement(GK);
			teamtag.addElement(form);

			
			// Add team players
			ArrayList<Player> players = team.getAllPlayers();
			XMLTag playerstag = new XMLTag("players");
			for (int j = 0; j < team.getAllPlayers().size(); j++) {
				Player player = players.get(j);
				XMLTag playertag = new XMLTag("player");
				playertag.addAttribute("id", player.getID());

				XMLTag name = new XMLTag("name");
				name.addAttribute("first", player.getFirstName());
				name.addAttribute("last", player.getLastName());
				playertag.addElement(name);

				XMLTag country = new XMLTag("country");
				country.setContent(player.getCountry());
				playertag.addElement(country);

				// TODO Where is type?

				if (player instanceof Fieldplayer) {
					Fieldplayer fplayer = (Fieldplayer) player;

					XMLTag pos = new XMLTag("pos");
					pos.setContent(fplayer.getPosition());
					playertag.addElement(pos);
				} else if (player instanceof Goalkeeper) {
					Goalkeeper gplayer = (Goalkeeper) player;
					XMLTag pos = new XMLTag("pos");
					pos.setContent(gplayer.getPosition());
					playertag.addElement(pos);
				} else {
					throw new UnableToSaveException(
							"Player did not match any known type");
				}

				XMLTag stats = new XMLTag("stats");
				if (player instanceof Fieldplayer) {
					Fieldplayer fplayer = (Fieldplayer) player;
					XMLTag att = new XMLTag("att");
					att.setContent(Integer.toString(fplayer.getAttackPower()));
					XMLTag def = new XMLTag("def");
					def.setContent(Integer.toString(fplayer.getDefencePower()));
					XMLTag sta = new XMLTag("sta");
					sta.setContent(Integer.toString(fplayer.getStamina()));
					stats.addElement(att);
					stats.addElement(def);
					stats.addElement(sta);
				} else if (player instanceof Goalkeeper) {
					Goalkeeper gplayer = (Goalkeeper) player;
					XMLTag div = new XMLTag("div");
					div.setContent(Integer.toString(gplayer.getDiving()));
					XMLTag pos = new XMLTag("pos");
					pos.setContent(Integer.toString(gplayer.getPositioning()));
					XMLTag ref = new XMLTag("ref");
					ref.setContent(Integer.toString(gplayer.getReflexes()));
					stats.addElement(div);
					stats.addElement(pos);
					stats.addElement(ref);
				} else {
					throw new UnableToSaveException(
							"Player did not match any known type");
				}
				playertag.addElement(stats);

				XMLTag price = new XMLTag("tprice");
				price.setContent(Integer.toString(player.getPrice()));
				playertag.addElement(price);
			}

			teamtag.addElement(playerstag);

			XMLTag usertag = new XMLTag("user", atts);
			usertag.addElement(teamtag);
			users.addElement(usertag);
		}
		root.addElement(users);
	}

	
	public static Game loadGame() {
		Game game = new Game(new ArrayList<User>());
		return game;
	}

}
