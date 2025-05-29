package co.com.segurosbolivar.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class EsInvalido implements Question<Boolean> {

    private final Target target;

    public EsInvalido(Target target) {
        this.target = target;
    }

    public static EsInvalido elCampo(Target target) {
        return new EsInvalido(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElement elemento = target.resolveFor(actor);
        return !elemento.isDisplayed() ? false :
                (Boolean) ((JavascriptExecutor)
                        actor.abilityTo(BrowseTheWeb.class).getDriver()
                ).executeScript("return arguments[0].matches(':invalid')", elemento);
    }

}
