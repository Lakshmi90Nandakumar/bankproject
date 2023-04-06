package Practice_package;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

	
	
	@DataProvider
	public Object[][] data() {
		Object [][] obj=new Object[2][2];
		obj[0][0]="Qspider";
		obj[0][1]="TestYantra";
		
		obj[1][0]="TestYantra";
		obj[1][1]="Sony";
		return obj;
		
	}

	
}
