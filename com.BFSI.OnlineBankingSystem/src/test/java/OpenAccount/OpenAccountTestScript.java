package OpenAccount;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.IpathConstant;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.PageObject.ApprovePendingAccountPage;
import com.PageObject.HomePage;
import com.PageObject.OpenAccountConformationPage;
import com.PageObject.OpenAccountpage;
import com.PageObject.StaffLoginHomePage;
import com.PageObject.StaffLoginPage;
import com.PageObject.ViewCustomerByAcPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccountTestScript {

	public static void main(String[] args) throws Throwable {

		
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility dLib = new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();		
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		dLib.maximizewindow(driver);
		String aurl = fLib.readDataFromPropertyFile("url");
		driver.get(aurl);
		dLib.waitForPageLoad(driver);		
		//click on open account 
		HomePage hp=new HomePage(driver);
		hp.openAccount();	
		OpenAccountpage op=new OpenAccountpage(driver);
		op.openaccount(driver);
		OpenAccountConformationPage oac = new OpenAccountConformationPage(driver);		
		String applicationnum = oac.applicationnum(driver);			
		StaffLoginPage sl = new StaffLoginPage(driver);
		sl.stafflogin();		
		//Click on Approve Pending A/C module		
		StaffLoginHomePage slh = new StaffLoginHomePage(driver);
		slh.approvePendingAc();
		ApprovePendingAccountPage ap = new ApprovePendingAccountPage(driver);
		String accountnum = ap.approvependingaccount(applicationnum, driver);
 
		 //click on Home button present in staff login 
		slh.stafHome();
			
		//verify customer details after creating account			
			//click on customer by account module
			slh.viewCustomerbyAc();			
			ViewCustomerByAcPage vc = new ViewCustomerByAcPage(driver);	
			vc.VerifyCustomerbyAcNo(accountnum, driver);

		
	}

}
