package javase05.t02;

import org.junit.Test;

public class PropertiesReaderTest {

    @Test
    public void testLoad() throws Exception {
        PropertiesReader test = new PropertiesReader();
        test.load("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test.properties");
        test.load("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test2.properties");
        test.load("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test.txt");
    }

    @Test
    public void testRead() throws Exception {
        PropertiesReader test = new PropertiesReader();
        test.load("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test.properties");

        System.out.println(test.read("key1"));
        System.out.println(test.read("key2"));
        System.out.println(test.read("key"));
    }
}