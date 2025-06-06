package dev.naamad.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/application.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
