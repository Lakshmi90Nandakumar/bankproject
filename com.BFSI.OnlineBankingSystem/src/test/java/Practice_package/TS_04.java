package Practice_package;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class TS_04 extends BaseClass{

		
		@Test(groups="smoke")
		public void testscript7()
		{
			System.out.println("---Test script 7--");
		}
		@Test(groups="regression")
		public  void testscript8() {
			System.out.println("----Test script 8---");
		}

}
