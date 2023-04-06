package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtility.IpathConstant;

public class DataExcel {
	
	@DataProvider
	public Object[][] getexceldata() throws Throwable {
		
		FileInputStream fis=new FileInputStream(IpathConstant.DATAPATH);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("data");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
