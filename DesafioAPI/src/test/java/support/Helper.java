package support;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Helper {
	
	   public static Response doGetRequest(String endpoint) {
	        RestAssured.defaultParser = Parser.JSON;

	        return
	            given()
	            	.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                	.get(endpoint)
                .then()
                	.contentType(ContentType.JSON).extract().response();
	    }
}
