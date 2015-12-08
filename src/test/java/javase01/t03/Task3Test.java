package javase01.t03;

import org.junit.Test;

public class Task3Test {

    @Test
    public void testRun() throws Exception {
        int a = 1;
        int b = 5;
        double h = 0.01;

        Task3 count = new Task3(a, b, h);
        count.run();
    }
}