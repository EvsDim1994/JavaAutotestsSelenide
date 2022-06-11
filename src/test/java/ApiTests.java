import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTests extends HooksApi {
    @Test
    public void restAssuredCheck() {
//        given()
//            .config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
        when()
            .get("/posts")
        .then()
            .statusCode(200);
    }

    @Test
    public void postMethod() {
        File body = new File("src/test/resources/post.json");
        Response response = given()
                .body(body).when()
            .contentType("application/json")
            .post("/posts");
        System.out.println(response.getBody().asString());
    }
}
