package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	//*[@id=\"page-header\"]/div/div/div[5]/a
	WebDriver driver;
	String text;
	
	public  Logout(WebDriver driver) {
		 //this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
		@FindBy(xpath="//*[@id=\"page-header\"]/div/div/div[5]/a")
		WebElement userLogout;
		@FindBy(xpath="//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[14]")
		WebElement logoutbtn;
		 public void userLogoutClick() throws InterruptedException {
			  //Clicking on the cart link
			 userLogout.click();
			  //Scrolling down till proceed button
			 
		  }
		 public void logoutClick() throws InterruptedException {
			  //Clicking on the cart link
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  // WebElement lgout= driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[14]"));
		   js.executeScript("arguments[0].scrollIntoView()", logoutbtn);
		   Thread.sleep(5000);
		   logoutbtn.click();
			 
		  }
}
