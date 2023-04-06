import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import dto.PostsResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NotMyPostTest {

    @Test
    public void firstTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 1)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(1));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("жареные сосиски"));
    }

    @Test
    public void secondTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", 1)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(16179));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("Торт Наполеон 6"));
    }

    @Test
    public void thirdTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 5)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(30));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("My firt post"));
    }

    @Test
    public void fourthTest() {
        PostsResponse postsResponse = given()
                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", 10)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(16119));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("test_Post"));
    }

    @Test
    public void fifthTest() {
        PostsResponse postsResponse = given()

                .header("X-Auth-token", "326acbc051acab01a3053bdb1b0b4592")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 20)
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .extract()
                .body()
                .as(PostsResponse.class);
        assertThat(postsResponse.getData().get(0).getId(), equalTo(97));
        assertThat(postsResponse.getData().get(0).getTitle(), equalTo("Тест1"));
    }
}