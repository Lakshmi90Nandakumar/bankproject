package OpenAccount;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccount {

	public static void main(String[] args) throws Throwable {
			//set up driver
		WebDriverManager.chromedriver().create();
		//launch the driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BankingCommondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
				
		//enter url of application
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click on open account Module
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\BankingTestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("OpenAc");
		HashMap<String, String> map = new HashMap<String, String>();
		
		Random ran=new Random();
		int rann = ran.nextInt(500);

		
			String actname = sh.getRow(1).getCell(1).getStringCellValue();
			
		for(int i=0;i<sh.getLastRowNum();i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> set:map.entrySet()) {
			if(set.getKey().equalsIgnoreCase("name"))
			{
				//String nm=set.getValue()+rann;
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+rann);
			}
			else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
		}
		
		//Enter all necessary details with valid input and click on submit button.
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
			Select s1=new Select(sele);
			s1.selectByValue("Washington");
			WebElement cele = driver.findElement(By.name("city"));
			Select sc=new Select(cele);
			sc.selectByVisibleText("Texas City");
			WebElement aele = driver.findElement(By.name("acctype"));
			Select sa=new Select(aele);
			sa.selectByValue("Saving");
			driver.findElement(By.name("submit")).click();
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
				String stun = p.getProperty("sun");
				String stpw = p.getProperty("pw");
			driver.findElement(By.name("staff_id")).sendKeys(stun);
			driver.findElement(By.name("password")).sendKeys("stpw");
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
