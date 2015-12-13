package javase01.t05;

import org.junit.Test;


public class MatrixTest {

    @Test
    public void testRun() throws Exception {
        int n = 14;

        Matrix task = new Matrix(n);
        task.run();
        task.print();
    }
}