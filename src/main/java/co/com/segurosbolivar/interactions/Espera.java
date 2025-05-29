package co.com.segurosbolivar.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

public class Espera implements Interaction {

    private final int segundos;

    public Espera(int segundos) {
        this.segundos = segundos;
    }

    public static Performable porSegundos(int segundos) {
        return Instrumented.instanceOf(Espera.class).withProperties(segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
