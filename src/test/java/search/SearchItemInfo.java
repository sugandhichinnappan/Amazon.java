package search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrderModule.OrderModulePom;

public class SearchItemInfo {
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
        pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
	}
	@Test
	 public void Search_FullItem() {
	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tablet");
	     driver.findElement(By.id("nav-search-submit-text")).click();
}
	@Test
	  public void Search_ParitalItem() {
		     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Smar");
		     driver.findElement(By.id("nav-search-submit-text")).click();
	}
	@Test
	         
	         public void Search_NumberItem() {
		     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("45678");
		     driver.findElement(By.id("nav-search-submit-text")).click();
	}
	@Test
	         
	         public void Search_descriptionItem() {
		     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Baby toys");
		     driver.findElement(By.id("nav-search-submit-text")).click();
	}
	@Test
	         public void Search_spellingMistakeItem() {
		     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ipone12");
		     driver.findElement(By.id("nav-search-submit-text")).click();
	}
	         @Test
	         public void Search_InvalidKeywordItem() {
		     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("@$%^^%$");
		     driver.findElement(By.id("nav-search-submit-text")).click();
	}
	         @AfterMethod
	     	public void closeTap() {
	     		driver.close();
	     		
	     	}

}
