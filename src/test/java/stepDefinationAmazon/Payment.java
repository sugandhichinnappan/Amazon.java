package stepDefinationAmazon;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Payment {

    WebDriver driver;

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void loginToAmazon() {
        driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");
        driver.findElement(By.id("ap_email")).sendKeys("techsugandhi@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("amazon123");
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Given("I am in the Amazon page")
    public void i_am_in_the_amazon_page() {
        initializeDriver();
        driver.get("https://www.amazon.ca/gp/yourstore?ref_=nav_AccountFlyout_recs");
    }

    @Given("I logged in the Amazon Account")
    public void i_logged_in_the_amazon_account() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
    }

    @When("Click on the {string} option")
    public void click_on_the_option() {
        loginToAmazon();
    }

    @When("Save the credit card")
    public void save_the_credit_card() {
        // Navigate to payment options
        driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(5) > span")).click();
        driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(3) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
        
        // Fill in card details
        driver.findElement(By.id("pp-fjVDyO-14")).click();  // Example to initiate adding a card
        driver.findElement(By.id("pp-dCScPQ-28-announce")).click(); // Click to confirm card details

        // Entering Credit Card Information
        driver.findElement(By.cssSelector("input.card-number")).sendKeys("5123456789012346");  // Simplified selector
        driver.findElement(By.cssSelector("input.card-expiry")).sendKeys("05/34");
        driver.findElement(By.cssSelector("input.card-cvc")).sendKeys("100");
        driver.findElement(By.cssSelector("input.card-name")).sendKeys("Sugandhi Chinnappan");

        driver.findElement(By.xpath("//button[text()='Save']")).click();  // Save the card info
    }

    @Then("Check whether the Credit card is saved")
    public void check_whether_the_credit_card_is_saved() {
        // Confirm if the card was saved successfully
        String confirmationMessage = driver.findElement(By.id("confirmationMessage")).getText();
        if (confirmationMessage.contains("Card saved successfully")) {
            System.out.println("Credit Card saved successfully.");
        } else {
            System.out.println("Credit Card save failed.");
        }
    }

    @Given("I am in the Amazon Page")
    public void i_am_in_the_amazon_page1() {
        initializeDriver();
        loginToAmazon();
    }

    @When("save the option")
    public void save_the_option() {
        // Navigate to payment options and save the default payment method
        driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(5) > span")).click();
        driver.findElement(By.cssSelector("#a-page > div.a-container > div > ul:nth-child(3) > li:nth-child(3) > span > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
        
        // Selecting and saving the payment method as default
        driver.findElement(By.id("pp-fjVDyO-14")).click();
        driver.findElement(By.id("pp-dCScPQ-28-announce")).click();
    }

    @Then("Check Whether the default payment is while checkout")
    public void check_whether_the_default_payment_is_while_checkout() {
        driver.findElement(By.xpath("//button[text()='Proceed to Checkout']")).click();
        
        String selectedPayment = driver.findElement(By.id("paymentMethodSelected")).getText();
        if (selectedPayment.contains("Default Payment Method")) {
            System.out.println("Default payment method selected successfully.");
        } else {
            System.out.println("Default payment method not selected.");
        }

        driver.close();  // Close the browser at the end of the test
    }
}
