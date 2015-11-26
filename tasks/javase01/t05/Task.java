package javase01.t05;

public class Task {
    private int n;

    public Task(int n) {
        if (n < 0) {
            System.exit(0);
        }
        this.n = n;
    }

    public int[][] run() {
        int[][] mass = new int[n][n];

        for (int i = 0; i < mass.length; i++) {
            mass[i][i] = 1;
            mass[i][mass.length - 1 - i] = 1;
        }
        return mass;
    }

    public void print(int[][] mass) {
        for (int[] cols : mass) {
            for (int value : cols) {
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
