package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ExtendDemo {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	
  @Test
  public void extentReportDemo() {
	  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
		//create an object of webdriver
		driver = new ChromeDriver();
		//navigate to webapplication
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		test.log(Status.PASS,"Navigated to HotelApp");
	  
	  WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys("vasuvespag");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("vasu12346");
		
		
		driver.findElement(By.className("login_button")).click();
		if(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel")){
			test.log(Status.PASS,"Successfully Logged in");
		}
		else
		{
			//test.log(Status.FAIL,"Invalid in");
			Screenshot s=new AShot().takeScreenshot(driver);
			try {
				ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\ExtendReportDemo\\target\\img.png"));
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\ExtendReportDemo\\target").build());
  }
  @BeforeTest
  public void beforeTest() {
	  report= new ExtentReports();
	  
	  ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
	  report.attachReporter(spark);
	  test=report.createTest("ExtentDemo");
	  
 ; }

  @AfterTest
  public void afterTest() {
	  report.flush();
  }

}
