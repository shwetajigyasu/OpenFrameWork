package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freemarker.log.Logger;
import pageWiseClass.HomePage;
import pageWiseClass.LoginPage;
import pageWiseClass.MyAccountPage;
import utility.Dataproviders;

public class Login_DDT extends BaseClass {
	
	WebDriver driver;
	
        @Test(dataProvider="LoginData" , dataProviderClass=Dataproviders.class)	
		public void verify_Login_DDT(String email , String pwd , String exp) {
		
           logger.info("******Login_DDT test case started*******");
        	try {
        		
		   HomePage hp=new HomePage(driver);
		   hp.ClickOnMyAccount();
		   hp.ClickOnLoginLink();
		   
		   ///////////////////////////////
		   
		   LoginPage lp=new LoginPage(driver);
		     lp.setEmail(email);
		     lp.setPassword(pwd);
		     lp.clickOnLoginButton();
		     
		   ////////////////////////////////////
		     
		     MyAccountPage myap =new MyAccountPage(driver);
		      boolean status=myap.headingMyAccount();
		         
		      if(exp.equalsIgnoreCase("valid")) {
		    	     if(status==true) {
		    	    	 Assert.assertTrue(true);
		    	    	 myap.clickonLogout();
		    	     }else {
		    	    	 Assert.assertTrue(false);
		    	     }
		      }
		      
		      if(exp.equalsIgnoreCase("invalid")) {
		    	  if(status==false) {
		    		 Assert.assertFalse(false); 
		    		 myap.clickonLogout();
		    	  }else {
		    		  Assert.assertFalse(true);
		    	  }
		    	  
		      }
        	
	}catch(Exception e){
		  Assert.fail();
		  
	       }
        	logger.info("******Login_DDT test case finished*******");
        	
        	
        	
        	
	}
	

}
