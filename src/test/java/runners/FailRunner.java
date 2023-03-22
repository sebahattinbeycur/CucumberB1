package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt"
        ,glue = "steps"
        ,plugin = {
        "pretty",
        "html:target/cucumber-report/cucumberReport.html",
        "json:target/cucumber-report/cucumberReport.json",
        "rerun:target/failed.txt"       // <== keep updating project's failed.txt file each time I fix and return my failed tests
}

)


public class FailRunner {
}