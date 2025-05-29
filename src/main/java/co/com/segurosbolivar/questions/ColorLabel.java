package co.com.segurosbolivar.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ColorLabel implements Question<String> {

    private final Target target;

    public ColorLabel(Target target) {
        this.target = target;
    }

    public static ColorLabel delElemento(Target target) {
        return new ColorLabel(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade element = target.resolveFor(actor);
        return element.getCssValue("color");
    }
}
