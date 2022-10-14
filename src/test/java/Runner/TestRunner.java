package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = {"src/test/java/Features"},
		glue = {"stepDefinitions"},
		plugin = {},
		dryRun = false,
		monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
