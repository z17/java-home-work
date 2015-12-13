package javase02.t03;


abstract public class Stationery {
    protected String name;
    protected double price;

    public Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nStationery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "}";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
