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

        @Given("I have access to the system")
        public void iHaveAccessToTheSystem() {
                theActorInTheSpotlight().attemptsTo(
                                ConsumeGet.service(WebServiceEndPoints.URI.getUrl()));
        }

        @When("I create a new user")
        public void iCreateANewUser() {
                double number = Math.random();
                UserModel customer = new UserModel("morpheus", "leader");
                user.remember("newCustomer", user);
                user.attemptsTo(
                                CreateUser.withDetails(user));
        }

        @Then("I should see a satisfactory state")
        public void iShouldSeeASatisfactoryState() {
                user.should(
                                seeThat("The response code is 200",
                                                StatusCode.status(), is(200)));
        }

        @Then("I retrieve a user state")
        public void iRetrieveAUser() {
                user.should(
                                seeThat("The response code is 200",
                                                StatusCode.status(), is(200)));
        }

        Actor user = Actor.named("user");

        @When("I validate get response contain data expected")
        public void iValidateGetResponseContainDataExpected() {
                theActorInTheSpotlight()
                                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected())
                                                .orComplainWith(AssertionsServices.class,
                                                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED));
        }

        @When("I delete a user")
        public void iDeleteAUser() {
                theActorInTheSpotlight().attemptsTo(
                                ConsumeDelete.service(
                                                WebServiceEndPoints.URI.getUrl()));
        }

        @Then("I should see a successful deletion status")
        public void iShouldSeeASuccessfulDeletionStatus() {
                user.should(
                                seeThat("The response code is 204",
                                                StatusCode.status(), is(204)));
        }
}
