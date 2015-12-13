package javase02.t03;


public class Pencil extends Stationery{
    private String color;
    private String hardness;

    public Pencil(String name, double price) {
        super(name, price);
    }

    public Pencil(String name, double price, String color, String hardness) {
        super(name, price);
        this.color = color;
        this.hardness = hardness;
    }

    public String getColor() {
        return color;
    }

    public String getHardness() {
        return hardness;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }
}
