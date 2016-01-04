package javase06.t02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesReaderMap {
    private HashMap<String, String> properties;


    public PropertiesReaderMap(String fileName) {
        Properties file = new Properties();
        try(InputStream input = new FileInputStream(fileName)) {
            file.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties = new HashMap<>(file.size());

        file.forEach( (k, v) -> properties.put((String)k, (String)v));
    }

    public String getValue(String key) {
        return properties.get(key);
    }

    public void addValue(String key, String value) {
        properties.put(key, value);
    }
}
