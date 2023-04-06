package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StaffLoginHomePage {
	
	@FindBy(name="viewdet")
	private WebElement viewactcus;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement viewcustbyAc;
	
	@FindBy(name="apprvac")
	private WebElement approvepenAc;
	
	@FindBy(name="del_cust")
	private WebElement delcust;
	
	@FindBy(name="credit_cust_ac")
	private WebElement credcustAc;
	
	@FindBy(name="home")
	private WebElement staffhome;
	
	@FindBy(name="logout_btn")
	private WebElement stafflogbtn;
	
	
	public StaffLoginHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getStaffhome() {
		return staffhome;
	}

	public WebElement getStafflogbtn() {
		return stafflogbtn;
	}


	public WebElement getViewactcus() {
		return viewactcus;
	}

	public WebElement getViewcustbyAc() {
		return viewcustbyAc;
	}

	public WebElement getApprovepenAc() {
		return approvepenAc;
	}

	public WebElement getDelcust() {
		return delcust;
	}

	public WebElement getCredcustAc() {
		return credcustAc;
	}
	
	public void stafHome() {
		staffhome.click();
	}
	
	public void viewActiveCustomer() {
		viewactcus.click();
	}
	
	public void viewCustomerbyAc() {
		viewcustbyAc.click();
		Assert.fail();
	}
	
	public void approvePendingAc() {
		approvepenAc.click();
	}
	
	public void deleteCust() {
		delcust.click();
	}
	
	public void staffLogBtn() {
		stafflogbtn.click();
	}
	
	public void creditCustomerAc() {
		credcustAc.click();
	}
}
