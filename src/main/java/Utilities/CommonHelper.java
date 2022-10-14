package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonHelper {
	

	@SuppressWarnings("finally")
	public String loadPropertyFileAndGetValue(String fileName,String key) {
		Properties prop = new Properties();
		String value=null;

		try {
		    prop.load(new FileInputStream(fileName));
		    value=prop.getProperty(key);
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}
		finally {
			return value;
		}
	}
	
	

}
