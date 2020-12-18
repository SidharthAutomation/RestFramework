package com.pratice.apis;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewProject {

	/*
	 * given() :- used to set precondition
	 * 
	 * when() :- used to send request with precondition
	 * 
	 * then() :- After getting response -- determine POST action for request
	 */
	@Test
	public void generateNewProject()
	{
		JSONObject job=new JSONObject();
		job.put("createdBy", "Sidharth");
		job.put("createdOn", "16/12/2020");
		job.put("projectId","TY_PROJ_002");
		job.put("projectName", "Google");
		job.put("status", "Completed");
		job.put("teamSize",5);
		
		String jsonData = job.toJSONString();
		RequestSpecification req = RestAssured.given();
		req.body(jsonData);
		req.contentType(ContentType.JSON);
		
		Response resp = req.when().post("http://localhost:8084/addProject");
		
		resp.then().log().all();
		
		 
	}
}














