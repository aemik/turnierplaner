package de.aemik.turnierplaner.adapter.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VereinResourceTest {

	@Test
	public void testVereinEndpoint() {
		given().when().get("/verein").then().statusCode(200);
	}

}