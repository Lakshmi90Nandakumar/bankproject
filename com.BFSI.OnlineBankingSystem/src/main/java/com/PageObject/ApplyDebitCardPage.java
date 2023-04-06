package com.PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

public class ApplyDebitCardPage {
	
	@FindBy(name="holder_name")
	private WebElement acholdername;
	
	@FindBy(name="dob")
	private WebElement dob;
	
	@FindBy(name="pan")
	private WebElement panno;
	
	@FindBy(name="mob")
	private WebElement mobileno;
	
	@FindBy(name="acc_no")
	private WebElement accno;
	
	@FindBy(name="dbt_crd_submit")
	private WebElement dbtcardsubmit;
	
	public ApplyDebitCardPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getAcholdername() {
		return acholdername;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getPanno() {
		return panno;
	}

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getAccno() {
		return accno;
	}

	public WebElement getDbtcardsubmit() {
		return dbtcardsubmit;
	}
	/**
	 * This method returns debit card number and pin (It stored in array)
	 * @param dname
	 * @param acNo
	 * @param driver
	 * @return debitNo,pin
	 * @throws Throwable
	 */
	
	public String[] applyDebit(String dname,String acNo,WebDriver driver) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility dLib=new WebDriverUtility();
		String[] ob=new String[2];
		
		acholdername.sendKeys(dname);
		
		
		HashMap<String, String> map = eLib.readMultipleDataFromExcel("ApplyDebitcard");
		
		
		for(Entry<String, String> set:map.entrySet()) {			
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}		
		 WebElement date = dob;
		date.click();
		date.sendKeys("20-02-1992");
		accno.sendKeys(acNo);
		dbtcardsubmit.click();
		String detext = dLib.acceptAlert(driver);
		System.out.println(detext);
		String dnum="";
		
		for(int i=0;i<detext.length();i++) {
			if(Character.isDigit(detext.charAt(i))) {
				dnum=dnum+detext.charAt(i);	
				
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
			ob[0]=debitcardno;
			ob[1]=pin;
			
			return ob;
	}

}
