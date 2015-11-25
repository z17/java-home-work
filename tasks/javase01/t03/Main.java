package javase01.t03;

public class Main {
    public static void main(String[] args) {
        // входные данные
        int a = 1;
        int b = 5;
        double h = 0.01;

        for (double x = 0; x < 2 * Math.PI; x += h) {
            double f = Math.tan(2 * x) - 3;
            if (a < f && f < b) {
                System.out.printf("%.2f", x);
                System.out.print("\t\t");
                System.out.println(f);
            }
        }


    }
}