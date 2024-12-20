package paymentAndGuestUser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GuestUser {
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
		//driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();

	}
	@Test(priority=1)
	public void GuestUserViewProduct() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	@Test(priority=2)
	public void GuestUserAddProducttotheCart() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();
	}

	@Test(priority=3)
	public void GuestUserAddProducttothecartBuyit() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();
		driver.findElement(By.id("sc-buy-box-ptc-button")).click();
	}
	@Test(priority=4)
	public void GuestUserRemoveProducttothecart1() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();
		//driver.findElement(By.id("sc-buy-box-ptc-button")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[2]/span/input")).click();
		//driver.findElement(By.cssSelector("#sc-active-66e106d4-0f3e-46c8-9cfc-96d45040b923 > div.sc-list-item-content > div > div:nth-child(2) > div.a-row.sc-action-links > span.sc-action-quantity > span.sc-quantity-stepper > div > button:nth-child(2) > span")).click();
	}
	@Test(priority=5)
	public void GuestUsersaveitlaterProducttothecart() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();
		//driver.findElement(By.id("sc-buy-box-ptc-button")).click();
		driver.findElement(By.id("nav-cart-count")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[3]/span/input")).click();
        
}
	@Test(priority=6)
	public void GuestUserShareProducttothecart() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();
		//driver.findElement(By.id("sc-buy-box-ptc-button")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		driver.findElement(By.linkText("Share")).click();
	}

	@Test(priority=7)
	public void GuestUserShoppingCartProductAnotherway() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();
		//driver.findElement(By.id("sc-buy-box-ptc-button")).click();
		//driver.findElement(By.id("nav-cart-count")).click();
		driver.findElement(By.id("sw-gtc")).click();
}
	@AfterMethod
	public void closeTap() {
		
		
	}

	
}
