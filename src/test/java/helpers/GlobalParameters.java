package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class GlobalParameters {
    private static GlobalParameters instance;
    private final Properties properties;

    private GlobalParameters() {
        // The approach in this class is preparing the project for different environments as cloud executions for example
        properties = new Properties();

        // Load from .env file first
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/.env");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load from Environment Variables overriding .env
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            properties.setProperty(key, env.get(key));
        }

        // Load from System Properties overriding both - It will be prioritized
        Properties sysProps = System.getProperties();
        properties.putAll(sysProps);
    }

    public static GlobalParameters getInstance() {
        if (instance == null) {
            synchronized (GlobalParameters.class) {
                if (instance == null) {
                    instance = new GlobalParameters();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
