package xmlToJson.rybin.epam.homework;

import java.io.FileReader;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {
	public static void main(String[] args) {
//		String path = RunnerOfXML.class.getProtectionDomain().getCodeSource().getLocation().getPath();

		try {
			XMLReader xr = XMLReaderFactory.createXMLReader();
			RunnerOfXML xml = new RunnerOfXML();
			xr.setContentHandler(xml);
			JSONCreator json = new JSONCreator();

			xr.parse(new InputSource(new FileReader("src\\main\\resources\\data.xml")));
			xml.printAll();
			System.out.println();
			json.createJSON(xml);
			json.printAll();
			
		}catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}


