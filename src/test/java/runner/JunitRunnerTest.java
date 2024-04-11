package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features",
		glue = {"stepdefinitions","hooks"},
		dryRun = false,
		plugin = {"pretty", "html:target/Cucumber-Report.html", "json:target/Report.json"},
		tags = "@Regresion"
		)
public class JunitRunnerTest {

}
