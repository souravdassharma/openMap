package excelHandler;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class readFromXL {

	public static FileInputStream file;
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
//	public static HashMap<String, List<String>> data = new HashMap<>();


	public static HashMap<String, List<String>> readXl(String fpath, Integer sheetIndex) {
		List<String> headerList = new ArrayList<>();
		List<String> values = new ArrayList<>();
		List<List<String>> collumnData = new ArrayList<List<String>>();
		HashMap<String, List<String>> xlData = new HashMap<>();

		xlData.clear();
		try {
			file = new FileInputStream(new File(fpath));
			workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheetAt(sheetIndex);
			headerList = getHeaders();
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i < rowCount + 1; i++) {
				Row row = sheet.getRow(i);
				values = read(row);
				collumnData.add(values);
			}
			for (int k=0;k<headerList.size();k++) {
				List<String> valueList=new ArrayList<String>();
				for (int p=0;p<collumnData.size();p++) {
					valueList.add(collumnData.get(p).get(k));
					
				}
				xlData.put(headerList.get(k), valueList);
			
				
			}
			
			file.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		
		return xlData;
	}

	public static List<String> getHeaders() {
		List<String> headers = new ArrayList<>();
		Row row = sheet.getRow(0);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			headers.add(cell.getStringCellValue());
		}
		return headers;

	}

	public static List<String> read(Row currentRow) {
		List<String> rowCollData = new ArrayList<>();
		int cellCount=currentRow.getLastCellNum();
		for(int k=0;k<cellCount;k++) {
				
			Cell cell = currentRow.getCell(k);
			if (cell.getCellType().toString().equals("NUMERIC")) {
				rowCollData.add(String.valueOf((int)(cell.getNumericCellValue())));
			} else {
				rowCollData.add(cell.getStringCellValue());
			}
		}
		return rowCollData;
	}
	
}
