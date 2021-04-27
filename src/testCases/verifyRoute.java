package testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import setup.Browser;
import setup.elementHandler;

public class verifyRoute {
	
	public static List<String> verifyRouteCount(HashMap <String, String> searchInputs) throws InterruptedException {
		List<String> tc_routes=new ArrayList<String>();
		tc_routes.add("Verifying route count from "+searchInputs.get("Source")+" to "+searchInputs.get("Destination")+" by "+searchInputs.get("Vehicle")+" as: "+searchInputs.get("Routes"));
		String result;
		WebElement elemSearh=elementHandler.getWebElement("input_Search");
		elemSearh.click();
		elemSearh.sendKeys(searchInputs.get("Source"));
		Thread.sleep(2000);
		elemSearh.sendKeys(Keys.ENTER);
		elementHandler.getWebElement("btn_Route").click();
		Thread.sleep(2000);
		WebElement elementDest=elementHandler.getWebElement("input_destination");
		elementDest.click();
		elementDest.sendKeys(searchInputs.get("Destination"));
		Thread.sleep(2000);
		elementDest.sendKeys(Keys.ENTER);
		WebElement transeportType=elementHandler.getWebElementXpath("//label[normalize-space(text())='"+searchInputs.get("Vehicle")+"']");
		transeportType.click();
		Thread.sleep(2000);
		int actualCount=elementHandler.getWebElements("routes").size();
		if(actualCount==Integer.parseInt(searchInputs.get("Routes"))) {
			result="Pass";
			tc_routes.add(result);
		} else {
			result="Fail";
			tc_routes.add(result);
			tc_routes.add("Expected Count: "+searchInputs.get("Routes"));
			tc_routes.add("Actual Count: "+actualCount);
			Browser.takeScreenShot("route");
		}
		elementHandler.getWebElement("btn_SearchBack").click();
		return tc_routes;	
	}

}
