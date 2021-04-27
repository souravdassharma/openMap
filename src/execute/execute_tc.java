package execute;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import excelHandler.readFromXL;
import excelHandler.writeToExcel;
import setup.Browser;
import setup.elementHandler;
import setup.env_Setup;
import testCases.verifyGovtSingapore;
import testCases.verifyMenus;
import testCases.verifyOverlayisPresent;
import testCases.verifyRoute;
import testCases.verifyWindowTitle;
public class execute_tc {
	
public static List<String> menuName = new ArrayList<String>(Arrays.asList("Vaccination Centres","COVID-19 Test Providers","Nearby Parks","Essential Amenities (2km)","School Query","PHPC near you","Land Query","Drone Query","Traffic Query","Property Query","Population Query","Nearby","Biz Query","Bus Explorer","Base Maps","Gallery","About OneMap","Feedback","Help"));
public static List<String> menuElem = new ArrayList<String>(Arrays.asList("btn_vaccineCenters","btn_covid19TestProviders","btn_nearbyParks","btn_essentialAmenities","btn_schoolQuery","btn_PHPC","btn_landQuery","btn_droneQuery","btn_trafficQuery","btn_propertyQuery","btn_populationQuery","btn_nearby","btn_bizQuery","btn_busExplorer","btn_baseMaps","btn_gallery","btn_abtOneMap","btn_feedback","btn_help"));

public static List<String> topMenuElem = new ArrayList<String>(Arrays.asList("btn_vaccineCenters","btn_covid19TestProviders","btn_nearbyParks","btn_essentialAmenities","btn_schoolQuery"));
public static List<String> sideMenuElem = new ArrayList<String>(Arrays.asList("btn_PHPC","btn_landQuery","btn_droneQuery","btn_trafficQuery","btn_propertyQuery","btn_nearby","btn_bizQuery","btn_busExplorer","btn_baseMaps","btn_abtOneMap","btn_feedback","btn_help"));
public static List<String> topMenuLinkNames = new ArrayList<String>(Arrays.asList("Vaccination Centres","COVID-19 Test Providers","Nearby Parks","Essential Amenities (2km)","School Query"));
public static List<String> sideMenuLinkNames = new ArrayList<String>(Arrays.asList("PHPC near you","Land Query","Drone Query","Traffic Query","Property Query","Nearby","Biz Query","Bus Explorer","Base Maps","About OneMap","Feedback","Help"));

public static List<String> camMenu = new ArrayList<String>(Arrays.asList(""));
	
	public static void main(String args[]) {
		
		List<String> tc_Tilte=new ArrayList<String>();
		List<String> tc_govtLogo=new ArrayList<String>();
		List<String> tc_overlay=new ArrayList<String>();
		List<String> tc_menuName=new ArrayList<String>();
		List<String> tc_topMenuLink=new ArrayList<String>();
		List<String> tc_sideMenuLink=new ArrayList<String>();
		List<String> tc_routeCount=new ArrayList<String>();
		HashMap<String, List<String>> inputs=new HashMap<>();
		HSSFWorkbook wrkbk = HSSFWorkbook.create(InternalWorkbook.createWorkbook());
		int j;
		
		String directoryName = "./screenshots";
		File directory = new File(directoryName);
		    if (!directory.exists()){
		        directory.mkdir();
		    }	
	
		 try { 
			 Browser.setup(); 
			 tc_Tilte=verifyWindowTitle.verifyTitle();// test case
			 tc_govtLogo=verifyGovtSingapore.verifyGovtLogo(); // test case
			 tc_overlay=verifyOverlayisPresent.checkOverlay(); // test case
			 System.out.println(tc_Tilte);
			 writeToExcel.writeTestResult(writeToExcel.createHeaders(wrkbk,"Verify Title"), 0, tc_Tilte);
			 System.out.println(tc_govtLogo);
			 writeToExcel.writeTestResult(writeToExcel.createHeaders(wrkbk,"Verify Govt Logo"), 0, tc_govtLogo);
			 System.out.println(tc_overlay);
			 writeToExcel.writeTestResult(writeToExcel.createHeaders(wrkbk,"Check OverLay Present"), 0, tc_overlay);
			 elementHandler.getWebElement("btn_wiedgetBar").click();
			 Thread.sleep(500);
			 HSSFSheet menuSheet=writeToExcel.createHeaders(wrkbk,"Validate Menu Names");
			 for(int i=0;i<menuElem.size();i++) {
				 tc_menuName=verifyMenus.validateMenuNames(menuElem.get(i), menuName.get(i)); // test case
				 System.out.println(tc_menuName);
				 writeToExcel.writeTestResult(menuSheet, i, tc_menuName);
				 tc_menuName.clear();
			 }
			 HSSFSheet menuLinkSheet=writeToExcel.createHeaders(wrkbk,"Validate Menu Link");
			 elementHandler.getWebElement("btn_wiedgetBar").click();
			 for(j=0;j<topMenuElem.size();j++) {
				 tc_topMenuLink=verifyMenus.validateTopMenuLink(topMenuElem.get(j), topMenuLinkNames.get(j)); // test case
				 System.out.println(tc_topMenuLink);
				 writeToExcel.writeTestResult(menuLinkSheet, j, tc_topMenuLink);
				 tc_topMenuLink.clear();
			 }
			
			 for(int k=0;k<sideMenuElem.size();k++) {
				 tc_sideMenuLink=verifyMenus.validateSideMenuLink(sideMenuElem.get(k), sideMenuLinkNames.get(k)); // test case
				 System.out.println(tc_sideMenuLink);
				 writeToExcel.writeTestResult(menuLinkSheet, (j+k), tc_sideMenuLink);
				 tc_sideMenuLink.clear();
			 } 
			 HSSFSheet routeSheet=writeToExcel.createHeaders(wrkbk,"Validate Route Count");
			 inputs=readFromXL.readXl(env_Setup.fetchData("testData"), 0);
			 HashMap <String, String> searchData=new HashMap<>();
				int loopSize=inputs.get("Source").size();
				for(int i=0;i<loopSize;i++) {
					searchData.put("Source", inputs.get("Source").get(i));
					searchData.put("Destination", inputs.get("Destination").get(i));
					searchData.put("Vehicle", inputs.get("Vehicle").get(i));
					searchData.put("Routes", inputs.get("Route").get(i));
					tc_routeCount=verifyRoute.verifyRouteCount(searchData); // test case
					System.out.println(tc_routeCount);
					writeToExcel.writeTestResult(routeSheet, i, tc_routeCount);
				}
			 writeToExcel.createTestResult(wrkbk);
			 Browser.endSession();			 
			 }
		 catch (Exception e) {  
			 e.printStackTrace();
			 }
	}

}
