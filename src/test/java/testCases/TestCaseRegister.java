package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageWiseClass.HomePage;
import pageWiseClass.RegistrationPage;

public class TestCaseRegister extends BaseClass {
	
	
	
	@Test(groups ={"Sanity","Master"})
	public void Tc_001RegisterUser() {
		
		try{
			
		
		logger.info("***** TestCaseRegister testcase has stated *****");
		String alphanum=getRandomAlphaNumeric();
		
		HomePage hp=new HomePage(driver);
		
		hp.ClickOnMyAccount();
		logger.info("Clicked on My Account Link");
		
		hp.ClickOnRegister();
		logger.info("Clicked on My Register Link");
		RegistrationPage rg=new RegistrationPage(driver);
		
		logger.info("Providing user details");
		
		rg.setUsername(getRandomString());
		rg.setLastname(getRandomString());
		rg.setemail(getRandomString()+"@gmail.com");
		rg.setTelephone(getRandomNumber());
		rg.setPassword(alphanum);
		rg.setConfirmPassword(alphanum);
		rg.clickOnPrivacyPolicy();
		rg.clickOnContinue();
		String msg=rg.getMessage();
		
		logger.info("Validating expected message");
		
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed");
			logger.debug("debug the logs....");
			 Assert.fail();
		};
		
		logger.info("***** TestCaseRegister testcase has finished *****");
		
		
	}
	
	
}
