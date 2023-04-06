package Practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelUtility;

public class DpExcelData {

/*	@Test(dataProviderClass=DataExcel.class,dataProvider="getexceldata")
	public void getdata(String src,String dst) {
		System.out.println("From ====>"+src+" to ====>"+dst);
	}*/
	
	
		@Test(dataProvider="dataget")
	public void getdata(String src,String dst) {
		System.out.println("From ====>"+src+" to ====>"+dst);
	}

	
	
	@DataProvider
	
	public Object[][] dataget() throws Throwable {
		
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.getexceldatapro("data");
		return value;
		
	}
}
