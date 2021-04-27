package setup;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
	
	public static WebDriver driver;
    static String browserName = null;

    public static WebDriver createWebDriver(String browser) throws Exception {
        System.setProperty("browser", browser);
        switch (browser.toLowerCase()) {
            case "ff":
            case "firefox":              
                System.setProperty("webdriver.gecko.driver", "./lib/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "ch":
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./lib/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;

            case "edge":
            	System.setProperty("webdriver.edge.driver", "./lib/drivers/msedgedriver.exe");
                driver = new EdgeDriver();;
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new Exception("Invalid Browser : " + browser);
        }


        return driver;
    }
    
    public static void open(String url) {

        //System.out.println("EC: @ Browser");
        driver.get(url);
    }
    
    public static void setup() throws Exception {
	     
    	createWebDriver(env_Setup.fetchData("browserType"));
		open(env_Setup.fetchData("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS) ;

	    }
    
    public static void endSession() throws Exception {
	     
    	driver.quit();

	    }
    
    public static void takeScreenShot(String fileName) {
    	
    	 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	 try {
             FileUtils.copyFile(screenshot, new File("./screenshots/"+fileName+"_"+System.currentTimeMillis()+".png"));
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
    }

}
