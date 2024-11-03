package com.udea.restapiautomation.task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CreateUser implements Task {
    private final Actor user;

    private CreateUser(Actor user) {
        this.user = user;
    }

    public static CreateUser withDetails(Actor user) {
        return new CreateUser(user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(user)
                .post("https://reqres.in/api/users");


    }
}
