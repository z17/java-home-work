package javase02.t02;

import java.util.ArrayList;

public class Worker {
    private String name;
    private String position;
    private ArrayList<Stationery> items;

    public Worker(String name, String position) {
        this.name = name;
        this.position = position;
        items = new ArrayList<Stationery>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setItems(ArrayList<Stationery> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public ArrayList<Stationery> getItems() {
        return items;
    }

    public void addItem(String name, double price) {
        Stationery newItem = new Stationery(name, price);
        items.add(newItem);
    }

    public void deleteItem(int number) {
        items.remove(number);
    }

    public void updateItem(int number, String name, double price) {
        Stationery current = items.get(number);
        current.setName(name);
        current.setPrice(price);
    }

    public double getPrice() {
        double sum = 0;
        for (Stationery one: items ) {
            sum += one.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Worker {" +
                "name='" + name + '\'' +
                ",position='" + position + '\'' +
                ",items=" + items +
                "}";
    }
}
