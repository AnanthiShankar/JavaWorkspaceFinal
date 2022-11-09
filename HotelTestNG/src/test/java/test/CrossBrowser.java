package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class CrossBrowser {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys("vasuvespag");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("vasu1234");
		
		
		driver.findElement(By.className("login_button")).click();
		Reporter.log("LoginSuccess");
  }
  @Parameters("browser")
  
  @BeforeTest
  public void beforeTest(String browser) {
	  if (browser.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
			//create an object of webdriver
			driver = new ChromeDriver();
			//navigate to webapplication
			driver.get("http://adactinhotelapp.com");
			driver.manage().window().maximize();
	  }
	  else if (browser.equalsIgnoreCase("edge"))
	  {
		  System.setProperty("webdriver.edge.driver","C:\\Ana\\Drivers\\Edge106\\msedgedriver.exe");
			//create an object of webdriver
			driver = new EdgeDriver();
			//navigate to webapplication
			driver.get("http://adactinhotelapp.com");
			driver.manage().window().maximize();
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
