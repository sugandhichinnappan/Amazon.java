package amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Detail_CreateAccountPom {
	WebDriver driver;
	@FindBy(id="ap_customer_name") WebElement Name;
	@FindBy(id="ap_email") WebElement Email_id;
	
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="ap_password_check") WebElement Check_Password;
    @FindBy(id="continue") WebElement Continue;
    @FindBy(id="signInSubmit") WebElement SignIn;
	public Detail_CreateAccountPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void Customer_name(String Customer_Name) {
		Name.sendKeys(Customer_Name);
		Name.sendKeys(Keys.ENTER);
		
	}
	public void Email_id(String Email) {
		Email_id.sendKeys(Email);

	}

	public void Password(String password) {
		Password.sendKeys(password);
		Password.sendKeys(Keys.ENTER);
		
	}
	public void check_Password(String check_password) {
		Check_Password.sendKeys(check_password);
		Check_Password.sendKeys(Keys.ENTER);

	}
	
	
	public void continue_login() {

        Continue.click();
	}
	public void signInPage() {
		
		SignIn.click();
	} 
}
