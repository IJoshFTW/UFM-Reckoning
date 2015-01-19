package nl.joshuaslik.tudelft.UFMGame.util.xml;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.util.xml.NoSuchElementException;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLFile;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLTag;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class XMLFileTest {

	private XMLFile file;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	public void construct() {
		LinkedHashMap<String, String> atts = new LinkedHashMap<String, String>();
		atts.put("attribute1", "value1");
		atts.put("attribute2", "value2");
		XMLTag tag = new XMLTag("rootname", atts);
		tag.setContent("rootcontent");
		atts = new LinkedHashMap<String, String>();
		XMLTag sub = new XMLTag("subname", atts);
		sub.setContent("subcontent");
		tag.addElement(sub);
		file = new XMLFile(tag);
	}

	@Test
	public void testConstructor() {
		construct();
	}

	@Test
	public void testGetContent2() {
		construct();
		assertTrue(file.getContent("rootname").equals("rootcontent"));
	}

	@Test
	public void testGetContent3() {
		construct();
		assertTrue(file.getContent("rootname.subname").equals("subcontent"));
	}

	@Test
	public void testGetContent4() {
		construct();
		thrown.expect(NoSuchElementException.class);
		file.getContent("rootname.falsesubname");
	}

	@Test
	public void testGetContent5() {
		construct();
		thrown.expect(NoSuchElementException.class);
		file.getContent("rootname.fakename");
	}

	@Test
	public void testGetElement1() {
		construct();
		assertTrue(file.getElement("rootname").getName().equals("rootname"));
		assertTrue(file.getElement("rootname").getContent()
				.equals("rootcontent"));
	}

	@Test
	public void testGetElement2() {
		construct();
		thrown.expect(NoSuchElementException.class);
		file.getElement("rootname.fakename");
	}

	@Test
	public void testSave1() {
		construct();
		file.save("build/testtarget/XMLFileTest/testSave1.xml");
	}

	@Test
	public void testSave2() {
		construct();
		file.save("build/testtarget/XMLFileTest/testSave2.xml", "UTF-16");
	}

	@Test
	public void testSave3() {
		construct();
		thrown.expect(NullPointerException.class);
		file.save("build/testtarget/XMLFileTest/testSave3.xml", "NOAH-16");
	}

	@Test
	public void testSave4() {
		construct();
		thrown.expect(NullPointerException.class);
		file.save("build/testtarget/XMLFileTest/Hal\0lo.txt");
	}

	@Test
	public void testToString1() {
		construct();
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">rootcontent\n")
				.append("    <subname>subcontent</subname>\n")
				.append("</rootname>").toString();
		assertTrue(file.toString().equals(expected));
	}

	@Test
	public void testToString2() {
		construct();
		file.getElement("rootname").setContent(null);
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">\n")
				.append("    <subname>subcontent</subname>\n")
				.append("</rootname>").toString();
		assertTrue(file.toString().equals(expected));
	}

	@Test
	public void testToString3() {
		construct();
		file.getElement("rootname.subname").setContent("");
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">rootcontent\n")
				.append("    <subname />\n").append("</rootname>").toString();
		assertTrue(file.toString().equals(expected));
	}

	@Test
	public void testToString4() {
		construct();
		file.getElement("rootname.subname").setContent(null);
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">rootcontent\n")
				.append("    <subname />\n").append("</rootname>").toString();
		assertTrue(file.toString().equals(expected));
	}

}
