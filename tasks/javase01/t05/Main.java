package javase01.t05;

public class Main {
    public static void main(String[] args) {

        // входные данные
        int n = 14;

        Task task = new Task(n);
        int[][] mass = task.run();
        task.print(mass);



    }
}
