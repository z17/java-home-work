package javase10.t01;
public class Main {
    public static void main(String[] args) {
        DataBaseWorker db = new DataBaseWorker();

        db.dropTable();
        db.createTable();
        db.insert("test", 10.2, 11.2);
        db.insert("test", 10.2, 11.2);
        db.insert("test", 10.2, 11.2);
        db.insert("test", 10.2, 11.2);
        db.update(1, "new", 10.3, 10.4);
        System.out.println(db.select(TestColumns.name, "test"));

    }
}

