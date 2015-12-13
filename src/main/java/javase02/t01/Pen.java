package javase02.t01;


public class Pen {
    private String color;
    private PenTypes type;


    public Pen(String color, PenTypes type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public PenTypes getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;

        Pen pen = (Pen) o;

        return !(getColor() != null ? !getColor().equals(pen.getColor()) : pen.getColor() != null) && getType() == pen.getType();

    }

    @Override
    public int hashCode() {
        int result = getColor() != null ? getColor().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                ", type=" + type +
                '}';
    }
}



