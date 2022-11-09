package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CartPage1 {
	//WebDriver driver;
	String text;
	
	public  CartPage1(WebDriver driver) {
		 //this.driver=driver;
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
		@FindBy(xpath="//*[@id='itemid-347798']/div[2]/div[3]/div[2]/a[1]")
		WebElement Removebutton1;
		@FindBy(xpath="//*[@id='itemid-940215']/div[2]/div[3]/div[2]/a[1]")
		WebElement Removebutton2;
		//@FindBy(linkText="Remove")
		//WebElement Removebutton2;
		//h="//input[starts-with[@id,itemid")
		//List<WebElement> Removebuttons;
		@FindBy(xpath="/html/body")
		WebElement Genericplace;
		
		
  
  public void Carlinkclick() throws InterruptedException {
	  //Clicking on the cart link
	  cartLink.click();
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(10000);
	  //Scrolling down till proceed button
	 
  }
  public void ProceedBtnclick(WebDriver driver) {
	  
      //Clicking on the proceed button
	  JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement filters= driver.findElement(By.xpath("//*[@id='app']/main/app-shopping-cart/div[1]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/button"));
	    js.executeScript("arguments[0].scrollIntoView();", filters);
	    proceedBtn.click();
		
  }
  
  public void RemovebuttonClick() {
	  Removebutton1.click();
	  Removebutton2.click();
	  
	    
  }
  public void GenericPlaceClick() {
	  Genericplace.click();
	    
  }
  public boolean EmptycartText() {
	  if (EmptycartText.isDisplayed()){
		  return true;
	  }
	  else {
		  return false;
	  }
		  
  }
  
}
