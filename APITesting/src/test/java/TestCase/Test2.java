package TestCase;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class Test2 {
    @Test
    public void addPet(){

            String payload = "{\n" +
                    "  \"id\": 10,\n" +
                    "  \"name\": \"doggie\",\n" +
                    "  \"category\": {\n" +
                    "    \"id\": 1,\n" +
                    "    \"name\": \"Dogs\"\n" +
                    "  },\n" +
                    "  \"photoUrls\": [\n" +
                    "    \"string\"\n" +
                    "  ],\n" +
                    "  \"tags\": [\n" +
                    "    {\n" +
                    "      \"id\": 0,\n" +
                    "      \"name\": \"string\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"status\": \"available\"\n" +
                    "}";
            RestAssured.baseURI = "https://petstore3.swagger.io/api/v3";
            given()
                    .header("Content-Type","application/json")
                    .body(payload)
                    .when()
                    .post("/pet")
                    .then()
                    .log().all()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("addPetSchema.json"));
        }
}

