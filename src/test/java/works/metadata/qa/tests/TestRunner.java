package works.metadata.qa.tests;

        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/metadataExchange/LoginPage/LoginPage.feature",
        glue = "works.metadata.qa.tests.steps",
        plugin = {"pretty", "summary", "de.monochromata.cucumber.report.PrettyReports:target/cucumber-reports/html", "html:target/cucumber-reports/html/cucumber.html", "json:target/cucumber-reports/json/cucumber.json"},
        monochrome = false,
        dryRun = false,
        tags = "@SmokeTest"
)
public class TestRunner {
}