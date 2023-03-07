package org.gitterdunn.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
  // Execute the same tests but in packaged mode.
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
        .body("genre", is("Information Technology"));
  }
}
