package amazon;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class detail_CreateAccount {

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
	
	@Test(priority=1)
	public void ValidDetails() {

		pom.Customer_name("Sugandhi");

		pom.Email_id("4567656789");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

	@Test(priority=2)
	public void AlreadyExistCustomer() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("techsugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      


	@Test(priority=3)
	public void CustomerNameDifferentButAlreadyExistMobileNumber() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("4567656789");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      

	

	@Test(priority=4)
	public void CustomerNameDifferentButAlreadyExistEmailId() {
		
		pom.Customer_name("Sugandhi");

		pom.Email_id("4567656789");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      

	

	@Test(priority=5)
	public void OTPNotReceived() {

		pom.Customer_name("Sugandhi");

		pom.Email_id("4567656789");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	


	@Test(priority=6)
	public void MultipleOTPRequestforsameEmail() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("4567656789");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      


	@Test(priority=7)
	public void AlreadyExistwithInvalidCredentials() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("4567656789");
        pom.Password("Amazon234");
        pom.check_Password("Azon234");
        pom.continue_login();
 	}	

      


	@Test(priority=8)
	public void AlreadyExistCustomerValidEmail() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("techsugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	


	@Test(priority=9)
	public void AlreadyExistCustomerInvalidEmail() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("techsugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Azon234");
        pom.continue_login();
 	}	

       
	@Test(priority=10)
	public void AlreadyExistCustomerEmptyEmail() {

		pom.Customer_name("Sugandhi");

		pom.Email_id("");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	
	

	@Test(priority=11)
	public void ValidEmailnotRegistered() {
		
		pom.Customer_name("Sugandhi");

		pom.Email_id("sugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      

	

	@Test(priority=12)
	public void AlreadyExistUppercaseEmailId() {
		pom.Customer_name("Sugandhi");
		pom.Email_id("TECHSUGANDHI@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      


	@Test(priority=13)
	public void AlreadyExistWhitespacethenEnterEmailId() {
		pom.Customer_name("Sugandhi");
		pom.Email_id("   techsugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");
        pom.continue_login();
 	}	

      
@AfterMethod
public void closeTap() {
	driver.close();
	
}
}
