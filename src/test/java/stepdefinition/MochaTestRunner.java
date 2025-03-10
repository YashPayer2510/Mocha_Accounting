package stepdefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/createproduct.feature",
        glue={"stepdefinition", "hooks", "Utilities"},
        monochrome = true,
        plugin= {"pretty","html:target/htmlReports", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class MochaTestRunner {
}