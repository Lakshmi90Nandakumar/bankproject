package OpenAccount;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntegrationOpenAccountToInternetBankingReg {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().create();
			WebDriver driver = new ChromeDriver();
			driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
			//mouse over on Internet Banking
			
			 Actions a = new Actions(driver);
			WebElement in = driver.findElement(By.partialLinkText("Internet Banking"));
			a.moveToElement(in).perform();
			driver.findElement(By.partialLinkText("Register")).click();
			 
			 driver.findElement(By.name("holder_name")).sendKeys("hari190");
			 driver.findElement(By.name("accnum")).sendKeys("1011611011379");
			 driver.findElement(By.name("dbtcard")).sendKeys("421393742844");
			 driver.findElement(By.name("dbtpin")).sendKeys("1617");
			 driver.findElement(By.name("mobile")).sendKeys("7013597454");
			 driver.findElement(By.name("pan_no")).sendKeys("123456");
			WebElement edob = driver.findElement(By.name("dob"));
			edob.click();
			Robot r2=new Robot();
			r2.keyPress(KeyEvent.VK_1);
			r2.keyPress(KeyEvent.VK_0);
			r2.keyPress(KeyEvent.VK_0);
			r2.keyPress(KeyEvent.VK_5);
			r2.keyPress(KeyEvent.VK_1);
			r2.keyPress(KeyEvent.VK_9);
			r2.keyPress(KeyEvent.VK_9);
			r2.keyPress(KeyEvent.VK_0);	
			
			
			driver.findElement(By.name("last_trans")).sendKeys("0");
			driver.findElement(By.name("password")).sendKeys("sirireddy");
			driver.findElement(By.name("cnfrm_password")).sendKeys("sirireddy");
			driver.findElement(By.name("submit")).click();


	}

}
