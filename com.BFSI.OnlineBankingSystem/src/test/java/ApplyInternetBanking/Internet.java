package ApplyInternetBanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.PageObject.InternetBankingRegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Internet {

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

		InternetBankingRegistrationPage ib=new InternetBankingRegistrationPage(driver);
		ib.regristration(driver);
		
	}

}
