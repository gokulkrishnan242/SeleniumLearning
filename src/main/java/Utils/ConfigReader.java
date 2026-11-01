package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getConfigData(String key) throws IOException {
            File file = new File("src/test/resources/testData/config.properties");
            FileReader reader = new FileReader(file);
            Properties properties = new Properties();
            properties.load(reader);
            properties.getProperty(key);
        return properties.getProperty(key);
    }
}
