package ApplyDebitcard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebitCard {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
				
		//enter url of application
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click on open account Module
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		String name="hari";
		Random ran=new Random();
		int rann = ran.nextInt(500);
		//Enter all necessary details with valid input and click on submit button.
		driver.findElement(By.name("name")).sendKeys(name+rann);
			WebElement ele = driver.findElement(By.name("gender"));
			Select s = new Select(ele);
			s.selectByValue("Male");
			driver.findElement(By.name("mobile")).sendKeys("7013597454");
			
			driver.findElement(By.name("email")).sendKeys("hari4u@gmail.com");
			driver.findElement(By.name("landline")).sendKeys("8559244215");
			
			WebElement dob = driver.findElement(By.name("dob"));
			dob.click();
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_2);
			r.keyPress(KeyEvent.VK_1);
			r.keyPress(KeyEvent.VK_0);
			r.keyPress(KeyEvent.VK_2);
			r.keyPress(KeyEvent.VK_1);
			r.keyPress(KeyEvent.VK_9);
			r.keyPress(KeyEvent.VK_9);
			r.keyPress(KeyEvent.VK_2);			
			driver.findElement(By.name("pan_no")).sendKeys("123456");
			driver.findElement(By.name("citizenship")).sendKeys("112233");
			driver.findElement(By.name("homeaddrs")).sendKeys("Btp");
			driver.findElement(By.name("officeaddrs")).sendKeys("btp 2nd stage");
			//driver.findElement(By.name("country")).sendKeys("US");
			WebElement sele = driver.findElement(By.name("state"));
			Select s1=new Select(sele);
			s1.selectByValue("Washington");
			WebElement cele = driver.findElement(By.name("city"));
			Select sc=new Select(cele);
			sc.selectByVisibleText("Texas City");
			driver.findElement(By.name("pin")).sendKeys("515731");
			driver.findElement(By.name("arealoc")).sendKeys("atp");
			driver.findElement(By.name("nominee_name")).sendKeys("sai");
			driver.findElement(By.name("nominee_ac_no")).sendKeys("1011520");
			WebElement aele = driver.findElement(By.name("acctype"));
			Select sa=new Select(aele);
			sa.selectByValue("Saving");
			driver.findElement(By.name("submit")).click();
			Thread.sleep(2000);
			//click on confirm button 
			driver.findElement(By.name("cnfrm-submit")).click();
			//click on Ok button in the confimation pop up
			Alert a = driver.switchTo().alert();
			String text = a.getText();	
			String applicationnum="";
			
			for(int i=0;i<text.length();i++) {
				if(Character.isDigit(text.charAt(i))) {
					applicationnum=applicationnum+text.charAt(i);					
				}
			}
			System.out.println("application number is" +applicationnum);
			a.accept();
			
			
			//click on staff Login module
			driver.findElement(By.linkText("Staff Login")).click();
			//enter the Valid credentials and click on login
			driver.findElement(By.name("staff_id")).sendKeys("210001");
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.name("staff_login-btn")).click();
			
			//Click on Approve Pending A/C module

			driver.findElement(By.name("apprvac")).click();
			//Enter the Account details need to be approved
			driver.findElement(By.name("application_no")).sendKeys(applicationnum);
			driver.findElement(By.name("search_application")).click();			
			//Click on Approve button 
			driver.findElement(By.name("approve_cust")).click(); 
			
			Alert a1 = driver.switchTo().alert();
			String atext = a1.getText();
			//System.out.println(atext);
			a1.accept();
			

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
			driver.findElement(By.name("holder_name")).sendKeys(name+rann);
			WebElement dedob = driver.findElement(By.name("dob"));
			dedob.click();
			Robot r1=new Robot();
			r1.keyPress(KeyEvent.VK_2);
			r1.keyPress(KeyEvent.VK_1);
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
		
		
		Alert ad = driver.switchTo().alert();
		String t = ad.getText();
		System.out.println(t);
		String dnum="";
		
		for(int i=0;i<t.length();i++) {
			if(Character.isDigit(t.charAt(i))) {
				dnum=dnum+t.charAt(i);	
				
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
			ad.accept();
		driver.findElement(By.linkText("Home")).click();
		System.out.println("Changes");
        System.out.println("changes1");		
        System.out.println("changes1");		

		driver.close();
		}
	}

