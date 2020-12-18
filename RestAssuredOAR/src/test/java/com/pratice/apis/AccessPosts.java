package com.pratice.apis;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class AccessPosts {

	@Test
	public void fetchPosts()
	{
		Response resp = given().param("userId", "4").param("id", "35").pathParam("x", "posts")
		.when().get("https://jsonplaceholder.typicode.com/{x}");
			
		resp.then().assertThat()
		.statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().log().all();
		
		Object value = resp.jsonPath().get("title");
		System.out.println(value);
	}
}












