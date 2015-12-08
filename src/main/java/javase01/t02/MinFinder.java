package javase01.t02;


public class MinFinder {
    private double eps;

    public MinFinder() {
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double run() {
        int i = 1;
        boolean finish = true;
        double result = 0;
        while (finish) {
            double a = countA(i);
            if (a < eps) {
                System.out.println(i);
                finish = false;
                result = a;
            } else {
                System.out.println(a);
            }
            i++;
        }
        return result;
    }

    private double countA(int i) {
        return 1 / Math.pow((i + 1), 2);
    }
}
