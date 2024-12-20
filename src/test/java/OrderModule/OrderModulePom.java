package OrderModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderModulePom {

	WebDriver driver;
	@FindBy(id="ap_email") WebElement Email_id;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="a-autoid-1-announce") WebElement Announce;
    //@FindBy(id="time-filter_3") WebElement yourOrder2023;
    @FindBy(linkText="Buy Again") WebElement Buy_Again;
	@FindBy(id="twotabsearchtextbox") WebElement Search;

    @FindBy(linkText="Not Yet Shipped") WebElement Not_Yet_Shipped;
    @FindBy(linkText="Cancelled Orders") WebElement Cancelled_Orders;
	@FindBy(id="continue") WebElement Continue;
    @FindBy(id="signInSubmit") WebElement SignIn;
    @FindBy(id="nav-search-submit-text") WebElement Search_Box;
	public OrderModulePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void Email_id(String Email) {
		Email_id.sendKeys(Email);

	}
	public void SearchBox() {
		Search_Box.click();
	}

	public void Password(String password) {
		Password.sendKeys(password);
		
	}
	public void search(String search) {
		Search.sendKeys(search);
	}
	public void Cancelled() {
		Cancelled_Orders.click();
	}
	public void autoid() {
		Announce.click();
	}
	public void not_Yet_Shipped() {
		Not_Yet_Shipped.click();
	}
	public void buy_Again() {
		Buy_Again.click();
	}
	
	public void continue_login() {

        Continue.click();
	}
	public void signInPage() {
		
		SignIn.click();
	}
	
}
