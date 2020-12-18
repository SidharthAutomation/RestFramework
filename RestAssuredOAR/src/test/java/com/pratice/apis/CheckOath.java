package com.pratice.apis;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CheckOath {

	@Test
	public void accessTokenAPI()
	{
		Response res = given()
				.formParam("client_id", "OAR")
				.formParam("client_secret", "c024123bfbf47efc2cdfdafae2d3693f")
				.formParam("grant_type", "client_credentials")
			.when()
				.post("http://coop.apps.symfonycasts.com/token");
			res.then().log().all();
		
			String token = res.jsonPath().get("access_token");
		System.out.println("===========================================================");
		Response resp = given().auth().oauth2(token)
		.when().post("http://coop.apps.symfonycasts.com/api/1301/eggs-count");
		
		resp.then().log().all();
	}
}
