import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void createNewUser() {
		// Specify base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request object
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "test");
		requestParams.put("salary", "123");
		requestParams.put("age", "23");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());  //Attach above data to the request

		// Response object
		Response response = httpRequest.request(Method.POST);

		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);
		
		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 200);  //this should be 201 but is 200 due to the server setup
		
		String succesCode = response.jsonPath().get("message");
		Assert.assertEquals(succesCode, "Successfully! Record has been added.");

	}
}
