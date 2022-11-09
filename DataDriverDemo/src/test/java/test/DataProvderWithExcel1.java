package test;

import org.testng.annotations.Test;

import utility.ExcelUtilities;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProvderWithExcel1 {
	WebDriver driver;
	String testCaseName;
  @Test(dataProvider = "dp")
  public void f(String user, String pass) {
	  WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(user);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.className("login_button")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
		//create an object of webdriver
		driver = new ChromeDriver();
		//navigate to webapplication
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	  ExcelUtilities.setExcelFile("C:\\Users\\Administrator\\JavaWorkspace\\DataDriverDemo\\src\\test\\java\\testdata\\TestData.xlsx","Sheet1");
	  testCaseName=this.toString();
	  testCaseName=utility.ExcelUtilities.getTestcaseName(this.toString());
	  //testCaseRow=utility.ExcelUtilities.getRowContent(testCaseName, 0);
	  Object[][] testObjectArray =utility.ExcelUtilities.getTableArray("C:\\Users\\Administrator\\JavaWorkspace\\DataDriverDemo\\src\\test\\java\\testdata\\TestData.xlsx","Sheet1");
	  return (testObjectArray); 
		/*
		 * return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
		 */
  }
}
