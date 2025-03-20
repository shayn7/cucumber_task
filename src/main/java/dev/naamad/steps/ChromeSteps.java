package dev.naamad.steps;

import dev.naamad.enums.Environment;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class ChromeSteps extends BaseSteps {
    public ChromeSteps(Environment environment) {
        super(environment);
    }

    @Override
    protected MutableCapabilities initCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}
