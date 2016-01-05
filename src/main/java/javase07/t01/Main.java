package javase07.t01;

public class Main {
    public static void main (String[] args) {
        String path = "F:\\java\\java-home-work\\src\\main\\resources\\javase07\\t01\\test_treads.txt";
        BillsWrapper wrap = new BillsWrapper(path);
        Thread test1 = new Thread(new BillsWrapperThread(wrap));
        Thread test2 = new Thread(new BillsWrapperThread(wrap));
        Thread test3 = new Thread(new BillsWrapperThread(wrap));
        Thread test4 = new Thread(new BillsWrapperThread(wrap));
        test1.start();
        test2.start();
        test3.start();
        test4.start();
        System.out.println("MAIN FINISH");
    }
}
