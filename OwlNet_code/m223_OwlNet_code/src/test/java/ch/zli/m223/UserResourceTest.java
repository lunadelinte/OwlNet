package ch.zli.m223;
  
  import io.quarkus.test.common.QuarkusTestResource;
  import io.quarkus.test.junit.QuarkusTest;
  import io.quarkus.test.security.TestSecurity;
  import org.junit.jupiter.api.Order;
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.TestMethodOrder;
  import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
  import static io.restassured.RestAssured.given;
  import static org.hamcrest.CoreMatchers.is;
  import io.quarkus.test.h2.H2DatabaseTestResource;
  
  @QuarkusTest
  @QuarkusTestResource(H2DatabaseTestResource.class)
  @TestMethodOrder(OrderAnnotation.class)
  public class UserResourceTest {
  
      @Test
      @Order(1)
      public void testRegistrationSuccess() {
          given()
              .body("{ \"email\": \"test@example.com\", \"password\": \"StrongPass!23\" }")
              .contentType("application/json")
              .when().post("/users/register")
              .then()
              .statusCode(200);
      }
  
      @Test
      @Order(2)
      public void testRegistrationFailure() {
          given()
              .body("{ \"email\": \"\", \"password\": \"weak\" }")
              .contentType("application/json")
              .when().post("/users/register")
              .then()
              .statusCode(400);
      }
  
      @Test
      @Order(3)
      @TestSecurity(user = "test@example.com", roles = "User")
      public void testAuthenticationSuccess() {
          given()
              .body("{ \"email\": \"test@example.com\", \"password\": \"StrongPass!23\" }")
              .contentType("application/json")
              .when().post("/users/authenticate")
              .then()
              .statusCode(200);
      }
  
      @Test
      @Order(4)
      public void testAuthenticationFailure() {
          given()
              .body("{ \"email\": \"test@example.com\", \"password\": \"WrongPassword\" }")
              .contentType("application/json")
              .when().post("/users/authenticate")
              .then()
              .statusCode(401);
      }
  }