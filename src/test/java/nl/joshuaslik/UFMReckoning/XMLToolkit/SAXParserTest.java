package nl.joshuaslik.UFMReckoning.XMLToolkit;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class SAXParserTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	public void constructFile() {

	}

	@Test
	public void testParseFile1() {
		// TODO Properly integrate this
		XMLFile file = SAXParser.parseFile("/data/base/players/adamsarota.xml");
	}
	
	@Test
	public void testParseFile2() {
		XMLFile file = SAXParser.parseFile("/data/base/players/adamsarotaasdfasdf.xml");
	}

	@Test
	public void testParseString() {
		String xmlstring = new StringBuilder()
				.append("<PLAYER id=\"adamsarota\">")
				.append("    <NAME first=\"Adam\" last=\"Sarota\" />")
				.append("    <COUNTRY>Australia</COUNTRY>")
				.append("    <TYPE>MF</TYPE>")
				.append("    <POS>CM</POS>")
				.append("    <STATS>")
				.append("        <ATT>62</ATT>")
				.append("        <DEF>60</DEF>")
				.append("        <STA>84</STA>")
				.append("    </STATS>")
				.append("    <TPRICE>250000</TPRICE>")
				.append("    <TEAM>fc-utrecht</TEAM>")
				.append("</PLAYER>")
				.toString();
		XMLFile file = SAXParser.parseString(xmlstring);
	}

	@Test
	public void testParseStringBreak1() {
		String xmlstring = new StringBuilder()
				.append("<PLAYER id=\"adamsarota\">")
				.append("    <NAME first=\"Adam\" last=\"Sarota\" />")
				.append("    <COUNTRY>Australia</COUNTRY>")
				.append("    <TYPE>MF</TYPE>")
				.append("    <POS>CM</POS>")
				.append("    <STATS>")
				.append("        <ATT>62</ATT>")
				.append("        <DEF>60</DEF>")
				.append("        <STA>84</STA>")
				.append("    </STATS>")
				.append("    <TPRICE>250000</TPRICE>")
				.append("    <TEAM>fc-utrecht</TEAM>")
				.append("</PLAYER>")
				.append("<ILLEGALTAG>")
				.toString();
		XMLFile file = SAXParser.parseString(xmlstring);
	}

//	@Test
//	public void testParseStringBreak2() {
//		String xmlstring = new StringBuilder()
//				.append("<PLAYER id=\"adamsarota\">\n")
//				.append("    <NAME first=\"Adam\" last=\"Sarota\" />\n")
//				.append("    <COUNTRY>Australia</COUNTRY>\n")
//				.append("    <TYPE>MF</TYPE>\n")
//				.append("    <POS>CM</POS>\n")
//				.append("    <STATS>\n")
//				.append("        <ATT>62</ATT>\n")
//				.append("        <DEF>60</DEF>\n")
//				.append("        <STA>84</STA>\n")
//				.append("    </STATS>\n")
//				.append("    <TPRICE>250000</TPRICE>\n")
//				.append("    <TEAM>fc-utrecht</TEAM>\n")
//				.append("</PLAYER>\n")
//				.append("<ILLEGALTAG>\n")
//				.toString();
//		File save = new File("build/testtarget/SAXParserTest/invalidxml.xml");
//		makeDirs("build/testtarget/SAXParserTest/invalidxml.xml");
//		PrintWriter pw = null;
//		try {
//			pw = new PrintWriter(save, "UTF-8");
//		} catch (FileNotFoundException e) {
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//		}
//		pw.write(xmlstring);
//		pw.flush();
//		pw.close();
//		XMLFile file = SAXParser.parseFile("/build/testtarget/SAXParserTest/invalidxml.xml");
//		System.out.println(file.getContent("PLAYER.STATS.ATT"));
//	}
	
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
