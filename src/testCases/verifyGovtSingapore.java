package testCases;

import java.util.ArrayList;
import java.util.List;

import setup.Browser;
import setup.elementHandler;

public class verifyGovtSingapore {

	public static List<String> verifyGovtLogo(){
		
		List<String> govtLogo=new ArrayList<>();
		String testCase="Verify govt of singapore logo is present";
		govtLogo.add(testCase);
		String result;
		if(elementHandler.getWebElements("elem_govtLogo").size()>0) {
			result="Pass";
		} else {
			result="Fail";
			Browser.takeScreenShot("logo");
		}
		govtLogo.add(result);
		return govtLogo;
	}
}
