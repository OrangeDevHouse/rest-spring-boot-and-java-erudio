package br.com.aj.integrationtests.swagger;

import br.com.aj.config.TestConfigs;
import br.com.aj.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    void shouldDisplaySwaggerUIPage() {
        var response =
            given()
                .basePath("/swagger-ui.html")
                .port(TestConfigs.SERVER_PORT)
            .when()
                .get()
            .then()
                .statusCode(200)
            .extract()
                .body()
                    .asString();

        assertTrue(response.contains("swagger-ui"), "Response should contain swagger-ui");
    }
}
