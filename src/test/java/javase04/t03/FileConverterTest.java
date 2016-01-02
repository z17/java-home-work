package javase04.t03;

import org.junit.Test;

public class FileConverterTest {

    @Test
    public void testConvert() throws Exception {
        String fileIn = "F:\\java\\java-home-work\\src\\main\\resources\\javase04\\t03\\input.txt";
        String fileOut = "F:\\java\\java-home-work\\src\\main\\resources\\javase04\\t03\\output.txt";

        FileConverter file = new FileConverter(fileIn, fileOut);
        file.convert();
    }
}