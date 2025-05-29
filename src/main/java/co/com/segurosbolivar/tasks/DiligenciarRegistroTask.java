package co.com.segurosbolivar.tasks;

import co.com.segurosbolivar.interactions.Espera;
import co.com.segurosbolivar.interactions.SeleccionarFecha;
import co.com.segurosbolivar.models.UsuarioPojo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Path;

import static co.com.segurosbolivar.userinterfaces.PracticeFormUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciarRegistroTask implements Task {

    private final UsuarioPojo user;

    public DiligenciarRegistroTask(UsuarioPojo user) {
        this.user = user;
    }

    public static Performable conUsuario(UsuarioPojo user) {
        return Instrumented.instanceOf(DiligenciarRegistroTask.class).withProperties(user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String genero = String.format(RDB_GENDER.getCssOrXPathSelector(), user.getGenero());
        String hobby = String.format(CHK_HOBBIES.getCssOrXPathSelector(), user.getHobby());
        String estado = String.format(LBL_STATE.getCssOrXPathSelector(), user.getEstado());
        String ciudad = String.format(LBL_CITY.getCssOrXPathSelector(), user.getCiudad());

        actor.attemptsTo(
                Enter.theValue(user.getNombre()).into(TXT_FIRST_NAME),
                Enter.theValue(user.getApellido()).into(TXT_LAST_NAME),
                Enter.theValue(user.getEmail()).into(TXT_EMAIL),
                Check.whether(!user.getGenero().isEmpty())
                        .andIfSo(Click.on(genero))
                        .otherwise(),
                Enter.theValue(user.getTelefono()).into(TXT_PHONE),
                SeleccionarFecha.conFecha(user.getFechaNacimiento()),
                Enter.theValue(user.getMaterias()).into(TXT_SUBJECTS),
                WaitUntil.the(LST_SUBJECTS, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(LST_SUBJECTS),
                Click.on(LST_SUBJECTS),
                Click.on(hobby),
                Upload.theFile(Path.of(user.getImagen())).to(BTN_UPLOAD_IMAGE),
                Scroll.to(TXT_ADDRESS),
                Enter.theValue(user.getDireccion()).into(TXT_ADDRESS),
                Click.on(LST_STATE),
                WaitUntil.the(estado, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(estado),
                Click.on(LST_CITY),
                WaitUntil.the(ciudad, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ciudad),
                Click.on(BTN_SUBMIT),
                Espera.porSegundos(2)
        );
    }

}
