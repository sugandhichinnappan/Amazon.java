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

public class AdditionalDeliveryInstruction {
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
	 
	      @Test
	public void AdditionalInformationAddressSave() {
		
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
            driver.findElement(By.linkText("Add delivery instructions")).click();
           
            driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(1) > a")).click();
            driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(1) > div > div > div > fieldset > span > div.a-radio.ma-pdl-safe-location-GARAGE.ma-safe-place-options.a-spacing-none > label > span")).click();
            driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(2) > a > span > div > div.ma-expander-summary-content.aok-hidden")).click();
           driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(2) > div > div.a-row.a-spacing-top-mini > label")).isSelected();
            driver.findElement(By.id("securityCode-HOUSE")).sendKeys("1234");
            driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(2) > div > div:nth-child(2) > div > label")).isSelected();
            driver.findElement(By.id("callBox-HOUSE")).sendKeys("Sugandhi");
            driver.findElement(By.linkText("Add more instructions")).click();
            driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(3) > a > span > div > div.a-row > h5")).click();
            driver.findElement(By.id("weekendTitleId-SAT")).isSelected();
            driver.findElement(By.cssSelector("#a-page > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-house-form-block > div:nth-child(3) > div > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(2) > span > span")).click();
            driver.findElement(By.id("cdp-save-button")).click();
	}
	      @AfterMethod
	  	public void closeTap() {
	  		driver.close();
	  		
	  	}

}

