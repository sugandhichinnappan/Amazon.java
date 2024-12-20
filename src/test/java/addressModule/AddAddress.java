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

public class AddAddress {
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
    pom.Email_id("chinnappan.sugandhi@gmail.com");
    pom.continue_login();

    pom.Password("Atarahgopi125129");
    pom.signInPage();
	 
    
    Actions action1=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
    driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(5) > span")).click();
    
}
	@Test(priority=1)
	public void AddAddressOPtion() {
	      
            driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(1) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
}
	@Test(priority=2)
	public void AddAddressSave() {
		
        driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(1) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
	        driver.findElement(By.cssSelector("#ya-myab-address-add-link > div > div")).click();
            //driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(1) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
           Actions action2=new Actions(driver);
           action2.moveToElement(driver.findElement(By.cssSelector("#address-ui-widgets-countryCode > span > span"))).build().perform();
             driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_37")).click();
           driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Sugandhi Chinnappan");
            driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4356785678");
            driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("16 hollyhedge court");
            driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/span/span/span/span")).click();
            driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")).click();
            driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6S1R5");
            driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
            
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

}