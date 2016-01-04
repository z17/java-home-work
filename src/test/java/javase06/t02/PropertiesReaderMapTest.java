package javase06.t02;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PropertiesReaderMapTest {

    @Test
    public void testLoad() throws Exception {
        PropertiesReaderMap test = new PropertiesReaderMap("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test.properties");
    }

    @Test
    public void testGetValue() throws Exception {
        PropertiesReaderMap test = new PropertiesReaderMap("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test.properties");
        assertTrue(test.getValue("key1").equals("one"));
        assertTrue(test.getValue("agssaga") == null);
    }

    @Test
    public void testAddValue() throws Exception {
        PropertiesReaderMap test = new PropertiesReaderMap("F:\\java\\java-home-work\\src\\main\\resources\\javase05\\t02\\test.properties");

        String newKey1 = "newKey1";
        test.addValue(newKey1, "value 1");
        assertTrue(test.getValue(newKey1).equals("value 1"));
        test.addValue(newKey1, "value 2");
        assertTrue(test.getValue(newKey1).equals("value 2"));
    }
}