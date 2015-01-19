package nl.joshuaslik.tudelft.UFMGame.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
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

	public static ArrayList<ZipEntry> listEntries(String zip) {
//		System.out.println("Zip Called");
		ZipFile zipFile = constructFile(zip);
//		System.out.println(zipFile);
		ArrayList<ZipEntry> ret = new ArrayList<ZipEntry>();
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			ret.add(zipEntry);
		}
//		System.out.println(ret);
		return ret;
	}
	
	public static ArrayList<String> listEntriesString(String zip) {
		ZipFile zipFile = constructFile(zip);
		
		ArrayList<String> ret = new ArrayList<String>();
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			ret.add(zipEntry.getName());
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
