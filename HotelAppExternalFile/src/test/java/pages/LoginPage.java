package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="username")
	WebElement uName;
	
	@FindAll({ //uses And and Connection so it should have id and name
		@FindBy(id="password"),
		@FindBy(name="password")
		
	})
	WebElement pwd;
	
	@FindAll({ //uses And and Connection so it should have id and name
		@FindBy(id="login"),
		@FindBy(name="login"),
		@FindBy(className="button")
		})
	WebElement lbtn;
	/**
	 * @param user
	 * @param pass
	 */
	public void loginAction(String user, String pass) {
		// TODO Auto-generated method stub
		uName.sendKeys(user);
		pwd.sendKeys(pass);
		lbtn.click();
		
	}
	

}
