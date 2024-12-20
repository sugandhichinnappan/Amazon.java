package stepDefinationAmazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount {

    WebDriver driver;

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Use a relative path or set in environment variables
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

   
    

    // Navigate to Amazon Create Account page
    @Given("User is in Amazon Create Account Page")
    public void user_is_in_amazon_create_account_page() {
        initDriver();
        driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");
    }

    // Click on the Start Here link
    @When("Click on the Start Here link below Sign-in")
    public void click_on_the_start_here_link_below_sign_in() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        driver.findElement(By.linkText("Start here.")).click();
    }

    @When("Enter details")
    public void enter_details() {
        driver.findElement(By.id("ap_customer_name")).sendKeys("Suagndhi");
        driver.findElement(By.id("ap_email")).sendKeys("techsugandhi@gmail.com");
    }

    // Move to password field after entering the email
    @Then("Click on the Enter move to password field")
    public void click_on_the_enter_move_to_password_field() {
        driver.findElement(By.id("ap_password")).click();
    }

    // Enter password
    @When("Enter password")
    public void enter_password() {
        driver.findElement(By.id("ap_password")).sendKeys("amazon123");
    }

    @Then("Click on the Enter Move to ReEnter-Password")
    public void click_on_the_enter_move_to_re_enter_password() {
        // Verify the re-enter password field is visible
        boolean Check_Password = driver.findElement(By.id("ap_password_check")).isDisplayed();
        assert Check_Password;
    }

    @When("Enter Check_Password")
    public void enter_check_password() {
        driver.findElement(By.id("ap_password_check")).sendKeys("amazon123");
    }

    @Then("Click on Continue and verify Email")
    public void click_on_continue_and_verify_email() {
        driver.findElement(By.id("continue")).click();
        // Verifying email confirmation after clicking continue
        String VerifyEmail = driver.findElement(By.id("emailConfirmation")).getText();
        assert VerifyEmail.contains("Check your email");
    }


    @Given("User is in Amazon Sign-in Page")
    public void user_is_in_amazon_sign_in_page() {
        initDriver();
        driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");
    }

    @When("Click on the Sign-in")
    public void click_on_the_sign_in(String email) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        driver.findElement(By.id("ap_email")).sendKeys(email);
    }

    @When("Enter Password Password")
    public void enter_password_password(String password) {
        driver.findElement(By.id("ap_password")).sendKeys(password);
    }

    @Then("Click on the Sign-in button")
    public void click_on_the_sign_in_button() {
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Given("User checks the Keep me Signed in checkbox")
    public void user_checks_the_keep_me_signed_in() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        driver.findElement(By.id("ap_email")).sendKeys("techsugandhi@gmail.com");
        driver.findElement(By.id("continue")).click();
    }

    @When("Click Select checkbox Keep me signed in")
    public void click_select_checkbox_keep_me_signed_in() {
        driver.findElement(By.id("ap_password")).sendKeys("amazon123");
        driver.findElement(By.id("rememberMe")).click(); // Remember Me checkbox
    }

    @Then("User should be signed in")
    public void user_should_be_signed_in() {
        driver.findElement(By.id("signInSubmit")).click();
        String welcomeMessage = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        assert welcomeMessage.contains("Hello");
        driver.close();
    }

    @Then("Display Hello, Sign-in Account and Lists")
    public void display_hello_sign_in_account_and_lists() {
        boolean Sign_in = driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();
        assert Sign_in;
        driver.close();
    }
}
