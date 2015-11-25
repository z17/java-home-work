package javase01.t03;


public class Task {
    private double a;
    private double b;
    private double h;

    public Task(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public void run() {
        for (double x = 0; x < 2 * Math.PI; x += h) {
            double f = func(x);
            if (a < f && f < b) {
                System.out.printf("%.2f", x);
                System.out.print("\t\t");
                System.out.println(f);
            }
        }
    }

    private double func(double x) {
        return Math.tan(2 * x) - 3;
    }


}
