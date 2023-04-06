import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTokenTest {

    @Test
    public void getTokenTest() {
        Response response = given()
                .contentType("multipart/form-data")
                .multiPart("username", "bogomol")
                .multiPart("password", "46815887d2")
                .post("https://test-stand.gb.ru/gateway/login");
        boolean contains = response.getBody().prettyPrint().contains("326acbc051acab01a3053bdb1b0b4592");
        assertThat(contains, equalTo(true));
    }

    @Test
    public void negativeLoginTest() {
        Response response = given()
                .contentType("multipart/form-data")
                .multiPart("username", "user")
                .multiPart("password", "46815887d2")
                .post("https://test-stand.gb.ru/gateway/login");
        assertThat(response.getStatusCode(), equalTo(401));
    }
    @Test
    public void negativePasswordTest() {
        Response response = given()
                .contentType("multipart/form-data")
                .multiPart("username", "bogomol")
                .multiPart("password", "4681588722")
                .post("https://test-stand.gb.ru/gateway/login");
        assertThat(response.getStatusCode(), equalTo(401));
    }
}