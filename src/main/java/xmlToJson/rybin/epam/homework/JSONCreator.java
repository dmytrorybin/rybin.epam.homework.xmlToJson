package xmlToJson.rybin.epam.homework;

import org.json.JSONObject;

public class JSONCreator {
	
	JSONObject resultJson = new JSONObject();

	public JSONObject createJSON (RunnerOfXML xml) {
	
		for (Person person : xml.getPersons()) {
//		for (int i = 0; i < xml.getPersons().size(); i++) {
			resultJson.accumulate("Name", person.name);
			resultJson.accumulate("url", person.url);
		}
		return resultJson;
	}
	
	public void printAll () {
		System.out.print(resultJson.toString());
	}
}
