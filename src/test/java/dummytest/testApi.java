package dummytest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testApi {

    private static String lightBulbUrl = "https://qa-challenges-lightbulb.atlassian.io/";
    @Test
    public void testSwitchOn(){
        given()
                .header("userId", "16138cbd-5656-003c-540b-ee1e6d3f52d8")
                .header("Content-Type", "application/json")
                .body("{ \"power\":20 }").
        when()
                .post(lightBulbUrl +"api/allmethods/on").
        then()
                .statusCode(200).log().everything()
                .body("Result", equalTo("Switch & custom power set successfully"));

    }

    @Test
    public void testSwitchOff(){
        given()
                .header("userId", "16138cbd-5656-003c-540b-ee1e6d3f52d8")
                .contentType("application/json").
        when()
                .post(lightBulbUrl+"api/allmethods/off").
        then()
                .statusCode(200)
                .body("Result", equalTo("Switch set successfully"));
    }

}
