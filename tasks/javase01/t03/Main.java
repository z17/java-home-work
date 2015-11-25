package javase01.t03;

public class Main {
    public static void main(String[] args) {

        // входные данные
        int a = 1;
        int b = 5;
        double h = 0.01;

        Task count = new Task(a, b, h);
        count.run();
    }
}