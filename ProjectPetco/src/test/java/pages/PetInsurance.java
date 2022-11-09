package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class PetInsurance {
	static WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	 
	 public  PetInsurance(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
		/*
		 * @FindAll({@FindBy(id="petName"),
		 * 
		 * @FindBy(name="petName"),
		 * 
		 * @FindBy(xpath=
		 * "/html/body/div[1]/div[1]/div/main/div/div/div[4]/div/form/div/div[1]/div/input"
		 * )}) WebElement petName;
		 */
	 
	// @FindBy(xpath=)
	// WebElement petName;
	 @FindAll({@FindBy(id="zipCode"),
			@FindBy(name="zipCode"),
			@FindBy(xpath="//*[@id=\"zipCode\"]")})
	 WebElement zipCode;
	 @FindAll({@FindBy(id="petType"),
			@FindBy(xpath="/html/body/div[1]/div[1]/div/main/div/div/div[4]/div/form/div/div[2]/div/button[2]")})
	 WebElement petTypeCat;
	 @FindAll({@FindBy(id="petType"),
			@FindBy(xpath="/html/body/div[1]/div[1]/div/main/div/div/div[4]/div/form/div/div[2]/div/button[1]")})
	 WebElement petTypeDog;
	 @FindAll({@FindBy(xpath="/html/body/div[1]/div[1]/div/main/div/div/div[4]/div/form/div/button")})
	 WebElement btn;
	 
		
public  void InsurancePage(String name,String code) throws InterruptedException {
	Thread.sleep(10000);
	Actions nameact = new Actions(driver);
 	
	  WebElement nameobj = driver.findElement(By.xpath("//*[@id=\"petName\"]"));
	  //nameobj.perform();
	  nameact.click(nameobj).build().perform();
	  nameobj.sendKeys(name);
	 //petName.sendKeys(name);
	 zipCode.sendKeys(code);
	 petTypeCat.click();
	 btn.click();
	 
}
}

	 

	 

