package javase01.t04;


public class Array {

    private double[] mass;
    public Array(double[] mass  ){
        this.mass = mass;
    }

    public double run() {
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
