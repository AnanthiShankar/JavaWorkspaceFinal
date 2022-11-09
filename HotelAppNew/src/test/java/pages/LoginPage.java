package pages;

public class LoginPage {

	WebDriver driver;
	By uname = By.id("username");
	By Password= By.id("password");
	By LoginButton=By.id("login");
	
	Public LoginPage(Webdriver driver2) {
		this.driver=driver2;
	}
	
