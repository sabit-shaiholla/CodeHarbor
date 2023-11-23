import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class FilmResourceTest {

    @Test
    public void test1() {
        given()
                .when().get("/film/5")
                .then()
                .statusCode(200)
                .body(containsString("AFRICAN EGG"));
    }

    @Test
    public void test2() {
        given()
                .when().get("/film/5")
                .then()
                .statusCode(200)
                .body(containsString("TITANIC"));
    }
}
