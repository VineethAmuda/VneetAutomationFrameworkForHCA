package stepdefinitions.apiStepDef;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;

public class GetUserSteps {

    private String endpoint;
    private Response response;

    @Given("I set the API endpoint for user with id {string}")
    public void i_set_api_endpoint(String userId) {
        endpoint = "https://reqres.in/api/users/" + userId;
    }

    @When("I send a GET request")
    public void i_send_get_request() {
        response = RestAssured.get(endpoint);
    }

    @Then("The response status should be {int}")
    public void verify_status(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("The response should contain first_name {string}")
    public void verify_first_name(String expectedName) {
        response.then().body("data.first_name", equalTo(expectedName));
    }
}

