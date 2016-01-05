package javase07.t01;

import org.junit.Test;

import java.time.LocalDateTime;

public class BillsLoaderTest {

    @Test
    public void testLoad() throws Exception {
        BillsLoader test = new BillsLoader("F:\\java\\java-home-work\\src\\main\\resources\\javase07\\t01\\bills.txt");
        System.out.println(test.load());
    }

    @Test
    public void testSaveBill() throws Exception {
        BillsLoader test = new BillsLoader("F:\\java\\java-home-work\\src\\main\\resources\\javase07\\t01\\bills.txt");
        test.saveBill(
                new Bill("123", "321", 500, LocalDateTime.now())
        );
    }
}