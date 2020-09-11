package api.test;

import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static support.Helper.*;

import io.restassured.response.Response;

public class APITest {
	public static String Url = "https://api.trello.com/1/actions/592f11060f95a3d3d46a987a";

	@Test
	public void TestAPI() {
		Response response1 = doGetRequest(Url);
		
		Assert.assertTrue(response1.statusCode() == 200);
		System.out.println("-------------------------------");
		System.out.println("API: " + Url);
		System.out.println("Status code: " + response1.statusCode());
		
		String lista = given()
					.when()
						.get(Url)
					.then()
						.statusCode(200)
						.extract().path("data.list.name").toString();
			System.out.println("Conteúdo do campo 'name' da estrutura 'list': " + lista);	
		
		System.out.println("-------------------------------");
	}
}



