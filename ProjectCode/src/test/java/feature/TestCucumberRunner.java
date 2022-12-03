package feature;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:build/reports/cucumber-tests/json-report-feature.json" }, glue = { "feature" }, features = { "src/test/resources/feature" })
public class TestCucumberRunner {

}
