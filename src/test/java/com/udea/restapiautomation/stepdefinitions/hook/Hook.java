package com.udea.restapiautomation.stepdefinitions.hook;

import freemarker.core.Environment;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    private EnvironmentVariables environmentVariables;


    @Before
    public void configureBaseUrl() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Regres");
        String theRestApiBaseUrl = environmentVariables.optionalProperty("environments.qa.base.url")
                .orElse("https://reqres.in/");

       OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
