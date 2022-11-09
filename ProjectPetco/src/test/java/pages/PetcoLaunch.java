package pages;

import java.io.File;
import java.io.IOException;
import pages.PetInsurance;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;



public class PetcoLaunch {
	 static WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	
  @Test(priority =1)
  public void services() {
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"petco-header-render-node\"]/header/div[4]/div[1]/div[2]/ul/li[1]/button")).click();
  }
  @Test (priority =2)
  public void Insurancelink() {
	  Actions actions = new Actions(driver);
	  WebElement menuHoverLink = driver.findElement(By.xpath("//*[@id=\"petco-header-render-node\"]/header/div[4]/div[1]/div[2]/ul/li[1]/button"));
	  actions.moveToElement(menuHoverLink).perform();
	  WebElement subLink = driver.findElement(By.cssSelector("#petco-header-render-node > header > div.HeaderBottomLayout__Container-sc-11q69ae-0.Pazjn > div.HeaderBottom__Container-sc-1yq0t42-7.eLrmOu > div:nth-child(2) > ul > li.HeaderBottom__ListItem-sc-1yq0t42-2.HeaderBottom___StyledListItem-sc-1yq0t42-6.cfXAgB.cHBXUz > div > div > div > ul > li:nth-child(9) > a"));
	  subLink.click();
	  
	  //driver.findElement(By.partialLinkText("/shop/en/petcostore/c/curbside-pickup")).click();
  }
  @Test(priority =3)
 public void InsuranceDetails() throws InterruptedException {
		/*
		 * Thread.sleep(1000);
		 *  if (driver.findElement(By.xpath("//*[@id=\"mainWellnessPage\"]/main/div/div/div[1]/div/p")).isDisplayed()){
		 * test.log(Status.PASS,"Successfully Navigate to Insuance Page"); } else {
		 * Screenshot s=new AShot().takeScreenshot(driver); try {
		 * ImageIO.write(s.getImage(), "PNG", new
		 * File("C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img.png"
		 * )); }catch (IOException e) { e.printStackTrace(); }
		 * 
		 * } test.fail(MediaEntityBuilder.createScreenCaptureFromPath(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target").build());
		 */
		/*
		 * Thread.sleep(40000); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div/main/div/div/div[4]/div/form/div/div[1]/div/input"
		 * )).clear(); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div/main/div/div/div[4]/div/form/div/div[1]/div/input"
		 * )).sendKeys("Scooby");
		 * driver.findElement(By.xpath("//*[@id=\"petType\"]/span")).click();
		 * driver.findElement(By.id("zipCode")).clear();
		 * driver.findElement(By.id("zipCode")).sendKeys("60603"); if
		 * (driver.findElement(By.xpath(
		 * "//*[@id=\"quoteFormContainer\"]/div/form/div/button")).isEnabled()){
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"quoteFormContainer\"]/div/form/div/button")).click(); } else {
		 * Screenshot s=new AShot().takeScreenshot(driver); try {
		 * ImageIO.write(s.getImage(), "PNG", new File(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img1.png"));
		 * }catch (IOException e) { e.printStackTrace(); } }
		 * test.fail(MediaEntityBuilder.createScreenCaptureFromPath(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target").build());
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div/div/div/div[3]/div/div/form/div/div/div/div/div[2]/div/svg"
		 * )).sendKeys("1 year old"); if
		 * (driver.findElement(By.id("continue-button")).isEnabled()){
		 * driver.findElement(By.id("continue-button")).click(); } else { Screenshot
		 * s=new AShot().takeScreenshot(driver); try { ImageIO.write(s.getImage(),
		 * "PNG", new File(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img2.png"));
		 * }catch (IOException e) { e.printStackTrace(); } }
		 * test.fail(MediaEntityBuilder.createScreenCaptureFromPath(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target").build());
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]")).sendKeys(
		 * "Boxer"); if (driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div/div/div[3]/div/form/button")).
		 * isEnabled()){ driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div/div/div[3]/div/form/button")).click()
		 * ; } else { Screenshot s=new AShot().takeScreenshot(driver); try {
		 * ImageIO.write(s.getImage(), "PNG", new File(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img3.png"));
		 * }catch (IOException e) { e.printStackTrace(); } }
		 * test.fail(MediaEntityBuilder.createScreenCaptureFromPath(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target").build());
		 * driver.findElement(By.name("email")).sendKeys("ananthi.shankariyer@gmail.com"
		 * ); if (driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div/div/div/div[3]/div[2]/form/button")).
		 * isEnabled()){ driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div/div/div/div[3]/div[2]/form/button")).
		 * click(); } else { Screenshot s=new AShot().takeScreenshot(driver); try {
		 * ImageIO.write(s.getImage(), "PNG", new File(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img4.png"));
		 * }catch (IOException e) { e.printStackTrace(); } }
		 * test.fail(MediaEntityBuilder.createScreenCaptureFromPath(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target").build());
		 * 
		 * if (driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div[2]/div[2]/div/div/button[1]")).
		 * isDisplayed()){ Screenshot s=new AShot().takeScreenshot(driver); try {
		 * ImageIO.write(s.getImage(), "PNG", new File(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img5.png"));
		 * }catch (IOException e) { e.printStackTrace(); }
		 * //driver.findElement(By.xpath(
		 * "//*[@id=\"mainWellnessPage\"]/main/div[2]/div[2]/div/div/button[1]")).click(
		 * ); } else { Screenshot s=new AShot().takeScreenshot(driver); try {
		 * ImageIO.write(s.getImage(), "PNG", new File(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target\\img6.png"));
		 * }catch (IOException e) { e.printStackTrace(); } }
		 * test.fail(MediaEntityBuilder.createScreenCaptureFromPath(
		 * "C:\\Users\\Administrator\\JavaWorkspace\\ProjectPecto\\target").build());
		 */
	  	JavascriptExecutor js = (JavascriptExecutor) driver;
	  	WebElement obj1= driver.findElement(By.xpath("//*[@id=\"quoteFormContainer\"]/div/form/div/div[4]/p\n"));
	  	js.executeScript("arguments[0].scrollIntoView()",obj1);
	  	//js.executeScript(Window.scrollBy(0,1000));
		PetInsurance pt=new PetInsurance(driver);
		pt.InsurancePage("Scooby", "60603");
		
	}
	  
  		
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	   System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
	   ChromeOptions HandleSSLError = new ChromeOptions();
	   HandleSSLError.setAcceptInsecureCerts(true);
	   HandleSSLError.addArguments("--disable-notifications");
	   
		//create an object of webdriver
		driver = new ChromeDriver(HandleSSLError);
		//navigate to webapplication
		driver.get("https://www.petco.com/");
		driver.manage().window().maximize();
		Reporter.log("driver instantiation in chrome and Petco site Launched");
		
		Thread.sleep(10000);
			
		  try {
			  if(driver.findElement(By.xpath("//*[@id=\"bx-element-1805167-a64bdbV\"]/div")).isDisplayed()) {
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//*[@id=\"bx-close-inside-1805167\"]")).click();
			  }
		  }catch(NoSuchElementException e) {
			  e.printStackTrace();
		  }
		 	 
		
  }

	/*
	 * @AfterTest public void afterTest() { driver.quit(); }
	 */
}
