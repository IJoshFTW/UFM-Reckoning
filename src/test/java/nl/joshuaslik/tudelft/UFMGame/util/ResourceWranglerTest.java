package nl.joshuaslik.tudelft.UFMGame.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 *
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class ResourceWranglerTest {

	/**
	 * General rule for thrown exception
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Testing method for getting a resource as a URL
	 */
	@Test
	public void testGetResource() {
		assertTrue(ResourceWrangler.getResource("/root/").toString().contains("file:"));
	}
	
	/**
	 * Testing method for getting a resource as a InputStream
	 * @throws IOException if there is a problem using the InputStream
	 */
	@Test
	public void testGetResourceAsStream() throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(ResourceWrangler.getResourceAsStream("/root/"), writer);
		String str = writer.toString();
		assertTrue(str.contains("Oh hai der :3"));
	}
	
	/**
	 * Testing method for getting the files in a resource directory
	 */
	@Test
	public void testListResourceFiles() {
		ArrayList<String> list = ResourceWrangler.listResourceFiles("/");
		assertTrue(list.contains("/root"));
	}
	
	/**
	 * Testing method for getting the directories in a resource directory
	 */
	@Test
	public void testListResourceDirectories() {
		ArrayList<String> list = ResourceWrangler.listResourceDirectories("/");
		assertTrue(list.contains("/data/"));
	}
	
}
