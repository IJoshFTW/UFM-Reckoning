package nl.joshuaslik.UFMReckoning.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import nl.joshuaslik.UFMReckoning.util.xml.SAXParser;
import nl.joshuaslik.UFMReckoning.util.xml.XMLFile;
import nl.joshuaslik.UFMReckoning.util.xml.XMLTag;

/**
 * @author Bryan van Wijk
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Save {
	
	/**
	 * 
	 * @param team
	 */
	public static Game newGame(Team team, String username){
		Human human = new Human(team, username, 50000 );
		LinkedHashMap<String, Team> teams = loadTeam();
		ArrayList<User> users = new ArrayList<User>();
		users.add(human);
		teams.remove(team.getid());
		int i =1;
		for(String key : teams.keySet()){
			users.add(new PC(teams.get(key), "pc"+i, 50000));
			i = i+1;
		}
		Game game = new Game(users);
		return game;
	}
	
	public static LinkedHashMap<String, Team> loadTeam(){
		String current = System.getProperty("user.dir");
		File folder = new File(current + "/src/main/resources/data/base/teams/");
		File[] listofFiles = folder.listFiles();
		LinkedHashMap<String, Player> players = loadplayers();
		LinkedHashMap<String, Team> teams = new LinkedHashMap<String, Team>();
		for (int j = 0; j < listofFiles.length; j++){
			if (listofFiles[j].isFile()){
				XMLFile file = SAXParser.parseFile("/data/base/teams/" + listofFiles[j].getName());
				String id = file.getElement("TEAM").getAttribute("id");
				String name = file.getElement("TEAM").getAttribute("name");
				String coach = file.getElement("TEAM").getAttribute("coach");
				Team team = new Team(id, name, coach);
				for (int i = 1; i < file.getElement("TEAM.PLAYERS").elements(); i++ ){
					if(players.get(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")) == null){
						System.out.println(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")+" is niet in the file");
					}
					if(file.getElement("TEAM.PLAYERS.PLAYER", i).getContent("ACTIVE").equals("true")){
						team.addActivePlayer(players.get(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					}
					else if(file.getElement("TEAM.PLAYERS.PLAYER", i).getContent("ACTIVE").equals("false")){
						team.addBenchPlayer(players.get(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					}
					else{
						System.out.println("er is een fout in players");
					}
				}
				teams.put(id, team);
			}
		}
		return teams;
		
	}
		
	
	public static LinkedHashMap<String, Player> loadplayers(){
		String current = System.getProperty("user.dir");
		File folder = new File(current + "/src/main/resources/data/base/players/");
		File[] listofFiles = folder.listFiles();
		ArrayList<Player> players = new ArrayList<Player>();
		LinkedHashMap<String, Player> playerslist = new LinkedHashMap<String, Player>();
		for (int i = 0; i < listofFiles.length; i++){
			if (listofFiles[i].isFile()){
				XMLFile file = SAXParser.parseFile("/data/base/players/" + listofFiles[i].getName());
				String id =  file.getElement("PLAYER").getAttribute("id");
				String last = file.getElement("PLAYER.NAME").getAttribute("last");
				String first = file.getElement("PLAYER.NAME").getAttribute("first");
				String country = file.getContent("PLAYER.COUNTRY");
				String type = file.getContent("PLAYER.TYPE");
				String pos =  file.getContent("PLAYER.POS");
				int price = Integer.parseInt(file.getContent("PLAYER.TPRICE"));
				String team = file.getContent("PLAYER.TEAM");
				if (type.equals("GK")){
					int DIV = Integer.parseInt(file.getElement("PLAYER.STATS").getContent("DIV"));
					int POS =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("POS"));
					int REF =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("REF"));
					playerslist.put(id, new Goalkeeper(id, first, last, country, REF, DIV, POS, price ));
					players.add(new Goalkeeper(id, first, last, country, REF, DIV, POS, price ));
	
				} else {
					int ATT = Integer.parseInt(file.getElement("PLAYER.STATS").getContent("ATT"));
					int DEF =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("DEF"));
					int STA =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("STA"));
					playerslist.put(id, new Fieldplayer(id, first, last, country, pos, ATT, DEF, STA, price));
					players.add(new Fieldplayer(id, first, last, country, pos, ATT, DEF, STA, price));
				}
			}
		}
		return playerslist;
	}
	
	public static void SaveGame(Game game){
		ArrayList<User> users = game.getUsers();
		String current = System.getProperty("user.dir");
		new File(current + "/src/main/resources/data/savedgames/"+game.getUser().getUserName()+"/").mkdir();
		File folder = new File(current + "/src/main/resources/data/savedgames/"+game.getUser().getUserName()+"/");
		LinkedHashMap<String, String> emptyatts = new LinkedHashMap<String, String>();
		for(int i=0; i < users.size(); i++){
			Team team = users.get(i).getTeam();
			LinkedHashMap<String, String> atts = new LinkedHashMap<String, String>();
			atts.put("id", team.getid());
			atts.put("name", team.getTeamName());
			atts.put("coach", team.getCoachName());
			XMLTag root = new XMLTag("TEAM", atts);
			for(int j =0; j < team.getActivePlayers().size(); j++){
				LinkedHashMap<String, String> playeratts = new LinkedHashMap<String, String>();
				playeratts.put("id", team.getActivePlayers().get(j).getID());
				XMLTag player = new XMLTag("PLAYER", playeratts);
				XMLTag active = new XMLTag("ACTIVE", emptyatts);
				active.setContent("true");
				player.addElement(active);
				root.addElement(player);
			}
			for(int j =0; j < team.getBenchPlayers().size(); j++){
				LinkedHashMap<String, String> playeratts = new LinkedHashMap<String, String>();
				playeratts.put("id", team.getBenchPlayers().get(j).getID());
				XMLTag player = new XMLTag("PLAYER", playeratts);
				XMLTag active = new XMLTag("ACTIVE", emptyatts);
				active.setContent("false");
				player.addElement(active);
				root.addElement(player);
			}
			XMLFile teamfile = new XMLFile(root);
			teamfile.save(current + "/src/main/resources/data/savedgames/"+game.getUser().getUserName()+"/"+users.get(i).getUserName()+".XML");
		}
	}
	
	public static ArrayList<Team> loadTeams(){
		String current = System.getProperty("user.dir");
		File folder = new File(current + "/src/main/resources/data/base/teams/");
		File[] listofFiles = folder.listFiles();
		LinkedHashMap<String, Player> players = loadplayers();
		ArrayList<Team> teams = new ArrayList<Team>();
		for (int j = 0; j < listofFiles.length; j++){
			if (listofFiles[j].isFile()){
				XMLFile file = SAXParser.parseFile("/data/base/teams/" + listofFiles[j].getName());
				String id = file.getElement("TEAM").getAttribute("id");
				String name = file.getElement("TEAM").getAttribute("name");
				String coach = file.getElement("TEAM").getAttribute("coach");
				Team team = new Team(id, name, coach);
				for (int i = 1; i < file.getElement("TEAM.PLAYERS").elements(); i++ ){
					if(players.get(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")) == null){
						System.out.println(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")+" is niet in the file");
					}
					if(file.getElement("TEAM.PLAYERS.PLAYER", i).getContent("ACTIVE").equals("true")){
						team.addActivePlayer(players.get(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					}
					else if(file.getElement("TEAM.PLAYERS.PLAYER", i).getContent("ACTIVE").equals("false")){
						team.addBenchPlayer(players.get(file.getElement("TEAM.PLAYERS.PLAYER", i).getAttribute("id")));
					}
					else{
						System.out.println("er is een fout in palyers");
					}
				}
				teams.add(team);
			}
		}
		return teams;
		
	}
	
	public static ArrayList<Player> loadplayersArrayList(){
		String current = System.getProperty("user.dir");
		File folder = new File(current + "/src/main/resources/data/base/players/");
		File[] listofFiles = folder.listFiles();
		ArrayList<Player> players = new ArrayList<Player>();

		for (int i = 0; i < listofFiles.length; i++){
			if (listofFiles[i].isFile()){
				XMLFile file = SAXParser.parseFile("/data/base/players/" + listofFiles[i].getName());
				String id =  file.getElement("PLAYER").getAttribute("id");
				String last = file.getElement("PLAYER.NAME").getAttribute("last");
				String first = file.getElement("PLAYER.NAME").getAttribute("first");
				String country = file.getContent("PLAYER.COUNTRY");
				String type = file.getContent("PLAYER.TYPE");
				String pos =  file.getContent("PLAYER.POS");
				int price = Integer.parseInt(file.getContent("PLAYER.TPRICE"));
				String team = file.getContent("PLAYER.TEAM");
				if (type.equals("GK")){
					int DIV = Integer.parseInt(file.getElement("PLAYER.STATS").getContent("DIV"));
					int POS =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("POS"));
					int REF =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("REF"));
					
					players.add(new Goalkeeper(id, first, last, country, REF, DIV, POS, price ));
	
				} else {
					int ATT = Integer.parseInt(file.getElement("PLAYER.STATS").getContent("ATT"));
					int DEF =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("DEF"));
					int STA =  Integer.parseInt(file.getElement("PLAYER.STATS").getContent("STA"));
	
					players.add(new Fieldplayer(id, first, last, country, pos, ATT, DEF, STA, price));
				}
			}
		}
		return players;
	}

}
