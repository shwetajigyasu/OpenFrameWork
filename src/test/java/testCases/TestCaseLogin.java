package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageWiseClass.HomePage;
import pageWiseClass.LoginPage;
import pageWiseClass.MyAccountPage;

public class TestCaseLogin extends BaseClass {
	

	@Test(groups = {"Regression" , "Master"})
	public void TC_002_LoginTestCase() {
		logger.info("***** TestCaseRegister testcase has stated *****");
		try {
		HomePage homepage=new HomePage(driver);
		homepage.ClickOnMyAccount();
		homepage.ClickOnLoginLink();
		
		
		
		LoginPage lp =new LoginPage(driver);
		boolean status =lp.ReturningCustomerMsgDisplay();
		
		Assert.assertEquals(status, true);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickOnLoginButton();
		
		MyAccountPage ap =new MyAccountPage(driver);
		boolean mystatus=ap.headingMyAccount();
		
		Assert.assertTrue(mystatus);
		
		}catch(Exception e) {
			Assert.fail();
		}
	
		logger.info("***** TestCaseRegister testcase has finished *****");
	}

}
