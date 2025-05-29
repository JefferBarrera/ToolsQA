package co.com.segurosbolivar.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;


public class HooksStepDefinitions {

    @Managed
    public static WebDriver driver;

    @Before
    public void actorSetup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Automatizador").can(BrowseTheWeb.with(driver));
    }

    @After
    public static void atTheEnd(){
        driver.quit();
    }

}
