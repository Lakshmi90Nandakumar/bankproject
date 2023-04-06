package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectCreateInRMG {

	public static void main(String[] args) throws Throwable {

		
		WebDriverManager.chromedriver().create();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://rmgtestingserver:8084/");
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.partialLinkText("Projects")).click();
		// driver.findElement(By.linkText("Projects")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 driver.findElement(By.name("projectName")).sendKeys("OBS Project");
		 driver.findElement(By.name("createdBy")).sendKeys("SR");
		WebElement ps = driver.findElement(By.name("status"));
		Select s = new Select(ps);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

		Driver driver1 = new Driver();
				DriverManager.registerDriver(driver1);
			Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
				Statement sat = con.createStatement();
				String query="select* from project;";
				ResultSet result = sat.executeQuery(query);
				boolean flag=true;
				while(result.next()) {
					String actproj=result.getString(4);
					System.out.println(actproj);
					String ectproj="OBS Project";
					if(actproj.equalsIgnoreCase(ectproj)) {
						flag=true;
						break;
					}
					if(flag) {
						System.out.println("project is created");
					}
					else {
						System.out.println("project is not created");
					}
				}

	
	}

}
