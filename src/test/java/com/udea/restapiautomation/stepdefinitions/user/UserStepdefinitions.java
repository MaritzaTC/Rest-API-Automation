package com.udea.restapiautomation.stepdefinitions.user;

import com.udea.restapiautomation.exceptions.AssertionsServices;
import com.udea.restapiautomation.models.UserModel;
import com.udea.restapiautomation.questions.*;
import com.udea.restapiautomation.task.ConsumeDelete;
import com.udea.restapiautomation.task.ConsumeGet;
import com.udea.restapiautomation.task.CreateUser;

import com.udea.restapiautomation.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;



import static org.hamcrest.Matchers.is;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserStepdefinitions {

    Actor user = Actor.named("user");

    @When("I call Get user API")
    public void iCallGetUserAPI() {
          theActorInTheSpotlight().attemptsTo(
                 ConsumeGet.service(WebServiceEndPoints.URI.getUrl())
          );
    }
    @Then("I should see the status code {int}")
    public void iShouldSeeTheStatusCode() {
        user.should(
                seeThat("The response code is 200",
                        StatusCode.status(), is(201))
        );

    }
    @Then("I validate get response contain data expected")
    public void iValidateGetResponseContainDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }
    @Given("I have access to the system")
    public void iHaveAccessToTheSystem() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(WebServiceEndPoints.URI.getUrl())
        );
    }

    @When("I delete a user")
    public void iDeleteAUser() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeDelete.service(
                        WebServiceEndPoints.URI.getUrl()
                ));
    }

    @Then("Should see the code {int}")
    public void shouldSeeTheCode(int arg0) {
    }

    @When("I create a new user")
    public void iCreateANewUser() {
        double number = Math.random();
        UserModel customer = new UserModel("morpheus", "leader");
        user.remember("newCustomer", user);
        user.attemptsTo(
                CreateUser.withDetails(user)
        );
    }

    @Then("I retrieve a user")
    public void iRetrieveAUser() {
        user.should(
                seeThat("The response code is 200",
                        StatusCode.status(), is(200))
        );
    }

    @When("I retrieve all users")
    public void iRetrieveAllUsers() {
        user.should(
                seeThat("The response code is 200",
                        StatusCode.status(), is(200))
        );
    }


}
