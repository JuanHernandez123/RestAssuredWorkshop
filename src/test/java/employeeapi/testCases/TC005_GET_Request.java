package employeeapi.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request {

	@Test
	void validateJSONResponse() {
		// Specify base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
		// Request object
		RequestSpecification httprerequest = RestAssured.given();
		// Response object
		Response response = httprerequest.request(Method.GET, "/2");
		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);
		
		//Validate if the response contains an specific property
		Assert.assertEquals(responseBody.contains("employee_name"), true);


	}

}
