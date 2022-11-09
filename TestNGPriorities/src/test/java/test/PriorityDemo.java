package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityDemo {
	WebDriver driver;
  @Test (priority=0) //(enabled=false)
    public void login() {
	  WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys("vasuvespag");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("vasu1234");
		
		
		driver.findElement(By.className("login_button")).click();
		Reporter.log("LoginSuccess");
  }
  
  @Test (priority=1)
  public void searchHotel() {
	  new Select(driver.findElement(By.cssSelector("#location"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#hotels"))).selectByValue("Hotel Sunshine");
		new Select(driver.findElement(By.cssSelector("#room_type"))).selectByVisibleText("Standard");
		driver.findElement(By.name("datepick_in")).clear();
		driver.findElement(By.name("datepick_in")).sendKeys("14/10/2022");
		driver.findElement(By.name("datepick_out")).clear();
		driver.findElement(By.name("datepick_out")).sendKeys("16/10/2022");
		
		driver.findElement(By.id("Submit")).click();
		Reporter.log("search hotel success");
  }
  @Test(priority=2)
  public void selectHotel() {
	  driver.findElement(By.id("radiobutton_0")).click();
	  Reporter.log("select hotel success");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
			//create an object of webdriver
			driver = new ChromeDriver();
			//navigate to webapplication
			driver.get("http://adactinhotelapp.com");
			driver.manage().window().maximize();
			Reporter.log("driver instantiation");
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  
  }

