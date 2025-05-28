package org.example.carina.demo;

import com.zebrunner.carina.cucumber.CucumberBaseTest;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/checkout_finish.feature",
        glue = {"org.example.carina.demo.cucumber.steps"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        publish = false
)
public class CucumberWebSampleTest extends CucumberBaseTest {

}
