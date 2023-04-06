package Practice_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class TS_01 extends BaseClass{
	
	@Test(retryAnalyzer=Practice_package.RetryImpClass.class)
	public void testscript1()
	{
		System.out.println("---Test script 1--");
		Assert.fail();
	}
//	@Test
//	public  void testscript2() {
//		System.out.println("----Test script 2---");
//	}

}
