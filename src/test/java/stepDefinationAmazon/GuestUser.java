package stepDefinationAmazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestUser {
	WebDriver driver;
	@Given("I am on the Amazon Homepage")
	public void i_am_on_the_amazon_homepage() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

				
				driver=new ChromeDriver();
				driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();

		
	}

	@When("Enter {string} in the search bar")
	public void enter_in_the_search_bar(String Search) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Search);
	}

	@Then("View the details of the Smart watch")
	public void view_the_details_of_the_smart_watch() {
		driver.findElement(By.id("nav-search-submit-button")).click();

	}
	@Given("Add cart in Amazon Homepage")
	public void Add_cart_in_Amazon_Homepage() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

				
				driver=new ChromeDriver();
				driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();

	}
	@When("Add to cart")
	public void add_to_cart() {
		driver.findElement(By.linkText("See options")).click();
		driver.findElement(By.id("submit.add-to-cart")).click();

	}

	@Then("check whether it is add to cart")
	public void check_whether_it_is_add_to_cart() {
		driver.findElement(By.id("sc-buy-box-ptc-button")).click();


	}
	@Given("Remove item cart in Amazon Homepage")
	public void Remove_item_cart_in_Amazon_Homepage() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

				
				driver=new ChromeDriver();
				driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	}

	@When("Remove from the cart")
	public void remove_from_the_cart() {
		driver.findElement(By.id("nav-cart-count")).click();
		
	
	}

	@Then("Check whether it is removed from Guest User Account")
	public void check_whether_it_is_removed_from_guest_user_account() {
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[2]/span/input")).click();
	
	}
	@Given("BuyAgain item cart in Amazon Homepage")
	public void BuyAgain_item_cart_in_Amazon_Homepage() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

				
				driver=new ChromeDriver();
				driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	}
	@When("Click the {string} option")
	public void click_the_option(String string) {
		driver.findElement(By.id("nav-cart-count")).click();
	
	}

	@Then("Buy it later")
	public void buy_it_later() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[3]/span/input")).click();
        
		}
	
	@Given("View item cart in Amazon Homepage")
	public void View_item_cart_in_Amazon_Homepage() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

				
				driver=new ChromeDriver();
				driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	}
	@When("view again the amazon homepage")
	public void view_again_the_amazon_homepage() {
		driver.findElement(By.id("nav-cart-count")).click();
	}
	

	@Then("Their is Nothing in the cart")
	public void their_is_nothing_in_the_cart() {
		driver.findElement(By.id("sw-gtc")).click();
        driver.close();
	}




}
