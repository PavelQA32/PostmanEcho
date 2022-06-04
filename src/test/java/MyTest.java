import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyTest {
    @Test
    void shouldFindJsonPath() {
        given()
                .baseUri("https://postman-echo.com")
                .body("{\n" +
                                "        \"RPGStuff\": {\n" +
                                "            \"items\": [\n" +
                                "                {\n" +
                                "                    \"name\": \"sword\",\n" +
                                "                    \"action\": \"atack\"\n" +
                                "                },\n" +
                                "                {\n" +
                                "                    \"name\": \"shield\",\n" +
                                "                    \"action\": \"resist\"\n" +
                                "                },\n" +
                                "                {\n" +
                                "                    \"name\": \"ring\",\n" +
                                "                    \"action\": \"magic\"\n" +
                                "                }\n" +
                                "            ]\n" +
                                "        }\n" +
                                "    }"
    )

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("{\n" +
                        "        \"RPGStuff\": {\n" +
                        "            \"items\": [\n" +
                        "                {\n" +
                        "                    \"name\": \"sword\",\n" +
                        "                    \"action\": \"atack\"\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"name\": \"shield\",\n" +
                        "                    \"action\": \"resist\"\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"name\": \"ring\",\n" +
                        "                    \"action\": \"magic\"\n" +
                        "                }\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    }"));
    }

}
