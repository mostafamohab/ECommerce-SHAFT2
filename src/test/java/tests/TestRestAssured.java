//Package that contains all test classes
package tests;

//Libraries Used
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//some libraries needs being static
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TestRestAssured {


    // setting main url paramter in setup function that will be used in all
    // functions
    @BeforeClass
    public void setUp() {

        // Given - All input details
        // When - Submit the API
        // Then - Validate the Response

        // initializing rest assured base url as object from restassured services
        io.restassured.RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // setting a function for Get post by {id} Rest API
    // GET https://jsonplaceholder.typicode.com/posts/1
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-17")
    @Test(priority = 17)
    public void getTest1() {
        given().log().all().header("Cookie", "__cfduid=de2354a31bda903ee9b1614f176bc71691613051811").when()
                .get("posts/1").then().log().all().assertThat().statusCode(200)
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .header("Server", "cloudflare");

    }

    // setting a function for Create a Post Rest API
    // POST https://jsonplaceholder.typicode.com/posts
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-18")
    @Test(priority = 18)
    public void getTest2() {

        given().log().all().header("Cookie", "__cfduid=de2354a31bda903ee9b1614f176bc71691613051811")
                .body("{\r\n" + "	\"title\": \"foo\",\r\n" + "    \"body\": \"bar\",\r\n" + "    \"userId\": 1\r\n"
                        + "}")
                .when().post("posts").then().log().all().assertThat().statusCode(201).body("body", equalTo(null))
                .header("Content-Type", "application/json; charset=utf-8");

    }

}
