import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

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

public class PutUpdateExistingPet {
	
	ExtentHtmlReporter htmlReporter;   //To create HTML Report
	ExtentReports extent;
    ExtentTest test;
    public ExtentTest logger;   //To generate the logs in the test report.

    @BeforeTest
    public void startReport() {
    	// Initializing the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/PutAPItestreport.html");

      //Initializing ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

      /*Configuration items to change the name, look and feel of the report*/
        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("PUT API Test Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
		
		logger = extent.createTest("To test the PUT API of pets");   //Set logs in report
    }
	
	// Set Request body
	private static String requestBody = "{\r\n"
			+ "  \"id\": 110,\r\n"
			+ "  \"name\": \"Modified_bruno\",\r\n"
			+ "  \"category\": {\r\n"
			+ "    \"id\": 1,\r\n"
			+ "    \"name\": \"Dogs\"\r\n"
			+ "  },\r\n"
			+ "  \"photoUrls\": [\r\n"
			+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \"crazy\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"sold\"\r\n"
			+ "}";
	
	@BeforeClass
    public static void setup() {
		
		// Set Base URL
		RestAssured.baseURI = "https://petstore3.swagger.io/api/v3/";
    }
	

	@Test(priority=1)
	public void updateexistingpet() {
		
		Response response = given()
				.header("Content-type", "application/json")   //Set headers in the request
				.and()
				.body(requestBody)
				.when()
				.put("/pet")
				.then()
				.extract().response();   //Extract response
		
		int statusCode = response.getStatusCode();   // Get Response Code
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);   // Get response time
		Headers allHeaders = response.headers();    // Get all headers
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 // Iterate over all the Headers to display them
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 Assert.assertEquals("Modified_bruno", response.jsonPath().getString("name"));    // Verify the name
		 Assert.assertEquals("110", response.jsonPath().getString("id"));   // Verify the id
		 Assert.assertEquals("sold", response.jsonPath().getString("status"));   // Verify the status
		System.out.println("Response time is - "+responseTime + " ms");
		
		// Validate response time
		ValidatableResponse valRes = response.then();
		valRes.time(Matchers.lessThan(3000L));    // To check if the response time is less than 2000 ms
		
		System.out.println("PUT Response is: " + response.asString());
	}
	
	@Test(priority=2)
	public void updatewithoutstatus() {
		
		String requestBody1 = "{\r\n"
				+ "  \"id\": 111,\r\n"
				+ "  \"name\": \"Test_bruno\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"crazy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"\"\r\n"
				+ "}";
		
		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody1)
				.when()
				.put("/pet")
				.then()
				.extract().response();
		int statusCode = response.getStatusCode();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 Assert.assertEquals("Test_bruno", response.jsonPath().getString("name"));
		 Assert.assertEquals("111", response.jsonPath().getString("id"));
		 Assert.assertEquals("", response.jsonPath().getString("status"));
		System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("PUT Response is: " + response.asString());
	}
	
	
	@Test(priority=3)
	public void updatewithoutname() {
		
		String requestBody2 = "{\r\n"
				+ "  \"id\": 11,\r\n"
				+ "  \"name\": \"\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"crazy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"sold\"\r\n"
				+ "}";
		
		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody2)
				.when()
				.put("/pet")
				.then()
				.extract().response();
		int statusCode = response.getStatusCode();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 Assert.assertEquals("11", response.jsonPath().getString("id"));
		 Assert.assertEquals("", response.jsonPath().getString("name"));
		 Assert.assertEquals("sold", response.jsonPath().getString("status"));
		System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("PUT Response is: " + response.asString());
	}
	
	@Test(priority=4)
	public void updatewithoutcategory() {
		
		String requestBody3 = "{\r\n"
				+ "  \"id\": 10,\r\n"
				+ "  \"name\": \"Caesar-new\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"crazy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody3)
				.when()
				.put("/pet")
				.then()
				.extract().response();
		int statusCode = response.getStatusCode();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 Assert.assertEquals("10", response.jsonPath().getString("id"));
		 Assert.assertEquals("Caesar-new", response.jsonPath().getString("name"));
		 Assert.assertEquals("available", response.jsonPath().getString("status"));
		System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("PUT Response is: " + response.asString());
	}
	
	@Test(priority=5)
	public void updateincorrectid() {
		
		String requestBody4 = "{\r\n"
				+ "  \"id\": 874588745,\r\n"
				+ "  \"name\": \"Modified_bruno\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"crazy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"sold\"\r\n"
				+ "}";
		
		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody4)
				.when()
				.put("/pet")
				.then()
				.extract().response();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 String jsonString = response.asString();
		 Assert.assertEquals(jsonString.contains("Pet not found"), true);
		 Assert.assertTrue(response.jsonPath().getString("message").contains("Pet not found"));    // Verify the message in the response
		 System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("PUT Response is: " + response.asString());
	}
	
	
	@Test(priority=6)
	public void updateinvalidparams() {
		
		String requestBody5 = "{\r\n"
				+ "  \"uid\": 10,\r\n"
				+ "  \"gname\": \"bruno\",\r\n"
				+ "  \"bcategory\": {\r\n"
				+ "    \"cid\": 1,\r\n"
				+ "    \"rname\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"aphotoUrls\": [\r\n"
				+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
				+ "  ],\r\n"
				+ "  \"ytags\": [\r\n"
				+ "    {\r\n"
				+ "      \"jid\": 0,\r\n"
				+ "      \"kname\": \"crazy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"tstatus\": \"available\"\r\n"
				+ "}";
		
		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody5)
				.when()
				.put("/pet")
				.then()
				.extract().response();
		int statusCode = response.getStatusCode();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 400,"Status code is - ");
		 Assert.assertTrue(response.jsonPath().getString("message").contains("error"));   // Verify the error message in response
		 System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("PUT Response is: " + response.asString());
	}
	
	@Test(priority=7)
	public void updatewithoutmodifications() {
		
		String requestBody5 = "{\r\n"
				+ "  \"id\": 110,\r\n"
				+ "  \"name\": \"Modified_bruno\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"https://www.akc.org/wp-content/uploads/2017/11/Beagles-standing-in-a-frosty-field-on-a-cold-morning.jpg\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"crazy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"sold\"\r\n"
				+ "}";
		
		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody5)
				.when()
				.put("/pet")
				.then()
				.extract().response();
		int statusCode = response.getStatusCode();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		Headers allHeaders = response.headers();
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		   } 
		
		 Assert.assertEquals(statusCode, 200,"Status code is - ");
		 Assert.assertEquals("Modified_bruno", response.jsonPath().getString("name"));
		 Assert.assertEquals("110", response.jsonPath().getString("id"));
		 Assert.assertEquals("sold", response.jsonPath().getString("status"));
		System.out.println("Response time is - "+responseTime + " ms");
		
		System.out.println("PUT Response is: " + response.asString());
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
	extent.flush();   // To write contents in the report
	}
	
}