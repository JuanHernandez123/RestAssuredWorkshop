package dataDrivenTesting;

import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReadXlsFile;

public class dataDrivenTest_Add_New_Employees {

	@Test(dataProvider = "dataProvider")
	void addNewEmployees(String pName, String pSalary, String pAge) {
		// Specify base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request object
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", pName);
		requestParams.put("salary", pSalary);
		requestParams.put("age", pAge);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString()); // Attach above data to the request

		// Response object
		Response response = httpRequest.request(Method.POST);

		// Print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body::: " + responseBody);

		// Validations
		String name = response.jsonPath().get("data.name");
		String salary = response.jsonPath().get("data.salary");
		String age = response.jsonPath().get("data.age");
		System.out.println(name);
		System.out.println(salary);
		System.out.println(age);

		Assert.assertEquals(name, pName);
		Assert.assertEquals(salary, pSalary);
		Assert.assertEquals(age, pAge);
		// other way.. Just for verify that the chain is contains in the response
		// Assert.assertEquals(responseBody.contains("test"), true);

		// Status code
		int statusCode = response.getStatusCode();
		System.out.println("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

	@DataProvider(name = "dataProvider")
	// Example: Get hard code data from matrix
	/*
	 * String[][] getData() { String dataSource[][] = { { "User 001", "1234564",
	 * "57" }, { "User 002", "12386754", "58" }, { "User 003", "8604564", "39" } };
	 * return (dataSource);
	 */

	// get data from external data source
	String[][] getData() throws IOException {
		String pathDataSource = System.getProperty("user.dir")
				+ "/src/test/java/dataDrivenTesting/dataSource/empdata.xlsx";

		int rowNumber = ReadXlsFile.getRowCount(pathDataSource, "Sheet1");
		int columnCount = ReadXlsFile.getCellCount(pathDataSource, "Sheet1", 1); // the 0 position is the header

		System.out.println("rowNumber>>>>>>>>>> " + rowNumber);
		System.out.println("columnCount>>>>>> " + columnCount);
		String dataSource[][] = new String[rowNumber][columnCount];
		for (int i = 1; i <= rowNumber; i++) {
			for (int j = 0; j < columnCount; j++) {
				dataSource[i - 1][j] = ReadXlsFile.getCellData(pathDataSource, "Sheet1", i, j);
			}
		}
		System.out.println("dataSource>>>>>>>>>>>> " + dataSource.toString());
		return (dataSource);
	}
}
