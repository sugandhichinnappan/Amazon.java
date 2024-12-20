package amazon; 
import java.time.Duration; 
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test; 
public class VerifyEmail_CreateAccount { 
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
action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform(); driver.findElement(By.linkText("Start here.")).click(); 
pom=new Detail_CreateAccountPom(driver); 
} 
@Test(priority=1) 
public void verifyEmailButton() { 
pom.Customer_name("Sugandhi"); 
pom.Email_id("suga"); 
                                      Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address")); 
} 
@Test(priority=2) 
public void EmailEmpty() { 
pom.Customer_name("Sugandhi"); 
pom.Email_id(""); 
        Assert.assertTrue(driver.getPageSource().contains("Email address is required")); 
} 
@Test(priority=3) 
public void INvalidEmailformat() { 
pom.Customer_name("Sugandhi"); 
pom.Email_id("suandhi@gmail.com"); 
                               Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address")); 
} 
@Test(priority=4) 
public void SpecialCharacterEmailEmpty() { 
pom.Customer_name("Sugandhi"); 
pom.Email_id("sugandhi#gmail.com");
                               Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address")); 
} 
@Test(priority=5) 
public void ValidEmail() { 
pom.Customer_name("Sugandhi"); 
pom.Email_id("techsugandhi@gmail.com"); 
        Assert.assertTrue(driver.getPageSource().contains("Next step or confirmation")); 
} 
}
