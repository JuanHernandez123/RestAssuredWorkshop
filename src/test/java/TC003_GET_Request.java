import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void googleMapsTest() {
		//Validate Headers
		
		// Specify base URL
		RestAssured.baseURI = "https://maps.googleapis.com";
		// Request object
		RequestSpecification httprerequest = RestAssured.given();
		// Response object
		Response response = httprerequest.request(Method.GET, "/maps/api/place/textsearch/json?query=restaurants%20in%20Sydney&key=AIzaSyCm4wLuiSuttHkpezBEZ_cEnpxTyF7ggU0");
		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);
		
		//Capture response header of response
		String contentType= response.header("Content-Type");
		System.out.println("Content type::: " + contentType);
		Assert.assertEquals(contentType, "application/json; charset=UTF-8");
		
		String contentEncoding= response.header("Content-Encoding");
		System.out.println("Content type::: " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
	}

}
