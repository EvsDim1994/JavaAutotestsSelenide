import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTests {
    @Test
    public void restAssuredCheck() {
        when()
            .get("https://www.eldorado.ru/sem/v3/a408/products?limit=15&query=71606112,71626029,71606107,71628007,71541565,71564184,71627999,71091114,71528155,71626758,71606104,71517258")
            .then()
            .body("limit", equalTo(16));
    }
}
