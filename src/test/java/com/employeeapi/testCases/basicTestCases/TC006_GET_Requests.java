package com.employeeapi.testCases.basicTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Requests {
	
	@Test
	void extractValuesForEachNodeInJSON(){
		// Specify base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
		// Request object
		RequestSpecification httprerequest = RestAssured.given();
		// Response object
		Response response = httprerequest.request(Method.GET, "/2");
		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);
		
		//Getting all the path
		JsonPath jsonPath  = response.jsonPath();
		System.out.println("id:: " + jsonPath.get("data.id"));
		System.out.println("employee_name:: " + jsonPath.get("data.employee_name"));
		System.out.println("employee_salary:: " + jsonPath.get("data.employee_salary"));
		System.out.println("employee_age:: " + jsonPath.get("data.employee_age"));
		System.out.println("profile_image" + jsonPath.get("data.profile_image"));
		
		Assert.assertEquals("Garrett Winters",jsonPath.get("data.employee_name"), "The employee name is not equals:: ");
	}

}
