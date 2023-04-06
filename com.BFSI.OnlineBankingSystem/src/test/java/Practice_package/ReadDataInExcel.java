package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataInExcel {

	public static void main(String[] args) throws Throwable {


		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		//to get workbook
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//get sheet 
		Sheet sh = wb.getSheet("details");
		// get row
		Row row = sh.getRow(1);
		//get cell
		Cell cell = row.getCell(1);
		//get data
		String data = cell.getStringCellValue();
		System.out.println(data);
		
	/*	Workbook wb = WorkbookFactory.create(fis);
		
		String v = wb.getSheet("details").getRow(1).getCell(0).getStringCellValue();
		System.out.println(v);*/
	}

}
