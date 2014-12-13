package nl.joshuaslik.UFMReckoning.util.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 *
 * @author <a href="http://www.joshuaslik.nl/" target="_blank">Joshua Slik</a>
 *
 */
public class XMLTag {

	private String name;
	// In LinkedHashMap for easy checking if elements contains a tag of a
	// certain name
	// (form of indexing)
	private ArrayList<XMLTag> elements;
	private ArrayList<String> elementnames;
	private LinkedHashMap<String, String> atts;
	private String content;

	public XMLTag(String name, LinkedHashMap<String, String> atts) {
		this.name = name;
		this.atts = atts;
		this.elements = new ArrayList<XMLTag>();
		this.elementnames = new ArrayList<String>();
		this.content = null;
	}

	public int elements() {
		return elements.size();
	}

	/**
	 * 
	 * @return true or false depending on if the element exists
	 */
	public boolean hasElements() {
		if (elements.size() == 0)
			return false;
		return true;
	}

	public boolean hasElement(String name) {
		return elementnames.contains(name);
	}

	public void addElement(XMLTag element) {
		elements.add(element);
		elementnames.add(element.getName());
	}

	/**
	 * @param element
	 *            is the index of the element to get
	 * @return the element
	 * @throws NoSuchElementException
	 *             is thrown if the element is not found
	 */
	public XMLTag getElement(String element) throws NoSuchElementException {
		if (element.equals(name)) {
			return this;
		}
		// Get the string of the following elements (+ 1 to also chop off
		// the '.')
		int splitpoint = element.indexOf(".") + 1;
		element = element.substring(splitpoint, element.length());
		if (elementnames.contains(element))
			return elements.get(elementnames.indexOf(element)).getElement(
					element);
		throw new NoSuchElementException(this.name + " does not have element "
				+ element);
	}

	public String getContent(String element) throws NoSuchElementException {
		if (element.equals(name)) {
			return content;
		}
		// Get the string of the following elements (+ 1 to also chop off
		// the '.')
		int splitpoint = element.indexOf(".") + 1;
		element = element.substring(splitpoint, element.length());
		String subelement = element.split("\\.")[0];
		if (Collections.frequency(elementnames, subelement) > 1)
			throw new ElementNotUniqueException(this.name
					+ " contains more than one element called '" + subelement + "'");
		if (elementnames.contains(subelement))
			return elements.get(elementnames.indexOf(subelement)).getContent(
					element);
		throw new NoSuchElementException(this.name + " does not have element '"
				+ element + "'");
	}

	public boolean hasAttribute() {
		return !(atts.isEmpty());
	}

	public boolean hasAttribute(String str) {
		return atts.containsKey(str);
	}

	public String getAttribute(String attribute)
			throws NoSuchAttributeException {
		if (atts.containsKey(attribute)) {
			return atts.get(attribute);
		}
		throw new NoSuchAttributeException(this.name
				+ " does not have attribute " + attribute + "!");
	}

	/**
	 * Getter
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter
	 * 
	 * @param name
	 *            is the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter
	 * 
	 * @return the elements
	 */
	// public LinkedHashMap<String, XMLTag> getElements() {
	// return elements;
	// }

	/**
	 * Setter
	 * 
	 * @param elements
	 *            is the elements to set
	 */
	// public void setElements(LinkedHashMap<String, XMLTag> elements) {
	// this.elements = elements;
	// }

	/**
	 * Getter
	 * 
	 * @return the attributes
	 */
	public LinkedHashMap<String, String> getAttributes() {
		return atts;
	}

	/**
	 * Setter
	 * 
	 * @param atts
	 *            is the attributes to set
	 */
	public void setAttributes(LinkedHashMap<String, String> atts) {
		this.atts = atts;
	}

	/**
	 * Getter
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter
	 * 
	 * @param content
	 *            is the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return toString(0);
	}

	public String toString(int indent) {
		String retstr = "";
		String dent = "";
		for (int i = 0; i < indent; i++)
			dent = dent + " ";

		retstr = retstr + dent + "<" + name;

		if (!(atts.isEmpty())) {
			ArrayList<String> keys = new ArrayList<String>(atts.keySet());
			ArrayList<String> values = new ArrayList<String>(atts.values());
			for (int i = 0; i < atts.size(); i++) {
				retstr = retstr + " " + keys.get(i) + "=\"" + values.get(i)
						+ "\"";
			}
		}

		if (elements.size() == 0 && (content == null || content.isEmpty())) {
			return retstr + " />" + "\n";
		}
		retstr = retstr + ">";

		if (!(content == null) && !(content.isEmpty())) {
			retstr = retstr + content;
		}

		if (elements.size() > 0) {
			retstr = retstr + "\n";
			for (int i = 0; i < elements.size(); i++)
				retstr = retstr + elements.get(i).toString(indent + 4);
			retstr = retstr + dent + "</" + name + ">" + "\n";
		} else {
			retstr = retstr + "</" + name + ">" + "\n";
		}

		return retstr;
	}
}
