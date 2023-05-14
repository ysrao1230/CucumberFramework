package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Base.BasePage;

public class TestUtils extends BasePage {

	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getTestData(int n) {
		// very imp method for data driven framework
		FileInputStream file = null;
		try {
			file = new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheetAt(n);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; // return type of data is
																								// 2 dimensional object
																								// array, eg: 2nd row
																								// and 1st column
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) { // 2 for loops for row and column
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.print(data[i][k]);
				System.out.print("|");
			}
			System.out.println();
		}
		return data;

	}
}
