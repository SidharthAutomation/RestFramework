package com.pratice.apis;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FetchAllProjects {

	@Test
	public void getAllProjectDetails()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		/*System.out.println("status code is : " + resp.getStatusCode());
		System.out.println("----------------------------------------------------");
		System.out.println("content type is : " + resp.getContentType());
		System.out.println("----------------------------------------------------");
		System.out.println("Response Time in miliseconds : " + resp.getTime());
		System.out.println("----------------------------------------------------");
		System.out.println("Response Time in seconds : " + resp.getTimeIn(TimeUnit.SECONDS));
		System.out.println("----------------------------------------------------");
		System.out.println("Actual Data : " );
		System.out.println(resp.asString());*/
		
		resp.then().log().all();
	}
}












