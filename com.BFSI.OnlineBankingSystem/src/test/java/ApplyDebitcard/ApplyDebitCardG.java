package ApplyDebitcard;

import java.awt.AWTException;
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

public class ApplyDebitCardG {

	public static void main(String[] args) throws Throwable {

		FileUtility fLib = new FileUtility();
		 WebDriverUtility dLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		dLib.maximizewindow(driver);
		
		
	String aurl = fLib.readDataFromPropertyFile("url");
	System.out.println(aurl);
	
	driver.get(aurl);
	dLib.waitForPageLoad(driver);
	driver.findElement(By.xpath("//li[text()='Open Account']")).click();
	
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
		
		driver.findElement(By.name("logout_btn")).click();
		//click on Home button   
	driver.findElement(By.linkText("Home")).click();
	//User can able to apply for Debit card 
	//click on Apply debit card Module
	driver.findElement(By.linkText("Apply Debit Card")).click();
	driver.findElement(By.name("holder_name")).sendKeys(eLib.readDataFromExcel("OpenAc", 1, 1)+jLib.random());
	WebElement dedob = driver.findElement(By.name("dob"));
	dedob.click();
	Robot r1=new Robot();
	r1.keyPress(KeyEvent.VK_2);
	r1.keyPress(KeyEvent.VK_0);
	r1.keyPress(KeyEvent.VK_0);
	r1.keyPress(KeyEvent.VK_2);
	r1.keyPress(KeyEvent.VK_1);
	r1.keyPress(KeyEvent.VK_9);
	r1.keyPress(KeyEvent.VK_9);
	r1.keyPress(KeyEvent.VK_2);	
	driver.findElement(By.name("pan")).sendKeys("123456");
	driver.findElement(By.name("mob")).sendKeys("7013597454");
	driver.findElement(By.name("acc_no")).sendKeys(accountnum);
	driver.findElement(By.name("dbt_crd_submit")).click();
	String ad = dLib.acceptAlert(driver);
	System.out.println(ad);
	String dnum="";
	
	for(int i=0;i<ad.length();i++) {
		if(Character.isDigit(ad.charAt(i))) {
			dnum=dnum+ad.charAt(i);	
			
		}
	}
		String debitcardno="";
		String pin="";
		
		for(int i=0;i<dnum.length();i++ ) {
			
			if(i<12) {
				debitcardno=debitcardno+dnum.charAt(i);
				
			}
			else {
				pin=pin+dnum.charAt(i);
				}
			}
		System.out.println("Debit Card No is  " +debitcardno);
		System.out.println("Pin No is  " +pin);
		driver.findElement(By.linkText("Home")).click();
		driver.close();
	
	}

}
