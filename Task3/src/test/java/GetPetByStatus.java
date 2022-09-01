import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.concurrent.TimeUnit;
import test1.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetPetByStatus extends BaseClass {
	
	ExtentHtmlReporter htmlReporter; //To create HTML Report
	ExtentReports extent;
    ExtentTest test;
    public ExtentTest logger;  //To generate the logs in the test report.

    @BeforeTest
    public void startReport() {
    	// Initializing the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/GetAPItestreport.html");

        //Initializing ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    /*Configuration items to change the name, look and feel of the report*/
        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Get API Test Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        
        logger = extent.createTest("To test the GET API of pets"); //Set logs
    }
	
	

	@Test(priority = 1)
	public void testgetavailablepets() {
		
		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "available");
		//Setting Request headers and parameters.
		
		Response response = httpRequest.expect().spec(responseSpec).when().get("/findByStatus");
		body = response.getBody(); //Get response body
		
		int statusCode = response.getStatusCode();  // Get status code of response
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS); // Get response time
		Headers allHeaders = response.headers();  // Get all response headers
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 // Iterate over all the Headers to display them
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");  // status code assertion
		System.out.println("Response time is - "+responseTime + " ms");
		
		// Validate the response time
		ValidatableResponse valRes = response.then();
		valRes.time(Matchers.lessThan(2000L)); // To check if the response time is less than 2000 ms
		
		System.out.println("GET Response for available pets:" + body.asString());
	}

	@Test(priority = 2)
	public void testgetpendingpets() {

		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "pending");
		//Setting Request headers and parameters.
		
		Response response = httpRequest.expect().spec(responseSpec).when().get("/findByStatus");
		body = response.getBody();    // Get response body
		int statusCode = response.getStatusCode();   // Get status code of response
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);   // Get response time
		Headers allHeaders = response.headers();    // Get all response headers
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		// Iterate over all the Headers to display them
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("GET Response for available pets:" + body.asString());
		
	}
	
	
	@Test(priority = 3)
	public void testsold() {

		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "sold");
		//Setting Request headers and parameters.
		
		Response response = httpRequest.expect().spec(responseSpec).when().get("/findByStatus");
		body = response.getBody();   //Get response body
		int statusCode = response.getStatusCode();   // Get status code of response
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		// Iterate over all the Headers to display them 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("GET Response for available pets:" + body.asString());
	}
	
	
	@Test(priority = 4)
	public void invalidstatus() {

		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "invalid");
		//Setting Request headers and parameters.
		
		Response response = httpRequest.expect().spec(responseSpec).when().get("/findByStatus");
		body = response.getBody();   //Get response body
		int statusCode = response.getStatusCode();   // Get status code of response
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		// Iterate over all the Headers to display them 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		Assert.assertEquals(statusCode, 400,"Status code is - ");
		System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("Response if the status is invalid - " + body.asString());
	}
	
	@Test(priority = 5)
	public void blankstatus() {

		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "");
		//Setting Request headers and parameters.
		
		Response response = httpRequest.expect().spec(responseSpec).when().get("/findByStatus");
		body = response.getBody();   //Get response body
		int statusCode = response.getStatusCode();   // Get status code of response
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		// Iterate over all the Headers to display them 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 400,"Status code is - ");
		 System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("Response if the status is blank - " + body.asString());
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
	extent.flush();
	}
	
	
}