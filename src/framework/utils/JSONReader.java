package framework.utils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 
 * @author Carlos Guevara
 *
 */
public class JSONReader {
	
	public String readJSON(String data) {
		JSONParser parser = new JSONParser();
		String value = "";
		String filePath = System.getProperty("user.dir")+"/src/config/config.json";
		try {
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			value = (String) jsonObject.get(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}