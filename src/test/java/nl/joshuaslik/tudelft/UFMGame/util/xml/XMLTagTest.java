package nl.joshuaslik.tudelft.UFMGame.util.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;

import nl.joshuaslik.tudelft.UFMGame.util.xml.NoSuchAttributeException;
import nl.joshuaslik.tudelft.UFMGame.util.xml.NoSuchElementException;
import nl.joshuaslik.tudelft.UFMGame.util.xml.SAXParser;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLFile;
import nl.joshuaslik.tudelft.UFMGame.util.xml.XMLTag;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests to check the XMLTag
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class XMLTagTest {

	private XMLTag tag;

	/**
	 * General rule for an expected exception
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Create a constructor for the XML tag
	 */
	public void construct() {
		LinkedHashMap<String, String> atts = new LinkedHashMap<String, String>();
		atts.put("attribute1", "value1");
		atts.put("attribute2", "value2");
		tag = new XMLTag("rootname", atts);
		tag.setContent("rootcontent");
		atts = new LinkedHashMap<String, String>();
		XMLTag sub = new XMLTag("subname", atts);
		sub.setContent("subcontent");
		tag.addElement(sub);
	}

	/**
	 * Tests the constructor
	 */
	@Test
	public void testConstructor() {
		construct();
	}

	/**
	 * Test to check if you can get the name
	 */
	@Test
	public void testGetName() {
		construct();
		assertTrue(tag.getName().equals("rootname"));
	}

	/**
	 * Test to check if you can get the content of the tag
	 */
	@Test
	public void testGetContent1() {
		construct();
		assertTrue(tag.getContent().equals("rootcontent"));
	}

	/**
	 * Test to check if you can get the content of the tag
	 */
	@Test
	public void testGetContent2() {
		construct();
		assertTrue(tag.getContent("rootname").equals("rootcontent"));
	}

	/**
	 * Test to check if you can get the content of the tag
	 */
	@Test
	public void testGetContent3() {
		construct();
		assertTrue(tag.getContent("rootname.subname").equals("subcontent"));
	}

	/**
	 * Test to check if you can get the content of the tag
	 */
	@Test
	public void testGetContent4() {
		construct();
		thrown.expect(NoSuchElementException.class);
		tag.getContent("rootname.falsesubname");
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced1() {
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		assertTrue(testfile.getElement("TEAM.PLAYERS.PLAYER", 1)
				.getContent("ACTIVE").equals("true"));
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced2() {
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		assertTrue(testfile.getElement("TEAM.PLAYERS").elements("PLAYER") == 28);
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced3() {
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		assertTrue(testfile.getElement("TEAM.PLAYERS").hasMoreThanOneElement(
				"PLAYER"));
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced4() {
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		assertTrue(testfile.getContent("TEAM.PLAYERS.PLAYER", 1).equals(""));
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced5() {
		thrown.expect(NoSuchElementException.class);
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		assertTrue(testfile.getContent("TEAM.PLAYERS.PLAYERS", 1).equals(""));
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced6() {
		thrown.expect(NoSuchElementException.class);
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		assertTrue(testfile.getContent("TEAM.PLAYERS.PLAYER", 100).equals(""));
	}

	/**
	 * Test to check if you can get the content
	 */
	@Test
	public void testGetContentAdvanced7() {
		thrown.expect(NoSuchElementException.class);
		XMLFile testfile = SAXParser.parseFile("/data/base/teams/ajax.xml");
		testfile.getElement("TEAM.PLAYERS")
				.addElement(new XMLTag("asdf", null));
		testfile.getElement("TEAM.PLAYERS.PLAYER", 100);
	}

	/**
	 * Test to check if you can get an element of the tag
	 */
	@Test
	public void getElement1() {
		construct();
		XMLTag sub = null;
		sub = tag.getElement("subname");
		assertTrue(sub.getContent().equals("subcontent"));
	}

	/**
	 * Test to check if you can get an element of the tag
	 */
	@Test
	public void getElement2() {
		construct();
		thrown.expect(NoSuchElementException.class);
		tag.getElement("falsesubname");
	}

	/**
	 * Test to check if the tag has elements
	 */
	@Test
	public void testHasElements1() {
		construct();
		assertTrue(tag.hasElements());
	}

	/**
	 * Test to check if the tag has elements
	 */
	@Test
	public void testHasElements2() {
		construct();
		assertFalse(tag.getElement("subname").hasElements());
	}

	/**
	 * Test to check if the tag has elements
	 */
	@Test
	public void testHasElement() {
		construct();
		assertTrue(tag.hasElement("subname"));
	}

	/**
	 * Test to check if the tag has elements
	 */
	@Test
	public void testElements() {
		construct();
		assertEquals(tag.elements(), 1);
	}

	/**
	 * Test to check if a tag has an attribute
	 */
	@Test
	public void testHasAttribute1() {
		construct();
		assertTrue(tag.hasAttribute());
	}

	/**
	 * Test to check if a tag has an attribute
	 */
	@Test
	public void testHasAttribute2() {
		construct();
		assertFalse(tag.getElement("rootname.subname").hasAttribute());
	}

	/**
	 * Test to check if a tag has an attribute
	 */
	@Test
	public void testHasAttribute3() {
		construct();
		assertTrue(tag.hasAttribute("attribute1"));
	}

	/**
	 * Test to check if a tag has an attribute
	 */
	@Test
	public void testHasAttribute4() {
		construct();
		assertFalse(tag.hasAttribute("fakeattribute"));
	}

	/**
	 * Test to check if you can get an attribute
	 */
	@Test
	public void testGetAttribute1() {
		construct();
		assertTrue(tag.getAttribute("attribute1").equals("value1"));
	}

	/**
	 * Test to check if you can get an attribute
	 */
	@Test
	public void testGetAttribute2() {
		construct();
		thrown.expect(NoSuchAttributeException.class);
		tag.getAttribute("fakeattribute");
	}

	/**
	 * Test to check the string
	 */
	@Test
	public void testToString1() {
		construct();
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">rootcontent\n")
				.append("    <subname>subcontent</subname>\n")
				.append("</rootname>").toString();
		assertTrue(tag.toString().equals(expected));

	}

	/**
	 * Test to check the string
	 */
	@Test
	public void testToString2() {
		construct();
		tag.setContent(null);
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">\n")
				.append("    <subname>subcontent</subname>\n")
				.append("</rootname>").toString();
		assertTrue(tag.toString().equals(expected));
	}

	/**
	 * Test to check the string
	 */
	@Test
	public void testToString3() {
		construct();
		tag.getElement("subname").setContent("");
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">rootcontent\n")
				.append("    <subname />\n").append("</rootname>").toString();
		assertTrue(tag.toString().equals(expected));
	}

	/**
	 * Test to check the string
	 */
	@Test
	public void testToString4() {
		construct();
		tag.getElement("subname").setContent(null);
		String expected = new StringBuilder()
				.append("<rootname attribute1=\"value1\" attribute2=\"value2\">rootcontent\n")
				.append("    <subname />\n").append("</rootname>").toString();
		assertTrue(tag.toString().equals(expected));
	}

}
