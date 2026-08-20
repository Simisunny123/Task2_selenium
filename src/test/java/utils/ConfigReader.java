package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadProperties() {

        prop = new Properties();

        try {

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                    + "/src/test/resources/config.properties"
            );

            prop.load(fis);

        } catch (IOException e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Unable to load config.properties"
            );
        }
    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}