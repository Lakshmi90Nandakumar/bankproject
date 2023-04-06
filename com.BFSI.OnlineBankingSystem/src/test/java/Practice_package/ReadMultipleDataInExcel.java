package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataInExcel {

	public static void main(String[] args) throws Throwable {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("details");
			int count = sh.getLastRowNum();
			
			for(int i=1;i<count;i++) {
				String branch = sh.getRow(i).getCell(0).getStringCellValue();
				String loc = sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(branch+"  "+loc);
			}
			
	}

}
