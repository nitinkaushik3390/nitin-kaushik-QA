package test1;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static ResponseSpecBuilder builder;
	public static ResponseSpecification responseSpec;
	public static RequestSpecBuilder requestbuilder;
	public static RequestSpecification requestSpec;
	public static ResponseBody body;
	
	public static HashMap<Object, Object> map = new HashMap<Object, Object>();
// This is to increase the reusability of the base class. In the POST test class file, we can then use map.put("id", "726"); map.put("name", "Garfield"); for request inside a function.

	@BeforeMethod
	public static void setupRequestSpecBuilder() {

	/* Setting request specifications like cookie, header*/
		
		requestbuilder = new RequestSpecBuilder();
		requestbuilder.addHeader("Content-Type", "application/json"); //Setting the header in the request
		requestSpec = requestbuilder.build();
		
	}
	

	@BeforeMethod
	public void setupResponseSpecBuilder() {
		
	/* Setting response specifications expecting headers, status code*/
		
		builder = new ResponseSpecBuilder();
		builder.expectHeader("Content-Type", "application/json"); //Expecting header in the response
		//builder.expectStatusCode(200);
		responseSpec = builder.build();
	}

	@BeforeClass
	public  void setup() {
		
	// Setting base URL & Path
		
		RestAssured.baseURI = "https://petstore3.swagger.io/api/v3/";
		RestAssured.basePath = "/pet";
	}

}
