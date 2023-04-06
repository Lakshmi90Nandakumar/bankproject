package Practice_package;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer {

	int count=0;
	int retryLimit=3;
	public boolean retry(ITestResult result) {

		if(count<retryLimit)
		{
			return true;
		}
		return false;
	}

	
	
}
