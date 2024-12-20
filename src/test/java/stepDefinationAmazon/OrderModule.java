package stepDefinationAmazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderModule {
    WebDriver driver;

    // Initializing WebDriver in the setup method
    @Given("I am logged into my Amazon account {string}")
    public void i_am_logged_into_my_amazon_account(String url) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("Click on the {string} link")
    public void click_on_the_link(String linkText) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("Below Sign-In")
    public void below_sign_in() {
        driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
    }

    @Then("Enter Email_id {string} and Password {string}")
    public void enter_email_id_and_password(String email, String password) {
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
    }

    @Then("Click on the {string} button")
    public void click_on_the_button(String buttonId) {
        driver.findElement(By.id(buttonId)).click();
    }

    @Then("check {string} option")
    public void check_option(String optionText) {
        driver.findElement(By.linkText(optionText)).click();
    }

    @Then("view Order placed in {int} month")
    public void view_order_placed_in_month(int monthsAgo) {
        // Assuming this logic applies for the 3-month filter
        if (monthsAgo == 3) {
            driver.findElement(By.id("time-filter_1")).click();
        }
    }

    @Given("User is in Amazon Sign-in  {string}")
    public void user_is_in_amazon_sign_in(String url) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("Enter Email_id {string} and Password {string}")
    public void enter_email_id_and_password2(String email, String password) {
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
    }

    @When("Go to {string} section")
    public void go_to_section(String sectionName) {
        driver.findElement(By.linkText(sectionName)).click();
    }

    @Then("Show the product brought for last year")
    public void show_the_product_brought_for_last_year() {
        driver.findElement(By.id("time-filter_3")).click();
    }

    @Then("show the product Cancelled last year")
    public void show_the_product_cancelled_last_year() {
        driver.findElement(By.linkText("View all orders")).click();
        driver.findElement(By.id("a-autoid-1-announce")).click();
        driver.findElement(By.id("orderFilter_3")).click();
    }

    @Then("click on the {string} link")
    public void click_on_the_filter_link(String filterId) {
        driver.findElement(By.id(filterId)).click();
    }

    @Then("view the product ready to shipped")
    public void view_the_product_ready_to_shipped() {
        driver.findElement(By.id("a-autoid-0")).click();
    }

    // Closing the driver after the tests
    @AfterMethod
    public void Tapclose() {
        driver.close();
    }
}
