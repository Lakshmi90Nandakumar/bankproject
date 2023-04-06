package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropertyFile {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String br = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String un = pobj.getProperty("username");
		String pw = pobj.getProperty("password");
		
		System.out.println(br);
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
		
		
	

	}

}
