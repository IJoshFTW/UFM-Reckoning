package nl.joshuaslik.tudelft.UFMGame.util.xml;

import java.io.File;

import nl.joshuaslik.tudelft.UFMGame.util.xml.SAXParser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests to check the SAX parser
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class SAXParserTest {

	/**
	 * general rule
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Constructs the file 
	 */
	public void constructFile() {

	}

	/**
	 * Test to check if an xml file can be parsed
	 */
	@Test
	public void testParseFile1() {
		// TODO Properly integrate this
		SAXParser.parseFile("/data/base/players/adamsarota.xml");
	}

	/**
	 * Test to check if an xml file can be parsed
	 */
	@Test
	public void testParseFile2() {
		SAXParser.parseFile("/data/base/players/adamsarotaasdfasdf.xml");
	}

	/**
	 * Test to check if a string can be parsed
	 */
	@Test
	public void testParseString() {
		String xmlstring = new StringBuilder()
				.append("<PLAYER id=\"adamsarota\">")
				.append("    <NAME first=\"Adam\" last=\"Sarota\" />")
				.append("    <COUNTRY>Australia</COUNTRY>")
				.append("    <TYPE>MF</TYPE>")
				.append("    <POS>CM</POS>")
				.append("    <STATS>")
				.append("        <ATT>62\"  \" \\ \\\" \r</ATT>\r\n")
				// How much can one irritate an XML Parser
				.append("        <DEF>60</DEF>")
				.append("        <STA>84</STA>").append("    </STATS>")
				.append("    <TPRICE>250000</TPRICE>")
				.append("    <TEAM>fc-utrecht</TEAM>").append("</PLAYER>")
				.toString();
		SAXParser.parseString(xmlstring);
	}

	/**
	 * Test to check if a string can be parsed
	 */
	@Test
	public void testParseStringMalformed1() {
		String xmlstring = new StringBuilder()
				.append("<PLAYER id=\"adamsarota\">")
				.append("    <NAME first=\"Adam\" last=\"Sarota\" />")
				.append("    <COUNTRY>Australia</COUNTRY>")
				.append("    <TYPE>MF</TYPE>").append("    <POS>CM</POS>")
				.append("    <STATS>").append("        <ATT>62</ATT>")
				.append("        <DEF>60</DEF>")
				.append("        <STA>84</STA>").append("    </STATS>")
				.append("    <TPRICE>250000</TPRICE>")
				.append("    <TEAM>fc-utrecht</TEAM>").append("</PLAYER>")
				.append("<ILLEGALTAG>").toString();
		SAXParser.parseString(xmlstring);
	}

	// @Test
	// public void testParseStringBreak2() {
	// String xmlstring = new StringBuilder()
	// .append("<PLAYER id=\"adamsarota\">\n")
	// .append("    <NAME first=\"Adam\" last=\"Sarota\" />\n")
	// .append("    <COUNTRY>Australia</COUNTRY>\n")
	// .append("    <TYPE>MF</TYPE>\n")
	// .append("    <POS>CM</POS>\n")
	// .append("    <STATS>\n")
	// .append("        <ATT>62</ATT>\n")
	// .append("        <DEF>60</DEF>\n")
	// .append("        <STA>84</STA>\n")
	// .append("    </STATS>\n")
	// .append("    <TPRICE>250000</TPRICE>\n")
	// .append("    <TEAM>fc-utrecht</TEAM>\n")
	// .append("</PLAYER>\n")
	// .append("<ILLEGALTAG>\n")
	// .toString();
	// File save = new File("build/testtarget/SAXParserTest/invalidxml.xml");
	// makeDirs("build/testtarget/SAXParserTest/invalidxml.xml");
	// PrintWriter pw = null;
	// try {
	// pw = new PrintWriter(save, "UTF-8");
	// } catch (FileNotFoundException e) {
	// System.err.println(e.getMessage());
	// e.printStackTrace();
	// } catch (UnsupportedEncodingException e) {
	// System.err.println(e.getMessage());
	// e.printStackTrace();
	// }
	// pw.write(xmlstring);
	// pw.flush();
	// pw.close();
	// XMLFile file =
	// SAXParser.parseFile("/build/testtarget/SAXParserTest/invalidxml.xml");
	// System.out.println(file.getContent("PLAYER.STATS.ATT"));
	// }

	@SuppressWarnings("unused")
	private void makeDirs(String location) {
		File target = new File(location);
		String here = new File("").getAbsolutePath();
		String apath = target.getAbsolutePath();
		apath = apath.replace("\\", "/");
		apath = apath.substring(here.length() + 1);
		apath = apath.substring(0, apath.lastIndexOf('/'));
		File file = new File(apath);
		file.mkdirs();
	}

}
