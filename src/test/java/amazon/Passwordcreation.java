package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Passwordcreation {
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
	
	@DataProvider(name="AccountDetails")
	public Object[][] getAccountDetails(){
		
		return new Object[][] {
			{"Sugandhi","techsugandhi@gmail.com","amazon123"},
			{"Gopi","techsugandhihjkdkjjs@gmail.com","Amzon123"},
			{"Sugandhi@#$","techsugandhi@gmail.com","amazon123"},
			{"Gopi","sugandhi@##$gmail.com","amazon123"},
			{"  Gopi","sugandhi@gmail.com","amazon123"},
			{"Sugandhi","    sugandhi@gmail.com","amazon123"},
			{"Sugandhi","techsugandhi1232@gmail.com","amazon123"}
		};
		
	}	


	@Test(dataProvider="AccountDetails")
	public void passwordCreation(String name,String Email_Id,String password) {
		pom.Customer_name(name);

		pom.Email_id(Email_Id);
        pom.Password(password);
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

}
