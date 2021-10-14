package com.employeeapi.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request {

	@Test
	void basicAutentication() {
		// This code isn't working, just is a structure example
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";

		// Basic Autentication
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("UserExample");
		authScheme.setPassword("PasswordExample");

		RestAssured.authentication = authScheme;	

		// Request object
		RequestSpecification httprerequest = RestAssured.given();

		// Response object
		Response response = httprerequest.request(Method.GET);

		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);

		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

}
