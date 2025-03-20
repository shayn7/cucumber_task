package dev.naamad.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"dev.naamad.stepDefinitions", "dev.naamad.hooks", "dev.naamad.config"}, // ✅ Add "dev.naamad.config"
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = "@LoginTest"
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}