package javase02.t02;


import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Worker> workers;

    public Company(String name) {
        this.name = name;
        workers = new ArrayList<Worker>();
    }

    @Override
    public String toString() {
        return "Company{\n" +
                "name = '" + name + "\',\n" +
                "workers = " + workers +
                "\n}";
    }

    public void addWorker(String name, String position) {
        Worker newWorker = new Worker(name, position);
        workers.add(newWorker);
    }

    public boolean addStationery(String nameWorker, String name, double price) {
        for(Worker one: workers ) {
            if (one.getName().equals(nameWorker)) {
                one.addItem(name, price);
                return true;
            }
        }
        return false;
    }

    public double getSumStationery() {
        double sum = 0;
        for (Worker one: workers) {
            sum += one.getPrice();
        }
        return sum;
    }

    public double getWorkerSumStationery(String name) {
        for(Worker one: workers ) {
            if (one.getName().equals(name)) {
                return one.getPrice();
            }
        }
        return 0;
    }
}
