package javase10.t02;

public class Book {
    private int id;
    private String name;
    private String author;
    private int countReads;

    public Book(int id, String name, String author, int countReads) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.countReads = countReads;
    }

    // конструктор без ID т.к. id в БД AUTO_INCREMENT и без countReads т.к. по умолчанию книгу ещё не читали
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.countReads = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCountReads() {
        return countReads;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCountReads(int countReads) {
        this.countReads = countReads;
    }
}
