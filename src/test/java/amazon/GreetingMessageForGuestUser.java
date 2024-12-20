package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GreetingMessageForGuestUser {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();	



	}
	@Test(priority=1)
	public void GreetingMessageforGuest() {
	
boolean e=driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();

System.out.println(e);
	}
	

   @Test(priority=2)
   public void GreetingLanguageSpecific() {
	   driver.findElement(By.cssSelector("#icp-nav-flyout > span > span.nav-line-2")).click();
  driver.findElement(By.cssSelector("#icp-language-settings > div:nth-child(5) > div > label > span > span")).click();
  driver.findElement(By.id("icp-save-button")).click();
  boolean e=driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();

  System.out.println(e);
   }
   
@Test(priority=3)
public void GreetingUpdateAfterLogin() {

	boolean e=driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();

	System.out.println(e);
	driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
	

	  driver.findElement(By.id("ap_email")).sendKeys("techsugandhi@gmail.com");
      driver.findElement(By.id("continue")).click();
      driver.findElement(By.id("ap_password")).sendKeys("amazon123");
      driver.findElement(By.id("signInSubmit")).click();
      boolean second=driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();

  	System.out.println(second);
	
	}
@AfterMethod
public void closeTap() {
	
	
}


}
