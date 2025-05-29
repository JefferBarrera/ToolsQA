package co.com.segurosbolivar.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


public class Navegar implements Task {

    private final String url;

    public Navegar(String url) {
        this.url = url;
    }

    public static Performable en(String url) {
        return Instrumented.instanceOf(Navegar.class).withProperties(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

}
