package javase02.t04;

import javase02.t03.Notebook;
import javase02.t03.Pen;
import javase02.t03.Pencil;
import javase02.t03.Stationery;
import org.junit.Test;

import java.util.ArrayList;

public class TaskTest {

    @Test
    public void testSort() throws Exception {

        ArrayList<Stationery> set = new ArrayList<Stationery>();

        set.add(new Pen("Bcd", 55));
        set.add(new Pencil("Abr", 55));
        set.add(new Notebook("YZZ", 54));

        System.out.println("Def:");
        System.out.println(set);
        set = Task.sortByName(set);
        System.out.println("By Name:");
        System.out.println(set);
        set = Task.sortByPrice(set);
        System.out.println("By Price:");
        System.out.println(set);
        set = Task.sortByNameAndPrice(set);
        System.out.println("By Price and Name:");
        System.out.println(set);
    }
}