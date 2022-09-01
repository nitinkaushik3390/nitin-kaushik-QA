import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import test1.ExtentReport;
public class DeletePet extends ExtentReport {
	
	
	
    @BeforeTest
	public static void setup() {
    	
    /* Set Base URL and logs for report*/
    	
    	logger = extent.createTest("To test the New Delete API of pets");
		RestAssured.baseURI = "https://petstore3.swagger.io/api/v3/";
    }
	
   @Test(priority=1)
   public void deleteRequest() {
      
	   int petid = 10; //id of the pet to be deleted. To be passed in the request URL
      
      
      Response response = given()
				.header("Content-type", "application/json","api_key","test") //Setting headers in the request
				.when()
				.delete("/pet/"+petid) //Passing pet id in the Request URL
				.then()
				.extract().response(); //Extracting the response of the API

      //verify status code of Response
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode, 400);

      //convert response to string then validate the message
      String jsonString = response.asString();
      Assert.assertEquals(jsonString.contains("Pet deleted"), false);
   }
   
   @Test(priority=2)
   public void deleteinvalidid() {
      
	   int petid = 666;
      
      
      Response response = given()
				.header("Content-type", "application/json","api_key","test")
				.when()
				.delete("/pet/"+petid)
				.then()
				.extract().response();

      //verify status code of Response
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode, 400);

      //convert response to string then validate
      String jsonString = response.asString();
      Assert.assertEquals(jsonString.contains("No pet found"), true);
   }
}