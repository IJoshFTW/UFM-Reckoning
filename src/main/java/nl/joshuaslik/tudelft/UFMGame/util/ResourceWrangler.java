package nl.joshuaslik.tudelft.UFMGame.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * @return
	 */
	public static URL getResource(String name) {
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
	 * @return
	 */
	public static InputStream getResourceAsStream(String name) {
		return Class.class.getResourceAsStream(name);
	}

	public static ArrayList<String> listResourceFiles(String name) {
		if (runFromJar()) {

		} else {
			name = ClassLoader.getSystemResource("").getPath() + name;
			File folder = new File(name);
			List<File> filelist = Arrays.asList(folder.listFiles());
			ArrayList<String> filenamelist = new ArrayList<String>();
			for (int i = 0; i < filelist.size(); i++) {
				if (filelist.get(i).isFile()) {
					int cutpoint = ClassLoader.getSystemResource("").getPath()
							.length() - 2;
					filenamelist.add(filelist.get(i).getPath()
							.substring(cutpoint));
				}
			}
			return filenamelist;
		}
		return null;
	}

	public static ArrayList<String> listResourceDirectories(String name) {
		if (runFromJar()) {

		} else {
			name = ClassLoader.getSystemResource("").getPath() + name;
			File folder = new File(name);
			List<File> filelist = Arrays.asList(folder.listFiles());
			ArrayList<String> filenamelist = new ArrayList<String>();
			for (int i = 0; i < filelist.size(); i++) {
				if (filelist.get(i).isDirectory()) {
					int cutpoint = ClassLoader.getSystemResource("").getPath()
							.length() - 2;
					filenamelist.add(filelist.get(i).getPath()
							.substring(cutpoint));
				}
			}
			return filenamelist;
		}
		return null;
	}

	public static boolean runFromJar() {
		URL testpath = ClassLoader.getSystemResource("");
		if (testpath == null) {
			System.out.println("[ResourceWrangler] I am run from a jar");
			return true;
		}
		System.out.println("[ResourceWrangler] I am not run from a jar");
		return false;
	}

}
