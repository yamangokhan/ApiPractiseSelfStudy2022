package DeserializingJsonToJava;

import utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasToString;

public class Test01 extends PojoClass{

    @BeforeClass
    public static void before(){
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan.base_url");
    }

    @Test
    public void setUp() {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", 50);
        bodyMap.put("name", "gokhan");
        bodyMap.put("gender", "Male");
        bodyMap.put("phone", "121232132132");

        given()

                .log().all() // <---- Gives every request as a log
                .contentType(ContentType.JSON)
                .body(bodyMap)


                .when()
                .post("/spartans")

                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", equalToIgnoringCase("gokhan"))
                .body("data.phone", hasToString("121232132132")); // 201 Created


    }

    @Test
    public void Single_Spartan_LoggingAll_details_Test(){
        given()
                .pathParam("my_id", 3)
                .log().all()
                .when()
                .get("/spartans/{my_id}")
                .then()
                .log().ifValidationFails()// <---- If any validation fail, it gives us as a log
                .statusCode(200);
    }

}
