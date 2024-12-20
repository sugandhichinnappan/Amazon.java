package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signincredentials_Amazon {
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
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
        pom=new Detail_CreateAccountPom(driver);

	}
	
	@Test(priority=1)
	public void SigninValidEmailidandPassword(){
		
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();

        pom.Password("amazon123");
        pom.signInPage();


	}

	@Test(priority=2)
	public void SigninValidEmailidandEmptyPassword(){
		pom.Email_id("techsugandhi@gmail.com");
	    pom.continue_login();

        pom.Password("");
        pom.signInPage();
	}

	@Test(priority=3)
	public void SigninValidEmailidandInvalidCharacterPassword(){
		
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();
        pom.Password("amazoGOPn234");
        pom.signInPage();

	}


	@Test(priority=4)
	public void SigninValidEmailidandwhitespacefrontPassword(){
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();
        pom.Password("  amazon234");
        pom.signInPage();

      
	}

	@Test(priority=5)
	public void SigninValidEmailidandmultipleFailedPassword(){
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();
        pom.Password("amazo234");
        pom.signInPage();
        pom.Password("aazo234");

       
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

}
