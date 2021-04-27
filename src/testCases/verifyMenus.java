package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import setup.Browser;
import setup.elementHandler;

public class verifyMenus {
	
	
public static List<String> validateMenuNames(String menu,String menuText ){
	List<String> tc_compareMenu=new ArrayList<String>();
	tc_compareMenu.add("Validate menu name of "+menu+" as "+menuText);
	String actualMenuName=elementHandler.getWebElement(menu).getText();
	String result;
	if(actualMenuName.equals(menuText)) {
		result="Pass";
		tc_compareMenu.add(result);
		
	} else {
		result="Fail";
		tc_compareMenu.add(result);
		tc_compareMenu.add("Expected menu name: "+menuText);
		tc_compareMenu.add("Actual menu name: "+actualMenuName);
		Browser.takeScreenShot("menuNames");
		
	}	
	return tc_compareMenu;
}	
	
public static List<String> validateTopMenuLink(String btn,String tabName){
	List<String> tc_topMenuLink=new ArrayList<String>();
	List<WebElement> btn_Close=new ArrayList<WebElement>();
	tc_topMenuLink.add("Validate menu link is working for "+tabName);	
	String result;
	elementHandler.getWebElement(btn).click();
	try {
		elementHandler.getWebElement("btn_formOK").click();
	} catch (Throwable e) {
//		System.out.println(e);
	}
	try {
		String actualTabName=elementHandler.getWebElements("menuTab_title").get(0).getText();
		if(actualTabName.equals(tabName)) {
			result="Pass";
			tc_topMenuLink.add(result);
		} else {
			result="Fail";
			tc_topMenuLink.add(result);
			tc_topMenuLink.add("Expected tab title is: "+tabName);
			tc_topMenuLink.add("Actual tab title is: "+actualTabName);
			Browser.takeScreenShot("menuLink");
		}
		btn_Close=elementHandler.getWebElements("btn_closeMenu");
		for(int t=0;t<btn_Close.size();t++) {
			btn_Close.get(t).click();
		}
	} catch (Throwable e) {
		tc_topMenuLink.add("Element not found for tab: "+tabName);
	}

	return tc_topMenuLink;
}
	
public static List<String> validateSideMenuLink(String btn,String tabName){
	List<WebElement> btn_Close=new ArrayList<WebElement>();
	List<String> tc_sideMenuLink=new ArrayList<String>();
	String result;
	tc_sideMenuLink.add("Validate menu link is working for "+tabName);	
	elementHandler.getWebElement("btn_wiedgetBar").click();
	elementHandler.getWebElement(btn).click();
	try {
		elementHandler.getWebElement("btn_formOK").click();
	} catch (Throwable e) {
//		System.out.println(e);
	}
	try {
		String actualTabName=elementHandler.getWebElements("menuTab_title").get(0).getText();
		if(actualTabName.equals(tabName)) {
			result="Pass";
			tc_sideMenuLink.add(result);
		} else {
			result="Fail";
			tc_sideMenuLink.add(result);
			tc_sideMenuLink.add("Expected tab title is: "+tabName);
			tc_sideMenuLink.add("Actual tab title is: "+actualTabName);
			Browser.takeScreenShot("menuLink");
		}
		btn_Close=elementHandler.getWebElements("btn_closeMenu");
		for(int t=0;t<btn_Close.size();t++) {
			btn_Close.get(t).click();
		}
	} catch(Throwable e) {
		tc_sideMenuLink.add("Element not found for tab: "+tabName);
	}
	
	return tc_sideMenuLink;
	
	}
}
