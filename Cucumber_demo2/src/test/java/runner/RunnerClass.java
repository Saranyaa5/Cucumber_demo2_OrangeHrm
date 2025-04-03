package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.core.snippets.SnippetType;

@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber-reports/OrangeHrmQuickStartReport.json"}, 
    features = "src/test/resources/com/features/OrangeHrmLogin.feature",
    glue = "stepDefinitions",
    monochrome = true,
    dryRun = false
  
)

public class RunnerClass extends AbstractTestNGCucumberTests {
}
