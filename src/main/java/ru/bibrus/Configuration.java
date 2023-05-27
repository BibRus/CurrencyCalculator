package ru.bibrus;

import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.util.Properties;

public final class Configuration {

    public static final int CONVERTER_ROUNDING_SCALE = Integer.parseInt(Configuration.get().value("converter.rounding.scale"));
    public static final RoundingMode CONVERTER_ROUNDING_MODE = RoundingMode.valueOf(Configuration.get().value("converter.rounding.mode"));

    private static Configuration instance = null;
    private final Properties properties;

    private Configuration() {
        properties = new Properties();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static synchronized Configuration get() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String value(String key) {
        return this.properties.getProperty(key, String.format("The key %s does not exists", key));
    }

}
