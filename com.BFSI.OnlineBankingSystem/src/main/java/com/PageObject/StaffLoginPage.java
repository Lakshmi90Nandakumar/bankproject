package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.FileUtility;

public class StaffLoginPage {
	
	@FindBy(linkText="Staff Login")
	private WebElement stafflogin;
	
	@FindBy(name="staff_id")
	private WebElement staffid;
	
	@FindBy(name="password")
	private WebElement staffpw;
	
	@FindBy(name="staff_login-btn")
	private WebElement stafflgbtn;
	
	public StaffLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getStafflogin() {
		return stafflogin;
	}

	public WebElement getStaffid() {
		return staffid;
	}

	public WebElement getStaffpw() {
		return staffpw;
	}

	public WebElement getStafflgbtn() {
		return stafflgbtn;
	}
	
	/**
	 * By using this method we can login as staff
	 * @throws Throwable
	 */
	public void stafflogin() throws Throwable {
		FileUtility fLib=new FileUtility();
		getStafflogin().click();
		Thread.sleep(2000);
		getStaffid().sendKeys(fLib.readDataFromPropertyFile("sun"));
		getStaffpw().sendKeys(fLib.readDataFromPropertyFile("pw"));
		getStafflgbtn().click();

	}
}
