package stepdefinitions.apiStepDef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class DeleteUserSteps {

    private Response response;
    private int userId;

    @Given("an existing user with id {int} to delete")
    public void an_existing_user_with_id_to_delete(Integer id) {
        this.userId = id;
    }

    @When("I send a request to delete the user")
    public void i_send_a_request_to_delete_the_user() {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("http://localhost:8080/users/" + userId); // replace with real URL
    }

    @Then("the user should be deleted successfully with status {int}")
    public void the_user_should_be_deleted_successfully_with_status(Integer statusCode) {
        response.then().statusCode(statusCode);
    }
}
