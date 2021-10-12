
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void getUserinformation() {
		// Specify base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
		// Request object
		RequestSpecification httprerequest = RestAssured.given();
		// Response object
		Response response = httprerequest.request(Method.GET, "/1");
		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);
		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line:: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
