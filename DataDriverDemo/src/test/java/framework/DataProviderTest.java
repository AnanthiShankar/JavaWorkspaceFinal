package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	WebDriver driver;
  @Test(dataProvider ="Auth")
  public void test(String uname, String password) {
	  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
		//create an object of webdriver
		WebDriver driver = new ChromeDriver();
		//navigate to webapplication

		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);	
		driver.findElement(By.className("login_button")).click();
		Reporter.log("This is login");
	
  }
   
  @DataProvider(name="Auth")
  public Object[][] credentials() {
	  return new Object[][] {
		  {"vasuvespag","vasu1234"},{"aryan1207","Aryn@120799"}
	  };
  }


  @BeforeTest
  public void beforeTest(String browser) {
	  if (browser.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
			//create an object of webdriver
		   driver = new ChromeDriver();
			//navigate to webapplication  
	  }
	  else if (browser.equalsIgnoreCase("edge"))
	  {
		  System.setProperty("webdriver.edge.driver","C:\\Ana\\Drivers\\Edge106\\msedgedriver.exe");
			//create an object of webdriver
			 driver = new EdgeDriver();
			//navigate to webapplication
			/*
			 * driver.get("http://adactinhotelapp.com");
			 * driver.manage().window().maximize();
			 * driver.findElement(By.id("username")).sendKeys(uname);
			 * 
			 * driver.findElement(By.name("password")).clear();
			 * driver.findElement(By.name("password")).sendKeys(password);
			 */
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
