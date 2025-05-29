package co.com.segurosbolivar.runners.Sistema;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Sistema/DiligenciarFormularioParalelo.feature",
        glue = "co.com.segurosbolivar.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "timeline:target/test-results/timeline"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerParalelo {
}
