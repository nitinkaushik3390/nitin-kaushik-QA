import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

public class GetfindByStatus {
    
	@BeforeClass
    public void setup() 
	{
		RestAssured.baseURI = "https://petstore3.swagger.io/api/v3/";		
		RestAssured.basePath = "/pet/";
	}
			
	@Test
	public void statusCodeVerification() 
	{
		
		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "available");
		Response response = httpRequest.get("/findByStatus/");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200,"Status code is correct");
	}
	
	@Test
	public void responsebodyVerification()
	{
		
		RequestSpecification httpRequest = RestAssured.given().headers("accept","application/json").queryParam("status", "available");
		Response response = httpRequest.get("/findByStatus/");
		
		JsonPath j = new JsonPath(response.asString());
		int s = j.getInt("item.size()");
	      for(int i = 0; i < s; i++) {
	         String status = j.getString("item["+i+"].status");
	         System.out.println(status);
		
	}}
	
	
	
	
}