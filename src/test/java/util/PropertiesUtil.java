package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PropertiesUtil {
    public static final String PROPERTY_FILE_NAME = "application.properties";
    public static final String PROPERTIES_PATH = "src//test//resources//config//";

    BufferedReader reader;
    java.util.Properties properties = new java.util.Properties();

    public PropertiesUtil() throws IOException {
        reader = new BufferedReader(new FileReader(PROPERTIES_PATH + PROPERTY_FILE_NAME));
        properties.load(reader);
    }

    public String getProperty(String property) {
        String propertyName = properties.getProperty(property);

        if (propertyName != null) {
            return propertyName;
        } else {
            throw new RuntimeException("Não foi encontrada a propriedade: " + property);
        }
    }
}
