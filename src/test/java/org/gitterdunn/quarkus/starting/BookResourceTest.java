package org.gitterdunn.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BookResourceTest {

  @Test
  public void testGetAllBooks() {
    given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
        .get("/api/books")
        .then()
        .statusCode(200)
        .body("size()", is(4));
  }

  @Test
  public void testCountAllBooks() {
    given()
        .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
        .get("/api/books/count")
        .then()
        .statusCode(200)
        .body(is("4"));
  }

  @Test
  public void testGetSpecificBook() {
    given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .pathParams("id", 1)
        .when()
        .get("api/books/{id}")
        .then()
        .statusCode(200)
        .body("id", is(1))
        .body("title", is("Understanding Quarkus"))
        .body("author", is("Antonio"))
        .body("yearOfPublication", is(2020))
        .body("genre", is("Comedy"));
  }
}
