package excelFiles;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelSheetReader {
	
	String path;
	String sheetName;
	public ExcelSheetReader(String filePath, String excelSheetName){
		path = filePath;
		sheetName = excelSheetName;
	}
	
	public List<Map<String, String>> readExcel() throws IOException {
		List<Map<String, String>> listOfMaps = new LinkedList<>();	
		try {
			Workbook workbook;
			workbook = Workbook.getWorkbook(new File(path));
			Sheet sheet = workbook.getSheet(sheetName); 

			for (int row = 0; row < sheet.getRows(); row++) {
				HashMap<String, String> map = new HashMap<>();
				for (int col = 0; col < sheet.getColumns(); col++) {
					String key = sheet.getCell(col,0).getContents();
					String value = 	sheet.getCell(col,row).getContents();		
					map.put(key, value);
				}
				listOfMaps.add(map);	
			}

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfMaps;
	}
}
