package pageWiseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstname_TXT;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastname_TXT;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email_TXT;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement telephone_TXT;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_TXT;
	
	//input[@name='confirm']
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement confirmpassword_TXT;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacyPolicy_CKB;
	
	//input[@value='Continue']
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continue_BT;
	
	//h1[text()='Your Account Has Been Created!']
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement message_Tx;
	
	
	public void setUsername(String username) {
		firstname_TXT.sendKeys(username);;
	}
	
public void setLastname(String lastname) {
	lastname_TXT.sendKeys(lastname);
	}


	
public void setemail(String email) {
	email_TXT.sendKeys(email);
}



public void setTelephone(String telephoneNo) {
	telephone_TXT.sendKeys(telephoneNo);
}


	
	
public void setPassword(String password) {
	password_TXT.sendKeys(password);
}






public void setConfirmPassword(String password) {
	confirmpassword_TXT.sendKeys(password);
}




public void clickOnPrivacyPolicy() {
	privacyPolicy_CKB.click();
}



public void clickOnContinue() {
	continue_BT.click();
}


public String getMessage() {
	

	return  (message_Tx.getText());
}

	

}
