package TestCase;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import ProductData.Product;
import ProductData.Data;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class POJOTest {

    @Test
    public void getMethod() {

        RestAssured.baseURI = "https://api.restful-api.dev";

        // 🔹 Deserialization: JSON → POJO
        Product product =
                given()
                        .pathParam("id", "7")
                        .when()
                        .get("/objects/{id}")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract()
                        .as(Product.class);

        // POJO assertions
        Assert.assertEquals(product.getId(),"7");
        Assert.assertEquals(product.getName(),"Apple MacBook Pro 16");
        Assert.assertEquals(product.getData().getCpuModel(),"Intel Core i9");


//        assert product.getId().equals("7");
//        assert product.getName().equals("Apple MacBook Pro 16");
//        assert product.getData().getCpuModel().equals("Intel Core i9");
    }

    @Test
    public void postMethod() {

        RestAssured.baseURI = "https://api.restful-api.dev";

        // 🔹 Build POJO
        Data data = new Data();
        data.setYear(2019);
        data.setPrice(1849.99);
        data.setCpuModel("Intel Core i9");
        data.setHardDiskSize("1 TB");

        Product product = new Product();
        product.setName("Apple MacBook Pro 16");
        product.setData(data);

        // 🔹 Serialization: POJO → JSON
        Product responseProduct =
                given()
                        .header("Content-Type", "application/json")
                        .body(product)
                        .when()
                        .post("/objects")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .assertThat().time(lessThan(5000L))
                        .assertThat().header("content-type", containsString("application/json"))
                        .body(matchesJsonSchemaInClasspath("Schema1.json"))
                        .extract()
                        .as(Product.class);

        // Validate response POJO
        assert responseProduct.getName().equals("Apple MacBook Pro 16");
        assert responseProduct.getData().getYear() == 2019;
    }
}
