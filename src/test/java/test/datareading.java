package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datareading {

	public static void main(String[] args) {
		String file_path = "C:\\Users\\taps4\\eclipse-workspace\\playWright\\demo.xlsx";
		try {
			FileInputStream fs = new FileInputStream(file_path);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			
			int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println(rowcount);
			System.out.println(sheet.getRow(0).getCell(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
