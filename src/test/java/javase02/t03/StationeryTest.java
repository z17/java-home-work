package javase02.t03;

import org.junit.Test;

import java.util.ArrayList;

public class StationeryTest {

    @Test
    public void test() throws Exception {
        ArrayList<Stationery> set = new ArrayList<Stationery>();

        set.add(new Pen("Name", 55));
        set.add(new Pencil("Pencil", 32));
        set.add(new Notebook("Home work", 23));
        System.out.println(set);
    }
}