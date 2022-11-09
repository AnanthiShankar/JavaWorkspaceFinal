package testcases;
import pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataproviders.ConfigFileReader;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigFileReader configRead= new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", configRead.getDriverPath());
		WebDriver driver = new ChromeDriver();
		String url=configRead.getAppUrl();
		driver.get(url);
		String user=configRead.getUsername();
		System.out.println(user);
		String pass=configRead.getPassword();
		System.out.println(pass);
		
		LoginPage loginPg= new LoginPage(driver);
		loginPg.loginAction(user, pass);
		
		
	}

}
