package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataInExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("details");
		Row row = sh.getRow(4);
		Cell cell = row.getCell(0);
		cell.setCellValue("py");
		
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wb.write(fos);
		wb.close();	

		 	}

}
