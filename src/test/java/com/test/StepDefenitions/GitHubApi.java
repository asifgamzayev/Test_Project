package com.test.StepDefenitions;

import com.test.Utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class GitHubApi {

    Response response;

    @Given("The Base URI is set")
    public void the_base_uri_is_set() {


        baseURI = "https://api.github.com";


    }

    @When("I send a PATCH request to {string} endpoint with the following values")
    public void i_send_a_patch_request_to_endpoint_with_the_following_values(String endpoint, Map<String, String> dataTable) {
        String loc = dataTable.get("location");
        String name = dataTable.get("company");
        boolean hire = Boolean.valueOf(dataTable.get("hireable"));

        response = given().
                header("Accept", "application/vnd.github+json").
                header("Authorization", "token " + ConfigReader.getProperty("github_token")).
                body("{\n" +
                        "     \"location\": \"" + loc + "\",\n" +
                        "     \"company\": \"" + name + "\",\n" +
                        "     \"hireable\" : " + hire + "\n" +
                        "}").


                when().log().all().
                patch(endpoint);

    }

    @Then("The response should contain the following")
    public void the_response_should_contain_the_following(Map<String, String> dataTable) {

        response.then().log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server")).
        body("company", equalTo(dataTable.get("company"))).
                body("location", equalTo(dataTable.get("location"))).
                body("hireable", equalTo(null));
    }



}
