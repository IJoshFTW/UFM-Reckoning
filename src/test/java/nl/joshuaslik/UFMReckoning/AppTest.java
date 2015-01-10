package nl.joshuaslik.UFMReckoning;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testApp() {
		App.main(new String[] { "" });
	}

	@Test
	public void testReadFile() {
		App.main(new String[] { "readfiletest",
				"/data/base/players/adamsarota.xml" });
	}

	@Test
	public void testReadFileNoArgument() {
		App.main(new String[] { "readfiletest" });
	}

	@Test
	public void testReadFileNotExistant() {
		thrown.expect(NullPointerException.class);
		App.main(new String[] { "readfiletest", "/fake/file/path/wololo.xml" });
	}

	@Test
	public void testXMLParse() {
		App.main(new String[] { "xmlparse", "/data/base/players/adamsarota.xml" });
	}

	@Test
	public void testXMLParseNoArgument() {
		App.main(new String[] { "xmlparse" });
	}

	@Test
	public void testXMLSave() {
		App.main(new String[] { "xmlsave", "/data/base/players/adamsarota.xml",
				"build/testtarget/AppTest/adamsarota.xml" });
	}

	@Test
	public void testXMLSaveNoArgument() {
		App.main(new String[] { "xmlsave" });
	}

}
