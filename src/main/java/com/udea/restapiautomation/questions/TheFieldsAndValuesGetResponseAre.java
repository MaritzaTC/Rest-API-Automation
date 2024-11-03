package com.udea.restapiautomation.questions;
import static com.udea.restapiautomation.utils.constants.Constants.VALIDATION_FIELDS_AND_VALUES;
import static org.hamcrest.Matchers.equalTo;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasItem;

public class TheFieldsAndValuesGetResponseAre implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS_AND_VALUES, "get"),
                        response -> response
                                .assertThat()
                                .body("data.id", hasItem(1))
                                .and().body("data.email", hasItem("george.bluth@reqres.in"))
                                .and().body("data.first_name", hasItem("George"))
                                .and().body("data.last_name", hasItem("Bluth"))
                                .and().body("data.avatar", hasItem("https://reqres.in/img/faces/1-image.jpg"))
                                .and().body("support.url", equalTo("https://reqres.in/#support-heading"))
                                .and().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                ));
        return true;
    }



    public static TheFieldsAndValuesGetResponseAre expected() {
        return new TheFieldsAndValuesGetResponseAre();
    }
}
