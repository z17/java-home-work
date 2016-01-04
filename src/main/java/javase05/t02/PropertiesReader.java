package javase05.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        load(name);
    }

    public void load(String name) {
        try(InputStream input = new FileInputStream(name)) {
            file.load(input);
        } catch (FileNotFoundException e) {
            System.out.println(name + " Properties File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(String key) throws PropertyNotFoundExeption {
        String ret;
        try {
            ret = file.getProperty(key);
            if (ret == null) {
                // кидаем исключение ради того чтобы его сразу же поймать!
                throw new PropertyNotFoundExeption();
            }
            return ret;
        } catch (PropertyNotFoundExeption e) {
            e.printStackTrace();
        }

        return null;
    }
}
