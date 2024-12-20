package amazon;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreateAccount {
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
	public void testCreateAccount_notEmpty() {
		
		pom.Customer_name("Sugandhi");
		pom.Email_id("techsugandhi@gmail.com");
	}	
	@Test(priority=2)
	public void CreateAccount_nameAndInvalidMobileNumber() {

		pom.Customer_name("Sugandhi");
		pom.Email_id("568567896522333");
	

		
	}
	@Test(priority=3)
	public void CreateAccount_SpecialCharacterName() {
		
		pom.Customer_name("Sugandhi@#$");
		pom.Email_id("4568524562");
		
		
	}
	@Test(priority=4)
	public void CreateAccount_NameAndSpecialCharacterNumber() {

		 
		pom.Customer_name("Sugandhi");
		pom.Email_id("859562@#$$");
		
		
	}
	@Test(priority=5)
	public void CreateAccount_NameAndCharacterNumber() {
		 
			pom.Customer_name("Sugandhi");
			pom.Email_id("859562erfd23");
	}
	@Test(priority=6)
	public void CreateAccount_SpaceNameAndMobileNumber() {
	      

		 
			pom.Customer_name("   Sugandhi");
			pom.Email_id("8595625656");	}
	@Test(priority=7)
	public void CreateAccount_NameAndSpaceMobileNumber() {
	      

		 
			pom.Customer_name("Sugandhi");
			pom.Email_id("  859562456");	}
	@Test(priority=8)
	public void CreateAccount_NameAndformatdifferentCountryForMobileNumber() {
	      
		 
			pom.Customer_name("Sugandhi");
			pom.Email_id("9785544178");
	}
	
	@Test(priority=9)
	public void CreateAccount_NameAndformatNotMatchingCountryforMobileNumber() {
	      

		 
			pom.Customer_name("Sugandhi");
			pom.Email_id("6475868956");	
				}
	
	@Test(priority=10)
	public void CreateAccount_NameAndMobileNumberAlreadyInUse() {
	      
		 
			pom.Customer_name("Sugandhi");
			pom.Email_id("6475868956");
	}
	@Test(priority=11)
	public void CreateAccount_NameAndMobileNumberVerify() {
	      

		 
			pom.Customer_name("Sugandhi");
			pom.Email_id("8595628956");	
			}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

}


