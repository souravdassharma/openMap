package testCases;

import java.util.ArrayList;
import java.util.List;

import setup.Browser;
import setup.elementHandler;

public class verifyOverlayisPresent {
	
	public static List<String> checkOverlay(){
		List<String> tc_overLay=new ArrayList<String>();
		tc_overLay.add("Verify Overlay is present");
		String result;
		if(elementHandler.getWebElements("overlay").size()>0) {
			result="Pass";
		} else {
			result="Fail";
			Browser.takeScreenShot("overLay");
		}
		tc_overLay.add(result);
		elementHandler.getWebElement("btn_doNotShow").click();
		return tc_overLay;
	}

}
