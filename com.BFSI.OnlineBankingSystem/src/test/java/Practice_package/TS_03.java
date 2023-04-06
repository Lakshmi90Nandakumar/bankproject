package Practice_package;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class TS_03 extends BaseClass {
	
		
		@Test(groups="smoke")
		public void testscript5()
		{
			System.out.println("---Test script 5--");
		}
		@Test(groups="regression")
		public  void testscript6() {
			System.out.println("----Test script 6---");
		}

}