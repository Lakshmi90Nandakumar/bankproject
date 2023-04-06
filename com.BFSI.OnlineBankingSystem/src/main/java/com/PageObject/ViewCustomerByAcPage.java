package com.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAcPage {
	@FindBy(name="account_no")
	private WebElement accountno;
	
	@FindBy(name="submit_view")
	private WebElement submitview;
	
	public ViewCustomerByAcPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountno() {
		return accountno;
	}

	public WebElement getSubmitview() {
		return submitview;
	}
	/**
	 * By using this method we can verify the customer through account number weather customer is created or not and we can get account holder name
	 * @return account Holder Name
	 * @throws Throwable 
	 */
	public String VerifyCustomerbyAcNo(String acNo,WebDriver driver) throws Throwable {
		
		
		accountno.sendKeys(acNo);
		submitview.click();
		
	   	 String name = "sirishaR";
		 String achname = driver.findElement(By.xpath("//label[3]")).getText();
		 String dname="";
		 System.out.println(achname);
		 
		 if(achname.contains(name)) {
			 
			 System.out.println("Account is created sucessfully");
		 }
		 else {
			 System.out.println("Account is not created sucessfully");
			 }	
		 
		 for(int i=15;i<achname.length();i++) {
			dname=dname+achname.charAt(i) ;
			
		 }
		 return dname;
	}

}
