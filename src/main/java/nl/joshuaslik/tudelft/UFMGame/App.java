package nl.joshuaslik.tudelft.UFMGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipFile;

import nl.joshuaslik.tudelft.UFMGame.backend.Save;
import nl.joshuaslik.tudelft.UFMGame.gui.Main;
import nl.joshuaslik.tudelft.UFMGame.util.ResourceWrangler;
import nl.joshuaslik.tudelft.UFMGame.util.Zipper;
import nl.joshuaslik.tudelft.UFMGame.util.xml.SAXParser;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLFile;

/**
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class App {

	/**
	 * The main class for Ultimate Football Manager
	 * 
	 * @param args
	 *            is an array of command line arguments
	 */
	public static void main(String[] args) {
		Main.fullscreen=true;
		System.out.println("Ultimate Football Manager");
		System.out
				.println("(c) 2014-2015 - Sander Benoist, Naomi de Ridder, Joshua Slik, Lisette Veldkamp, Bryan van Wijk");

		// Random tests
		if (args.length > 0) {
			if (args[0].equals("readfiletest")) {
				if (args.length < 2) {
					System.err.println("You need to provide a filename");
				} else {
					InputStream input = Class.class
							.getResourceAsStream(args[1]);
					InputStreamReader inputReader = new InputStreamReader(input);
					BufferedReader reader = new BufferedReader(inputReader);

					String line = null;
					try {
						while ((line = reader.readLine()) != null)
							System.out.println(line);
						reader.close();
					} catch (IOException e) {
						System.err
								.println("Error reading or closing BufferedReader");
					}

				}
			}

			if (args[0].equals("xmlparse")) {
				if (args.length < 2) {
					System.err.println("You need to provide a filename");
				} else {
					XMLFile file = SAXParser.parseFile(args[1]);
					System.out.println(file.toString());
					System.out.println(file.getContent("PLAYER.STATS.STA"));
				}
			}

			if (args[0].equals("xmlsave")) {
				if (args.length < 3) {
					System.err.println("You need to provide two filenames");
				} else {
					XMLFile file = SAXParser.parseFile(args[1]);
					file.save(args[2]);
				}
			}

			if (args[0].equals("xmlsave")) {
				if (args.length < 3) {
					System.err.println("You need to provide two filenames");
				} else {
					XMLFile file = SAXParser.parseFile(args[1]);
					file.save(args[2]);
				}
			}

			if (args[0].equals("loadtest")) {
				System.out.println(Save.loadPlayers().get(63).getID());
				Save.loadTeams();
			}
			
			if (args[0].equals("appdatatest")) {
				String saveloc = System.getenv("APPDATA") + "\\Ultimate Football Manager\\saves\\slot" + 1 + ".xml";
				System.out.println(saveloc);
			}
			
			if (args[0].equals("filelisttest")) {
				String rootloc = ClassLoader.getSystemResource("root").getPath();
				rootloc = rootloc.substring(0, rootloc.length() - 5);
				rootloc = rootloc.substring(5, rootloc.length() - 1);
				System.out.println(rootloc);
				ZipFile rootfolder = null;
				
				Zipper.printEntries(System.out, rootloc);
				System.out.println(Class.class.getResourceAsStream("/root"));
				System.out.println(Class.class.getResourceAsStream("/data/base/players/adamsarota.xml"));
			}
			
			if (args[0].equals("resourcelisttest")) {
				System.out.println(ResourceWrangler.listResourceFiles("/data/base/players"));
				System.out.println(ResourceWrangler.listResourceDirectories("/data/base/players"));
				System.out.println(ResourceWrangler.listResourceDirectories("/data"));
				System.out.println(ResourceWrangler.listResourceDirectories("/data/base"));
				System.out.println(ResourceWrangler.getJarName());
			}

		} else {
			Main.main(args);
		}

	}

}