package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class OpenAccountConformationPage {

	
	@FindBy(xpath="//input[@name='cnfrm-submit']")
	private WebElement cnfrmsubmit;
	
	@FindBy(xpath="//input[@value=\"Go back\"]")
	private WebElement goback;
	
	
	public OpenAccountConformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCnfrmsubmit() {
		return cnfrmsubmit;
	}

	public WebElement getGoback() {
		return goback;
	}
	
	/**
	 * by using this we can get the application number
	 * @param driver
	 * @return application number
	 */
	public String applicationnum(WebDriver driver ) {
		//click conform button
		cnfrmsubmit.click();
		
		//get application number
		WebDriverUtility dLib=new WebDriverUtility();
		String text = dLib.acceptAlert(driver);
		String applicationnum="";
		
		for(int i=0;i<text.length();i++) {
			if(Character.isDigit(text.charAt(i))) {
				applicationnum=applicationnum+text.charAt(i);					
			}
		}
		System.out.println("application number is" +applicationnum);
		return applicationnum;
	}
}
