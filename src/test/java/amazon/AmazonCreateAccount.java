package amazon;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonCreateAccount  {
	
	WebDriver driver;
	Detail_CreateAccountPom pom;
	@BeforeMethod
	public void setup() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();	
		driver.findElement(By.linkText("Start here.")).click();
		pom=new Detail_CreateAccountPom(driver);



	}
	
	@DataProvider(name="AccountDetails")
	public Object[][] getAccountDetails(){
		
		return new Object[][] {
			{"Sugandhi","4565678978"},
			{"Gopi","5682456654223333"},
			{"Sugandhi@#$","4565238596"},
			{"Gopi","234556fggh45"},
			{"  Gopi","4568528956"},
			{"Sugandhi","    5685256"},
			{"Sugandhi","9785623541"}
		};
		
	}	
	@Test(dataProvider="AccountDetails")
	public void testCreateAccount(String name,String Mobile_number) {

		driver.findElement(By.id("ap_customer_name")).sendKeys(name);
		driver.findElement(By.id("ap_email")).sendKeys(Mobile_number);		

		
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}
}