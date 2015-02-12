package framework.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class xmlReader {

	public String getPropValues() throws IOException {

		String result = "";
		Properties prop = new Properties();
		String propFileName = "configFile.xml";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		Date time = new Date(System.currentTimeMillis());

		// get the property value and print it out
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String browser1 = prop.getProperty("browser1");
		String browser2 = prop.getProperty("browser2");

		result = "Property List = " + url + ", " + password + ", " + browser1 + ", " + browser2;
		System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
		return result;
	}
}
