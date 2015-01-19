package nl.joshuaslik.tudelft.UFMGame.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * For your daily interactions with ZIP files and the like
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Zipper {

	public static void printEntries(PrintStream stream, String zip) {
		ZipFile zipFile = constructFile(zip);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			stream.println(zipEntry.getName());
		}
	}

	public static LinkedHashMap<String, ZipEntry> listEntries(String zip) {
		ZipFile zipFile = constructFile(zip);
		
		LinkedHashMap<String, ZipEntry> ret = new LinkedHashMap<String, ZipEntry>();
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			ret.put(zipEntry.getName(), zipEntry);
		}
		
		return ret;
	}

	private static ZipFile constructFile(String zip) {
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(zip);
		} catch (IOException e) {
			System.err.println("[ERROR] Error opening zip file: " + zip);
		}
		return zipFile;
	}

}
