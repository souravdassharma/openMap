package testCases;

import static setup.Browser.driver;

import java.util.ArrayList;
import java.util.List;

import setup.Browser;

public class verifyWindowTitle {
	
	public static List<String> verifyTitle () {
		List<String> tc_title=new ArrayList<String>();
		String result;
		tc_title.add("Verify Window Title as OpenMap");
		String title=driver.getTitle();
		if(title.equals("OneMap")) {
			result="Pass";
		} else {
			result="Fail";
			Browser.takeScreenShot("title");
		}
		tc_title.add(result);
		return tc_title;
	}

}
