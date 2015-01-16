package nl.joshuaslik.UFMReckoning;

import nl.joshuaslik.tudelft.UFMGame.App;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple Application
 * 
 * @author Naomi de Ridder
 */
public class AppTest {

	/**
	 * General rule for thrown exception
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test to check the app
	 */
	@Test
	public void testApp() {
		App.main(new String[] { "" });
	}

	/**
	 * Test to check if a file can be read
	 */
	@Test
	public void testReadFile() {
		App.main(new String[] { "readfiletest",
				"/data/base/players/adamsarota.xml" });
	}

	/**
	 * Test to check if a file can be read
	 */
	@Test
	public void testReadFileNoArgument() {
		App.main(new String[] { "readfiletest" });
	}

	/**
	 * Test to check a fake file
	 */
	@Test
	public void testReadFileNotExistant() {
		thrown.expect(NullPointerException.class);
		App.main(new String[] { "readfiletest", "/fake/file/path/wololo.xml" });
	}

	/**
	 * Test to check the XML parse
	 */
	@Test
	public void testXMLParse() {
		App.main(new String[] { "xmlparse", "/data/base/players/adamsarota.xml" });
	}

	/**
	 * Test to check the XML parse
	 */
	@Test
	public void testXMLParseNoArgument() {
		App.main(new String[] { "xmlparse" });
	}

	/**
	 * Test to check if an XML can be saved
	 */
	@Test
	public void testXMLSave() {
		App.main(new String[] { "xmlsave", "/data/base/players/adamsarota.xml",
				"build/testtarget/AppTest/adamsarota.xml" });
	}

	/**
	 * Test to check if an XML can be saved
	 */
	@Test
	public void testXMLSaveNoArgument() {
		App.main(new String[] { "xmlsave" });
	}

}
