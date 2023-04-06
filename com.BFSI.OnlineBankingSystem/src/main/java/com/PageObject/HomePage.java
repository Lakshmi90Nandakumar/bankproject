package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.BaseClass;

public class HomePage {
	
	@FindBy(linkText="Open Account")
	private WebElement openaccount;
	
	@FindBy(linkText="Apply Debit Card")
	private WebElement applydebitcard;
	
	@FindBy(partialLinkText="Internet Banking")
	private WebElement internetbanking;
	
	@FindBy(linkText="Fund Transfer")
	private WebElement fundTransfer;
	
	@FindBy(linkText="Register")
	private WebElement registerinter;
	
	@FindBy(linkText="Login ")
	private WebElement logininternet;
	
	@FindBy(linkText="Fund Transfer")
	private WebElement fundtransfer;
	
	@FindBy(linkText="Home")
	private WebElement home;
	
	@FindBy (linkText="Staff Login")
	private WebElement stafflogin;
	

	public WebElement getOpenaccount() {
		return openaccount;
	}

	public WebElement getApplydebitcard() {
		return applydebitcard;
	}

	public WebElement getInternetbanking() {
		return internetbanking;
	}

	public WebElement getFundTransfer() {
		return fundTransfer;
	}

	public WebElement getRegisterinter() {
		return registerinter;
	}

	public WebElement getLogininternet() {
		return logininternet;
	}

	public WebElement getFundtransfer() {
		return fundtransfer;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getStafflogin() {
		return stafflogin;
	}


	//intilation
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void openAccount() {
		
		openaccount.click();
	}

	public void homeBtn() 
	{
		home.click();
	}
	
	public void staffLogin() 
	
	{
		stafflogin.click();
	}
	
	public void applyDebitCard() 
	{
		applydebitcard.click();
	}
	
	
}
