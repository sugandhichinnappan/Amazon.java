package paymentAndGuestUser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrderModule.OrderModulePom;

public class DefaultPayment {
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

	}
	@Test(priority=1)
	public void defaultPayment() {
		 
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
		 
	        driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(5) > span")).click();
	        driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(3) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();

	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

	
}
