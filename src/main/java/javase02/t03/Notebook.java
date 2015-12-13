package javase02.t03;


public class Notebook extends Stationery {

    private int lists;
    public Notebook(String name, double price) {
        super(name, price);
    }

    public int getLists() {
        return lists;
    }

    public void setLists(int lists) {
        this.lists = lists;
    }
}
