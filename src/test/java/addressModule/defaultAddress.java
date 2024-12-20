package addressModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrderModule.OrderModulePom;

public class defaultAddress {
WebDriver driver;
OrderModulePom pom;
	
	@BeforeMethod
	public void setup() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();	
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
        pom=new OrderModulePom(driver);
        pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();

        pom.Password("amazon123");
        pom.signInPage();
		 
        
        Actions action1=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(5) > span")).click();
        
	}
	@Test
	public void defaultAddressset() {
		driver.findElement(By.linkText("Set as Default")).click();
		
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}


}
