package reqresPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	File file;
	FileInputStream fis;
	XSSFWorkbook excelWorkbook;
	XSSFSheet excelSheet;
	FileOutputStream fos;
	String fileName;

	public ExcelConfig(String fileName) {
		this.fileName = fileName;
		String filePath = System.getProperty("user.dir") + "\\TestData\\";
		System.out.println(filePath + fileName);
		file = new File(filePath + fileName);
		try {
			fis = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getXlSheet(String sheetName) {
		try {
			excelWorkbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		excelSheet = excelWorkbook.getSheet(sheetName);
	}

	public int getRowNum() {
		int rowNum = excelSheet.getLastRowNum();
		return rowNum;
	}

	public int getColumnNum() {
		int colNum = excelSheet.getRow(0).getLastCellNum();
		return colNum;
	}

	public String getCellData(String colName, int rowIndex) {
		String colHeaderName = null;
		String cellData = null;
		column: for (int i = 0; i <= getColumnNum(); i++) {
			colHeaderName = excelSheet.getRow(0).getCell(i).getStringCellValue();
			if (colName.equals(colHeaderName)) {
				row: for (int j = rowIndex; j <= getRowNum(); j++) {
					cellData = excelSheet.getRow(j).getCell(i).getStringCellValue();
					break row;
				}
				break column;
			}
		}
		return cellData;
	}

	public void closeXl() {
		try {
			excelWorkbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}