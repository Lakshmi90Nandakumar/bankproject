package ApplyInternetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.PageObject.ApplyDebitCardPage;
import com.PageObject.ApprovePendingAccountPage;
import com.PageObject.HomePage;
import com.PageObject.InternetBankingRegistrationPage;
import com.PageObject.OpenAccountConformationPage;
import com.PageObject.OpenAccountpage;
import com.PageObject.StaffLoginHomePage;
import com.PageObject.StaffLoginPage;
import com.PageObject.ViewCustomerByAcPage;

import OpenAccount.OpenAccountTestScript;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingRegistrationTestScript {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility dLib = new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();		
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		dLib.maximizewindow(driver);
		String aurl = fLib.readDataFromPropertyFile("url");
		driver.get(aurl);
		dLib.waitForPageLoad(driver);		
		//click on open account 
		HomePage hp=new HomePage(driver);
		hp.openAccount();
		
		OpenAccountpage op=new OpenAccountpage(driver);
		op.openaccount(driver);
		OpenAccountConformationPage oac = new OpenAccountConformationPage(driver);		
		String applicationnum = oac.applicationnum(driver);		
		StaffLoginPage sl = new StaffLoginPage(driver);
		sl.stafflogin();		
		//Click on Approve Pending A/C module		
		StaffLoginHomePage slh = new StaffLoginHomePage(driver);
		slh.getApprovepenAc().click();
		
		ApprovePendingAccountPage ap = new ApprovePendingAccountPage(driver);
		//ap.approvependingaccount();
		//Enter the Account details need to be approved
		ap.getApplicationnum().sendKeys(applicationnum);
		ap.getSearchapp().click();
		Thread.sleep(2000);
		ap.getApprovebtn().click();
		Thread.sleep(2000);
		
		String	atext=dLib.acceptAlert(driver);
		String accountnum="";
		for(int i=0;i<atext.length();i++) {
			if(Character.isDigit(atext.charAt(i))){
				accountnum=accountnum+atext.charAt(i);
			}
		}
		System.out.println("Account number is" +accountnum);

		//click on Home button present in staff login 
			slh.getStaffhome().click();
			
			
		//verify customer details after creating account			
			//click on customer by account module
			slh.getViewcustbyAc().click();	
			
			//enter a/c no & click submit button
			ViewCustomerByAcPage vc = new ViewCustomerByAcPage(driver);
			vc.getAccountno().sendKeys(accountnum);
			vc.getSubmitview().click();
			
			//String name = "sirishaR";
			String accountholdername="";
			 String achname = driver.findElement(By.xpath("//label[3]")).getText();
			 for(int i=15;i<achname.length();i++) {
				 accountholdername=accountholdername+achname.charAt(i);
			 }
			 System.out.println(accountholdername);

				//click on logout button present in staff page 
				slh.getStafflogbtn().click();
				//click on home button
				hp.getHome().click();
				//click on Apply debit card module
				 hp.getApplydebitcard().click();
				
				ApplyDebitCardPage adc = new ApplyDebitCardPage(driver);
				 adc.getAcholdername().sendKeys(accountholdername);;
				adc.applyDebit(achname, achname, driver);
				adc.getAccno().sendKeys(accountnum);
				Thread.sleep(2000);
				adc.getDbtcardsubmit().click();
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
					hp.getHome().click();
		
		
	/*	OpenAccountTestScript opp=new OpenAccountTestScript();
        opp.
		
			//registration for internet banking		
			InternetBankingRegistrationPage ib=new InternetBankingRegistrationPage(driver);
			ib.regristration(driver);
			ib.getAchname().sendKeys(accountholdername);	
			ib.getAccno().sendKeys(accountnum);
			ib.getDbtcardno().sendKeys(debitcardno);
			ib.getDbtpin().sendKeys(pin);
			ib.getSubmitbtn().click();*/
					
						
	}

}
