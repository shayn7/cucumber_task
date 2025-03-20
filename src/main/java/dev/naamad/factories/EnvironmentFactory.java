package dev.naamad.factories;

import dev.naamad.enums.Environment;
import dev.naamad.steps.BaseSteps;
import dev.naamad.steps.ChromeSteps;

import static dev.naamad.enums.Environment.*;

/**
 * Factory class for creating environment-specific steps.
 */
public class EnvironmentFactory {

    /**
     * Get environment-specific steps based on the environment name.
     *
     * @param environment The name of the environment.
     * @return Environment-specific steps.
     */
    public static synchronized BaseSteps getEnvironment(String environment) {
        return switch (environment) {
            case "local_chrome" -> createChromeSteps(LOCAL_CHROME);
            case "remote" -> createChromeSteps(REMOTE_CHROME);
            default -> throw new IllegalArgumentException("Unsupported environment: " + environment);
        };
    }

    private static BaseSteps createChromeSteps(Environment environment) {
        return new ChromeSteps(environment);
    }

}
