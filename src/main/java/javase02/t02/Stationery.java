package javase02.t02;


public class Stationery {
    private static int maxId = 0;
    private String name;
    private Double price;
    private int id;

    public Stationery(String name, Double price) {
        this.name = name;
        this.price = price;
        id = ++maxId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
