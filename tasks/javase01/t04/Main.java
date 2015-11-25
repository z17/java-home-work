package javase01.t04;

public class Main {
    public static void main(String[] args) {

        // входные данные
        int n = 30;
        double[] mass = new double[2 * n];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Math.random();
        }

        double max = Task.run(mass);
        System.out.println(max);


    }
}
