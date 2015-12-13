package javase02.t05;

public class Student<T> {
    private String name;
    private T mark;

    public Student(String name, T mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public T getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(T mark) {
        this.mark = mark;
    }
}
