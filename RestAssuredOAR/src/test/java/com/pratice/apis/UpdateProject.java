package com.pratice.apis;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProjectData()
	{
		JSONObject job=new JSONObject();
		job.put("createdBy", "Sidharth");
		job.put("createdOn", "16/12/2020");
		
		job.put("projectName", "Yahoo");
		job.put("status", "Completed");
		job.put("teamSize",5);
		
		String jsonData = job.toJSONString();
		RequestSpecification req = RestAssured.given();
		req.body(jsonData);
		req.contentType(ContentType.JSON);
		
		Response resp = req.when().put("http://localhost:8084/projects/TY_PROJ_202");
		
		resp.then().log().all();
	}
}
