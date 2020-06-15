package runner;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetdatafromExcel {

	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public GetdatafromExcel(String excelPath, String sheetName) {
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);		
	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void getRowCount() {
		int rowCnt = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows are : "+rowCnt);
	}
	
	public String getData(int rowNum, int colNum) {
		//DataFormatter format = new DataFormatter();
		//Object value = format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(value);
		return value;
	}

}
	
