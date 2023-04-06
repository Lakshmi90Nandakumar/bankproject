package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	
	public void elementTobeVisible(WebDriver driver, WebElement element ) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element, String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(String visibleText, WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	
	public void mousehover(WebDriver  driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void drogAndDrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	 public void doubleClick(WebDriver driver,WebElement element) {
		 Actions act=new Actions(driver);
		 act.doubleClick(element).perform();
	 }
	 public void rightClick(WebDriver driver) {
		 Actions act=new Actions(driver);
		 act.contextClick().perform();
	 }
	 public void rightClick(WebDriver driver,WebElement element) {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 
	 public void enterKeyPress(WebDriver driver) {
		 
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.ENTER).perform();		 
	 }
	 public void enterkey(WebDriver driver) throws AWTException {
		 Robot rb=new Robot();
		 rb.keyPress(KeyEvent.VK_ENTER);
	 }
	 
	 public void enternumbers(WebDriver driver,int num) throws AWTException {
		 Robot rb=new Robot();
		// rb.keyPress(KeyEvent.VK_num);
	 }
	 
	 public void switchToFrame(WebDriver driver,int index) {
		 driver.switchTo().frame(index);
	 }
	 
	 public void switchToFrame(WebDriver driver,String nameOrID) {
		 driver.switchTo().frame(nameOrID);
	 }
	 public void switchToFrame(WebDriver driver, WebElement address) {
		 driver.switchTo().frame(address);
	 }
	 public String acceptAlert(WebDriver driver) {
		  Alert al = driver.switchTo().alert();
		String text = al. getText();
		al.accept();
		return text;
	 }
	 
	 public void cancelAlert(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 public void switchTowindow(WebDriver driver, String partialTitle) {
		 //step1: use getwindowhandles to capture all window id's
		 Set<String> window = driver.getWindowHandles();
	
		 //step2: iterate through the window
			Iterator<String> it = window.iterator();
			
			//Step3: check whether there is next window
			while(it.hasNext()) {
				
				//step4: capture current window id
				String winId=it.next();
				
				//step5:switch to current window and capture title
				String currentWinTitle=driver.switchTo().window(winId).getTitle();
				
				//step6:check wether current window is expected
				if(currentWinTitle.contains(partialTitle)) {
					break; 
				}
	 		}
			 }
	 public static String getScreenshot(WebDriver driver,String screenshotname) throws IOException {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 String path=".\\screenshot\\"+screenshotname+".png";
		 File dst=new File(path);
		 FileUtils.copyFile(src, dst);
		 return path;
	 }
	 
	 public void scroolBarActions(WebDriver driver,WebElement element) {
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 int y = element.getLocation().getY();
		 jse.executeScript("window.scrollBy(0,"+y+")",element);
	 }
}
