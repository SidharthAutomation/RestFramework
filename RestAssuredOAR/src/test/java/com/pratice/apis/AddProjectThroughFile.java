package com.pratice.apis;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class AddProjectThroughFile {

	@Test
	public void insertProjectFromFile()
	{
		File jsonData = new File("./MyProjectData.json");
		
		given().body(jsonData).contentType(ContentType.JSON)
		.when().post("http://localhost:8084/addProject")
		.then().log().all();
		
		
	}
}













