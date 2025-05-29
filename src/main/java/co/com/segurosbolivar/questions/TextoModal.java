package co.com.segurosbolivar.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.segurosbolivar.userinterfaces.PracticeFormUI.TXT_CONFIRMATION_MESSAGE;

public class TextoModal implements Question<String> {

    public static TextoModal es() {
        return new TextoModal();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TXT_CONFIRMATION_MESSAGE.resolveFor(actor).getText();
    }

}
