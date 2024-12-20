package OrderModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderHistory {
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
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span"));
        driver.findElement(By.cssSelector("#nav_prefetch_yourorders > span")).click();
        pom=new OrderModulePom(driver);


	}
	@Test
	public void GotoOrderHistoryPage() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
		 
	        
	        
	}
	@Test(priority=1)
	public void ViewOrderPlacedinPast3Month() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.autoid();
 
	    driver.findElement(By.id("time-filter_1")).click();
	        
	}
	@Test(priority=2)
	public void ViewOrderPlacedinCurrentYear() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.autoid();
	    driver.findElement(By.id("time-filter_3")).click();
	     
	        
	}
	@Test(priority=3)
	public void ViewOrderPlacedinArchivedOrders() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.autoid();
	    driver.findElement(By.id("time-filter_6")).click();
	     
	      
	}
	@AfterMethod
	public void closeTap() {
	
		
	}

}