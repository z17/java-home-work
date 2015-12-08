package javase01.t02;


import static org.junit.Assert.assertEquals;

public class MinFinderTest {

    @org.junit.Test
    public void testRun() throws Exception {
        // входные данные
        double eps = 0.02;
        MinFinder count = new MinFinder();
        count.setEps(eps);
        double min = count.run();

        assertEquals(min, eps, 0.01);
    }
}