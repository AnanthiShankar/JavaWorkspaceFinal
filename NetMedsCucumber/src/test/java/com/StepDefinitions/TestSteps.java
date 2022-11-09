package com.StepDefinitions;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage1;
import pages.Logout;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TestSteps {
WebDriver driver;
ExtentTest test;
ExtentReports report;
String check;
String ExpectedOutput;
CartPage1 CP;
Logout LP;

@Given("User is on the NetMeds HomePage")
public void user_is_on_the_net_meds_home_page() {
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
  driver.findElement(By.linkText("Sign in / Sign up")).click();
      
      
}

@When("User enters the Phonenumber details")
public void user_enters_the_phonenumber_details() {
	WebElement telNumber = driver.findElement(By.id("loginfirst_mobileno"));
    
    //telNumber.sendKeys("9121862790");
    //telNumber.sendKeys("9047488667");
    //telNumber.sendKeys("7411920347");
    telNumber.sendKeys("8003886177");
     // telNumber.sendKeys("9686266442");
}

@When("User enters the OTP details")
public void user_enters_the_otp_details() {
	driver.findElement(By.xpath("//*[@id='app']/main/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button")).click();
}

@When("User clicks the VerifyButton")
public void user_clicks_the_verify_button() throws InterruptedException {
	Thread.sleep(50000);
    driver.findElement(By.xpath("//*[@id='app']/main/app-login/div[1]/div/div/div[2]/div[1]/form/div[2]/div/button")).click();
}

@Then("Login is successful")
public void login_is_successful() {
	String actualoutput = "Netmeds Sign In / Sign Up";
	ExpectedOutput=driver.getTitle();
	Assert.assertEquals(ExpectedOutput, actualoutput);
	System.out.println(actualoutput);
	Screenshot s=new AShot().takeScreenshot(driver);
	try {
		ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img.png"));
	}catch (IOException e) {
		e.printStackTrace();
	}
	test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img.png").build());
}

@Given("User is on Homepage")
public void user_is_on_homepage() {
    System.out.println("User is in the HomePage");
}

@When("User selects medicines")
public void user_selects_medicines() {
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
	
	 
	 
}

@When("User selects Product and Add to cart")
public void user_selects_product_and_add_to_cart() {
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
}

@Then("Item is added to cart successfully")
public void item_is_added_to_cart_successfully() {
	System.out.println("Medicines Added to cart successfully");
		
}

@Given("User is on HomePage")
public void user_is_on_home_page() {
	driver.navigate().to("https://www.netmeds.com/"); 
}

@When("User Selects Beauty")
public void user_selects_beauty() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  
	  Actions act=new Actions(driver);
  WebElement beautymainMenu= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]"));
  act.moveToElement(beautymainMenu).perform();
}

@When("User Selects HairProducts and added to cart")
public void user_selects_hair_products_and_added_to_cart() {
	 Actions act=new Actions(driver);
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
    driver.findElement(By.xpath("//*[@id=\"algolia_hits\"]/div/div/ol/li[1]/div/a[1]/span[1]/img")).click();
    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]/div[8]/form/div/button/span[1]")).click();
    Screenshot s=new AShot().takeScreenshot(driver);
		try {
			ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img2.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img2.png").build());
}

@Given("User is on the cart page")
public void user_is_on_the_cart_page() throws InterruptedException {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  //CartPage c1=PageFactory.initElements(driver, CartPage.class);
	  CP=new CartPage1(driver);
	  CP.Carlinkclick();
	  Screenshot s=new AShot().takeScreenshot(driver);
		try {
			ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img3.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\JavaWorkspace\\NetMedsProject\\target\\img3.png").build());
		String actualoutput = "Netmeds.com: Indian Online Pharmacy | Buy Medicines Online, Fast Delivery";
		ExpectedOutput=driver.getTitle();
		Assert.assertEquals(ExpectedOutput, actualoutput);
}

@When("User clicks on Proceed button and navigates to cartpage")
public void User_clicks_on_Proceed_button_and_navigates_to_cartpage() throws InterruptedException {
	
	CP= new CartPage1(driver);
	
	CP.ProceedBtnclick(driver);
	
	CP.GenericPlaceClick();
	//Navigating to Cartpage
	driver.navigate().to("https://www.netmeds.com/checkout/cart");
	  
	 
}
@Then("Removes Items in the cart and Logsout")
public void Removes_Items_in_the_cart_and_Logsout() throws InterruptedException {
	
	  CP= new CartPage1(driver);
	  CP.RemovebuttonClick();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //CP.Removebutton2Click();
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		 	 	  
	  LP=new Logout(driver);
	  LP.userLogoutClick();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  LP.logoutClick();
	  String actualoutput = "Netmeds Sign In / Sign Up";
	  ExpectedOutput=driver.getTitle();
	  Assert.assertEquals(ExpectedOutput, actualoutput);
	  driver.quit();
	  report.flush();
}

}
