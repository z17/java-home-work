package javase01.t04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayTest {

    @Test
    public void testRun() throws Exception {

        double[] mass = {1, 2, 5, 0.4, 2 ,5 };
        Array testArray = new Array(mass);

        double max = testArray.run();
        System.out.println(max);
        assertEquals(6, max, 0.1);

    }
}