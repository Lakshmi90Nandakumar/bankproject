package Practice_package;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertExamp {

	@Test
	public void test()
	{
		System.out.println("---Statement 1---");
		System.out.println("---Statement 2---");
        Assert.assertEquals("Actual", "Expected");
        System.out.println("---Statement 3---");
	}
	
	@Test
	public void test1()
	{
	
		System.out.println("---Statement 4---");
		System.out.println("---Statement 5---");
        Assert.assertSame("Actual", "Expected","Mismatched data found");
        System.out.println("---Statement 6---");
	}
}
