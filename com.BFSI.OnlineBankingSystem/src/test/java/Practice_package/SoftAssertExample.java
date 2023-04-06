package Practice_package;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

	@Test
	public void test()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("--Statement 1---");
		System.out.println("---statement 2--");
		sa.assertEquals("Example", "Example", " Mismatched");
		System.out.println("---statement 3--");
	    sa.assertAll();
		System.out.println("---statement --");


		
	}
	@Test
	public void test1() 
	{
		int a=9;
		SoftAssert sa=new SoftAssert();
		System.out.println("--Statement 4---");
		System.out.println("---statement 5--");
		sa.assertNull(a);;
		System.out.println("---statement 6--");
		sa.assertAll();

	}
}
