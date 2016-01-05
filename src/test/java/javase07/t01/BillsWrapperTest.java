package javase07.t01;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BillsWrapperTest {

    @Test
    public void testAddBill() throws Exception {
        BillsWrapper test = new BillsWrapper("F:\\java\\java-home-work\\src\\main\\resources\\javase07\\t01\\test_addBill.txt");
        test.addBill("123", "321", 500);
    }

    @Test
    public void testGetBalance() throws Exception {
        BillsWrapper test = new BillsWrapper("F:\\java\\java-home-work\\src\\main\\resources\\javase07\\t01\\test_getBalance.txt");
        assertTrue(test.getBalance("123") == 1160);
        assertTrue(test.getBalance("321") == -400);
    }
}