package javase10.t02;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        LibraryMain library = new LibraryMain();
        boolean actualList = false;
        System.out.println("Commands: get list, get book, add, read, delete, exit");
        do {
            System.out.println("Enter command:");
            command = scanner.nextLine();


            switch (command) {
                case "get list":
                    library.print(library.getList());
                    break;
                case "get book":
                    getBook(scanner, library);
                    break;
                case "add":
                    System.out.println("Enter name and author");
                    String name = scanner.nextLine();
                    String author = scanner.nextLine();
                    library.add(name, author);
                    break;
                case "read":
                    System.out.println("Enter id of the book");
                    try {
                        int idRead = Integer.parseInt(scanner.nextLine());
                        library.read(idRead);
                    } catch (NumberFormatException e) {
                        System.out.println("Id error");
                    }
                    break;
                case "delete":
                    System.out.println("Enter id");
                    try {
                        int idDelete = Integer.parseInt(scanner.nextLine());
                        library.delete(idDelete);
                    } catch (NumberFormatException e) {
                        System.out.println("Id error");
                    }
                    break;
                case "exit":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("command error, try more");
                    break;
            }
        } while (!command.equals("exit"));

    }

    private static void getBook(Scanner scanner, LibraryMain library) {
        System.out.println("By id or name (or exit)?");
        String commend = scanner.nextLine();
        switch (commend) {
            case "id":
                int id = Integer.parseInt(scanner.nextLine());
                library.print(library.getById(id));
                break;
            case "name":
                String name = scanner.nextLine();
                library.print(library.getByName(name));
                break;
            case "exit":
                return;
            default:
                System.out.println("error field, try more");
                getBook(scanner, library);
                break;
        }

    }

    private BookDAO bookWorker;
    private boolean actualList;
    private ArrayList<Book> currentList;

    public LibraryMain() {
        bookWorker = new BookDAO();
        actualList = false;
        currentList = null;
    }

    private ArrayList<Book> getList() {
        if (!actualList) {
            actualList = true;
            currentList = bookWorker.get();
            return bookWorker.get();
        }
        return currentList;
    }

    private Book getById(int id) {
        if (actualList) {
            for(Book book: currentList) {
                if (book.getId() == id) {
                    return book;
                }
            }
        }

        ArrayList<Book> list = bookWorker.get("id", id);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    private ArrayList<Book> getByName(String name) {
        if (actualList) {
            return currentList.stream()
                    .filter(book -> book.getName().equals(name))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        return bookWorker.get("name", name);
    }

    private void print(ArrayList<Book> list) {
        for(Book one: list) {
            print(one);
            System.out.println();
        }
    }

    private void print(Book book) {
        if (book != null) {
            System.out.println("id = " + book.getId());
            System.out.println("name = " + book.getName());
            System.out.println("author = " + book.getAuthor());
            System.out.println("reads = " + book.getCountReads());
        } else {
            System.out.println("Not Found");
        }
    }

    private void add(String name, String author) {
        bookWorker.create(new Book(name, author));
        actualList = false;
    }

    private void read(int id) {
        Book book = getById(id);
        if (book != null) {
            book.setCountReads(book.getCountReads() + 1);
            bookWorker.update(book);
            actualList = false;
            System.out.println("ok");
        } else {
            System.out.println("not found");
        }
    }

    private void delete(int id) {
        Book book = getById(id);
        if (book != null) {
            actualList = false;
            bookWorker.delete(book);
        } else {
            System.out.println("not found");
        }
    }
}
