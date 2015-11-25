package javase01.t02;


public class Task {
    private double eps;

    public Task() {
    }

    public void setEps(double eps) {
        this.eps = eps;
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

    private double countA(int i) {
        return 1 / Math.pow((i + 1), 2);
    }

}
