package Practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGEx {

	private static final String dataprovider = null;

	@Test
	public void create() {
		System.out.println("created project");
	}
	
	
	@Test(invocationCount=2, dependsOnMethods="create")
	public void edit() {
		System.out.println(" data is edited");
	}
	
	@Test()
	public void delete() {
		System.out.println("data is deleted");
	}
	
	
	
	@DataProvider
	public Object[][] data() {
		Object [][] obj=new Object[2][2];
		obj[0][0]="Qspider";
		obj[0][1]="TestYantra";
		
		obj[1][0]="TestYantra";
		obj[1][1]="Sony";
		return obj;
		
	}
	
	@Test(dataProvider="data")
	public void getdata(String src, String dst) {
		
		System.out.println("From---->"+src+ "to---."+dst);
		
	}
	
}
