package xmlToJson.rybin.epam.homework;

import java.io.CharArrayWriter;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RunnerOfXML extends DefaultHandler {
	private Person currentPerson; 
	private List<Person> persons = new ArrayList<Person>();
	private CharArrayWriter contents = new CharArrayWriter();

	public void startElement(String namespaceURI, String localName, String qName, Attributes attr) throws SAXException {
		contents.reset();

		if (localName.equals("person")) {
			currentPerson = new Person();
			if (attr.getValue("id") != null) {
				currentPerson.id = Integer.parseInt(attr.getValue("id"));
			}
		}
	}
	
	public void endElement(String namespaceURI, String localName, String qName ) throws SAXException {

		 if (localName.equals("name")) {
			 currentPerson.name = contents.toString();
		 }
		 
		 if (localName.equals("url")) {
			 currentPerson.url = contents.toString();
		 }

		 if (localName.equals("person")) {
			 persons.add(currentPerson);
			 currentPerson = null;
		 }
	}
	
	public void characters( char[] ch, int start, int length ) throws SAXException
	{
	 contents.write( ch, start, length );
	}

	public void printAll() {
		for (int i = 0; i < persons.size(); i++) {
			persons.get(i).print();
		} 
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
