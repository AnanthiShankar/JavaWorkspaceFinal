package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class MyFirstSeleniumgrid {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String baseurl="http://adactinhotelapp.com";
		String gridurl="http://172.20.0.25:4444";
		
		/*
		 * ChromeOptions opt=new ChromeOptions(); opt.addArguments("start-maximized");
		 * opt.addArguments("chrome.switches","-disable-extensions");
		 * opt.addArguments("--enable-popup-blocking");
		 */
		  EdgeOptions eo= new EdgeOptions();
			 eo.addArguments("start-maximized");
			 eo.addArguments("chrome.switches","-disable-extensions");
			 eo.addArguments("--enable-popup-blocking");
			 
		
		/*
		 * DesiredCapabilities dCap= new DesiredCapabilities();
		 * dCap.setCapability("browserName", "msedge");
		 * dCap.setCapability("version","106.0.1370.47");
		 */
		  System.out.println("start of execution");
			/*
			 * WebDriver driver=new RemoteWebDriver(new URL(gridurl),eo);
			 * driver.get(baseurl); WebElement uname=driver.findElement(By.id("username"));
			 * uname.clear(); uname.sendKeys("vasuvaspeg"); WebElement
			 * pass=driver.findElement(By.id("password")); pass.sendKeys("vasu1234");
			 */
			
			/*
			 * driver.findElement(By.className("login_button")).click(); WebElement
			 * greeting=driver.findElement(By.id("username_show"));
			 * System.out.println(greeting.getAttribute("value"));
			 */
		
		
		
				
		System.out.println("start of execution");
		WebDriver driver=new RemoteWebDriver(new URL(gridurl),eo);
		driver.get(baseurl);
		
		  WebElement uname=driver.findElement(By.id("username")); uname.clear();
		  uname.sendKeys("vasuvespag"); 
		  WebElement pass=driver.findElement(By.id("password")); pass.sendKeys("vasu1234");
		 
		
		  driver.findElement(By.className("login_button")).click(); 
		  WebElement greeting=driver.findElement(By.id("username_show"));
		  System.out.println(greeting.getAttribute("value"));
		  
		  new Select(driver.findElement(By.cssSelector("#location"))).selectByVisibleText("Sydney");
		  new Select(driver.findElement(By.cssSelector("#hotels"))).selectByVisibleText("Hotel Creek");
		  new Select(driver.findElement(By.cssSelector("#room_type"))).selectByVisibleText("Double");
		  new Select(driver.findElement(By.cssSelector("#room_nos"))).selectByVisibleText("2 - Two");
		  driver.findElement(By.name("datepick_in")).clear();
		  driver.findElement(By.name("datepick_in")).sendKeys("15/10/2022");
		  driver.findElement(By.name("datepick_out")).clear();
		  driver.findElement(By.name("datepick_out")).sendKeys("16/10/2022");
		  new Select(driver.findElement(By.cssSelector("#adult_room"))).selectByVisibleText("1 - One");
		  //new Select(driver.findElement(By.cssSelector("#adult_rrom"))).selectByVisibleText("1 - one");
		  new Select(driver.findElement(By.cssSelector("#child_room"))).selectByVisibleText("1 - One");
		  driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
		  
			FluentWait<WebDriver> wait =new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("welcome")));
		
		
		
		
	}

}
