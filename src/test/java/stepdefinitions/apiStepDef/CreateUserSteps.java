package stepdefinitions.apiStepDef;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserSteps {

    private Response response;
    private String name;
    private String email;

    @Given("a user with name {string} and email {string}")
    public void a_user_with_name_and_email(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @When("I send a request to create the user")
    public void i_send_a_request_to_create_the_user() {
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"" + name + "\", \"email\":\"" + email + "\"}")
                .when()
                .post("http://localhost:8080/users"); // replace with real URL
    }

    @Then("the user should be created successfully with status {int}")
    public void the_user_should_be_created_successfully_with_status(Integer statusCode) {
        response.then().statusCode(statusCode)
                .body("name", equalTo(name))
                .body("email", equalTo(email));
    }
}

