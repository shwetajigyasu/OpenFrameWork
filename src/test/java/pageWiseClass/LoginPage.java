package pageWiseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	//jishu.shweta@gmail.com
	//masha123
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement username_TXT;
	
	//a[(text()='Register')]
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password_TXT;
	
	//input[@value='Login']
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_BT;
	
	//h2[text()='Returning Customer']
	
	@FindBy(xpath="//h2[text()='Returning Customer']")
	WebElement msg_ReturningCustomer;
	
	//////////////////////////////////////////
	
	public void setEmail(String email) {
		username_TXT.sendKeys( email);
	}
	
	public void setPassword(String password) {
		 password_TXT.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		login_BT.click();
	}
	
	public boolean ReturningCustomerMsgDisplay() {
		boolean display=msg_ReturningCustomer.isDisplayed();
		return display;
	}
	
}
