import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class HooksApi {

    @BeforeEach
    public void beforeRestAssured(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
