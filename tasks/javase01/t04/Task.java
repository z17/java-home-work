package javase01.t04;

public class Task {

    public static double run(double[] mass) {
        double max = mass[0];
        for (int i = 0; i < mass.length / 2; i++) {
            double current = mass[i] + mass[mass.length - i - 1];
            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
