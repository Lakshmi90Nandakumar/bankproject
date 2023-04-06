package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenericUtility.WebDriverUtility;

public class ApprovePendingAccountPage {
	WebDriverUtility dLib=new WebDriverUtility();
	
	@FindBy(name="application_no")
	private WebElement applicationnum;
	
	@FindBy(name="search_application")
	private WebElement searchapp;
	
	@FindBy(name="approve_cust")
	private WebElement approvebtn;
	
	public ApprovePendingAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getApplicationnum() {
		return applicationnum;
	}

	public WebElement getSearchapp() {
		return searchapp;
	}

	public WebElement getApprovebtn() {
		return approvebtn;
	}
	
	/**
	 * By using this method we can approve the application and get account number
	 * @return Account Number
	 * @throws Throwable 
	 */
	public String approvependingaccount(String apno,WebDriver driver) throws Throwable {	
		
		
			
		applicationnum.sendKeys(apno);
		searchapp.click();
		Thread.sleep(2000);
		approvebtn.click();
		
		String	atext=dLib.acceptAlert(driver);
		String accountnum="";
		for(int i=0;i<atext.length();i++) {
			if(Character.isDigit(atext.charAt(i))){
				accountnum=accountnum+atext.charAt(i);
			}
		}
		System.out.println("Account number is" +accountnum);
		return accountnum;
		
	}
}
