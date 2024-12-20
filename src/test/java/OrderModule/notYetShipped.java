package OrderModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class notYetShipped {
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
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span"));
        driver.findElement(By.cssSelector("#nav_prefetch_yourorders > span")).click();
        pom=new OrderModulePom(driver);


	}
	@Test(priority=1)
	public void OrderNotYetShipped() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.not_Yet_Shipped();	        
	}
	@Test(priority=2)
	public void FilterByOrderNotYetShipped() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.not_Yet_Shipped();	  
		driver.findElement(By.linkText("View all orders")).click();
	        driver.findElement(By.cssSelector("#a-autoid-1-announce > span")).click();
	        driver.findElement(By.id("orderFilter_3")).click();
	}
	@Test(priority=3)
	public void sortingOrderNotYetShipped() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.not_Yet_Shipped();	  		 
	        driver.findElement(By.linkText("View all orders")).click();
	        driver.findElement(By.cssSelector("#a-autoid-1-announce > span")).click();
	        driver.findElement(By.id("orderFilter_4")).click();


	        
	}
	@Test(priority=4)
	public void SearchOrderNotYetShipped() {
		pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.not_Yet_Shipped();	  		 
	        driver.findElement(By.linkText("View all orders")).click();
	        driver.findElement(By.cssSelector("#a-autoid-1-announce > span")).click();
	        driver.findElement(By.id("orderFilter_4")).click();

	        driver.findElement(By.id("searchOrdersInput")).sendKeys("Gate");
	        driver.findElement(By.id("a-autoid-0")).click();
	        
	        
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

}
