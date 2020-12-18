package com.RMG.GitAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2Test {
	
	@Test
	public void oAuthTest() {
		
		Response res = given()
			.formParam("client_id", "OAR")
			.formParam("client_secret", "c024123bfbf47efc2cdfdafae2d3693f")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		res.then().log().all();
		String token=res.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "1301")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
			.assertThat().statusCode(200)
		.log().all();
	}
//c024123bfbf47efc2cdfdafae2d3693f
//bfd4784e93772583c085b5baf8302255f3f6c5d7
}
