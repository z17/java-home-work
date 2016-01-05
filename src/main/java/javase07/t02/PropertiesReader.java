package javase07.t02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties file;

    public PropertiesReader() {
        file = new Properties();
    }

    public PropertiesReader(String name) {
        file = new Properties();
        try(InputStream input = new FileInputStream(name)) {
            synchronized (PropertiesReader.class) {
                file.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return file.getProperty(key);
    }
}
