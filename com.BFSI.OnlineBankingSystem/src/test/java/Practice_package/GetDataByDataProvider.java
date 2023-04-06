package Practice_package;

import org.testng.annotations.Test;

public class GetDataByDataProvider {

	@Test(dataProviderClass=DataProviderTest.class,dataProvider="data")
	public void getdata(String src, String dst) {
		
		System.out.println("From---->"+src+ "to---."+dst);
		
	}


}
