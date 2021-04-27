package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class env_Setup {
	
	static Browser browser=new Browser();
	
	  public static String fetchData(String propertyKey){

	        String propertyValue=null;
	        Properties properties = new Properties();
	        try {
	        	FileInputStream inps = new FileInputStream("./setup.properties");
	            properties.load(inps);
	            propertyValue=properties.getProperty(propertyKey);
	            inps.close();

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return propertyValue;
	    }
	 
}
