package com.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public DatabaseUtility db=new DatabaseUtility();
	public WebDriverUtility dLib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(alwaysRun=true)
	public void configBs() throws Throwable {
		//db.conenectToBB();
		System.out.println("Connect to Data Base");		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun=true)
	//public void configBc(String BROWSER) throws Throwable {
	public void configBc() throws Throwable{
		String browser = fLib.readDataFromPropertyFile("browser");
		String url = fLib.readDataFromPropertyFile("url");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else {
			System.out.println("Invalid Browser");
		}
		
		sdriver=driver;
		dLib.maximizewindow(driver);
		driver.get(url);
		dLib.waitForPageLoad(driver);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void configBM() {
		System.out.println("login into the application");
	}
	
	@AfterMethod(alwaysRun=true)
	public void configAM() {
		System.out.println("logout from the application");
	}
	
	@AfterClass(alwaysRun=true)
	public void configAC() {
		System.out.println("Browser closed");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun=true)
	public void configAS() throws Throwable {
		//db.closeDB();
	}
}
