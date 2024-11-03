package com.udea.restapiautomation.task;

import com.udea.restapiautomation.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Consume implements Task {
    private final String resource;

    public Consume(String resource) {
        this.resource = resource;
    }

    public static Consume service(String resource) {
        return instrumented(Consume.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(resource));
    }
}
