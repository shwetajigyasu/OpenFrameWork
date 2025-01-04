package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.DrbgParameters.Capability;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass  {
	
	public static WebDriver driver;
	
	public Logger logger;
	
	public Properties   p;
	
	@BeforeClass(groups = {"Regression" , "Master" , "Sanity"})
	@Parameters({"browser" , "os"})
	public void setUP(String br ,String os) throws IOException {
		
		logger =LogManager.getLogger(this.getClass());
		
		     
		FileReader file=new FileReader("./src//test//resources//config.properties");
		             p =new Properties();
		             p.load(file); 
		             
	//////////if excecution env is Remote///////////////////////////	             
		
//		   if(p.getProperty("excecution_env").equalsIgnoreCase("Remote")) {
//			   DesiredCapabilities capbility =new DesiredCapabilities();  
//			      
//			    if(os.equalsIgnoreCase("Windows")) {
//			    	
//			    	capbility.setPlatform(Platform.WIN11);
//			    	
//			    }else if(os.equalsIgnoreCase("mac")) {
//			    	capbility.setPlatform(Platform.MAC);
//			    }else {
//			    	System.out.println("no os is matching");
//			    }
//			    
//			    
//			    switch(br.toLowerCase()) {
//			    
//			    case "chrome":capbility.setBrowserName("chrome"); break;
//			    case "edge"  :capbility.setBrowserName("microsoftEdge"); break;
//			    default :System.out.println("no browser matching"); return;
//			    
//			    }
//			    
//			      WebDriver driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capbility);
//		   
//		   }
//		   
	////////////////////////////////////////////////////////////	 
		 if (p.getProperty("execution_env").equalsIgnoreCase("Local")) {
			 
			 switch(br.toLowerCase()) {
				case ("chrome"):driver=new ChromeDriver(); break;
				case ("edge"):driver=new EdgeDriver();break;
				case ("firefox"):driver=new FirefoxDriver();break;
				default : System.out.println("browser is invalid"); return ; 
				}
				
		 }
		             
		
		////driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(p.getProperty("AppURL"));
		
		////driver.get("https://tutorialsninja.com/demo");
		
		driver.manage().window().maximize();
	}
	
	
public String getRandomString() {
		
		@SuppressWarnings("deprecation")
		String randomAlpha=RandomStringUtils.randomAlphabetic(4);
		return randomAlpha; 
	}
	
public String getRandomNumber() {
		
		String randomNumber=RandomStringUtils.randomNumeric(8);
		return randomNumber; 
	}

public String getRandomAlphaNumeric() {
	String randomAlpha=RandomStringUtils.randomAlphabetic(4);
	String randomNumber=RandomStringUtils.randomNumeric(4);
	String alphanumeric =randomAlpha+"&"+randomNumber; 
	return alphanumeric;
	
}
	
	

	@AfterClass(groups = {"Regression" , "Master" , "Sanity"})
	public void tear() {
		driver.quit();
		
	}

	
	public String CaptureScreenShot(String tname) {
		
		String timestamp =new SimpleDateFormat("yymmddmmss").format(new Date());
		
		TakesScreenshot takescreenshot =(TakesScreenshot)driver;
		
		 File srcFile=takescreenshot.getScreenshotAs(OutputType.FILE);
		           
	 String  targetfilePath=System.getProperty("user.dir")+"//ScreenShots//"+tname+" "+timestamp+".png";
	 
	                  File targetfile=new File(targetfilePath);
	                  
	                  srcFile.renameTo(targetfile);
	                 return targetfilePath; 
		 
		
		
	}

}
