package tests;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CartPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class CartTest {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	String check;
  @Test(priority=1)
  public void Login() throws InterruptedException {
	  driver.findElement(By.linkText("Sign in / Sign up")).click();
      
      WebElement telNumber = driver.findElement(By.id("loginfirst_mobileno"));
      
      //telNumber.sendKeys("9121862790");
      //telNumber.sendKeys("9686266442");
      telNumber.sendKeys("7411920347");
      //telNumber.sendKeys("8003886177");
      

      driver.findElement(By.xpath("//*[@id='app']/main/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button")).click();
      Thread.sleep(25000);
      driver.findElement(By.xpath("//*[@id='app']/main/app-login/div[1]/div/div/div[2]/div[1]/form/div[2]/div/button")).click();
      //System.out.println( driver.getTitle());
     // Reporting("Netmeds Sign In / Sign Up");
      Screenshot s=new AShot().takeScreenshot(driver);
		try {
			ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img.png").build());
  	}
  
  @Test(priority=2)
  public void medicineDropDown() throws InterruptedException 
  {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  
	  Actions act = new Actions(driver);
	  WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[1]"));
	  act.moveToElement(mainMenu).build().perform();
	  
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();	
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	  
	  JavascriptExecutor j = (JavascriptExecutor) driver; 
	  WebElement element1 =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/h1"));
	  j.executeScript("arguments[0].scrollIntoView();", element1);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.findElement(By.xpath("//*[@id=\"list-nav\"]/div[1]/ul/li[2]/a")).click();		
	  driver.findElement(By.xpath("//*[@id=\"list-nav-nav\"]/div/a[4]")).click();	
	  driver.findElement(By.linkText("D Acne Soap 75gm")).click();	
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver; 
	  WebElement element2 =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]/div[1]/h1"));
	  js.executeScript("arguments[0].scrollIntoView();", element2);

	  WebElement web = driver.findElement(By.xpath("//*[@id=\"pincode\"]"));
	  web.clear();
	  web.sendKeys("110044");
	  driver.findElement(By.xpath("//*[@id=\"check_expiry_btn\"]/i")).click();
	
	 
	 driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]/div[8]/form/div/button/span[1]")).click();	
	 driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]/div[8]/form/div/button[2]")).click();
	 driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]/div[8]/form/div/button[1]")).click();
	 //System.out.println( driver.getTitle());
	 //Reporting("D Acne Soap 75gm - Buy Medicines online at Best Price from Netmeds.com");
	 Reporter.log("This is Medicine Drop Down test");	
	 
	 Screenshot s=new AShot().takeScreenshot(driver);
		try {
			ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img1.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img1.png").build());
		driver.navigate().to("https://www.netmeds.com/"); 
  }
  

  @Test (priority=3)
  public void beauty() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  
	  Actions act=new Actions(driver);
      WebElement beautymainMenu= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]"));
      act.moveToElement(beautymainMenu).perform();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement SubList=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/ul/li[3]/a "));
      act.moveToElement(SubList).perform();
      SubList.click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.findElement(By.xpath("//*[@id=\"category_filter\"]/div/ul/li[1]/div/div/label/input")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.findElement(By.xpath("//*[@id=\"stock_filter\"]/div/ul/li/div/div/div/label/input")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     JavascriptExecutor js=(JavascriptExecutor) driver;
      
     WebElement discount= driver.findElement(By.xpath("//*[@id=\"sort_container\"]/button[4]"));
      js.executeScript("arguments[0].scrollIntoView()", discount);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement filters= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div/h2/span"));
      js.executeScript("arguments[0].scrollIntoView()", filters);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.findElement(By.xpath("//*[@id=\"algolia_hits\"]/div/div/ol/li[1]/div/form/button")).click();
      Screenshot s=new AShot().takeScreenshot(driver);
		try {
			ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img2.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img2.png").build());
      //System.out.println( driver.getTitle());   
     // Reporting("Hair - Non-Prescription");
  }
  
  @Test(priority=4)
  public void CartTestValidation() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  CartPage c1=PageFactory.initElements(driver, CartPage.class);
	  
	  c1.CartValidation();
	  Screenshot s=new AShot().takeScreenshot(driver);
		try {
			ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img3.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img3.png").build());
	  //System.out.println( driver.getTitle());
	  //Reporting("Netmeds.com: Indian Online Pharmacy | Buy Medicines Online, Fast Delivery");
	 
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
	   ChromeOptions HandleSSLError = new ChromeOptions();
	   HandleSSLError.setAcceptInsecureCerts(true);
	   HandleSSLError.addArguments("--disable-notifications");
	   
		//create an object of webdriver
		driver = new ChromeDriver(HandleSSLError);
		//navigate to webapplication
		driver.get("https://www.netmeds.com/");
		driver.manage().window().maximize();
		Reporter.log("driver instantiation in chrome and netmeds site Launched");
		 report= new ExtentReports();
		  
		  ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
		  report.attachReporter(spark);
		  test=report.createTest("CartTest");
		  //System.out.println( driver.getTitle());
  }
  @AfterTest
  public void AfterTest() throws InterruptedException {
	  driver.findElement(By.xpath("/html/body"));
	  driver.navigate().to("https://www.netmeds.com/checkout/cart");
	  
	  driver.findElement(By.xpath("//*[@id='itemid-347798']/div[2]/div[3]/div[2]/a[1]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id='itemid-889019']/div[2]/div[3]/div[2]/a[1]")).click();
	//*[@id="page-header"]/div/div/div[5]/a
	  driver.findElement(By.xpath("//*[@id=\"page-header\"]/div/div/div[5]/a")).click();
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement lgout= driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[14]"));
      js.executeScript("arguments[0].scrollIntoView()", lgout);
      driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[14]")).click();
  
      driver.quit();
	  report.flush();
  }
 

}
