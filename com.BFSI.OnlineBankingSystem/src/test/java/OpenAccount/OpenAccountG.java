package OpenAccount;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccountG {

	public static void main(String[] args) throws Throwable {

		
		WebDriverManager.chromedriver().create();		
		 WebDriver driver = new ChromeDriver();
			FileUtility fLib = new FileUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility dLib = new WebDriverUtility();
		
			dLib.maximizewindow(driver);
		
		
		String aurl = fLib.readDataFromPropertyFile("url");
		System.out.println(aurl);
		
		driver.get(aurl);
		dLib.waitForPageLoad(driver);
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		
		ExcelUtility eLib = new ExcelUtility();
		HashMap<String, String> map = eLib.readMultipleDataFromExcel("OpenAc");
		
		for(Entry<String, String> set:map.entrySet()) {
			if(set.getKey().equalsIgnoreCase("name"))
			{
				//String nm=set.getValue()+rann;
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.random());
			}
			else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
			}
		
		WebElement ele = driver.findElement(By.name("gender"));
		Select s = new Select(ele);
		s.selectByValue("Male");
		
		WebElement dob = driver.findElement(By.name("dob"));
		dob.click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_1);
		r.keyPress(KeyEvent.VK_9);
		r.keyPress(KeyEvent.VK_9);
		r.keyPress(KeyEvent.VK_2);	
		WebElement sele = driver.findElement(By.name("state"));
			dLib.select(sele, "Washington");
			WebElement cele = driver.findElement(By.name("city"));
			dLib.select("Texas City", cele);
			WebElement aele = driver.findElement(By.name("acctype"));
			dLib.select(aele, "Saving");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.name("cnfrm-submit")).click();
			String text = dLib.acceptAlert(driver);
			String applicationnum="";
			
			for(int i=0;i<text.length();i++) {
				if(Character.isDigit(text.charAt(i))) {
					applicationnum=applicationnum+text.charAt(i);					
				}
			}
			System.out.println("application number is" +applicationnum);
			
			//click on staff Login module
			driver.findElement(By.linkText("Staff Login")).click();
			//enter the Valid credentials and click on login
			String sun = fLib.readDataFromPropertyFile("sun");
			String pw = fLib.readDataFromPropertyFile("pw");
			driver.findElement(By.name("staff_id")).sendKeys(sun);
			driver.findElement(By.name("password")).sendKeys(pw);
			Thread.sleep(3000);
			driver.findElement(By.name("staff_login-btn")).click();
			
			//Click on Approve Pending A/C module

			driver.findElement(By.xpath("//input[@name='apprvac']")).click();
			//Enter the Account details need to be approved
			
			driver.findElement(By.name("application_no")).sendKeys(applicationnum);
			driver.findElement(By.name("search_application")).click();
			
			//Click on Approve button 
			driver.findElement(By.name("approve_cust")).click();
			Thread.sleep(2000);
			String atext = dLib.acceptAlert(driver);
			String accountnum="";
			for(int i=0;i<atext.length();i++) {
				if(Character.isDigit(atext.charAt(i))){
					accountnum=accountnum+atext.charAt(i);
				}
			}
			System.out.println("Account number is" +accountnum);
			//click on Home button present in staff login 
			driver.findElement(By.name("home")).click();
			
			//verify customer details after creating account
			driver.findElement(By.name("view_cust_by_ac")).click();
			driver.findElement(By.name("account_no")).sendKeys(accountnum);
			driver.findElement(By.name("submit_view")).click();
			 String achname = driver.findElement(By.xpath("//label[contains(.,'sirishaR')]")).getText();
			 System.out.println(achname);
			 
			 if(achname.contains("sirishaR")) {
				 System.out.println("Account is created sucessfully");
			 }
			 else {
				 System.out.println("Account is not created sucessfully");
			 }			
			
			//click on log out button
			driver.findElement(By.name("logout_btn")).click();
			driver.close();

	}

}
