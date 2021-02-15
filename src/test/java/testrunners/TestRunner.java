package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", 
tags = "@Posts",
glue= {"stepdefinitions", "apphooks"}, plugin= {"pretty", "html:target/cucumber-reports"} , monochrome = true)
public class TestRunner {
	
}
