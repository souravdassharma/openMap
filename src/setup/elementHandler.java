package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static setup.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class elementHandler {
	
	 public static WebElement getWebElement(String elemKey){
//		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  WebElement elem=null;
	        Properties properties = new Properties();
	        try {
	        	FileInputStream inps = new FileInputStream("./elements.properties");
	            properties.load(inps);
	            String elemXpath=properties.getProperty(elemKey);
	            elem=driver.findElement(By.xpath(elemXpath));
	            inps.close();

	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
	        } catch (IOException e) {
//	            e.printStackTrace();
	        }

	        return elem;
	    }
	 
	 public static WebElement getWebElementXpath(String elemXpath){
//		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  WebElement elem=null;
	     
	        try {	        	
	            elem=driver.findElement(By.xpath(elemXpath));
	        } catch (Throwable e) {
//	            e.printStackTrace();
	        }

	        return elem;
	    }
	 
	 public static List<WebElement> getWebElementsXpath(String elemXpath){
//		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 List<WebElement> elems=null;
	     
	        try {	        	
	            elems=driver.findElements(By.xpath(elemXpath));
	        } catch (Throwable e) {
//	            e.printStackTrace();
	        }

	        return elems;
	    }
	 
	 public static List<WebElement> getWebElements(String elemKey){
//		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  List<WebElement> elems=null;
	        Properties properties = new Properties();
	        try {
	        	FileInputStream inps = new FileInputStream("./elements.properties");
	            properties.load(inps);
	            String elemXpath=properties.getProperty(elemKey);
	            elems=driver.findElements(By.xpath(elemXpath));
	            inps.close();

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return elems;
	    }

}
