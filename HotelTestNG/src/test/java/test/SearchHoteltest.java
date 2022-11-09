package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class SearchHoteltest {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys("vasuvespag");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("vasu1234");
		
		
		driver.findElement(By.className("login_button")).click();
		WebElement Greeting=driver.findElement(By.name("username_show"));
		System.out.println(Greeting.getAttribute("value"));
		new Select(driver.findElement(By.cssSelector("#location"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#hotels"))).selectByValue("Hotel Sunshine");
		new Select(driver.findElement(By.cssSelector("#room_type"))).selectByVisibleText("Standard");
		driver.findElement(By.name("datepick_in")).clear();
		driver.findElement(By.name("datepick_in")).sendKeys("14/10/2022");
		driver.findElement(By.name("datepick_out")).clear();
		driver.findElement(By.name("datepick_out")).sendKeys("16/10/2022");
		
		driver.findElement(By.id("Submit")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		//create an object of webdriver
		driver = new ChromeDriver();
		//navigate to webapplication
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  

}
