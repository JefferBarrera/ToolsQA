package co.com.segurosbolivar.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ui.Select;

import static co.com.segurosbolivar.userinterfaces.PracticeFormUI.*;
import static co.com.segurosbolivar.userinterfaces.PracticeFormUI.SELECT_MONTH;

public class SeleccionarFecha implements Interaction {

    private final String fecha;

    public SeleccionarFecha(String fecha) {
        this.fecha = fecha;
    }

    public static Performable conFecha(String fecha) {
        return Instrumented.instanceOf(SeleccionarFecha.class).withProperties(fecha);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

        String[] fechaSplit = fecha.split(" ");
        String diaCustom = String.format(LBL_DAY.getCssOrXPathSelector(), fechaSplit[0]);

        actor.attemptsTo(
                Scroll.to(TXT_DATE_OF_BIRTH),
                Click.on(TXT_DATE_OF_BIRTH),
                Select.option(fechaSplit[2]).from(SELECT_YEAR),
                Select.option(fechaSplit[1]).from(SELECT_MONTH),
                Click.on(diaCustom)
        );

    }

}
