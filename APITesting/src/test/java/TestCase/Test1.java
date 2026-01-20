package TestCase;

import io.restassured.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Test1 {

    @Test
    public void getMethod()
    {
//        String result = "{\n" +
//                "    \"id\": \"7\",\n" +
//                "    \"name\": \"Apple MacBook Pro 16\",\n" +
//                "    \"data\": {\n" +
//                "        \"year\": 2019,\n" +
//                "        \"price\": 1849.99,\n" +
//                "        \"CPU model\": \"Intel Core i9\",\n" +
//                "        \"Hard disk size\": \"1 TB\"\n" +
//                "    }\n" +
//                "}\n";
        RestAssured.baseURI = "https://api.restful-api.dev";
        given().pathParam("id","7")
        .header("Content-Type","application/json")
                .when()
                .get("/objects/{id}")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().time(lessThan(5000L))
                .assertThat().header("content-type","application/json")
                .header("connection","keep-alive")
                .body("id",equalTo("7"))
                .body("name", equalTo("Apple MacBook Pro 16"));
    }

    @Test
    public void postMethod()
    {
        String payload = "{\n" +
                "    \"name\": \"Apple MacBook Pro 16\",\n" +
                "    \"data\": {\n" +
                "        \"year\": 2019,\n" +
                "        \"price\": 1849.99,\n" +
                "        \"CPU model\": \"Intel Core i9\",\n" +
                "        \"Hard disk size\": \"1 TB\"\n" +
                "    }\n" +
                "}\n";
        RestAssured.baseURI = "https://api.restful-api.dev";
        given()
                .header("Content-Type","application/json")
                .body(payload)
                .when()
                .post("/objects")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().time(lessThan(5000L))
                .assertThat().header("content-type","application/json")
                .header("connection","keep-alive")
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Schema1.json"));
    }
}
