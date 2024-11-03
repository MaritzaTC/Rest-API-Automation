package com.udea.restapiautomation.stepdefinitions;

import com.udea.restapiautomation.models.TestData;
import com.udea.restapiautomation.questions.StatusCode;
import com.udea.restapiautomation.task.ConsumeGet;
import com.udea.restapiautomation.task.Load;
import com.udea.restapiautomation.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;


import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetStepdefinitions {
    @Given("I Load customer information")
    public void iLoadCustomerInformation(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }
    @When("I call Get user API")
    public void iCallGetUserAPI() {
          theActorInTheSpotlight().attemptsTo(
                 ConsumeGet.service(WebServiceEndPoints.URI.getUrl())
          );
    }
    @Then("I should see the status code {int}")
    public void iShouldSeeTheStatusCode(Integer responseCode) {
            theActorInTheSpotlight().should(
                    seeThat("The response code is correct", StatusCode.is(responseCode))
            );

    }
    @Then("I validate quantity key is {int}")
    public void iValidateQuantityKeyIs(Integer int1) {

    }
    @Then("I validate schema response {string}")
    public void iValidateSchemaResponse(String string) {

    }
    @Then("I validate fields get response api")
    public void iValidateFieldsGetResponseApi() {

    }
    @Then("I validate get response contain data expected")
    public void iValidateGetResponseContainDataExpected() {

    }
}
