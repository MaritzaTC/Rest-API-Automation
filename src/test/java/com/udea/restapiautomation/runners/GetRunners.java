package com.udea.restapiautomation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
    features = "src/test/java/resources/features/user/user.feature",
        glue = {
                "com.udea.restapiautomation.stepdefinitions.hook",
                "com.udea.restapiautomation.stepdefinitions",
        }
)
public class GetRunners {

}
