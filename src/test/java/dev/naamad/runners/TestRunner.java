package dev.naamad.runners;

import dev.naamad.config.CucumberSpringConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.test.context.ContextConfiguration;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"dev.naamad.stepDefinitions", "dev.naamad.hooks", "dev.naamad.config"}, // ✅ Include the config package
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
@ContextConfiguration(classes = CucumberSpringConfiguration.class)
public class TestRunner extends AbstractTestNGCucumberTests {
}

