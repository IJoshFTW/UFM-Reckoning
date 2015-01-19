package nl.joshuaslik.tudelft.UFMGame.util;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Doing the difficult stuff with resources so you don't have to.
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ResourceWrangler {

	public static URL getResource(String name) {
		return Class.class.getResource(name);
	}
	
	public static InputStream getResourceAsStream(String name) {
		return Class.class.getResourceAsStream(name);
	}
	
	public static ArrayList<String> getFileList(String name) {
		return null;
		
	}
	
	public static boolean runFromJar() {
		URL testpath = ClassLoader.getSystemResource("");
		if (testpath == null) {
			System.out.println("I am run from a jar");
			return true;
		}
		System.out.println("I am not run from a jar");
		return true;	
	}
	
}
