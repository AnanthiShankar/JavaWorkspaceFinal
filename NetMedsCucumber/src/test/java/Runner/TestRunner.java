package Runner;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		features="Features",
		glue="com.stepDefinitions"
		)
public class TestRunner {

}
