package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class signin_KeepMeSignedin {

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
	public void Signin_KeepmesignedinCheckbox(){
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();

        pom.Password("amazon123");
        pom.signInPage();

        driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div.a-section > div > div > form > div > div.a-section.a-spacing-top-extra-large > div > div > label > div > label > span")).click();
}
	@Test(priority=2)
	public void SigninKeepmesignedinNotSelectCheckbox(){
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();

        pom.Password("amazon123");
        pom.signInPage();

		
       
}
	@Test(priority=3)
	public void SigninKeepMeSignedinCheckboxandChangedPassword(){
		pom.Email_id("techsugandhi@gmail.com");
        pom.continue_login();

        pom.Password("amzon123");
        driver.findElement(By.linkText("Forgot password?")).click();
        driver.findElement(By.id("ap_email")).sendKeys("");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("input-box-otp")).sendKeys("905969");
        driver.findElement(By.id("cvf-submit-otp-button")).click();
        pom.signInPage();
        driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div.a-section > div > div > form > div > div.a-section.a-spacing-top-extra-large > div > div > label > div > label > span")).click();
}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

	
}