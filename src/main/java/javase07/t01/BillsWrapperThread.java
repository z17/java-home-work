package javase07.t01;

public class BillsWrapperThread implements Runnable {
    private static int number = 0;
    private static int test = 0;
    private int currentNumber;
    private BillsWrapper wrap;

    public BillsWrapperThread(BillsWrapper wrap) {
        this.wrap = wrap;
    }

    @Override
    public void run() {

        synchronized (this) {
            currentNumber = number++;
        }

        wrap.addBill(currentNumber+"999", "888", 500);
        System.out.println(wrap.getBalance(currentNumber+"999"));
        System.out.println(wrap.getBalance("888"));
        wrap.addBill(currentNumber+"999", "888", 500);
        System.out.println(wrap.getBalance(currentNumber+"999"));
        System.out.println(wrap.getBalance("888"));

        System.out.println("end " + currentNumber);
    }
}
