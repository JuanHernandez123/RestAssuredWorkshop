package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "3"; // Hard coded - Input for get details og the single Employee & update employee
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		//This implementation is created for read the logs
		//This function is taking into account the setup in the file C:\Automation_Projects\APITestingRestAssured_V10\log4j.properties
		logger= Logger.getLogger("EmployeesRestAPI");// Usually is the name of the project
		PropertyConfigurator.configure("Log4j.properties"); // location of the Log4j.properties file
		logger.setLevel(Level.DEBUG);
	}
}
