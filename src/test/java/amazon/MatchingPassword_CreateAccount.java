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

public class MatchingPassword_CreateAccount {
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
	@Test(priority=3)
	public void LowercasePasswordAndUppercasePasswordAgain() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("sugandhi@gmail.com");
        pom.Password("amazon234");
        pom.check_Password("AMAZON234");

            
	}
	@Test(priority=2)
	public void MisMatchPasswordAndPasswordAgain() {
		
		pom.Customer_name("Sugandhi");

		pom.Email_id("sugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("AMAZin234");

           
	}
	@Test(priority=1)
	public void MatchingPasswordAndPasswordAgain() {
		
		pom.Customer_name("Sugandhi");

		pom.Email_id("sugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("Amazon234");


           
	}
	@Test(priority=4)
	public void PasswordAndSpecialCharacterPasswordAgain() {

      

		pom.Customer_name("Sugandhi");

		pom.Email_id("sugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("AMA@#$%34");
      
	}
	@Test(priority=5)
	public void PasswordAndInvalidLengthPasswordAgain() {
		pom.Customer_name("Sugandhi");

		pom.Email_id("sugandhi@gmail.com");
        pom.Password("Amazon234");
        pom.check_Password("AMAZO3ddfffN234");


      

      
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}


}


