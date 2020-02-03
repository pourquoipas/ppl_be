package org.gnius.hr.repository.model.admin;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@QuarkusTest
public class SocietaTest {
	private static String payload = "{\n" +
	        "  \"codice\": \"9999\",\n" +
	        "  \"descrizione\": \"Societa TEST\"\n" +
	        "}";

	@Test
	@Order(1)
	public void testSocieta() {
		RestAssured.given()
        .when().get("/v1/societa")
        .then()
        .statusCode(200);
	}
	
	@Test
	@Order(2)
	public void testNonExistentId() {
		RestAssured.given()
        .when().get("/v1/societa/invalid-id")
        .then()
        .statusCode(404);
	}
	
	@Test
	@Order(3)
	public void testInsert() {
		RestAssured.given()
		.when()
		.contentType(ContentType.JSON)
		.body(payload)
		.post("/v1/societa")
		.then()
		.statusCode(201);
	}

	/** Viene eseguito per quarto, quindi dopo il 3 che fa una insert.
	 * DEVE trovare un record. (Almeno)
	 * Occhio che elimina i record codice "9999" !!!
	 */
	@Test
	@Order(4)
	public void testDelete() {
		
		Response response = RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.get("/v1/societa");
		response.then().statusCode(200);
		List<Societa> l_s = Arrays.asList(response.getBody().as(Societa[].class));
		if (l_s != null) {
			for (Societa s : l_s) {
				if (s.codice != null && s.codice.equals("9999")) {
					RestAssured.given().when().contentType(ContentType.JSON).delete("/societa/" + s.uuid).then().statusCode(204);
				}
			}
//			l_s
//				.stream()
//				.filter(s -> (s.codice != null && s.codice.equals("9999")))
//				.forEach(s -> {
//					RestAssured.given().when().contentType(ContentType.JSON).delete("/societa/" + s.uuid).then().statusCode(204);
//				});
		}
		
	}

}
