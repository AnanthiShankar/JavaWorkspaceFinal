package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFristAutmationScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://Adactinhotelapp.com");
		WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys("vasuvespag");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("vasu1234");
		driver.findElement(By.className("login_button")).click();
		
		new Select(driver.findElement(By.cssSelector("#location"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#hotels"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#room_type"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#room_nos"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#adult_room"))).selectByIndex(1);
		new Select(driver.findElement(By.cssSelector("#child_room"))).selectByIndex(1);
		
		driver.findElement(By.className("reg_button")).click();
		driver.findElement(By.xpath("//*[@id=\"radiobutton_0\"]")).click();
		
		
		
		
		
		
	}

}
