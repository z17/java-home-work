package javase01.t02;


public class Task {
    private double eps;

    Task() {
    }

    public void setEps(double _eps) {
        eps = _eps;
    }

    public void run() {
        int i = 1;
        boolean finish = true;
        while (finish) {
            double a = countA(i);
            if (a < eps) {
                System.out.println(i);
                finish = false;
            } else {
                System.out.println(a);
            }
            i++;
        }
    }

    private double countA(final int i) {
        return 1 / Math.pow((i + 1), 2);
    }

}
