package core;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass(alwaysRun = true)
    public void setupApi() {
        // ✅ Base URI for your APIs
        RestAssured.baseURI = "https://reqres.in";  // Change if needed
        RestAssured.useRelaxedHTTPSValidation();
    }
}
