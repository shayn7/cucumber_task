package dev.naamad.config;

import dev.naamad.enums.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "dev.naamad")
public class TestConfig {

    @Value("${test.environment}")
    private String environmentValue;

    @Bean
    public Environment environment() {
        return Environment.valueOf(environmentValue);
    }
}
