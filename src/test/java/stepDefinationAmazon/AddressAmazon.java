package stepDefinationAmazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressAmazon {
	WebDriver driver;
	@Given("I am in the Amazon homePage")
	public void i_am_in_the_amazon_home_page() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		
	}

	

	@Given("I am Logged in the Amazon Account")
	public void i_am_logged_in_the_amazon_account(String Email_id,String Password) {
		driver.findElement(By.id("ap_email")).sendKeys(Email_id);
		driver.findElement(By.id("continue")).click();

		driver.findElement(By.id("ap_password")).sendKeys(Password);
		driver.findElement(By.id("signInSubmit")).click();
		  


	}

	@When("Click the {string} option")
	public void click_the_option(String string) {
        driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(1) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
 
	}

	

	@When("Enter the details")
	public void enter_the_details() {
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

	@Then("Save the Address")
	public void save_the_address1() {
        driver.findElement(By.id("cdp-save-button")).click();

	}
	

	@Given("I am logged into Amazon Account")
	public void i_am_logged_into_amazon_account(String Email_id,String Password) {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		driver.findElement(By.id("ap_email")).sendKeys(Email_id);
		driver.findElement(By.id("continue")).click();

		driver.findElement(By.id("ap_password")).sendKeys(Password);
		driver.findElement(By.id("signInSubmit")).click();
		  

	}
	

	@When("Click on the {string} option")
	public void click_on_the_option(String string) {
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

	@Then("save the Address")
	public void save_the_Address() {
        driver.findElement(By.id("cdp-save-button")).click();
	}

	

	@Then("Save it as DEfault Address")
	public void save_it_as_d_efault_address() {
        driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(5) > span")).click();

		driver.findElement(By.linkText("Set as Default")).click();

	    	}
	@Given("the Amazon homePage")
	public void the_amazon_home_page() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		
	}

	

	@When("Enter the invalid details")
	public void enter_the_invalid_details() {
		driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(1) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
        driver.findElement(By.cssSelector("#ya-myab-address-add-link > div > div")).click();
       Actions action2=new Actions(driver);
       action2.moveToElement(driver.findElement(By.cssSelector("#address-ui-widgets-countryCode > span > span"))).build().perform();
         driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_37")).click();
       driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Sugandhi Chinnappan");
        driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4356785678");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("16 hollyhedge court");
        driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/span/span/span/span")).click();
        driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_5")).click();
        driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6S1F5");
        driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
   

	}

	@Then("ask for the Suggestion option")
	public void ask_for_the_suggestion_option() {
		  driver.findElement(By.id("address-ui-widgets-suggested-address-block_id-input")).click();
		
	}

	@Then("Save the address")
	public void save_the_address() {
        driver.findElement(By.cssSelector("#a-autoid-2 > span > input")).click();

	}



}
