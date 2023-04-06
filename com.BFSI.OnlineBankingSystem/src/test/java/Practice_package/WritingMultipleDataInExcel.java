package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingMultipleDataInExcel {

	public static void main(String[] args) throws Throwable {

		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		for(int i=0;i<10;i++) {
		sh.getRow(i).getCell(0).setCellValue("mysore");
		sh.getRow(i).getCell(1).setCellValue("Hyd");

				
		}
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wb.write(fos);
		wb.close();
	
	}

}
