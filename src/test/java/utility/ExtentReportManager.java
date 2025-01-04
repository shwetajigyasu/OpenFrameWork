package utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; ///  UI of the report
	 
    ExtentReports extent ;         /// populate common info on report
    
    ExtentTest   test;
    



public void onStart(ITestContext context) {
	
	
	 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	 
	        String RepName="myReports"+timeStamp+".html";

sparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+RepName);

sparkReporter.config().setDocumentTitle("Automation Result");
sparkReporter.config().setReportName("UI testing");
sparkReporter.config().setTheme(Theme.DARK);

extent =new ExtentReports();
extent.attachReporter(sparkReporter);

extent.setSystemInfo("environment", "QA");
extent.setSystemInfo("ApplicationName", "OpenCart");
extent.setSystemInfo("Module", "Admin");
extent.setSystemInfo("SubModule", "Customer");
extent.setSystemInfo("UserName", "user.name");

//String browser=context.getCurrentXmlTest().getParameter("browser");
//extent.setSystemInfo("Browser", "browser");

//List<String> IncludedGroups=context.getCurrentXmlTest().getIncludedGroups();
//if(!IncludedGroups.isEmpty()) {
//	extent.setSystemInfo("Groups", IncludedGroups.toString());
//}

}




public void onTestSuccess(ITestResult result) {
ExtentTest test=extent.createTest(result.getName());
test.assignCategory(result.getMethod().getGroups());
test.log(Status.PASS, "The test "+ result.getName()+ " is Passed");
}



public void onTestFailure(ITestResult result) {
  test =extent.createTest(result.getName());
  test.assignCategory(result.getMethod().getGroups());
  test.log(Status.FAIL, "The test "+ result.getName()+ " is failed");
  test.log(Status.INFO, result.getThrowable().getMessage());
  
                     try {
	                  String Imgpath =new BaseClass().CaptureScreenShot(result.getName());
	                  test.addScreenCaptureFromPath(Imgpath);
	  
                       }catch(Exception e1) {
	                           e1.printStackTrace();
                         }
  
  
}


public void onTestSkipped(ITestResult result) {
  test=extent.createTest(result.getName());
  test.log(Status.SKIP, "The test "+ result.getName()+ " is Passed");
}


public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
ITestListener.super.onTestStart(result);
}





public void onFinish(ITestContext context) {
extent.flush();
}







}
