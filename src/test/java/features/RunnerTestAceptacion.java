package features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/EnviarCorreo.feature"}, glue = {"com.TestingGmail/src/test/java/steps/EnviarCorreoStepsDefinitions"})
public class RunnerTestAceptacion {
}
