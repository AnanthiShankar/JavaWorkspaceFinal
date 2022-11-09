package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;

public class LoginTest {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Ana\\Drivers\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://Adactinhotelapp.com");
			
		LoginPage LoginPg= PageFactory.initElements(driver, LoginPage.class);
		LoginPg.loginAction("vasuvespag","vasu1234");
		driver.quit();
		
	}

}
