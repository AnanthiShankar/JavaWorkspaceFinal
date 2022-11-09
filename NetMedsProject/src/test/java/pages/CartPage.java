package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.CartTest;
public class CartPage {
	WebDriver driver;
	String text;
	
	public  CartPage(WebDriver driver) {
		// this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
		@FindBy(xpath="//*[@id='minicart_btn']/a/div")
		WebElement cartLink;
		@FindBy(xpath="//*[@id='app']/main/app-shopping-cart/div[2]/div/div[1]/h3")
		WebElement addProductsbtn;
		@FindBy(xpath="//*[@id='app']/main/app-shopping-cart/div[1]/div/div/div[1]/div[3]/div[2]/a")
		WebElement addmoreItem;
		
		@FindBy(xpath="//*[@id='app']/main/app-shopping-cart/div[1]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/button")
		WebElement proceedBtn;
		
		@FindBy(xpath="//*[@id='app']/main/app-shopping-cart/div[2]/div/div[1]/h3")
		
		WebElement EmptycartText;
		//@FindBy(xpath="//*[@id='app']/main/app-shopping-cart/div[2]/div/div[1]/h3")
		
		
  
  public void CartValidation() throws InterruptedException {
	  //Clicking on the cart link
	  cartLink.click();
	  //Validating if the cart is empty
	  //text=EmptycartText.getText();
	//  if (text.equals("Your Cart is empty!")){
		//  addProductsbtn.click();
	  //}
	 //else
	  //{
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement filters= driver.findElement(By.xpath("//*[@id='app']/main/app-shopping-cart/div[1]/div/div/div[1]/div[3]/div[2]/a"));
      js.executeScript("arguments[0].scrollIntoView()", filters);
      //addmoreItem.click();
      proceedBtn.click();
		 //CartTest t1= new CartTest();
		// t1.beauty();
	  //}
  }
}
