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

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

public class OpenAccountpage {
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="gender")
	private WebElement gender;
	
	@FindBy(name="mobile")
	private WebElement mobileno;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="landline")
	private WebElement landline;
	
	@FindBy(name="dob")
	private WebElement dob;
	
	@FindBy(name="pan_no")
	private WebElement panno;
	
	@FindBy(name="citizenship")
	private WebElement citizen;
	
	@FindBy(name="homeaddrs")
	private WebElement homeaddress;
	
	@FindBy(name="officeaddrs")
	private WebElement officeaddress;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="pin")
	private WebElement pin;
	
	@FindBy(name="arealoc")
	private WebElement arealocation;
	
	@FindBy(name="nominee_name")
	private WebElement nomineename;
	
	@FindBy(name="nominee_ac_no")
	private WebElement nominacno;
	
	@FindBy(name="acctype")
	private WebElement accounttype;
	
	@FindBy(name="submit")
	private WebElement submit;
	
	//intilaztion
	
	public OpenAccountpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	


	public WebElement getName() {
		return name;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getLandline() {
		return landline;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getPanno() {
		return panno;
	}

	public WebElement getCitizen() {
		return citizen;
	}

	public WebElement getHomeaddress() {
		return homeaddress;
	}

	public WebElement getOfficeaddress() {
		return officeaddress;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPin() {
		return pin;
	}

	public WebElement getArealocation() {
		return arealocation;
	}

	public WebElement getNomineename() {
		return nomineename;
	}

	public WebElement getNominacno() {
		return nominacno;
	}

	public WebElement getAccounttype() {
		return accounttype;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	//utilaztion
	/**
	 * By using this method we can enter all details 
	 * @param driver
	 * @throws Throwable
	 */
	
	public void openaccount(WebDriver driver) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility dLib=new WebDriverUtility();
		
		
		HashMap<String, String> map = eLib.readMultipleDataFromExcel("OpenAc");
		
		for(Entry<String, String> set:map.entrySet()) {
			if(set.getKey().equalsIgnoreCase("name"))
			{
				//String nm=set.getValue()+rann;
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.random());
			}
			else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
			}
		
		WebElement ge =getGender();
	
		dLib.select("Female", ge);
		WebElement date = dob;
		date.click();
		date.sendKeys("20-02-1992");
		/*Robot r=new Robot();
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_1);
		r.keyPress(KeyEvent.VK_9);
		r.keyPress(KeyEvent.VK_9);
		r.keyPress(KeyEvent.VK_2);	*/
		WebElement st = getState();
		dLib.select("Alaska", st);
		WebElement ce =getCity();
		dLib.select("Texas City", ce);
		WebElement aele = getAccounttype();
		dLib.select(aele, "Saving");
		getSubmit().click();


	}
}
