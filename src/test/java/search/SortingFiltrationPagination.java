package search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrderModule.OrderModulePom;

public class SortingFiltrationPagination {
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
        pom.Email_id("chinnappan.sugandhi@gmail.com");
        pom.continue_login();

        pom.Password("Atarahgopi125129");
        pom.signInPage();
        pom.search("Tshirt");
        pom.SearchBox();
	}
	@Test
	public void sortingFiltrationPagination() {
		driver.findElement(By.cssSelector("#a-autoid-0-announce > span.a-dropdown-label")).click();
        driver.findElement(By.id("s-result-sort-select_4")).click();
		driver.findElement(By.cssSelector("#p_n_feature_twenty-six_browse-bin\\/121477348011 > span > a > span")).click();
		driver.findElement(By.cssSelector("#p_n_deal_type\\/23565508011 > span > a > span")).click();
		

	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

}
