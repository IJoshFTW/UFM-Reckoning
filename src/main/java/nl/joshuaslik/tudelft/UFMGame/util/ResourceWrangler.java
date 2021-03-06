package nl.joshuaslik.tudelft.UFMGame.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;

import nl.joshuaslik.tudelft.UFMGame.App;

/**
 * Doing the difficult stuff with resources so you don't have to.
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ResourceWrangler {

	/**
	 * Get a resource URL, starting from the classpath. <br>
	 * If the resource is at the top of the classpath, get it like this:
	 * "/nameoffile" <br>
	 * If the resource is in a subdirectory, get it like this:
	 * "/sub/dir/ect/ory/nameoffile" <br>
	 * In other words, always lead with a forward slash.
	 * 
	 * @param name
	 *            is the name of the resource file to get
	 * @return the name of the resource url
	 */
	public static URL getResource(String name) {
		name = name.replace("\\", "/");
		if (name.endsWith("/"))
			name = name.substring(0, name.length() - 1);
		return Class.class.getResource(name);
	}

	/**
	 * Get a resource as an InputStream, starting from the classpath. <br>
	 * If the resource is at the top of the classpath, get it like this:
	 * "/nameoffile" <br>
	 * If the resource is in a subdirectory, get it like this:
	 * "/sub/dir/ect/ory/nameoffile" <br>
	 * In other words, always lead with a forward slash.
	 * 
	 * @param name
	 *            is the name of the resource file to get
	 * @return the resource as a stream
	 */
	public static InputStream getResourceAsStream(String name) {
		name = name.replace("\\", "/");
		if (name.endsWith("/"))
			name = name.substring(0, name.length() - 1);
		return Class.class.getResourceAsStream(name);
	}

	/**
	 * get the resource files as a string
	 * 
	 * @param name
	 *            is a string
	 * @return resource files
	 */
	public static ArrayList<String> listResourceFiles(String name) {
		name = name.replace("\\", "/");
		if (name.endsWith("/"))
			name = name.substring(0, name.length() - 1);
		if (runFromJar()) {
			name = name.substring(1);
			ArrayList<ZipEntry> filelist = Zipper.listEntries(getJarName());
			ArrayList<String> filenamelist = new ArrayList<String>();

			for (int i = 0; i < filelist.size(); i++) {
				if (filelist.get(i).isDirectory() == false) {
					if (filelist.get(i).getName().startsWith(name)) {
						// Make a string cutting off the root, to check if it
						// goes down another directory
						String root = filelist.get(i).getName().substring(name.length() + 1);
						if (root.contains("/") == false && root.length() > 0) {
							filenamelist.add("/" + filelist.get(i).getName());
						}
					}
				}
			}
			return filenamelist;
		}

		// Code to list directories when not in a JAR
		String rootres = Class.class.getResource("/root").getPath();
		// System.out.println("Root: " + rootres);
		// System.out.println("Name: " + name);
		name = rootres.substring(0, rootres.length() - 5) + name;
		// System.out.println("Finl: " + name);
		File folder = new File(name);
		// System.out.println(folder);
		List<File> filelist = Arrays.asList(folder.listFiles());
		// System.out.println(folder.listFiles());
		// System.out.println(folder.listFiles()[0].toURI());
		ArrayList<String> filenamelist = new ArrayList<String>();
		for (int i = 0; i < filelist.size(); i++) {
			if (filelist.get(i).isFile()) {
				String filename = filelist.get(i).toURI().toString();
				filename = filename.replace("\\", "/");
				filenamelist.add(filename.substring(rootres.length()));
				// System.out.println("Added: " +
				// filename.substring(rootres.length()));
			}
		}
		return filenamelist;
	}

	/**
	 * get the list with resource directories
	 * 
	 * @param name
	 *            is a string
	 * @return resource files
	 */
	public static ArrayList<String> listResourceDirectories(String name) {
		name = name.replace("\\", "/");
		if (name.endsWith("/"))
			name = name.substring(0, name.length() - 1);
		if (runFromJar()) {
			name = name.substring(1);
			ArrayList<ZipEntry> filelist = Zipper.listEntries(getJarName());
			ArrayList<String> filenamelist = new ArrayList<String>();

			for (int i = 0; i < filelist.size(); i++) {
				if (filelist.get(i).isDirectory() == true) {
					if (filelist.get(i).getName().startsWith(name)) {
						// Make a string cutting off the root, to check if it
						// goes down another directory
						String root = filelist.get(i).getName().substring(name.length() + 1);
						// Check if there is only one / in the name and if it is
						// not 0 chars long
						if (root.indexOf("/") == root.lastIndexOf("/") && root.length() > 0) {
							filenamelist.add("/" + filelist.get(i).getName());
						}
					}
				}
			}
			return filenamelist;
		}

		// Code to list directories when not in a JAR
		String rootres = Class.class.getResource("/root").getPath();
		// System.out.println("Root: " + rootres);
		// System.out.println("Name: " + name);
		name = rootres.substring(0, rootres.length() - 5) + name;
		// System.out.println("Finl: " + name);
		File folder = new File(name);
		// System.out.println(folder);
		List<File> filelist = Arrays.asList(folder.listFiles());
		// System.out.println(folder.listFiles());
		// System.out.println(folder.listFiles()[0].toURI());
		ArrayList<String> filenamelist = new ArrayList<String>();
		for (int i = 0; i < filelist.size(); i++) {
			if (filelist.get(i).isDirectory()) {
				String filename = filelist.get(i).toURI().toString();
				filename = filename.replace("\\", "/");
				filenamelist.add(filename.substring(rootres.length()));
				// System.out.println("Added: " +
				// filename.substring(rootres.length()));
			}
		}
		return filenamelist;
	}

	/**
	 * check if you have to run from a jar
	 * 
	 * @return boolean true or false if it's run as a jar
	 */
	public static boolean runFromJar() {
		URL testpath = ClassLoader.getSystemResource("");
		if (testpath == null) {
			// System.out.println("[ResourceWrangler] I am run from a jar");
			return true;
		}
		// System.out.println("[ResourceWrangler] I am not run from a jar");
		return false;
	}

	private static String getJarName() {
		String filename = App.class.getResource("App.class").getPath();
		// Cut off file: and everything after .jar
		filename = filename.substring(5, filename.indexOf(".jar!") + 4);
		return filename;
	}

}
