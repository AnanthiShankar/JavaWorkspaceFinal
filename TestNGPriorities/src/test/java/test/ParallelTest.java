package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParallelTest {
	WebDriver driver;
  @Test
  public void ChromeTest() {
	  	System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
		//create an object of webdriver
		driver = new ChromeDriver();
		//navigate to webapplication
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		Reporter.log("driver instantiation in chrome");
  }
  @Test
  public void EdgeTest() {
	  	System.setProperty("webdriver.edge.driver","C:\\Ana\\Drivers\\Edge106\\msedgedriver.exe");
		//create an object of webdriver
		driver = new EdgeDriver();
		//navigate to webapplication
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		Reporter.log("driver instantiation in edge");
  }
}
