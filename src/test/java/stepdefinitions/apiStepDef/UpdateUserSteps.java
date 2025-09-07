package stepdefinitions.apiStepDef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateUserSteps {

    private Response response;
    private int userId;
    private String newName;
    private String newEmail;

    @Given("an existing user with id {int} and new name {string} and new email {string}")
    public void an_existing_user_with_id_and_new_name_and_new_email(Integer id, String name, String email) {
        this.userId = id;
        this.newName = name;
        this.newEmail = email;
    }

    @When("I send a request to update the user")
    public void i_send_a_request_to_update_the_user() {
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"" + newName + "\", \"email\":\"" + newEmail + "\"}")
                .when()
                .put("http://localhost:8080/users/" + userId); // replace with real URL
    }

    @Then("the user should be updated successfully with status {int}")
    public void the_user_should_be_updated_successfully_with_status(Integer statusCode) {
        response.then().statusCode(statusCode)
                .body("name", equalTo(newName))
                .body("email", equalTo(newEmail));
    }
}
