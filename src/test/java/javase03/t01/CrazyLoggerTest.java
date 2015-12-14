package javase03.t01;

import org.junit.Test;


public class CrazyLoggerTest {

    @Test
    public void test() throws Exception {
        CrazyLogger.add("Test message");
        CrazyLogger.add("Test another message");
        System.out.println(CrazyLogger.findMessages(14, 12, 2015));
        System.out.println(CrazyLogger.findMessages(12, 2015));
        System.out.println(CrazyLogger.findMessages(2015));
    }
}