package javase02.t03;


import javase02.t01.PenTypes;

public class Pen extends Stationery {
    private String color;
    private PenTypes type;

    public Pen(String name, double price) {
        super(name, price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public PenTypes getType() {
        return type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(PenTypes type) {
        this.type = type;
    }
}
