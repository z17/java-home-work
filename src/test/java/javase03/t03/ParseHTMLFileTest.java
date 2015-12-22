package javase03.t03;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParseHTMLFileTest {
    ParseHTMLFile file = new ParseHTMLFile();
    @Test
    public void testLoadFile() throws Exception {
        file.loadFile("F:\\java\\java-home-work\\src\\main\\resources\\javase03\\t03\\input.html");
        assertTrue(file.getHtml().length() > 0);
    }

    @Test
    public void testDetect() throws Exception {
        file.loadFile("F:\\java\\java-home-work\\src\\main\\resources\\javase03\\t03\\input.html");
        file.detect();
    }
}