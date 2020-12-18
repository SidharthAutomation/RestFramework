package baseUtils;

import io.restassured.response.Response;

/**
 * 
 * @author Nitheesha
 *
 */
public class JsonUtils {
	/**
	 * This method for get the value from the json response
	 * @param res
	 * @param jsonPath
	 * @return
	 */
 public static String getJsonValue(Response res,String jsonPath) {
	 return res.jsonPath().get(jsonPath);
 }
}













