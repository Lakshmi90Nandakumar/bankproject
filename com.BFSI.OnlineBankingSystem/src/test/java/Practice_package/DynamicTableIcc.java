package Practice_package;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//get ranking from table in Icc-cricket


public class DynamicTableIcc {

	public static void main(String[] args) {

		 WebDriverManager.chromedriver().create();
		 WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	 List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> match = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		for(int i=0;i<teams.size();i++) {
			
			String myteams = teams.get(i).getText();
		String matc = match.get(i).getText();
		System.out.println(myteams+"  "+matc);		
		}		

		//for Ratings
		List<WebElement> ranks = driver.findElements(By.xpath("//tbody/tr/td[5]"));

		for(int i=0;i<teams.size();i++) {
			String myteams = teams.get(i).getText();
			String rank = ranks.get(i).getText();
			System.out.println(myteams+"  "+rank);

		}		
		driver.close();
	}

}
