package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

public class InternetBankingRegistrationPage {
	
	
	@FindBy(name="holder_name")
	private WebElement achname;
	
	@FindBy(name="accnum")
	private WebElement accno;
	
	@FindBy(name="dbtcard")
	private WebElement dbtcardno;
	
	@FindBy(name="dbtpin")
	private WebElement dbtpin;
	
	@FindBy(name="mobile")
	private WebElement mobileno;
	
	@FindBy(name="pan_no")
	private WebElement panno;
	
	@FindBy(name="dob")
	private WebElement idob;
	
	@FindBy(name="last_trans")
	private WebElement lasttrans;
	
	@FindBy(name="password")
	private WebElement intpwd;
	
	@FindBy(name="cnfrm_password")
	private WebElement intcnfrmpw;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	public InternetBankingRegistrationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getAchname() {
		return achname;
	}

	public WebElement getAccno() {
		return accno;
	}

	public WebElement getDbtcardno() {
		return dbtcardno;
	}

	public WebElement getDbtpin() {
		return dbtpin;
	}

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getPanno() {
		return panno;
	}

	public WebElement getIdob() {
		return idob;
	}

	public WebElement getLasttrans() {
		return lasttrans;
	}

	public WebElement getIntpwd() {
		return intpwd;
	}

	public WebElement getIntcnfrmpw() {
		return intcnfrmpw;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void regristration(WebDriver driver) throws Throwable {
		WebDriverUtility dLib=new WebDriverUtility();
		HomePage hp=new HomePage(driver);
		OpenAccountConformationPage oc=new OpenAccountConformationPage(driver);
		ApprovePendingAccountPage ap=new  ApprovePendingAccountPage(driver);
		ViewCustomerByAcPage vc=new ViewCustomerByAcPage(driver);
		ApplyDebitCardPage adc=new ApplyDebitCardPage(driver);
		
		WebDriverUtility dLip=new WebDriverUtility();
		WebElement e = hp.getInternetbanking();
		dLip.scroolBarActions(driver, e);
		
		WebElement ie = hp.getRegisterinter();
		dLib.mousehover(driver, ie);
		hp.getRegisterinter().click();
		String apNo = oc.applicationnum(driver);
		String acNo = ap.approvependingaccount(apNo, driver);		
		String acname = vc.VerifyCustomerbyAcNo(acNo, driver);
		String[] dp = adc.applyDebit(acname, acNo, driver);
			String debitcardNo = dp[0];
			String pin=dp[1];
		achname.sendKeys(acname);
		accno.sendKeys(acNo);
		dbtcardno.sendKeys(debitcardNo);
		dbtpin.sendKeys(pin);		
		mobileno.sendKeys("6281590159");
		panno.sendKeys("778899");
		 WebElement date = idob;
		date.click();
		date.sendKeys("20-02-1992");
		lasttrans.sendKeys("0");
		intpwd.sendKeys("sirireddy");
		intcnfrmpw.sendKeys("sirireddy");

	}
}
