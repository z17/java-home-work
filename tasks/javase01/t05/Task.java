package javase01.t05;

public class Task {
    private int n;
    private int[][]matrix;

    public Task(int n) {
        if (n < 0) {
            System.exit(0);
        }
        this.n = n;
    }

    public void run() {
        int[][] mass = new int[n][n];

        for (int i = 0; i < mass.length; i++) {
            mass[i][i] = 1;
            mass[i][mass.length - 1 - i] = 1;
        }
        matrix = mass;
    }

    public void print() {
        for (int[] cols : matrix) {
            for (int value : cols) {
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
