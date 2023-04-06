package Practice_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RankingInIcccricket {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		
		for(int i=0;i<teams.size();i++) {
		}
		driver.close();
		
		
	}

}
