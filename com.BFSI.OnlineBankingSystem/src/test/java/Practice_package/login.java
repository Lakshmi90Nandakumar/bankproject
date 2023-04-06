package Practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.close();
	}

}
