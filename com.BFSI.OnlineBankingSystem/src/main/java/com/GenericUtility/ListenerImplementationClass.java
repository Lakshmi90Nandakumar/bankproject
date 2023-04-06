package com.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	public void onFinish(ITestContext context) {
	report.flush();
	
	}
	

	public void onStart(ITestContext context) {
		//create html report
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtenetReport/report.html");
		htmlreport.config().setDocumentTitle("Online Banking");
		htmlreport.config().setTheme(Theme.DARK);
	    htmlreport.config().setReportName("Truist");
	    
	    report=new ExtentReports();
	    report.attachReporter(htmlreport);
	    report.setSystemInfo("BaseBrowser","chrome");
	    report.setSystemInfo("Os", "Windows");
	    report.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/Online_Banking_System/");
	    
	}
 
	public void onTestFailure(ITestResult result) {
		
		String FScript=result.getMethod().getMethodName();
		String date = new JavaUtility().getSystemDate();
		String FS=FScript+date;
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		 File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+FS+".png");
		File path=dst.getAbsoluteFile();
		try
		{
          FileUtils.copyFile(src, path);
		}
		catch(Throwable e)
		{
		
			e.printStackTrace();
		}
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+"---->Skipped");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Test script Execution skipped");
		
		
//		try
//		{
//			String screenShotName = WebDriverUtility.getScreenshot(BaseClass.sdriver,result.getMethod().getMethodName());
//		}
//		catch(Throwable e)
//		{
//			e.printStackTrace();
//		}

	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Test script Execution skipped");
		
	}

	public void onTestStart(ITestResult result) {
		
		//execution starts from here
		
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"---->TEstscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		
	  String methodName = result.getMethod().getMethodName();
	  test.log(Status.PASS, methodName+"--->Passsed");
	  Reporter.log(methodName+"---->Passed");
	}
	
	

}
