package search;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrderModule.OrderModulePom;

public class Pagination {
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
	}
	@Test
	public void pagination_Check() {
		
		     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tablet");
		     driver.findElement(By.id("nav-search-submit-text")).click();
		     List<String> previousPageTitles=new ArrayList<>();
		     List<String> currentPageTitles=new ArrayList<>();
		     boolean PageAvailable=true;
		     
		     for(int Page=1;Page<=5;Page++) {
		    	 System.out.println("currently on the Page:"+Page);
		    	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.s-wide-grid-style.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(79) > div > div > span > ul > li:nth-child(3) > span > span"))).click();
		     currentPageTitles.clear();
	    	 List<WebElement> Item=driver.findElements(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.s-wide-grid-style.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(79) > div > div > span > ul > li:nth-child(4) > span > a"));

		     for(WebElement product:Item) {
		    	 currentPageTitles.add(product.getText());
		     }
		     System.out.println("Item on page"+Page+":"+currentPageTitles);
		     }
		     previousPageTitles.clear();
		     previousPageTitles.addAll(currentPageTitles);
		Assert.assertEquals(PageAvailable, "No Item found in the next page");    
	  
	}
	@AfterMethod
	public void closeTap() {
		driver.close();
		
	}

		
	}

