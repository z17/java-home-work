package javase02.t06;

import org.junit.Test;


public class NuclearBoatTest {

    @Test
    public void test() throws Exception {
        NuclearBoat boat = new NuclearBoat("Nautilus");
        boat.goAway();
    }
}