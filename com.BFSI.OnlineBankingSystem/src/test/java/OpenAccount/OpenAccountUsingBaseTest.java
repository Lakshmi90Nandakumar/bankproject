package OpenAccount;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.PageObject.ApprovePendingAccountPage;
import com.PageObject.HomePage;
import com.PageObject.OpenAccountConformationPage;
import com.PageObject.OpenAccountpage;
import com.PageObject.StaffLoginHomePage;
import com.PageObject.StaffLoginPage;
import com.PageObject.ViewCustomerByAcPage;

@Listeners(com.GenericUtility.ListenerImplementationClass.class)
public class OpenAccountUsingBaseTest extends BaseClass {
	@Test
	public void openac () throws Throwable {
	    
		//click on open account           
		HomePage hp=new HomePage(driver);
	    hp.openAccount();	
	   
	    //enter the details
	    
	    OpenAccountpage op=new OpenAccountpage(driver);
	    op.openaccount(driver);
	    
	    //click on confirmation page
	     
	     OpenAccountConformationPage oac = new OpenAccountConformationPage(driver);		
	     String applicationnum = oac.applicationnum(driver);	
	
	     //click on staff login
	
	     StaffLoginPage sl = new StaffLoginPage(driver);
	     sl.stafflogin();		
	
	     //Click on Approve Pending A/C module	
	      
	      StaffLoginHomePage slh = new StaffLoginHomePage(driver);
	      slh.approvePendingAc();
	     
	      //approving acount
	      
	      ApprovePendingAccountPage ap = new ApprovePendingAccountPage(driver);
	      String accountnum = ap.approvependingaccount(applicationnum, driver);

	      //click on Home button present in staff login 
	        slh.stafHome();
		
	      //verify customer details after creating account			
		
	      //click on customer by account module
		   // Assert.fail();
	         slh.viewCustomerbyAc();			
		    ViewCustomerByAcPage vc = new ViewCustomerByAcPage(driver);	
		    vc.VerifyCustomerbyAcNo(accountnum, driver);


	}	

}
