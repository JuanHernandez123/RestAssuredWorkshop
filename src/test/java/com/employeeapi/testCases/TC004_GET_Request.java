package com.employeeapi.testCases;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request {

	@Test
	void googleMapsPrintAllHeaders() {
		// Print All the Headers

		// Specify base URL
		RestAssured.baseURI = "https://maps.googleapis.com";
		// Request object
		RequestSpecification httprerequest = RestAssured.given();
		// Response object
		Response response = httprerequest.request(Method.GET,
				"/maps/api/place/textsearch/json?query=restaurants%20in%20Sydney&key=AIzaSyCm4wLuiSuttHkpezBEZ_cEnpxTyF7ggU0");
		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);

		// Get all the headers
		Headers allHeaders = response.headers();

		for (Header header : allHeaders) {
			System.out.println(header.getName() + "----" + header.getValue());
		}

	}

}
