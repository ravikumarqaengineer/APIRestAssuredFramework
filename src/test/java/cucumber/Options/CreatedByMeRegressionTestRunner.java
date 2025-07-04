package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/CreatedByMeRegression.feature", plugin = "json:target/jsonReports/cucumber-report.json", 
glue={"stepDefinations"}, /*, tags = {"@DeletePlace"}*/
tags ="@Regression",
monochrome=true,stepNotifications=true)

public class CreatedByMeRegressionTestRunner {

}
