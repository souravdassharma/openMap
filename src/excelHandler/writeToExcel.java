package excelHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import setup.env_Setup;

public class writeToExcel {
	
	
	/* public static void createFile() throws IOException {
		File reportFile = new File(env_Setup.fetchData("testReport"));
		if(!reportFile.exists()){
			reportFile.createNewFile();
		}else{
		  System.out.println("File already exists");
		}
	} */
	
	public static HSSFSheet createHeaders(HSSFWorkbook wb, String sheetName) {
		HSSFSheet sheet=wb.createSheet(sheetName);
		Row header=sheet.createRow(0);
		Cell cell1=header.createCell(0);
		Cell cell2=header.createCell(1);
		Cell cell3=header.createCell(2);
		Cell cell4=header.createCell(3);
		Cell cell5=header.createCell(4);
		cell1.setCellValue("Test Case");
		cell2.setCellValue("Result");
		cell3.setCellValue("Expected");
		cell4.setCellValue("Actual");
		cell5.setCellValue("Comment");
		return sheet;
	}
	
	public static void writeTestResult(HSSFSheet sheet, int rowNum, List<String> output) throws IOException {
		Row row= sheet.createRow(rowNum+1);
		for (int i=0;i<output.size();i++) {
			Cell cell=row.createCell(i);
			cell.setCellValue(output.get(i));
		}		
	}
	
	public static void createTestResult(HSSFWorkbook wb) throws IOException {
		String fpath=env_Setup.fetchData("testReport");
		File file=new File (fpath);
		if(file.exists()) {
			fpath=fpath.split("Report.")[0]+"Report_"+System.currentTimeMillis()+".xls";
		}
		 FileOutputStream outputStream = new FileOutputStream(fpath);
	     wb.write(outputStream);
	     outputStream.close();
	}
}
