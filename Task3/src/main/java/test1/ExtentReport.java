package test1;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentHtmlReporter htmlReporter; //To create HTML Report
	public static ExtentReports extent;
	public static ExtentTest test;
    public static ExtentTest logger;  //To generate the logs in the test report.

    @BeforeTest
    public void startReport() {
    	// Initializing the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/DeleteAPItestreport.html");

      //Initializing ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    /*Configuration items to change the name, look and feel of the report*/
        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Delete API Test Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    
    @AfterMethod
   	public void getResult(ITestResult result) throws Exception{
   	if(result.getStatus() == ITestResult.FAILURE){
   		
   	//MarkupHelper is used to display the output in different colors
   		
   	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
   	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
   	}
   	else if(result.getStatus() == ITestResult.SKIP){
   	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
   	}
   	else if(result.getStatus() == ITestResult.SUCCESS)
   	{
   	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
   	}
   	}
   	@AfterTest
   	public void endReport() {
   	extent.flush(); // To write the results in the reports
   	}

	
	

}
