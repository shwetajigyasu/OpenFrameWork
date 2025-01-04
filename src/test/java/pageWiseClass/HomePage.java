package pageWiseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[(text()='My Account')]")
	WebElement MyAccount_LK;
	
	//a[(text()='Register')]
	
	@FindBy(xpath="//a[(text()='Register')]")
	WebElement Register_LK;
	
	
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement Login_LK;
	
	/////////////////////////////////////////////////
	
	public void ClickOnMyAccount() {
		MyAccount_LK.click();
	}
	
	public void ClickOnRegister() {
		Register_LK.click();
	}
	
	public void ClickOnLoginLink() {
		Login_LK.click();
	}

}
