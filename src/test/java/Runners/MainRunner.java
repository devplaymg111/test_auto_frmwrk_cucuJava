package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@smoke",
        plugin = {
                "pretty",
                "html:build/reports/cucumber-report.html",
                "json:build/reports/cucumber.json"
        },
        monochrome = true
)
public class MainRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        super.runScenario(pickleWrapper, featureWrapper);
    }
}
