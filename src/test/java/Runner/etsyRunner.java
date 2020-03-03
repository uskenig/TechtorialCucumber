package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\com.cucumber.features\\com.cucumber.features.Etsy\\EtsySearch.feature",
        glue = "StepDefinitions\\EtsyStepDefinition",
        monochrome = true,
        dryRun = false
)
public class etsyRunner {
}
