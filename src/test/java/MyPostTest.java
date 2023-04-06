import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import dto.PostsResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyPostTest {

    @Test
    public void firstTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 1)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(16153));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("формат"));
    }

    @Test
    public void secondTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", 1)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(16159));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("New"));
    }

    @Test
    public void thirdTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 2)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(16157));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("2134568765432"));
    }

    @Test
    public void fourthTest() {
        Response postsResponse = given()
                .queryParam("page", 1)
                .when()
                .get("https://test-stand.gb.ru/api/posts");
        assertThat(postsResponse.getStatusCode(), equalTo(401));
    }

    @Test
    public void fifthTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", 2)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(16155));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("22222"));
    }
}