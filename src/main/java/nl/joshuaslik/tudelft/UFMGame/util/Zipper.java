package nl.joshuaslik.tudelft.UFMGame.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * For your daily interactions with ZIP files and the like
 * 
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class Zipper {

	/**
	 * Prints the entries
	 * @param stream is the stream you have to print
	 * @param zip the file is a zip
	 */
	public static void printEntries(PrintStream stream, String zip) {
		ZipFile zipFile = constructFile(zip);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			stream.println(zipEntry.getName());
		}
	}

	/**
	 * Making an arraylist of the zip
	 * @param zip is the file in which it is
	 * @return the zipfile as an array
	 */
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
	
	/**
	 * Listing the entries as a string
	 * @param zip is the file 
	 * @return the zipfile as an array
	 */
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
